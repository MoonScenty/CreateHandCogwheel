package me.moonscenty.createhandcogwheel.content;

import com.simibubi.create.content.kinetics.crank.HandCrankBlock;
import com.simibubi.create.content.kinetics.crank.HandCrankBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;

import me.moonscenty.createhandcogwheel.CreateHandCogwheel;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A hand crank that also participates in Create's small-cogwheel propagation.
 */
public class HandCogwheelBlock extends HandCrankBlock implements ICogWheel {
    public HandCogwheelBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSmallCog() {
        return true;
    }

    @Override
    public boolean isDedicatedCogWheel() {
        // Create's dedicated cog placement helper assumes an AXIS block-state
        // property. Hand cranks use FACING instead, so only expose the cog
        // connection behavior and opt out of that placement helper.
        return false;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // Cogwheels are self-supporting. Keeping the crank's support check here
        // would make guided cog-to-cog placement fail and fall back to vanilla
        // placement at the clicked face.
        return true;
    }

    @Override
    public BlockEntityType<? extends HandCrankBlockEntity> getBlockEntityType() {
        return CreateHandCogwheel.HAND_COGWHEEL_BLOCK_ENTITY.get();
    }
}
