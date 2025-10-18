package net.Ntouz.corruptedore.recipe;

import net.Ntouz.corruptedore.CorruptedOre;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CorruptedOre.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, CorruptedOre.MOD_ID);

    public static final RegistryObject<RecipeSerializer<PurifyingCauldronRecipe>> PURIFYING_CAULDRON_SERIALIZER =
            SERIALIZERS.register("purifying_cauldron", PurifyingCauldronRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<PurifyingCauldronRecipe>> PURIFYING_CAULDRON_TYPE =
            TYPES.register("purifying_cauldron", () -> new RecipeType<PurifyingCauldronRecipe>() {
                @Override
                public String toString() {
                    return "purifying_cauldron";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
