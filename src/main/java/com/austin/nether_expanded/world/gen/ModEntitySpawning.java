package com.austin.nether_expanded.world.gen;

import com.austin.nether_expanded.entity.BloodZombieEntity;
import com.austin.nether_expanded.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawning {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES), SpawnGroup.MONSTER,
                ModEntities.BLOOD_ZOMBIE, 50, 1, 3);

        SpawnRestriction.register(ModEntities.BLOOD_ZOMBIE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
    }
}
