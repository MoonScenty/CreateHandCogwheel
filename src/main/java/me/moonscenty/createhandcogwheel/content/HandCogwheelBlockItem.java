package me.moonscenty.createhandcogwheel.content;

import me.moonscenty.createhandcogwheel.CreateHandCogwheel;
import net.createmod.catnip.placement.IPlacementHelper;
import net.createmod.catnip.placement.PlacementHelpers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/** Applies the same placement helper offset used by the client-side ghost. */
public class HandCogwheelBlockItem extends BlockItem {
    public HandCogwheelBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        BlockState clickedState = level.getBlockState(clickedPos);
        Player player = context.getPlayer();
        IPlacementHelper helper = PlacementHelpers.get(CreateHandCogwheel.HAND_COGWHEEL_PLACEMENT_HELPER);

        if (player != null && !player.isShiftKeyDown() && helper.matchesState(clickedState)) {
            BlockHitResult hit = new BlockHitResult(
                    context.getClickLocation(),
                    context.getClickedFace(),
                    clickedPos,
                    true);

            return helper.getOffset(player, level, clickedState, clickedPos, hit)
                    .placeInWorld(level, this, player, context.getHand(), hit)
                    .result();
        }

        return super.onItemUseFirst(stack, context);
    }
}
