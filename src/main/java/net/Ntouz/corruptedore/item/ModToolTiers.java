package net.Ntouz.corruptedore.item;

import net.Ntouz.corruptedore.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier CORRUPTED = new ForgeTier(1200, 7, 2.0f, 12,
            ModTags.Blocks.NEEDS_CORRUPTED_TOOL, () -> Ingredient.of(ModItems.CORRUPTEDGEM.get()),
            ModTags.Blocks.INCORRECT_FOR_CORRUPTED_TOOL);

    public static final Tier PURE = new ForgeTier(2500, 10f, 5.0f, 22,
            ModTags.Blocks.NEEDS_PURE_TOOL, () -> Ingredient.of(ModItems.PUREGEM.get()),
            ModTags.Blocks.INCORRECT_FOR_PURE_TOOL);

    public static final Tier STALWART = new ForgeTier(9000, 15f, 9.0f, 25,
            ModTags.Blocks.NEEDS_STALWART_TOOL, () -> Ingredient.of(ModItems.PURE_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_STALWART_TOOL);
}
