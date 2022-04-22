package com.austin.nether_expanded.block;

import com.austin.nether_expanded.NetherExpanded;
import com.austin.nether_expanded.block.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CRIMSONITE_ORE = registerBlock("crimsonite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(3.0f).resistance(0.4f).requiresTool().sounds(BlockSoundGroup.NETHER_GOLD_ORE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(3.5f).resistance(0.4f).requiresTool().sounds(BlockSoundGroup.NETHER_GOLD_ORE), UniformIntProvider.create(0, 2)), ItemGroup.BUILDING_BLOCKS);
    public static final Block NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(2.5f).resistance(0.4f).requiresTool().sounds(BlockSoundGroup.NETHER_GOLD_ORE), UniformIntProvider.create(0, 1)), ItemGroup.BUILDING_BLOCKS);
    public static final Block NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(3.5f).resistance(0.4f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(3, 6)), ItemGroup.BUILDING_BLOCKS);
    public static final Block AMETHYST_ORE = registerBlock("amethyst_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(3.25f).resistance(0.4f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(3, 6)), ItemGroup.BUILDING_BLOCKS);
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(3.75f).resistance(0.4f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(3, 6)), ItemGroup.BUILDING_BLOCKS);
    public static final Block NETHER_LAPIS_ORE = registerBlock("nether_lapis_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(1.25f).resistance(5.0f).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE), UniformIntProvider.create(2, 5)), ItemGroup.BUILDING_BLOCKS);

    public static final Block BLEEDING_OBSIDIAN = registerBlock("bleeding_obsidian",
            new BleedingObsidianBlock(FabricBlockSettings.of(Material.STONE).hardness(50.0f).resistance(1200.0f).luminance(state -> 8).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.of(Material.METAL).hardness(7.5f).resistance(3.5f).requiresTool().sounds(BlockSoundGroup.COPPER)), ItemGroup.BUILDING_BLOCKS);
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).hardness(10).resistance(10).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRIMSONITE_BLOCK = registerBlock("crimsonite_block",
            new Block(FabricBlockSettings.of(Material.METAL).hardness(8.0f).resistance(6.5f).requiresTool().sounds(BlockSoundGroup.COPPER)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(FabricBlockSettings.of(Material.METAL).hardness(66f).resistance(1200f).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(5.5f).resistance(4.5f).requiresTool().sounds(BlockSoundGroup.METAL)), ItemGroup.BUILDING_BLOCKS);

    public static final Block SOUL_STONE = registerBlock("soul_stone",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(6.5f).resistance(5.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), ItemGroup.BUILDING_BLOCKS);

    public static final Block FLESH_BLOCK = registerBlock("flesh_block",
            new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).hardness(1).resistance(1).requiresTool().sounds(BlockSoundGroup.NETHER_WART)), ItemGroup.BUILDING_BLOCKS);

    public static final Block NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).hardness(4.25f).resistance(8.0f).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block BLOODSTONE = registerBlock("bloodstone",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(1.8f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLISHED_BLOODSTONE = registerBlock("polished_bloodstone",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block BLOODSTONE_BRICKS = registerBlock("bloodstone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRACKED_BLOODSTONE = registerBlock("cracked_bloodstone",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(3.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_BLOODSTONE = registerBlock("chiseled_bloodstone",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block BLOODSTONE_BUTTON = registerBlock("bloodstone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).hardness(1.8f).resistance(6.0f).requiresTool()), ItemGroup.REDSTONE);
    public static final Block BLOODSTONE_PRESSURE_PLATE = registerBlock("bloodstone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).hardness(1.8f).resistance(6.0f).requiresTool()), ItemGroup.REDSTONE);

    public static final Block BLOODSTONE_WALL = registerBlock("bloodstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.DECORATIONS);
    public static final Block BLOODSTONE_STAIRS = registerBlock("bloodstone_stairs",
            new ModStairsBlock(ModBlocks.BLOODSTONE_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block BLOODSTONE_SLAB = registerBlock("bloodstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block BLOODSTONE_BRICK_WALL = registerBlock("bloodstone_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.DECORATIONS);
    public static final Block BLOODSTONE_BRICK_STAIRS = registerBlock("bloodstone_brick_stairs",
            new ModStairsBlock(ModBlocks.BLOODSTONE_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block BLOODSTONE_BRICK_SLAB = registerBlock("bloodstone_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block POLISHED_BLOODSTONE_WALL = registerBlock("polished_bloodstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.DECORATIONS);
    public static final Block POLISHED_BLOODSTONE_STAIRS = registerBlock("polished_bloodstone_stairs",
            new ModStairsBlock(ModBlocks.BLOODSTONE_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLISHED_BLOODSTONE_SLAB = registerBlock("polished_bloodstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block BLOOD_ALTAR = registerBlock("blood_altar",
            new AltarBlock(FabricBlockSettings.of(Material.STONE).hardness(50.0f).resistance(1200.0f).requiresTool()), ItemGroup.DECORATIONS);
    public static final Block CRIMSON_CRAFTING_TABLE = registerBlock("crimson_crafting_table",
            new ModCraftingTableBlock(FabricBlockSettings.of(Material.NETHER_WOOD).hardness(2.0f).resistance(3).sounds(BlockSoundGroup.WOOD)), ItemGroup.DECORATIONS);
    public static final Block WARPED_CRAFTING_TABLE = registerBlock("warped_crafting_table",
            new ModCraftingTableBlock(FabricBlockSettings.of(Material.NETHER_WOOD).hardness(2.0f).resistance(3).sounds(BlockSoundGroup.WOOD)), ItemGroup.DECORATIONS);
    public static final Block BLACKSTONE_FURNACE = registerBlock("blackstone_furnace",
            new ModFurnaceBlock(FabricBlockSettings.of(Material.STONE).hardness(3.5f).resistance(3.5f).luminance((state) -> state.get(ModFurnaceBlock.LIT) ? 13 : 0).requiresTool()), ItemGroup.DECORATIONS);
    public static final Block NETHER_BLAST_FURNACE = registerBlock("nether_blast_furnace",
            new ModBlastFurnaceBlock(FabricBlockSettings.of(Material.STONE).hardness(3.5f).resistance(3.5f).luminance((state) -> state.get(ModFurnaceBlock.LIT) ? 13 : 0).requiresTool().sounds(BlockSoundGroup.METAL)), ItemGroup.DECORATIONS);
    public static final Block FORGE = registerBlock("forge",
            new ForgeBlock(FabricBlockSettings.of(Material.STONE).hardness(4).resistance(4).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ItemGroup.DECORATIONS);

    public static final Block CRIMSON_BARREL = registerBlock("crimson_barrel",
            new ModBarrelBlock(FabricBlockSettings.of(Material.NETHER_WOOD).hardness(2.0f).resistance(3).sounds(BlockSoundGroup.WOOD)), ItemGroup.DECORATIONS);
    public static final Block WARPED_BARREL = registerBlock("warped_barrel",
            new ModBarrelBlock(FabricBlockSettings.of(Material.NETHER_WOOD).hardness(2.0f).resistance(3).sounds(BlockSoundGroup.WOOD)), ItemGroup.DECORATIONS);

    public static final Block BLOODROOT_CROP = registerBlockWithoutBlockItem("bloodroot_crop",
            new BloodrootCropBlock(FabricBlockSettings.copy(Blocks.NETHER_WART).nonOpaque().noCollision()), ItemGroup.FOOD);
    public static final Block SOUL_SHROOM_CROP = registerBlockWithoutBlockItem("soul_shroom_crop",
            new SoulShroomCropBlock(FabricBlockSettings.copy(Blocks.NETHER_WART).nonOpaque().noCollision().luminance((state) -> (state.get(SoulShroomCropBlock.AGE)+1)*3)), ItemGroup.FOOD);
    public static final Block SOUL_FRUIT_BUSH = registerBlockWithoutBlockItem("soul_fruit_bush",
            new SoulFruitBushBlock(FabricBlockSettings.copy(Blocks.SWEET_BERRY_BUSH).nonOpaque().noCollision().luminance((state) -> (state.get(SoulFruitBushBlock.AGE)-1)*6)), ItemGroup.FOOD);

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.BLOCK, new Identifier(NetherExpanded.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(NetherExpanded.MOD_ID, name), block);
    }

   private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(NetherExpanded.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
   }

    public static void registerModBlocks(){
        System.out.println("blocks for " + NetherExpanded.MOD_ID);
    }
}
