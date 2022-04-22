package com.austin.nether_expanded.potion;

import com.austin.nether_expanded.NetherExpanded;
import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import com.austin.nether_expanded.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static final Potion BLEEDING = registerPotion("bleeding", new Potion(new StatusEffectInstance(ModStatusEffects.BLEEDING,900)));
    public static final Potion LONG_BLEEDING = registerPotion("long_bleeding", new Potion(new StatusEffectInstance(ModStatusEffects.BLEEDING,1800)));
    public static final Potion STRONG_BLEEDING = registerPotion("strong_bleeding", new Potion(new StatusEffectInstance(ModStatusEffects.BLEEDING,432, 1)));
    public static final Potion BLIGHT = registerPotion("blight", new Potion(new StatusEffectInstance(ModStatusEffects.BLIGHT, 1)));
    public static final Potion STRONG_BLIGHT = registerPotion("strong_blight", new Potion(new StatusEffectInstance(ModStatusEffects.BLIGHT, 1, 1)));
    public static final Potion SMITE = registerPotion("smite", new Potion(new StatusEffectInstance(ModStatusEffects.SMITE,200)));
    public static final Potion TRANSFIGURE = registerPotion("transfigure", new Potion(new StatusEffectInstance(ModStatusEffects.TRANSFIGURE,450)));
    public static final Potion LONG_TRANSFIGURE = registerPotion("long_transfigure", new Potion(new StatusEffectInstance(ModStatusEffects.TRANSFIGURE,900)));
    public static final Potion STRONG_TRANSFIGURE = registerPotion("strong_transfigure", new Potion(new StatusEffectInstance(ModStatusEffects.TRANSFIGURE,216, 1)));
    public static final Potion TELEPORT = registerPotion("teleport", new Potion(new StatusEffectInstance(ModStatusEffects.TELEPORT,200)));
    public static final Potion DECAY = registerPotion("decay", new Potion(new StatusEffectInstance(StatusEffects.WITHER,900)));
    public static final Potion LONG_DECAY = registerPotion("long_decay", new Potion(new StatusEffectInstance(StatusEffects.WITHER,1800)));
    public static final Potion STRONG_DECAY = registerPotion("strong_decay", new Potion(new StatusEffectInstance(StatusEffects.WITHER,432, 1)));
    public static final Potion BLINDNESS = registerPotion("blindness", new Potion(new StatusEffectInstance(StatusEffects.BLINDNESS,900)));
    public static final Potion LONG_BLINDNESS = registerPotion("long_blindness", new Potion(new StatusEffectInstance(StatusEffects.BLINDNESS,1800)));
    public static final Potion RESISTANCE = registerPotion("resistance", new Potion(new StatusEffectInstance(StatusEffects.RESISTANCE,3600)));
    public static final Potion LONG_RESISTANCE = registerPotion("long_resistance", new Potion(new StatusEffectInstance(StatusEffects.RESISTANCE,7200)));
    public static final Potion STRONG_RESISTANCE = registerPotion("strong_resistance", new Potion(new StatusEffectInstance(StatusEffects.RESISTANCE,1728, 1)));
    public static final Potion HEALTH_BOOST = registerPotion("health_boost", new Potion(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,3600)));
    public static final Potion LONG_HEALTH_BOOST = registerPotion("long_health_boost", new Potion(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,7200)));
    public static final Potion STRONG_HEALTH_BOOST = registerPotion("strong_health_boost", new Potion(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,1728, 1)));
    public static final Potion ABSORPTION = registerPotion("absorption", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION,3600)));
    public static final Potion LONG_ABSORPTION = registerPotion("long_absorption", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION,7200)));
    public static final Potion STRONG_ABSORPTION = registerPotion("strong_absorption", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION,1728, 1)));
    public static final Potion GLOWING = registerPotion("glowing", new Potion(new StatusEffectInstance(StatusEffects.GLOWING,900)));
    public static final Potion LONG_GLOWING = registerPotion("long_glowing", new Potion(new StatusEffectInstance(StatusEffects.GLOWING,1800)));
    public static final Potion INFECT = registerPotion("infect", new Potion(new StatusEffectInstance(ModStatusEffects.INFECT,675)));
    public static final Potion LONG_INFECT = registerPotion("long_infect", new Potion(new StatusEffectInstance(ModStatusEffects.INFECT,1350)));
    public static final Potion STRONG_INFECT = registerPotion("strong_infect", new Potion(new StatusEffectInstance(ModStatusEffects.INFECT,324, 1)));
    public static final Potion XP = registerPotion("xp", new Potion(new StatusEffectInstance(ModStatusEffects.XP,600)));
    public static final Potion LONG_XP = registerPotion("long_xp", new Potion(new StatusEffectInstance(ModStatusEffects.XP,1200)));
    public static final Potion STRONG_XP = registerPotion("strong_xp", new Potion(new StatusEffectInstance(ModStatusEffects.XP,288, 1)));

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, name, potion);

    }
    public static void registerModPotions(){
        System.out.println("potions for " + NetherExpanded.MOD_ID);
        registerPotionRecipes();
    }

    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.FIRE_ESSENCE, ModPotions.BLEEDING);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.BLEEDING, Items.REDSTONE, ModPotions.LONG_BLEEDING);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.BLEEDING, Items.GLOWSTONE_DUST, ModPotions.STRONG_BLEEDING);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.BLIGHT, ModPotions.BLIGHT);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.BLIGHT, ModItems.BLIGHT, ModPotions.STRONG_BLIGHT);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.LIGHTNING_POWDER, ModPotions.SMITE);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.TRANSFIGURATION_ESSENCE, ModPotions.TRANSFIGURE);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.TRANSFIGURE, Items.REDSTONE, ModPotions.LONG_TRANSFIGURE);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.TRANSFIGURE, Items.GLOWSTONE_DUST, ModPotions.STRONG_TRANSFIGURE);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.ENDER_ESSENCE, ModPotions.TELEPORT);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.WITHER_POWDER, ModPotions.DECAY);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.DECAY, Items.REDSTONE, ModPotions.LONG_DECAY);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.DECAY, Items.GLOWSTONE_DUST, ModPotions.STRONG_DECAY);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.PIG_IRON, ModPotions.RESISTANCE);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.RESISTANCE, Items.REDSTONE, ModPotions.LONG_RESISTANCE);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.RESISTANCE, Items.GLOWSTONE_DUST, ModPotions.STRONG_RESISTANCE);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.PURE_GLOWSTONE_DUST, ModPotions.GLOWING);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.GLOWING, Items.REDSTONE, ModPotions.LONG_GLOWING);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.SOUL_FRUIT, ModPotions.HEALTH_BOOST);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.HEALTH_BOOST, Items.REDSTONE, ModPotions.LONG_HEALTH_BOOST);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.HEALTH_BOOST, Items.GLOWSTONE_DUST, ModPotions.STRONG_HEALTH_BOOST);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.ECTOPLASM, ModPotions.ABSORPTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.ABSORPTION, Items.REDSTONE, ModPotions.LONG_ABSORPTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.ABSORPTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_ABSORPTION);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.SOUL_DUST, ModPotions.BLINDNESS);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.BLINDNESS, Items.REDSTONE, ModPotions.LONG_BLINDNESS);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.VIRAL_ESSENCE, ModPotions.INFECT);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.INFECT, Items.REDSTONE, ModPotions.LONG_INFECT);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.INFECT, Items.GLOWSTONE_DUST, ModPotions.STRONG_INFECT);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(Potions.AWKWARD, ModItems.SOUL_SHROOMS, ModPotions.XP);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.XP, Items.REDSTONE, ModPotions.LONG_XP);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRegistry(ModPotions.XP, Items.GLOWSTONE_DUST, ModPotions.STRONG_XP);
    }
}
