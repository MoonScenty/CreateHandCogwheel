package me.moonscenty.createhandcogwheel.content;

import com.simibubi.create.content.kinetics.crank.HandCrankBlockEntity;

import me.moonscenty.createhandcogwheel.CreateHandCogwheel;
import me.moonscenty.createhandcogwheel.CreateHandCogwheelPartialModels;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class HandCogwheelBlockEntity extends HandCrankBlockEntity {
    public HandCogwheelBlockEntity(BlockPos pos, BlockState state) {
        super(CreateHandCogwheel.HAND_COGWHEEL_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public SuperByteBuffer getRenderedHandle() {
        BlockState state = getBlockState();
        Direction facing = state.getValue(HandCogwheelBlock.FACING);
        return CachedBuffers.partialFacingVertical(CreateHandCogwheelPartialModels.HANDLE, state, facing);
    }
}
