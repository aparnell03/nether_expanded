package com.austin.nether_expanded.block.entity;

import com.austin.nether_expanded.NetherExpanded;
import com.austin.nether_expanded.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<ModFurnaceBlockEntity> BLACKSTONE_FURNACE;
    public static BlockEntityType<ModBlastFurnaceBlockEntity> NETHER_BLAST_FURNACE;
    public static BlockEntityType<ForgeBlockEntity> FORGE;

    public static void registerAllEntities() {
        BLACKSTONE_FURNACE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(NetherExpanded.MOD_ID, "blackstone_furnace"),
                FabricBlockEntityTypeBuilder.create(ModFurnaceBlockEntity::new,
                        ModBlocks.BLACKSTONE_FURNACE).build(null));
        NETHER_BLAST_FURNACE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(NetherExpanded.MOD_ID, "nether_blast_furnace"),
                FabricBlockEntityTypeBuilder.create(ModBlastFurnaceBlockEntity::new,
                        ModBlocks.NETHER_BLAST_FURNACE).build(null));
        FORGE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(NetherExpanded.MOD_ID, "forge"),
                FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new,
                        ModBlocks.FORGE).build(null));
    }
}

