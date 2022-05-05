package com.austin.nether_expanded.effect.effects;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class XPStatusEffect extends StatusEffect {

    public XPStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, 0x99FFFF);
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
        int num = amplifier*5;
        if(entity.getType() == EntityType.PLAYER){
            num += ((PlayerEntity)entity).experienceLevel;
            //players
            //bad effects
            if(num<5){
                entity.damage(DamageSource.STARVE, 1f);
            }
            if(num<8){
                if(!entity.hasStatusEffect(StatusEffects.BLINDNESS)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, amplifier));
                }
            }
            if(num<10){
                if(!entity.hasStatusEffect(StatusEffects.SLOWNESS)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, amplifier));
                }
            }
            if(num<12){
                if(!entity.hasStatusEffect(StatusEffects.WEAKNESS)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, amplifier));
                }
            }
            if(num<15){
                if(!entity.hasStatusEffect(StatusEffects.NAUSEA)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, amplifier));
                }
            }

            //good effects
            if(num>=5){
                entity.heal(1f);
            }
            if(num>=10){
                entity.heal(1f);
            }
            if(num>=15){
                if(!entity.hasStatusEffect(StatusEffects.SPEED)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, amplifier));
                }
            }
            if(num>=20){
                if(!entity.hasStatusEffect(StatusEffects.STRENGTH)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, amplifier));
                }
            }
            if(num>=25){
                if(!entity.hasStatusEffect(StatusEffects.RESISTANCE)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, amplifier));
                }
            }
            if(num>=30){
                if(!entity.hasStatusEffect(StatusEffects.HEALTH_BOOST)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1200, amplifier));
                }
            }
        }else {
            //mobs
            num += (int)(entity.getMaxHealth()*0.6);

            //bad effects
            if(num>=5){
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 150, amplifier));
            }
            if(num>=10){
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, amplifier));
            }
            if(num>=15){
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, amplifier));
            }
            if(num>=20){
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 600, amplifier));
            }
            if(num>=25){
                entity.damage(DamageSource.STARVE, 1f);
            }
            if(num>=30){
                entity.damage(DamageSource.STARVE, 1f);
            }
        }
    }
}
