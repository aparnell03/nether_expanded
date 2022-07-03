package com.austin.nether_expanded.item;

import com.austin.nether_expanded.NetherExpanded;
import com.austin.nether_expanded.block.ModBlocks;
import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.custom.*;
import com.austin.nether_expanded.item.custom.armor.CrimsoniteArmorItem;
import com.austin.nether_expanded.item.custom.armor.DemoniteArmorItem;
import com.austin.nether_expanded.item.custom.armor.EncrustedCrimsoniteArmorItem;
import com.austin.nether_expanded.item.custom.armor.WitherArmorItem;
import com.austin.nether_expanded.item.custom.staffs.*;
import com.austin.nether_expanded.item.custom.swords.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item CRIMSONITE_SCRAP = registerItem("crimsonite_scrap",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item RAW_CRIMSONITE = registerItem("raw_crimsonite",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item CRIMSONITE_INGOT = registerItem("crimsonite_ingot",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item DEMONITE_INGOT = registerItem("demonite_ingot",new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item PIG_IRON = registerItem("pig_iron",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item STEEL_SCRAP = registerItem("steel_scrap",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item RAW_STEEL = registerItem("raw_steel",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item STEEL_INGOT = registerItem("steel_ingot",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item GILDED_NETHERITE_INGOT = registerItem("gilded_netherite_ingot",new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));
    public static final Item MYSTICAL_POWDER = registerItem("mystical_powder",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item QUARTZ_CRYSTAL = registerItem("quartz_crystal",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item RUBY = registerItem("ruby",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENCHANTED_QUARTZ = registerItem("enchanted_quartz",new ShinyItem(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENCHANTED_AMETHYST = registerItem("enchanted_amethyst",new ShinyItem(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENCHANTED_EMERALD = registerItem("enchanted_emerald",new ShinyItem(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENCHANTED_RUBY = registerItem("enchanted_ruby",new ShinyItem(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENCHANTED_DIAMOND = registerItem("enchanted_diamond",new ShinyItem(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item GEM_CLUSTER = registerItem("gem_cluster",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENCHANTED_GEM_CLUSTER = registerItem("enchanted_gem_cluster",new ShinyItem(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item WITHER_BONE = registerItem("wither_bone",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item BLOOD_ZOMBIE_SPAWN_EGG = registerItem("blood_zombie_spawn_egg",new SpawnEggItem(NetherExpanded.BLOOD_ZOMBIE, 0, 0, new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item WITHER_POWDER = registerItem("wither_powder",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item SOUL_DUST = registerItem("soul_dust",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item PURE_GLOWSTONE_DUST = registerItem("glow_dust",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item LIGHTNING_POWDER = registerItem("lightning_powder",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item ECTOPLASM = registerItem("ectoplasm",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item BLIGHT = registerItem("blight",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item ENDER_ESSENCE = registerItem("ender_essence",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item VIRAL_ESSENCE = registerItem("viral_essence",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item FIRE_ESSENCE = registerItem("fire_essence",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    public static final Item TRANSFIGURATION_ESSENCE = registerItem("transfiguration_essence",new Item(new FabricItemSettings().group(ItemGroup.BREWING)));

    public static final Item ENDERITE_SHEET = registerItem("enderite_sheet",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot",new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item SOUL = registerItem("soul",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item SAND_SOUL = registerItem("sand_soul",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ENDER_SOUL = registerItem("ender_soul",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item UNDEAD_SOUL = registerItem("undead_soul",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item WITHER_SOUL = registerItem("wither_soul",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item FIRE_SOUL = registerItem("fire_soul",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item GLOW_SOUL = registerItem("glow_soul",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item SOUL_FRAGMENT = registerItem("soul_fragment",new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item BLOODROOT_SEEDS = registerItem("bloodroot_seeds",new BlockItem(ModBlocks.BLOODROOT_CROP, new FabricItemSettings().group(ItemGroup.FOOD)));

    public static final Item SOUL_FRUIT = registerItem("soul_fruit",(Item)new AliasedBlockItem(ModBlocks.SOUL_FRUIT_BUSH, new Item.Settings().group(ItemGroup.BREWING).food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0), 1.0f).build())));
    public static final Item SOUL_SHROOMS = registerItem("soul_shrooms",(Item)new AliasedBlockItem(ModBlocks.SOUL_SHROOM_CROP, new Item.Settings().group(ItemGroup.BREWING).food(new FoodComponent.Builder().snack().alwaysEdible().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(ModStatusEffects.XP, 200, 0), 0.5f).build())));

    public static final Item BLOODROOT = registerItem("bloodroot",new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().snack().hunger(5).saturationModifier(0.6f).build())));
    public static final Item GOLDEN_BLOODROOT = registerItem("golden_bloodroot",new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().snack().hunger(8).saturationModifier(0.9f).build())));
    public static final Item CRIMSON_HEART = registerItem("crimson_heart",new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 2), 1.0f).build())));
    public static final Item GOLDEN_HEART = registerItem("golden_heart",new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().alwaysEdible().hunger(5).saturationModifier(1f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 2), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 1), 1.0f).build())));
    public static final Item CRIMSON_STEW = registerItem("crimson_stew",new StewItem(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(4).saturationModifier(.2f).build())));
    public static final Item WARPED_STEW = registerItem("warped_stew",new StewItem(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 1.0F).statusEffect(new StatusEffectInstance(ModStatusEffects.TELEPORT, 1, 1), 1.0F).build())));

    public static final Item FORTRESS_COMPASS = registerItem("fortress_compass",new FortressCompassItem(new FabricItemSettings().maxCount(1).group(ItemGroup.TOOLS)));

    public static final Item SOUL_GLASS_SHARD = registerItem("soul_glass_shard",new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item TINTED_GLASS_BOTTLE = registerItem("tinted_glass_bottle",new TintedGlassBottleItem(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item LAVA_BOTTLE = registerItem("lava_bottle",new Item(new FabricItemSettings().maxCount(1).group(ItemGroup.MISC)));

    public static final Item QUARTZ_STAFF = registerItem("quartz_staff", new QuartzStaffItem(new FabricItemSettings().maxCount(1).maxDamage(1000).group(ItemGroup.COMBAT)));
    public static final Item AMETHYST_STAFF = registerItem("amethyst_staff", new AmethystStaffItem(new FabricItemSettings().maxCount(1).maxDamage(50).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_STAFF = registerItem("emerald_staff", new EmeraldStaffItem(new FabricItemSettings().maxCount(1).maxDamage(80).group(ItemGroup.COMBAT)));
    public static final Item RUBY_STAFF = registerItem("ruby_staff", new RubyStaffItem(new FabricItemSettings().maxCount(1).maxDamage(150).group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_STAFF = registerItem("diamond_staff", new DiamondStaffItem(new FabricItemSettings().maxCount(1).maxDamage(100).group(ItemGroup.COMBAT)));



    public static final Item BLACKSTONE_SWORD = registerItem("blackstone_sword",
            new SwordItem(ModToolMaterial.BLACKSTONE, 3, -2.8f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item BLACKSTONE_SHOVEL = registerItem("blackstone_shovel",
            new ShovelItem(ModToolMaterial.BLACKSTONE, 1.5f, -3.6f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item BLACKSTONE_PICKAXE = registerItem("blackstone_pickaxe",
            new ModPickaxeItem(ModToolMaterial.BLACKSTONE, 1, -3.2f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item BLACKSTONE_AXE = registerItem("blackstone_axe",
            new ModAxeItem(ModToolMaterial.BLACKSTONE, 6, -3.4f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item BLACKSTONE_HOE = registerItem("blackstone_hoe",
            new ModHoeItem(ModToolMaterial.BLACKSTONE, -1, 0f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item STEEL_HELMET = registerItem("steel_helmet",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item STEEL_BOOTS = registerItem("steel_boots",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(ModToolMaterial.STEEL, 3, -2.6f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            new ShovelItem(ModToolMaterial.STEEL, 1.5f, -3.2f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new ModPickaxeItem(ModToolMaterial.STEEL, 1, -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item STEEL_AXE = registerItem("steel_axe",
            new ModAxeItem(ModToolMaterial.STEEL, 5, -3.2f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item STEEL_HOE = registerItem("steel_hoe",
            new ModHoeItem(ModToolMaterial.STEEL, -1, 0f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item BRONZE_HELMET = registerItem("bronze_helmet",
            new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings",
            new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots",
            new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item BRONZE_SWORD = registerItem("bronze_sword",
            new SwordItem(ModToolMaterial.BRONZE, 3, -2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ShovelItem(ModToolMaterial.BRONZE, 1.5f, -2.6f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new ModPickaxeItem(ModToolMaterial.BRONZE, 1, -2.4f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new ModAxeItem(ModToolMaterial.BRONZE, 5, -2.6f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new ModHoeItem(ModToolMaterial.BRONZE, -1, 0.4f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item GILDED_NETHERITE_HELMET = registerItem("gilded_netherite_helmet",
            new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.HEAD,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item GILDED_NETHERITE_CHESTPLATE = registerItem("gilded_netherite_chestplate",
            new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.CHEST,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item GILDED_NETHERITE_LEGGINGS = registerItem("gilded_netherite_leggings",
            new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.LEGS,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item GILDED_NETHERITE_BOOTS = registerItem("gilded_netherite_boots",
            new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.FEET,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));

    public static final Item GILDED_NETHERITE_SWORD = registerItem("gilded_netherite_sword",
            new SwordItem(ModToolMaterial.GILDED_NETHERITE, 3, -2.2f,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item GILDED_NETHERITE_SHOVEL = registerItem("gilded_netherite_shovel",
            new ShovelItem(ModToolMaterial.GILDED_NETHERITE, 1.5f, -2.8f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));
    public static final Item GILDED_NETHERITE_PICKAXE = registerItem("gilded_netherite_pickaxe",
            new ModPickaxeItem(ModToolMaterial.GILDED_NETHERITE, 1, -2.6f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));
    public static final Item GILDED_NETHERITE_AXE = registerItem("gilded_netherite_axe",
            new ModAxeItem(ModToolMaterial.GILDED_NETHERITE, 5f, -2.8f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));
    public static final Item GILDED_NETHERITE_HOE = registerItem("gilded_netherite_hoe",
            new ModHoeItem(ModToolMaterial.GILDED_NETHERITE, 0, 0f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));

    public static final Item DEMONITE_HELMET = registerItem("demonite_helmet",
            new DemoniteArmorItem(ModArmorMaterials.DEMONITE, EquipmentSlot.HEAD,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item DEMONITE_CHESTPLATE = registerItem("demonite_chestplate",
            new DemoniteArmorItem(ModArmorMaterials.DEMONITE, EquipmentSlot.CHEST,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item DEMONITE_LEGGINGS = registerItem("demonite_leggings",
            new DemoniteArmorItem(ModArmorMaterials.DEMONITE, EquipmentSlot.LEGS,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item DEMONITE_BOOTS = registerItem("demonite_boots",
            new DemoniteArmorItem(ModArmorMaterials.DEMONITE, EquipmentSlot.FEET,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));

    public static final Item DEMONITE_SWORD = registerItem("demonite_sword",
            new SwordItem(ModToolMaterial.DEMONITE, 3, -2f,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item DEMONITE_SHOVEL = registerItem("demonite_shovel",
            new ShovelItem(ModToolMaterial.DEMONITE, 1.5f, -2.6f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));
    public static final Item DEMONITE_PICKAXE = registerItem("demonite_pickaxe",
            new ModPickaxeItem(ModToolMaterial.DEMONITE, 1, -2.5f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));
    public static final Item DEMONITE_AXE = registerItem("demonite_axe",
            new ModAxeItem(ModToolMaterial.DEMONITE, 5, -2.6f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));
    public static final Item DEMONITE_HOE = registerItem("demonite_hoe",
            new ModHoeItem(ModToolMaterial.DEMONITE, -1, 0.4f,
                    new FabricItemSettings().fireproof().group(ItemGroup.TOOLS)));

    public static final Item CRIMSONITE_HELMET = registerItem("crimsonite_helmet",
            new CrimsoniteArmorItem(ModArmorMaterials.CRIMSONITE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item CRIMSONITE_CHESTPLATE = registerItem("crimsonite_chestplate",
            new CrimsoniteArmorItem(ModArmorMaterials.CRIMSONITE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item CRIMSONITE_LEGGINGS = registerItem("crimsonite_leggings",
            new CrimsoniteArmorItem(ModArmorMaterials.CRIMSONITE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item CRIMSONITE_BOOTS = registerItem("crimsonite_boots",
            new CrimsoniteArmorItem(ModArmorMaterials.CRIMSONITE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item ENCRUSTED_CRIMSONITE_HELMET = registerItem("encrusted_crimsonite_helmet",
            new EncrustedCrimsoniteArmorItem(ModArmorMaterials.ENCRUSTED_CRIMSONITE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item ENCRUSTED_CRIMSONITE_CHESTPLATE = registerItem("encrusted_crimsonite_chestplate",
            new EncrustedCrimsoniteArmorItem(ModArmorMaterials.ENCRUSTED_CRIMSONITE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item ENCRUSTED_CRIMSONITE_LEGGINGS = registerItem("encrusted_crimsonite_leggings",
            new EncrustedCrimsoniteArmorItem(ModArmorMaterials.ENCRUSTED_CRIMSONITE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item ENCRUSTED_CRIMSONITE_BOOTS = registerItem("encrusted_crimsonite_boots",
            new EncrustedCrimsoniteArmorItem(ModArmorMaterials.ENCRUSTED_CRIMSONITE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item WITHER_HELMET = registerItem("wither_helmet",
            new WitherArmorItem(ModArmorMaterials.WITHER, EquipmentSlot.HEAD,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item WITHER_CHESTPLATE = registerItem("wither_chestplate",
            new WitherArmorItem(ModArmorMaterials.WITHER, EquipmentSlot.CHEST,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item WITHER_LEGGINGS = registerItem("wither_leggings",
            new WitherArmorItem(ModArmorMaterials.WITHER, EquipmentSlot.LEGS,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));
    public static final Item WITHER_BOOTS = registerItem("wither_boots",
            new WitherArmorItem(ModArmorMaterials.WITHER, EquipmentSlot.FEET,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));

    public static final Item QUARTZ_SWORD = registerItem("quartz_sword",
            new QuartzSwordItem(ModToolMaterial.QUARTZ, 3, -2.2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword",
            new AmethystSwordItem(ModToolMaterial.AMETHYST, 3, -2.2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item EMERALD_SWORD = registerItem("emerald_sword",
            new EmeraldSwordItem(ModToolMaterial.EMERALD, 3, -2.2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new RubySwordItem(ModToolMaterial.RUBY, 3, -2.1f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item ENCRUSTED_SWORD = registerItem("encrusted_sword",
            new EncrustedSwordItem(ModToolMaterial.ENCRUSTED, 3, -2.1f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item GEM_SWORD = registerItem("gem_sword",
            new GemSwordItem(ModToolMaterial.GEM, 4, -2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item CRIMSONITE_SWORD = registerItem("crimsonite_sword",
            new CrimsoniteSwordItem(ModToolMaterial.CRIMSONITE, 3, -2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item ENCRUSTED_CRIMSONITE_SWORD = registerItem("encrusted_crimsonite_sword",
            new EncrustedCrimsoniteSwordItem(ModToolMaterial.GEM, 5, -1.8f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item WITHER_SWORD = registerItem("wither_sword",
            new WitherSwordItem(ModToolMaterial.DEMONITE, 6, -1.6f,
                    new FabricItemSettings().fireproof().group(ItemGroup.COMBAT)));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(NetherExpanded.MOD_ID, name), item);
    }

    public static void registerModItems(){
      System.out.println("items for " + NetherExpanded.MOD_ID);
    }

}
