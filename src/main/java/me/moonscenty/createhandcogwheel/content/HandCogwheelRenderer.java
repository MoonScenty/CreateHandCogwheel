package me.moonscenty.createhandcogwheel.content;

import com.mojang.blaze3d.vertex.PoseStack;

import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.render.CachedBuffers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.crank.HandCrankBlock;
import me.moonscenty.createhandcogwheel.CreateHandCogwheelPartialModels;

/** Renders the supplied handle model even when Flywheel visualization is active. */
public class HandCogwheelRenderer extends KineticBlockEntityRenderer<HandCogwheelBlockEntity> {
    public HandCogwheelRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(HandCogwheelBlockEntity blockEntity, float partialTicks, PoseStack poseStack,
            MultiBufferSource bufferSource, int light, int overlay) {
        Direction facing = blockEntity.getBlockState().getValue(HandCrankBlock.FACING);

        renderRotatingBuffer(
                blockEntity,
                CachedBuffers.partialFacingVertical(
                        CreateHandCogwheelPartialModels.COG,
                        blockEntity.getBlockState(),
                        facing),
                poseStack,
                bufferSource.getBuffer(RenderType.solid()),
                light);

        kineticRotationTransform(
                blockEntity.getRenderedHandle(),
                blockEntity,
                facing.getAxis(),
                AngleHelper.rad(blockEntity.getIndependentAngle(partialTicks)),
                light)
                .renderInto(poseStack, bufferSource.getBuffer(RenderType.solid()));
    }
}
