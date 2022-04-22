package com.austin.nether_expanded.particle;

import com.austin.nether_expanded.NetherExpanded;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticleTypes{

    public static final DefaultParticleType DRIPPING_OBSIDIAN_BLOOD = FabricParticleTypes.simple();
    public static final DefaultParticleType FALLING_OBSIDIAN_BLOOD = FabricParticleTypes.simple();
    public static final DefaultParticleType LANDING_OBSIDIAN_BLOOD = FabricParticleTypes.simple();

    public static void registerParticles(String name, DefaultParticleType particle) {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(NetherExpanded.MOD_ID, "dripping_obsidian_blood"), DRIPPING_OBSIDIAN_BLOOD);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(NetherExpanded.MOD_ID, "falling_obsidian_blood"), FALLING_OBSIDIAN_BLOOD);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(NetherExpanded.MOD_ID, "landing_obsidian_blood"), LANDING_OBSIDIAN_BLOOD);
    }
    public static void registerModParticles(){
        System.out.println("particles for " + NetherExpanded.MOD_ID);
    }
}

