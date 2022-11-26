package com.austin.nether_expanded.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

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

    public static final RegistryEntry<PlacedFeature> ORE_NETHER_LAPIS = PlacedFeatures.register("ore_nether_lapis",
            ModConfiguredFeatures.ORE_NETHER_LAPIS, ModOreFeatures.modifiersWithCount(32,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_FERROSTONE = PlacedFeatures.register("ore_ferrostone",
            ModConfiguredFeatures.ORE_FERROSTONE, ModOreFeatures.modifiersWithCount(80,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> ORE_GILDED = PlacedFeatures.register("gilded_ore",
            ModConfiguredFeatures.ORE_GILDED, ModOreFeatures.modifiersWithCount(32,
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    public static final RegistryEntry<PlacedFeature> SOUL_BUSH_PATCH = PlacedFeatures.register("soul_bush_patch", ModConfiguredFeatures.PATCH_SOUL_BUSH,PlacedFeatures.BOTTOM_TO_TOP_RANGE, BiomePlacementModifier.of());
}
