package com.austin.nether_expanded.effect.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import org.jetbrains.annotations.Nullable;

public class BlightStatusEffect extends StatusEffect {

    public BlightStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0xFFD500);
    }
    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
            int i = (int)(proximity * (double)(6 << amplifier) + 0.5);
            if (source == null) {
                target.damage(DamageSource.MAGIC, i);
            } else {
                target.damage(DamageSource.magic(source, attacker), i);
            }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(DamageSource.MAGIC, (float)(6 << amplifier));
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}
