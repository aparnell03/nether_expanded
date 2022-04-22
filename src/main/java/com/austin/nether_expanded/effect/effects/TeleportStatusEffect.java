package com.austin.nether_expanded.effect.effects;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class TeleportStatusEffect extends StatusEffect {

    public TeleportStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0x8D01C9);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient) {
            double d = entity.getX();
            double e = entity.getY();
            double f = entity.getZ();
            for (int i = 0; i < 16; ++i) {
                double g = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
                double h = MathHelper.clamp(entity.getY() + (double)(entity.getRandom().nextInt(16) - 8), (double)entity.getWorld().getBottomY(), (double)(entity.getWorld().getBottomY() + ((ServerWorld)entity.getWorld()).getLogicalHeight() - 1));
                double j = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
                if (entity.hasVehicle()) {
                    entity.stopRiding();
                }
                if (!entity.teleport(g, h, j, true)) continue;
                SoundEvent soundEvent = entity instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                entity.getWorld().playSound(null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
                entity.playSound(soundEvent, 1.0f, 1.0f);
                break;
            }
        }
    }

}
