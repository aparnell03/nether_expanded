package com.austin.nether_expanded.world.gen;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

public interface ModConfiguredStructureFeatureTags {
    public static final TagKey<ConfiguredStructureFeature<?, ?>> FORTRESS = ModConfiguredStructureFeatureTags.of("fortress");


    private static TagKey<ConfiguredStructureFeature<?, ?>> of(String id) {
        return TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier(id));
    }
}
