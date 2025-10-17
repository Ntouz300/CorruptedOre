package net.Ntouz.corruptedore.util;

import net.Ntouz.corruptedore.CorruptedOre;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CORRUPTED_TOOL = createTag("needs_corrupted_tool");
        public static final TagKey<Block> INCORRECT_FOR_CORRUPTED_TOOL = createTag("incorrect_for_corrupted_tool");

        public static final TagKey<Block> NEEDS_PURE_TOOL = createTag("needs_pure_tool");
        public static final TagKey<Block> INCORRECT_FOR_PURE_TOOL = createTag("incorrect_for_pure_tool");

        public static final TagKey<Block> NEEDS_STALWART_TOOL = createTag("needs_stalwart_tool");
        public static final TagKey<Block> INCORRECT_FOR_STALWART_TOOL = createTag("incorrect_for_stalwart_tool");

        public static final TagKey<Block> MINEABLE_WITH_PAXEL = createTag("mineable_with_paxel");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, name));
        }

        public static class Items {
            public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

            private static TagKey<Item> createTag(String name) {
                return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, name));
            }
        }
    }
}
