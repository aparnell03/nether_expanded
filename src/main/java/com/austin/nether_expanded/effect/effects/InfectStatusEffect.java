package com.austin.nether_expanded.effect.effects;

import com.austin.nether_expanded.effect.ModStatusEffects;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class InfectStatusEffect extends StatusEffect {

    public InfectStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0x336600);
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
        if (entity.getGroup() != EntityGroup.UNDEAD) {
            entity.damage(DamageSource.MAGIC, 1.0f);
        }
        if(entity.getHealth()/entity.getMaxHealth() <= 0.35 && entity.getMaxHealth() <= 50){
            if (entity.getType() == EntityType.PIGLIN) {
                ((MobEntity)entity).convertTo(EntityType.ZOMBIFIED_PIGLIN, true);
            }else if (entity.getType() == EntityType.PIGLIN_BRUTE) {
                if (false){

                }else {
                    ((MobEntity)entity).convertTo(EntityType.ZOMBIFIED_PIGLIN, true);
                }
            }else if (entity.getType() == EntityType.VILLAGER || entity.getType() == EntityType.WANDERING_TRADER) {
                ((MobEntity)entity).convertTo(EntityType.ZOMBIE_VILLAGER, true);
            }else if (entity.getType() == EntityType.PLAYER) {
                ZombieEntity zombie = EntityType.ZOMBIE.create(entity.getWorld());
                zombie.refreshPositionAndAngles((double) entity.getX() + 0.5, (double) entity.getY() + 0.05, (double) entity.getZ() + 0.5, entity.getYaw(), entity.getPitch());
                entity.getWorld().spawnEntity(zombie);
                for (ServerPlayerEntity serverPlayerEntity : entity.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, zombie.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, zombie);
                }
                entity.kill();
            }else {
                entity.kill();
            }
        }
    }
}
