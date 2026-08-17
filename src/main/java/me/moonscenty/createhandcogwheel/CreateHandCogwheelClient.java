package me.moonscenty.createhandcogwheel;

import me.moonscenty.createhandcogwheel.content.HandCogwheelRenderer;
import me.moonscenty.createhandcogwheel.ponder.HandCogwheelPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod(value = CreateHandCogwheel.MODID, dist = Dist.CLIENT)
public class CreateHandCogwheelClient {
    public CreateHandCogwheelClient(IEventBus modEventBus) {
        PonderIndex.addPlugin(new HandCogwheelPonderPlugin());
        CreateHandCogwheelPartialModels.init();
        modEventBus.addListener(this::registerRenderers);
    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(
                CreateHandCogwheel.HAND_COGWHEEL_BLOCK_ENTITY.get(),
                HandCogwheelRenderer::new);
    }
}
