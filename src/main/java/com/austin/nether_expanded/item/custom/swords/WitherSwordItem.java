package com.austin.nether_expanded.item.custom.swords;

import com.austin.nether_expanded.effect.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class WitherSwordItem extends SwordItem {

    public WitherSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BLEEDING, 100, 10), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 10), attacker);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 3), attacker);
        attacker.removeStatusEffect(StatusEffects.WITHER);
        target.removeStatusEffect(StatusEffects.REGENERATION);
        target.removeStatusEffect(StatusEffects.RESISTANCE);
        target.removeStatusEffect(StatusEffects.FIRE_RESISTANCE);
        return super.postHit(stack, target, attacker);
    }
}
