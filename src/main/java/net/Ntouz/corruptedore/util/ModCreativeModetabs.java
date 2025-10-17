package net.Ntouz.corruptedore.util;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModetabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CorruptedOre.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CORRUPTED_COMBAT_TAB = CREATIVE_MODE_TABS.register("corruptedore_combat_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CORRUPTED_HAMMER.get()))
                    .title(Component.translatable("creative.corruptedore.corruptedore_combat"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.CORRUPTED_BATTLE_AXE.get());
                        output.accept(ModItems.CORRUPTED_HAMMER.get());
                        output.accept(ModItems.CORRUPTED_PAXEL.get());

                        output.accept(ModItems.CORRUPTED_SWORD.get());
                        output.accept(ModItems.CORRUPTED_PICKAXE.get());
                        output.accept(ModItems.CORRUPTED_AXE.get());
                        output.accept(ModItems.CORRUPTED_SHOVEL.get());
                        output.accept(ModItems.CORRUPTED_HOE.get());

                        output.accept(ModItems.CORRUPTED_BOW.get());

                        output.accept(ModItems.PURE_BATTLE_AXE.get());
                        output.accept(ModItems.PURE_HAMMER.get());
                        output.accept(ModItems.PURE_PAXEL.get());

                        output.accept(ModItems.PURE_SWORD.get());
                        output.accept(ModItems.PURE_PICKAXE.get());
                        output.accept(ModItems.PURE_AXE.get());
                        output.accept(ModItems.PURE_SHOVEL.get());
                        output.accept(ModItems.PURE_HOE.get());

                        output.accept(ModItems.PURE_BOW.get());

                        output.accept(ModItems.CORRUPTED_BOOTS.get());
                        output.accept(ModItems.CORRUPTED_LEGGINGS.get());
                        output.accept(ModItems.CORRUPTED_CHESTPLATE.get());
                        output.accept(ModItems.CORRUPTED_HELMET.get());

                        output.accept(ModItems.PURE_BOOTS.get());
                        output.accept(ModItems.PURE_LEGGINGS.get());
                        output.accept(ModItems.PURE_CHESTPLATE.get());
                        output.accept(ModItems.PURE_HELMET.get());

                        output.accept(ModItems.CORRUPTED_HORSE_ARMOR.get());
                        output.accept(ModItems.PURE_HORSE_ARMOR.get());

                        output.accept(ModItems.STALWART_PAXEL.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> CORRUPTED_ORE_ITEMS_TAB = CREATIVE_MODE_TABS.register("corruptedore_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CORRUPTEDGEM.get()))
                    .title(Component.translatable("creative.corruptedore.corruptedore_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CORRUPTEDGEM.get());
                        output.accept(ModItems.PUREGEM.get());
                        output.accept(ModItems.CORRUPTED_INGOT.get());
                        output.accept(ModItems.PURE_INGOT.get());
                        output.accept(ModItems.CORRUPTEDFRAGMENT.get());

                        output.accept(ModItems.PURIFYING_ORB.get());
                        output.accept(ModItems.CORRUPTED_APPLE.get());
                        output.accept(ModItems.PURE_APPLE.get());

                        output.accept(ModItems.CORRUPTED_GNOME_EGG.get());
                        output.accept(ModItems.SMALL_STALWART_GOLEM_SPAWN_EGG.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> CORRUPTED_ORE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("corruptedore_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CORRUPTED_BLOCK.get()))
                    .title(Component.translatable("creative.corruptedore.corruptedore_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RICH_PURE_ORE.get());
                        output.accept(ModBlocks.RICH_CORRUPTED_ORE.get());
                        output.accept(ModBlocks.CORRUPTED_ORE.get());
                        output.accept(ModBlocks.PURE_ORE.get());

                        output.accept(ModBlocks.CORRUPTED_NETHER_ORE.get());
                        output.accept(ModBlocks.PURE_NETHER_ORE.get());
                        output.accept(ModBlocks.CORRUPTED_END_ORE.get());
                        output.accept(ModBlocks.PURE_END_ORE.get());

                        output.accept(ModBlocks.CORRUPTED_BLOCK.get());
                        output.accept(ModBlocks.PURE_BLOCK.get());

                        output.accept(ModBlocks.PURIFIER_BLOCK.get());
                        output.accept(ModBlocks.PURIFYING_CAULDRON.get());

                        output.accept(ModBlocks.CORRUPTED_STAIRS.get());
                        output.accept(ModBlocks.CORRUPTED_SLAB.get());

                        output.accept(ModBlocks.CORRUPTED_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.CORRUPTED_BUTTON.get());

                        output.accept(ModBlocks.CORRUPTED_FENCE.get());
                        output.accept(ModBlocks.CORRUPTED_FENCE_GATE.get());
                        output.accept(ModBlocks.CORRUPTED_WALL.get());

                        output.accept(ModBlocks.CORRUPTED_DOOR.get());
                        output.accept(ModBlocks.CORRUPTED_TRAPDOOR.get());

                        output.accept(ModBlocks.STALWART_PUMPKIN.get());
                        output.accept(ModBlocks.SALWART_GOLEM_HEAD.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
