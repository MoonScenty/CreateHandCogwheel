package me.moonscenty.createhandcogwheel;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.resources.ResourceLocation;

public final class CreateHandCogwheelPartialModels {
    public static final PartialModel COG = block("hand_cogwheel_cog");
    public static final PartialModel HANDLE = block("hand_cogwheel_handle");

    private CreateHandCogwheelPartialModels() {
    }

    private static PartialModel block(String path) {
        return PartialModel.of(ResourceLocation.fromNamespaceAndPath(
                CreateHandCogwheel.MODID, "block/" + path));
    }

    /** Loads this class early enough for Flywheel to include the partial models during baking. */
    public static void init() {
    }
}
