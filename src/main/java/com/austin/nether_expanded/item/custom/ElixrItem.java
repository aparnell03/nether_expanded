package com.austin.nether_expanded.item.custom;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class ElixrItem extends Item {
    public ElixrItem(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (!world.isClient) {
            StatusEffectInstance effect = user.getStatusEffect(StatusEffects.HEALTH_BOOST);
            if (effect != null){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, effect.getAmplifier()+1));
            }else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, 0));
            }
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 3));
        }
        return stack;
    }
}
