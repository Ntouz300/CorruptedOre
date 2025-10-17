package net.Ntouz.corruptedore.datagen;

import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CORRUPTED_BLOCK.get());
        dropSelf(ModBlocks.PURE_BLOCK.get());
        dropSelf(ModBlocks.PURIFIER_BLOCK.get());

        this.add(ModBlocks.CORRUPTED_ORE.get(),
                block -> createOreDrop(ModBlocks.CORRUPTED_ORE.get(), ModItems.CORRUPTEDGEM.get()));
        this.add(ModBlocks.PURE_ORE.get(),
                block -> createOreDrop(ModBlocks.PURE_ORE.get(), ModItems.PUREGEM.get()));
        this.add(ModBlocks.RICH_CORRUPTED_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.RICH_CORRUPTED_ORE.get(), ModItems.CORRUPTEDGEM.get(), 2, 3));
        this.add(ModBlocks.RICH_PURE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.RICH_PURE_ORE.get(), ModItems.CORRUPTEDGEM.get(), 2, 2));
        this.add(ModBlocks.CORRUPTED_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.CORRUPTED_END_ORE.get(), ModItems.CORRUPTEDGEM.get(), 2, 4));
        this.add(ModBlocks.PURE_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PURE_END_ORE.get(), ModItems.PUREGEM.get(), 2, 3));
        this.add(ModBlocks.CORRUPTED_NETHER_ORE.get(),
                block -> createOreDrop(ModBlocks.CORRUPTED_NETHER_ORE.get(), ModItems.CORRUPTEDGEM.get()));
        this.add(ModBlocks.PURE_NETHER_ORE.get(),
                block -> createOreDrop(ModBlocks.PURE_NETHER_ORE.get(), ModItems.PUREGEM.get()));

        dropSelf(ModBlocks.CORRUPTED_STAIRS.get());
        this.add(ModBlocks.CORRUPTED_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CORRUPTED_SLAB.get()));

        dropSelf(ModBlocks.CORRUPTED_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.CORRUPTED_BUTTON.get());

        dropSelf(ModBlocks.CORRUPTED_FENCE.get());
        dropSelf(ModBlocks.CORRUPTED_WALL.get());
        dropSelf(ModBlocks.CORRUPTED_FENCE_GATE.get());

        dropSelf(ModBlocks.PURIFYING_CAULDRON.get());

        dropSelf(ModBlocks.STALWART_PUMPKIN.get());
        dropSelf(ModBlocks.SALWART_GOLEM_HEAD.get());

        dropSelf(ModBlocks.CORRUPTED_TRAPDOOR.get());
        this.add(ModBlocks.CORRUPTED_DOOR.get(),
                block -> createDoorTable(ModBlocks.CORRUPTED_DOOR.get()));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;

    }
}
