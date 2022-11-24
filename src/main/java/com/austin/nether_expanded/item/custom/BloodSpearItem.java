package com.austin.nether_expanded.item.custom;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BloodSpearItem extends SwordItem {

    public BloodSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1, 1);
        int slot = user.getInventory().selectedSlot;
        ItemStack old = user.getStackInHand(hand);
        ItemStack flip = ModItems.WITHER_SPEAR.getDefaultStack();
        flip.setNbt(old.getNbt());
        user.getStackReference(slot).set(flip);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 1), attacker);
        target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.ENSANGUINED,200,0));
        return super.postHit(stack, target, attacker);
    }
}
