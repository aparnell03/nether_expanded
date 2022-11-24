package com.austin.nether_expanded.entity;

import com.austin.nether_expanded.NetherExpanded;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static final EntityType<ElixrBlob> ELIXR_BLOB = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(NetherExpanded.MOD_ID, "elixr_blob"),
            FabricEntityTypeBuilder.<ElixrBlob>create(SpawnGroup.MISC, ElixrBlob::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static void registerModEntities(){
        System.out.println("entities for " + NetherExpanded.MOD_ID);
    }
}
