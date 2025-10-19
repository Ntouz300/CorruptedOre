package net.Ntouz.corruptedore.worldgen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static ResourceKey<BiomeModifier> ADD_CORRUPTED_ORE = registerKey("add_corrupted_ore");
    public static ResourceKey<BiomeModifier> ADD_CORRUPTED_NETHER_ORE = registerKey("add_corrupted_nether_ore");
    public static ResourceKey<BiomeModifier> ADD_CORRUPTED_END_ORE = registerKey("add_corrupted_end_ore");

    public static ResourceKey<BiomeModifier> ADD_PURE_ORE = registerKey("add_pure_ore");
    public static ResourceKey<BiomeModifier> ADD_PURE_NETHER_ORE = registerKey("add_pure_nether_ore");
    public static ResourceKey<BiomeModifier> ADD_PURE_END_ORE = registerKey("add_pure_end_ore");

    public static ResourceKey<BiomeModifier> SPAWN_CORRUPTED_GNOME = registerKey("spawn_corrupted_gnome");
    public static ResourceKey<BiomeModifier> SPAWN_MARROWDER = registerKey("spawn_marrowder");




    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_CORRUPTED_ORE,  new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CORRUPTED_OVERWORLD_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CORRUPTED_NETHER_ORE,  new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CORRUPTED_NETHER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CORRUPTED_END_ORE,  new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CORRUPTED_END_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_PURE_ORE,  new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.PURE_OVERWORLD_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_PURE_NETHER_ORE,  new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.PURE_NETHER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_PURE_END_ORE,  new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.PURE_END_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(SPAWN_CORRUPTED_GNOME,  new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DARK_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.CORRUPTED_GNOME.get(), 25, 4, 5))));

        context.register(SPAWN_MARROWDER,  new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.DARK_FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST), biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MARROWDER.get(), 25, 4, 5))));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, name));
    }
}
