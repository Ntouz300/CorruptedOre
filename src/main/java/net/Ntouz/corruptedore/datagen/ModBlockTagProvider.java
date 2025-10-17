package net.Ntouz.corruptedore.datagen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CorruptedOre.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PURE_BLOCK.get())
                .add(ModBlocks.RICH_PURE_ORE.get())
                .add(ModBlocks.PURE_ORE.get())
                .add(ModBlocks.CORRUPTED_BLOCK.get())
                .add(ModBlocks.RICH_CORRUPTED_ORE.get())
                .add(ModBlocks.CORRUPTED_ORE.get())
                .add(ModBlocks.PURIFIER_BLOCK.get())
                .add(ModBlocks.PURE_END_ORE.get())
                .add(ModBlocks.CORRUPTED_END_ORE.get())
                .add(ModBlocks.PURE_NETHER_ORE.get())
                .add(ModBlocks.CORRUPTED_NETHER_ORE.get())
                .add(ModBlocks.SALWART_GOLEM_HEAD.get())
                .add(ModBlocks.SALWART_GOLEM_HEAD.get())
                .add(ModBlocks.STALWART_PUMPKIN.get())
                .add(ModBlocks.CORRUPTED_DOOR.get())
                .add(ModBlocks.CORRUPTED_FENCE.get())
                .add(ModBlocks.CORRUPTED_PRESSURE_PLATE.get())
                .add(ModBlocks.CORRUPTED_STAIRS.get())
                .add(ModBlocks.CORRUPTED_SLAB.get())
                .add(ModBlocks.CORRUPTED_TRAPDOOR.get())
                .add(ModBlocks.CORRUPTED_BUTTON.get())
                .add(ModBlocks.CORRUPTED_FENCE_GATE.get());



        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CORRUPTED_BLOCK.get())
                .add(ModBlocks.CORRUPTED_ORE.get())
                .add(ModBlocks.RICH_CORRUPTED_ORE.get())
                .add(ModBlocks.PURE_BLOCK.get())
                .add(ModBlocks.PURE_BLOCK.get())
                .add(ModBlocks.CORRUPTED_NETHER_ORE.get())
                .add(ModBlocks.CORRUPTED_END_ORE.get())
                .add(ModBlocks.SALWART_GOLEM_HEAD.get())
                .add(ModBlocks.STALWART_PUMPKIN.get())
                .add(ModBlocks.CORRUPTED_DOOR.get())
                .add(ModBlocks.CORRUPTED_FENCE.get())
                .add(ModBlocks.CORRUPTED_PRESSURE_PLATE.get())
                .add(ModBlocks.CORRUPTED_STAIRS.get())
                .add(ModBlocks.CORRUPTED_SLAB.get())
                .add(ModBlocks.CORRUPTED_TRAPDOOR.get())
                .add(ModBlocks.CORRUPTED_BUTTON.get())
                .add(ModBlocks.CORRUPTED_FENCE_GATE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PURE_ORE.get())
                .add(ModBlocks.RICH_PURE_ORE.get())
                .add(ModBlocks.PURE_END_ORE.get())
                .add(ModBlocks.PURE_NETHER_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.CORRUPTED_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.CORRUPTED_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.CORRUPTED_WALL.get());

        tag(ModTags.Blocks.NEEDS_CORRUPTED_TOOL)
                .add(ModBlocks.PURE_END_ORE.get())
                .add(ModBlocks.PURE_NETHER_ORE.get())
                .add(ModBlocks.PURE_ORE.get())
                .add(ModBlocks.RICH_PURE_ORE.get())
                .add(Blocks.OBSIDIAN)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_CORRUPTED_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_CORRUPTED_TOOL);

        tag(ModTags.Blocks.NEEDS_PURE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_PURE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_PURE_TOOL);

        tag(ModTags.Blocks.MINEABLE_WITH_PAXEL)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        tag(ModTags.Blocks.NEEDS_STALWART_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(ModTags.Blocks.NEEDS_PURE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_STALWART_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(ModTags.Blocks.NEEDS_STALWART_TOOL);
        }

    }

