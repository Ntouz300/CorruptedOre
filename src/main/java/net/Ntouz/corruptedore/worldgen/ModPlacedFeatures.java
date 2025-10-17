package net.Ntouz.corruptedore.worldgen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CORRUPTED_OVERWORLD_ORE_PLACED_KEY = registerKey("corrupted_ore_placed");
    public static final ResourceKey<PlacedFeature> CORRUPTED_NETHER_ORE_PLACED_KEY = registerKey("corrupted_nether_ore_placed");
    public static final ResourceKey<PlacedFeature> CORRUPTED_END_ORE_PLACED_KEY = registerKey("corrupted_end_ore_placed");

    public static final ResourceKey<PlacedFeature> PURE_OVERWORLD_ORE_PLACED_KEY = registerKey("pure_ore_placed");
    public static final ResourceKey<PlacedFeature> PURE_NETHER_ORE_PLACED_KEY = registerKey("pure_nether_ore_placed");
    public static final ResourceKey<PlacedFeature> PURE_END_ORE_PLACED_KEY = registerKey("pure_end_ore_placed");



    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CORRUPTED_OVERWORLD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTED_OVERWORLD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(25))));

        register(context, CORRUPTED_NETHER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTED_NETHER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(8), VerticalAnchor.absolute(22))));

        register(context, CORRUPTED_END_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTED_END_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(60))));

        register(context, PURE_OVERWORLD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PURE_OVERWORLD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(6))));

        register(context, PURE_NETHER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PURE_NETHER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(8), VerticalAnchor.absolute(22))));

        register(context, PURE_END_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PURE_END_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(60))));



    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}


