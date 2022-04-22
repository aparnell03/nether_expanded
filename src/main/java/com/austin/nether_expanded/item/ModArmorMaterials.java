package com.austin.nether_expanded.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    BRONZE("bronze", 30, new int[]{2, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 0.0F, 0.05F, () -> {
        return Ingredient.ofItems(ModItems.BRONZE_INGOT);
    }),
    STEEL("steel", 30, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.STEEL_INGOT);
    }),
    GILDED_NETHERITE("gilded_netherite", 37, new int[]{3, 6, 8, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.1F, 0.11F, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DEMONITE("demonite", 37, new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, .15F, () -> {
        return Ingredient.ofItems(ModItems.DEMONITE_INGOT);
    }),
    CRIMSONITE("crimsonite", 37, new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.025F, () -> {
        return Ingredient.ofItems(ModItems.CRIMSONITE_INGOT);
    }),
    ENCRUSTED_CRIMSONITE("encrusted_crimsonite", 37, new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.5F, 0.08F, () -> {
        return Ingredient.ofItems(ModItems.CRIMSONITE_INGOT);
    }),
    WITHER("wither", 37, new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> {
        return Ingredient.ofItems(Items.NETHER_STAR);
    });

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
