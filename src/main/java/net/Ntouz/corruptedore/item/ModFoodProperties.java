package net.Ntouz.corruptedore.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CORRUPTED_APPLE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 400), 0.20f).build();

    public static final FoodProperties PURE_APPLE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(1.3F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 450, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 8000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 3600, 3), 1.0F)
            .alwaysEdible()
            .build();

}
