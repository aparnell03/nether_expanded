package com.austin.nether_expanded.item;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {

    BLACKSTONE(1, 150, 4.0F, 1.5F, 4, () -> {
        return Ingredient.ofItems(Items.BLACKSTONE);
    }),
    BRONZE(2, 400, 7.5F, 1F, 24, () -> {
        return Ingredient.ofItems(ModItems.BRONZE_INGOT);
    }),
    STEEL(3, 1200, 8F, 3.5F, 15, () -> {
        return Ingredient.ofItems(ModItems.STEEL_INGOT);
    }),
    QUARTZ(3, 450, 7.5F, 1.5F, 25, () -> {
        return Ingredient.ofItems(Items.QUARTZ);
    }),
    AMETHYST(3, 500, 8F, 1.5F, 26, () -> {
        return Ingredient.ofItems(Items.AMETHYST_SHARD);
    }),
    EMERALD(3, 550, 8.5F, 2.0F, 28, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    RUBY(3, 600, 9F, 2.5F, 30, () -> {
        return Ingredient.ofItems(ModItems.RUBY);
    }),
    ENCRUSTED(3, 800, 9.5F, 3.0F, 32, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GILDED_NETHERITE(4, 2063, 10.0F, 4.5F, 22, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DEMONITE(4, 2500, 12.0F, 6.0F, 30, () -> {
        return Ingredient.ofItems(ModItems.DEMONITE_INGOT);
    }),
    CRIMSONITE(4, 1200, 10.0F, 2.5F, 35, () -> {
        return Ingredient.ofItems(ModItems.CRIMSONITE_INGOT);
    }),
    GEM(4, 1200, 10.0F, 2.5F, 35, () -> {
        return Ingredient.ofItems(ModItems.ENCHANTED_GEM_CLUSTER);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
