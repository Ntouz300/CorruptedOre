package net.Ntouz.corruptedore.datagen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.item.ModItems;
import net.Ntouz.corruptedore.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, CorruptedOre.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Voir la vidéo sur les étiquettes//
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CORRUPTED_HELMET.get())
                .add(ModItems.CORRUPTED_CHESTPLATE.get())
                .add(ModItems.CORRUPTED_LEGGINGS.get())
                .add(ModItems.CORRUPTED_BOOTS.get())
                .add(ModItems.PURE_HELMET.get())
                .add(ModItems.PURE_CHESTPLATE.get())
                .add(ModItems.PURE_LEGGINGS.get())
                .add(ModItems.PURE_BOOTS.get());
    }
}
