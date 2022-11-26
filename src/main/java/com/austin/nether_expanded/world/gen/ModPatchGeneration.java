package com.austin.nether_expanded.world.gen;

import com.austin.nether_expanded.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModPatchGeneration {
    public static void generatePatches(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SOUL_BUSH_PATCH.getKey().get());
    }
}
