package net.Ntouz.corruptedore.worldgen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_OVERWORLD_ORE_KEY = registerKey("corrupted_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_NETHER_ORE_KEY = registerKey("corrupted_nether_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_END_ORE_KEY = registerKey("corrupted_end_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURE_OVERWORLD_ORE_KEY = registerKey("pure_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURE_NETHER_ORE_KEY = registerKey("pure_nether_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURE_END_ORE_KEY = registerKey("pure_end_ore");



    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldCorruptedOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CORRUPTED_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RICH_CORRUPTED_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldPureOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PURE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RICH_PURE_ORE.get().defaultBlockState()));

        register(context, CORRUPTED_OVERWORLD_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCorruptedOres, 5));
        register(context, CORRUPTED_NETHER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.CORRUPTED_NETHER_ORE.get().defaultBlockState(), 6));
        register(context, CORRUPTED_END_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.CORRUPTED_END_ORE.get().defaultBlockState(), 7));

        register(context, PURE_OVERWORLD_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPureOres, 4));
        register(context, PURE_NETHER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.PURE_NETHER_ORE.get().defaultBlockState(), 5));
        register(context, PURE_END_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.PURE_END_ORE.get().defaultBlockState(), 5));


    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
