package net.Ntouz.corruptedore.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record PurifyingCauldronRecipe(Ingredient inputItem, ItemStack output) implements Recipe<PurifyingCauldronRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(PurifyingCauldronRecipeInput pInput, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        return inputItem.test(pInput.getItem(0));
    }

    @Override
    public ItemStack assemble(PurifyingCauldronRecipeInput pInput, HolderLookup.Provider pRegistries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.PURIFYING_CAULDRON_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.PURIFYING_CAULDRON_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<PurifyingCauldronRecipe> {
        public static final MapCodec<PurifyingCauldronRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(PurifyingCauldronRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(PurifyingCauldronRecipe::output)
        ).apply(inst, PurifyingCauldronRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, PurifyingCauldronRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, PurifyingCauldronRecipe::inputItem,
                        ItemStack.STREAM_CODEC, PurifyingCauldronRecipe::output,
                        PurifyingCauldronRecipe::new);

        @Override
        public MapCodec<PurifyingCauldronRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, PurifyingCauldronRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
