package com.austin.nether_expanded.effect.effects;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class SmiteStatusEffect extends StatusEffect {

    public SmiteStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0xCCFFFF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(entity.getWorld());
        BlockPos blockPos = entity.getBlockPos();
        lightningEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
        entity.getWorld().spawnEntity(lightningEntity);
        for (ServerPlayerEntity serverPlayerEntity : entity.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, lightningEntity.getBoundingBox().expand(5.0))) {
            Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, lightningEntity);
        }
    }

}
