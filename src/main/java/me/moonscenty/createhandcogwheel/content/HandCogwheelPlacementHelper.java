package me.moonscenty.createhandcogwheel.content;

import java.util.function.Predicate;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;

import me.moonscenty.createhandcogwheel.CreateHandCogwheel;
import net.createmod.catnip.placement.IPlacementHelper;
import net.createmod.catnip.placement.PlacementOffset;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/** Cog-style placement preview using the hand crank's FACING property. */
public class HandCogwheelPlacementHelper implements IPlacementHelper {
    @Override
    public Predicate<ItemStack> getItemPredicate() {
        return stack -> stack.is(CreateHandCogwheel.HAND_COGWHEEL_ITEM.get());
    }

    @Override
    public Predicate<BlockState> getStatePredicate() {
        return state -> AllBlocks.SHAFT.has(state)
                || ICogWheel.isSmallCog(state)
                || ICogWheel.isLargeCog(state);
    }

    @Override
    public PlacementOffset getOffset(Player player, Level level, BlockState state, BlockPos pos, BlockHitResult ray) {
        Direction.Axis axis = ((IRotate) state.getBlock()).getRotationAxis(state);

        if (AllBlocks.SHAFT.has(state))
            return getShaftOffset(level, pos, ray, axis);

        for (Direction direction : IPlacementHelper.orderedByDistanceExceptAxis(pos, ray.getLocation(), axis)) {
            BlockPos target = pos.relative(direction);
            if (!level.getBlockState(target).canBeReplaced())
                continue;
            if (!CogWheelBlock.isValidCogwheelPosition(false, level, target, axis))
                continue;

            Direction facing = Direction.get(Direction.AxisDirection.POSITIVE, axis);
            return PlacementOffset.success(target,
                    placed -> placed.setValue(HandCogwheelBlock.FACING, facing));
        }

        return PlacementOffset.fail();
    }

    private PlacementOffset getShaftOffset(Level level, BlockPos pos, BlockHitResult ray, Direction.Axis axis) {
        for (Direction direction : IPlacementHelper.orderedByDistanceOnlyAxis(pos, ray.getLocation(), axis)) {
            BlockPos target = pos.relative(direction);
            if (!level.getBlockState(target).canBeReplaced())
                continue;

            return PlacementOffset.success(target,
                    placed -> placed.setValue(HandCogwheelBlock.FACING, direction));
        }
        return PlacementOffset.fail();
    }
}
