package com.austin.nether_expanded.world.gen;

import com.austin.nether_expanded.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS,BiomeKeys.NETHER_WASTES),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_BLOODSTONE.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST,BiomeKeys.WARPED_FOREST),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_FOREST_BLOODSTONE.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_NETHER_DIAMOND.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST,BiomeKeys.NETHER_WASTES),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CRIMSONITE.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST,BiomeKeys.NETHER_WASTES),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_NETHER_COPPER.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS,BiomeKeys.CRIMSON_FOREST,BiomeKeys.NETHER_WASTES),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_NETHER_IRON.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS,BiomeKeys.SOUL_SAND_VALLEY),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_AMETHYST.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS,BiomeKeys.WARPED_FOREST),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_EMERALD_NETHER.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS,BiomeKeys.CRIMSON_FOREST),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_RUBY.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SOUL_SAND_VALLEY),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_SOUL_STONE.getKey().get());
    }
}
