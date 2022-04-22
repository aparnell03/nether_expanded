package com.austin.nether_expanded.item.custom.swords;

import com.austin.nether_expanded.effect.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class QuartzSwordItem extends SwordItem {

    public QuartzSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 3), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 40, 1), attacker);
        return super.postHit(stack, target, attacker);
    }
}
