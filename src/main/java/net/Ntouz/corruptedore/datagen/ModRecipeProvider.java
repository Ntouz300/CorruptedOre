package net.Ntouz.corruptedore.datagen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CORRUPTED_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PUREGEM.get())
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CORRUPTEDGEM.get(), 9)
                .requires(ModBlocks.CORRUPTED_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CORRUPTED_BLOCK.get()), has(ModBlocks.CORRUPTED_BLOCK.get())).save(pRecipeOutput, CorruptedOre.MOD_ID + ":corrupted_block_to_corruptedgem");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PUREGEM.get(), 9)
                .requires(ModBlocks.PURE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PURE_BLOCK.get()), has(ModBlocks.PURE_BLOCK.get())).save(pRecipeOutput, CorruptedOre.MOD_ID + ":pure_block_to_puregem");

        // Pour les recettes de smelting voir vidéo 11, min 30 //

        stairBuilder(ModBlocks.CORRUPTED_STAIRS.get(), Ingredient.of(ModItems.CORRUPTEDGEM.get())).group("corruptedgem")
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUPTED_SLAB.get(), ModItems.CORRUPTEDGEM.get());

        buttonBuilder(ModBlocks.CORRUPTED_BUTTON.get(), Ingredient.of(ModItems.CORRUPTEDGEM.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.CORRUPTED_PRESSURE_PLATE.get(), ModItems.CORRUPTEDGEM.get());

        fenceBuilder(ModBlocks.CORRUPTED_FENCE.get(), Ingredient.of(ModItems.CORRUPTEDGEM.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.CORRUPTED_FENCE_GATE.get(), Ingredient.of(ModItems.CORRUPTEDGEM.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUPTED_WALL.get(), ModItems.CORRUPTEDGEM.get());

        doorBuilder(ModBlocks.CORRUPTED_DOOR.get(), Ingredient.of(ModItems.CORRUPTEDGEM.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.CORRUPTED_TRAPDOOR.get(), Ingredient.of(ModItems.CORRUPTEDGEM.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_AXE.get())
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_HOE.get())
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.PUREGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.PUREGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItems.PUREGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_AXE.get())
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItems.PUREGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_HOE.get())
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItems.PUREGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_HAMMER.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern(" B ")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_HAMMER.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern(" B ")
                .define('A', ModItems.PUREGEM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.PUREGEM.get())
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PUREGEM.get())
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.PUREGEM.get())
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.PUREGEM.get())
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_PAXEL.get())
                .pattern("ABC")
                .pattern(" D ")
                .pattern(" D ")
                .define('A', ModItems.PURE_AXE.get())
                .define('B', ModItems.PURE_SHOVEL.get())
                .define('C', ModItems.PURE_PICKAXE.get())
                .define('D', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_PAXEL.get())
                .pattern("ABC")
                .pattern(" D ")
                .pattern(" D ")
                .define('A', ModItems.CORRUPTED_AXE.get())
                .define('B', ModItems.CORRUPTED_SHOVEL.get())
                .define('C', ModItems.CORRUPTED_PICKAXE.get())
                .define('D', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_BATTLE_AXE.get())
                .pattern("AB")
                .pattern("BD")
                .pattern(" D")
                .define('A', ModItems.CORRUPTED_AXE.get())
                .define('B', ModItems.CORRUPTEDGEM.get())
                .define('D', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_BATTLE_AXE.get())
                .pattern("AB")
                .pattern("BD")
                .pattern(" D")
                .define('A', ModItems.PURE_AXE.get())
                .define('B', ModItems.PUREGEM.get())
                .define('D', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_BOW.get())
                .pattern("ACB")
                .pattern("A B")
                .pattern("ACB")
                .define('A', ModItems.PUREGEM.get())
                .define('B', Items.STRING)
                .define('C', Items.STICK)
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_BOW.get())
                .pattern("ACB")
                .pattern("A B")
                .pattern("ACB")
                .define('A', ModItems.CORRUPTEDGEM.get())
                .define('B', Items.STRING)
                .define('C', Items.STICK)
                .unlockedBy(getHasName(ModItems.CORRUPTEDGEM.get()), has(ModItems.CORRUPTEDGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURIFYING_ORB.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.DIAMOND)
                .define('B', Blocks.GLOWSTONE)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_INGOT.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', ModItems.PUREGEM.get())
                .define('B', ModItems.CORRUPTED_INGOT.get())
                .unlockedBy(getHasName(ModItems.PUREGEM.get()), has(ModItems.PUREGEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTED_INGOT.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.DIAMOND)
                .define('B', ModItems.CORRUPTEDGEM.get())
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STALWART_PAXEL.get())
                .pattern("AAA")
                .pattern(" C ")
                .pattern(" B ")
                .define('A', ModItems.PURE_INGOT.get())
                .define('B', ModItems.PURE_PAXEL.get())
                .define('C', Items.NETHER_STAR)
                .unlockedBy(getHasName(ModItems.PURE_INGOT.get()), has(ModItems.PURE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTEDGEM.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.CORRUPTEDFRAGMENT.get())
                .unlockedBy(getHasName(ModItems.CORRUPTEDFRAGMENT.get()), has(ModItems.CORRUPTEDFRAGMENT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STALWART_PUMPKIN.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModItems.PURE_INGOT.get())
                .define('B', Items.PUMPKIN)
                .unlockedBy(getHasName(ModItems.PURE_INGOT.get()), has(ModItems.PURE_INGOT.get())).save(pRecipeOutput);
    }
}
