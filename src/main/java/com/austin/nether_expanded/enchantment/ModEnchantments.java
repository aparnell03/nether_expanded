package com.austin.nether_expanded.enchantment;

import com.austin.nether_expanded.NetherExpanded;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static final Enchantment SOUL_REND = register("soul_rend", new SoulRendEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, name, enchantment);
    }
    public static void registerModEnchantments(){
        System.out.println("enchantments for " + NetherExpanded.MOD_ID);
    }
}
