package me.moonscenty.createhandcogwheel;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;

import me.moonscenty.createhandcogwheel.content.HandCogwheelBlock;
import me.moonscenty.createhandcogwheel.content.HandCogwheelBlockEntity;
import me.moonscenty.createhandcogwheel.content.HandCogwheelBlockItem;
import me.moonscenty.createhandcogwheel.content.HandCogwheelPlacementHelper;
import net.createmod.catnip.placement.PlacementHelpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(CreateHandCogwheel.MODID)
public class CreateHandCogwheel {
    public static final String MODID = "createhandcogwheel";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final DeferredBlock<HandCogwheelBlock> HAND_COGWHEEL = BLOCKS.register("hand_cogwheel",
            () -> new HandCogwheelBlock(BlockBehaviour.Properties.ofFullCopy(AllBlocks.HAND_CRANK.get())));

    public static final DeferredItem<HandCogwheelBlockItem> HAND_COGWHEEL_ITEM = ITEMS.register("hand_cogwheel",
            () -> new HandCogwheelBlockItem(HAND_COGWHEEL.get(), new Item.Properties()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HandCogwheelBlockEntity>>
            HAND_COGWHEEL_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("hand_cogwheel",
                    () -> BlockEntityType.Builder
                            .of(HandCogwheelBlockEntity::new, HAND_COGWHEEL.get())
                            .build(null));

    public static final int HAND_COGWHEEL_PLACEMENT_HELPER =
            PlacementHelpers.register(new HandCogwheelPlacementHelper());

    public CreateHandCogwheel(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey()) {
            event.accept(HAND_COGWHEEL_ITEM);
        }
    }
}
