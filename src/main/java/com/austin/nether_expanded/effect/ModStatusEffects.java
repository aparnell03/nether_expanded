package com.austin.nether_expanded.effect;

import com.austin.nether_expanded.NetherExpanded;
import com.austin.nether_expanded.effect.effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {

    public static final StatusEffect BLEEDING = new BleedingStatusEffect();
    public static final StatusEffect SMITE = new SmiteStatusEffect();
    public static final StatusEffect BLIGHT = new BlightStatusEffect();
    public static final StatusEffect TRANSFIGURE = new TransfigureStatusEffect();
    public static final StatusEffect TELEPORT = new TeleportStatusEffect();
    public static final StatusEffect REND = new RendStatusEffect();
    public static final StatusEffect INFECT = new InfectStatusEffect();
    public static final StatusEffect XP = new XPStatusEffect();


    public static void registerModStatusEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "bleeding"), BLEEDING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "smite"), SMITE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "blight"), BLIGHT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "transfigure"), TRANSFIGURE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "teleport"), TELEPORT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "rend"), REND);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "infect"), INFECT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(NetherExpanded.MOD_ID, "xp"), XP);
    }
}
