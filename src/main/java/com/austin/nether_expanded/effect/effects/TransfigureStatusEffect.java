package com.austin.nether_expanded.effect.effects;

import com.austin.nether_expanded.effect.ModStatusEffects;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class TransfigureStatusEffect extends StatusEffect {

    public TransfigureStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0xFF79CE);
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
        entity.damage(DamageSource.STARVE, 1.0f);
        if(entity.getHealth()/entity.getMaxHealth() <= 0.5 && entity.getMaxHealth() <= 50){
            if(entity.getType() != EntityType.PLAYER) {
                ((MobEntity) entity).convertTo(EntityType.PIG, false);
            }else {
                PigEntity pig = EntityType.PIG.create(entity.getWorld());
                pig.refreshPositionAndAngles((double) entity.getX() + 0.5, (double) entity.getY() + 0.05, (double) entity.getZ() + 0.5, entity.getYaw(), entity.getPitch());
                entity.getWorld().spawnEntity(pig);
                for (ServerPlayerEntity serverPlayerEntity : entity.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, pig.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, pig);
                }
                entity.kill();
            }
        }
    }
}
