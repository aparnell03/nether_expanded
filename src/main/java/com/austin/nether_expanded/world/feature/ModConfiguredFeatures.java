package com.austin.nether_expanded.world.feature;

import com.austin.nether_expanded.NetherExpanded;
import com.austin.nether_expanded.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RuleTest BLACKSTONE = new BlockMatchRuleTest(Blocks.BLACKSTONE);
    public static final RuleTest BLOODSTONE = new BlockMatchRuleTest(ModBlocks.BLOODSTONE);
    public static final RuleTest BASALT = new BlockMatchRuleTest(Blocks.BASALT);
    public static final RuleTest SOUL_SOIL = new BlockMatchRuleTest(Blocks.SOUL_SOIL);

    public static final List<OreFeatureConfig.Target> AMETHYST_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.AMETHYST_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_AMETHYST = ConfiguredFeatures.register("amethyst_ore",
            Feature.ORE, new OreFeatureConfig(AMETHYST_ORE, 6));

    public static final List<OreFeatureConfig.Target> CRIMSONITE_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.CRIMSONITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_CRIMSONITE = ConfiguredFeatures.register("crimsonite_ore",
            Feature.ORE, new OreFeatureConfig(CRIMSONITE_ORE, 6));

    public static final List<OreFeatureConfig.Target> NETHER_COPPER_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHER_COPPER_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_NETHER_COPPER = ConfiguredFeatures.register("nether_copper_ore",
            Feature.ORE, new OreFeatureConfig(NETHER_COPPER_ORE, 8));

    public static final List<OreFeatureConfig.Target> NETHER_EMERALD_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHER_EMERALD_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_EMERALD_NETHER = ConfiguredFeatures.register("nether_emerald_ore",
            Feature.ORE, new OreFeatureConfig(NETHER_EMERALD_ORE, 6));

    public static final List<OreFeatureConfig.Target> NETHER_IRON_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHER_IRON_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_NETHER_IRON = ConfiguredFeatures.register("nether_iron_ore",
            Feature.ORE, new OreFeatureConfig(NETHER_IRON_ORE, 8));

    public static final List<OreFeatureConfig.Target> RUBY_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.RUBY_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_RUBY = ConfiguredFeatures.register("ruby_ore",
            Feature.ORE, new OreFeatureConfig(RUBY_ORE, 6));

    public static final List<OreFeatureConfig.Target> BLOODSTONE_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.BLOODSTONE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_BLOODSTONE = ConfiguredFeatures.register("bloodstone_ore",
            Feature.ORE, new OreFeatureConfig(BLOODSTONE_ORE, 33));

    public static final List<OreFeatureConfig.Target> BLOODSTONE_ORE_FOREST = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.BLOODSTONE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_FORST_BLOODSTONE = ConfiguredFeatures.register("bloodstone_ore_forest",
            Feature.ORE, new OreFeatureConfig(BLOODSTONE_ORE_FOREST, 38));

    public static final List<OreFeatureConfig.Target> GILDED_BLACKSTONE_ORE = List.of(
            OreFeatureConfig.createTarget(BLACKSTONE, Blocks.GILDED_BLACKSTONE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_GILDED = ConfiguredFeatures.register("gilded_ore",
            Feature.ORE, new OreFeatureConfig(GILDED_BLACKSTONE_ORE, 8));

    public static final List<OreFeatureConfig.Target> NETHER_LAPIS_ORE = List.of(
            OreFeatureConfig.createTarget(BLACKSTONE, ModBlocks.NETHER_LAPIS_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_NETHER_LAPIS = ConfiguredFeatures.register("nether_lapis_ore",
            Feature.ORE, new OreFeatureConfig(NETHER_LAPIS_ORE, 8));

    public static final List<OreFeatureConfig.Target> NETHER_DIAMOND_ORE = List.of(
            OreFeatureConfig.createTarget(BLOODSTONE, ModBlocks.NETHER_DIAMOND_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_NETHER_DIAMOND = ConfiguredFeatures.register("nether_diamond_ore",
            Feature.ORE, new OreFeatureConfig(NETHER_DIAMOND_ORE, 12));

    public static final List<OreFeatureConfig.Target> DEEPSLATE_ORE = List.of(
            OreFeatureConfig.createTarget(BASALT, Blocks.DEEPSLATE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_NETHER_DEEPSLATE = ConfiguredFeatures.register("nether_deepslate_ore",
            Feature.ORE, new OreFeatureConfig(DEEPSLATE_ORE, 35));

    public static final List<OreFeatureConfig.Target> SOUL_STONE_ORE = List.of(
            OreFeatureConfig.createTarget(SOUL_SOIL, ModBlocks.SOUL_STONE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_SOUL_STONE = ConfiguredFeatures.register("soul_stone_ore",
            Feature.ORE, new OreFeatureConfig(SOUL_STONE_ORE, 4));



    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + NetherExpanded.MOD_ID);
    }
}
