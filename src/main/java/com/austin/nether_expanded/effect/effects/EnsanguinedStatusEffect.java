package com.austin.nether_expanded.effect.effects;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;

import static com.austin.nether_expanded.item.custom.swords.EmeraldSwordItem.randomItems;

public class EnsanguinedStatusEffect extends StatusEffect {

    public EnsanguinedStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0xA10707);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 10 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(DamageSource.STARVE, 5.0f);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,20,0));
        randomItems(entity, entity);
        ExperienceOrbEntity orb = EntityType.EXPERIENCE_ORB.create(entity.getWorld());
        BlockPos blockPos = entity.getBlockPos();
        orb.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
        entity.getWorld().spawnEntity(orb);
    }
}
