package com.austin.nether_expanded.enchantment;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class SoulRendEnchantment extends Enchantment {


    protected SoulRendEnchantment(Enchantment.Rarity weight, EquipmentSlot ... slot) {
        super(weight, EnchantmentTarget.WEAPON, slot);
    }
    @Override
    public int getMinPower(int level) {
        return level * 25;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {

        if (group != EntityGroup.UNDEAD) {
            return (float)2.5f;
        }
        return 0.0f;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof DamageEnchantment || other instanceof SoulRendEnchantment);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.getItem() instanceof AxeItem) {
            return true;
        }
        return super.isAcceptableItem(stack);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if(livingEntity.getType() != EntityType.PLAYER)
            livingEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.REND, 200));
        }
    }
}
