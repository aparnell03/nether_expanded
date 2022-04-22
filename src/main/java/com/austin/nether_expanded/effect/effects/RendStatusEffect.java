package com.austin.nether_expanded.effect.effects;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class RendStatusEffect extends StatusEffect {

    public RendStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0xC087FF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        ItemEntity soul = EntityType.ITEM.create(entity.getWorld());
        BlockPos blockPos = entity.getBlockPos();
        if (entity.getHealth() < 0.25) {
            if(entity.getGroup() != EntityGroup.ARTHROPOD || entity.getGroup() != EntityGroup.AQUATIC) {
                if (entity.getType() == EntityType.WITHER_SKELETON) {
                    soul.setStack(new ItemStack(ModItems.WITHER_SOUL));
                } else if (entity.getGroup() == EntityGroup.UNDEAD) {
                    soul.setStack(new ItemStack(ModItems.UNDEAD_SOUL));
                } else if (entity.getType() == EntityType.BLAZE) {
                    soul.setStack(new ItemStack(ModItems.FIRE_SOUL));
                } else if (entity.getType() == EntityType.ENDERMAN) {
                    soul.setStack(new ItemStack(ModItems.ENDER_SOUL));
                } else if (entity.getGroup() == EntityGroup.ILLAGER || entity.getType() == EntityType.WOLF || entity.getType() == EntityType.LLAMA || entity.getType() == EntityType.CAT || entity.getType() == EntityType.PARROT || entity.getType() == EntityType.DOLPHIN || entity.getType() == EntityType.VILLAGER || entity.getType() == EntityType.WITCH || entity.getType() == EntityType.PANDA || entity.getType() == EntityType.PLAYER || entity.getType() == EntityType.PIGLIN || entity.getType() == EntityType.PIGLIN_BRUTE || entity.getType() == EntityType.WANDERING_TRADER || entity.getType() == EntityType.HORSE || entity.getType() == EntityType.MULE || entity.getType() == EntityType.DONKEY || entity.getType() == EntityType.TRADER_LLAMA) {
                    soul.setStack(new ItemStack(ModItems.SOUL));
                }else{
                    soul.setStack(new ItemStack(ModItems.SOUL_FRAGMENT));
                }
                soul.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 2.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SMITE));
                entity.getWorld().sendEntityStatus(entity, (byte)46);
                entity.getWorld().spawnEntity(soul);
                entity.getWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.PLAYERS, 0.2f, 0.0f);
                entity.remove(Entity.RemovalReason.DISCARDED);
            }
        }
    }
}
