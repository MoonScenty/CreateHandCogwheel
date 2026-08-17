package me.moonscenty.createhandcogwheel.ponder;

import me.moonscenty.createhandcogwheel.CreateHandCogwheel;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class HandCogwheelPonderPlugin implements PonderPlugin {
    @Override
    public String getModId() {
        return CreateHandCogwheel.MODID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        ResourceLocation item = CreateHandCogwheel.HAND_COGWHEEL_ITEM.getId();

        helper.addStoryBoard(item, create("hand_crank"), HandCogwheelPonderScenes::manualPower);
        helper.addStoryBoard(item, create("cog/small"), HandCogwheelPonderScenes::cogConnection);
        helper.addStoryBoard(item, create("shaft/relay"), HandCogwheelPonderScenes::shaftConnection);
    }

    private static ResourceLocation create(String path) {
        return ResourceLocation.fromNamespaceAndPath("create", path);
    }
}
