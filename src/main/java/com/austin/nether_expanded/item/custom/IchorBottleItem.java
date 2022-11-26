package com.austin.nether_expanded.item.custom;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class IchorBottleItem extends HoneyBottleItem {
    public IchorBottleItem(Settings settings) {
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
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,500,0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,500,0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,500,0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,500,0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,500,0));
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BLIGHT,20,1));
        }
        if (stack.isEmpty()) {
            return new ItemStack(ModItems.TINTED_GLASS_BOTTLE);
        }
        if (user instanceof PlayerEntity playerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            ItemStack itemStack = new ItemStack(ModItems.TINTED_GLASS_BOTTLE);
            if (!playerEntity.getInventory().insertStack(itemStack)) {
                playerEntity.dropItem(itemStack, false);
            }
        }
        return stack;
    }
}
