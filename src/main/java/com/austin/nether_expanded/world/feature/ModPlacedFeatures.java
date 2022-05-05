package com.austin.nether_expanded.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> ORE_BLOODSTONE = PlacedFeatures.register("ore_bloodstone",
            ModConfiguredFeatures.ORE_BLOODSTONE, ModOreFeatures.modifiersWithCount(8,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_FOREST_BLOODSTONE = PlacedFeatures.register("ore_bloodstone_forest",
            ModConfiguredFeatures.ORE_FORST_BLOODSTONE, ModOreFeatures.modifiersWithCount(8,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_NETHER_DIAMOND = PlacedFeatures.register("ore_diamond_nether",
            ModConfiguredFeatures.ORE_NETHER_DIAMOND, ModOreFeatures.modifiersWithCount(99,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_CRIMSONITE = PlacedFeatures.register("ore_crimsonite",
            ModConfiguredFeatures.ORE_CRIMSONITE, ModOreFeatures.modifiersWithCount(8,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_NETHER_IRON = PlacedFeatures.register("ore_iron_nether",
            ModConfiguredFeatures.ORE_NETHER_IRON, ModOreFeatures.modifiersWithCount(10,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_NETHER_COPPER = PlacedFeatures.register("ore_copper_nether",
            ModConfiguredFeatures.ORE_NETHER_COPPER, ModOreFeatures.modifiersWithCount(12,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_EMERALD_NETHER = PlacedFeatures.register("ore_emerald_nether",
            ModConfiguredFeatures.ORE_EMERALD_NETHER, ModOreFeatures.modifiersWithCount(4,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_AMETHYST = PlacedFeatures.register("ore_amethyst",
            ModConfiguredFeatures.ORE_AMETHYST, ModOreFeatures.modifiersWithCount(4,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_RUBY = PlacedFeatures.register("ore_ruby",
            ModConfiguredFeatures.ORE_RUBY, ModOreFeatures.modifiersWithCount(4,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_SOUL_STONE = PlacedFeatures.register("ore_soul_stone",
            ModConfiguredFeatures.ORE_SOUL_STONE, ModOreFeatures.modifiersWithCount(32,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

}
