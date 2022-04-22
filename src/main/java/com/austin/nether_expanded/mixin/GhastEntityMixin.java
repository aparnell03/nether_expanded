package com.austin.nether_expanded.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GhastEntity.class)
public class GhastEntityMixin extends MobEntity{

    protected GhastEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals",at = @At("TAIL"))
    protected void initGoals(CallbackInfo ci) {
        this.targetSelector.add(3, new ActiveTargetGoal<PiglinEntity>((MobEntity)this, PiglinEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<PiglinBruteEntity>((MobEntity)this, PiglinBruteEntity.class, true));
    }
}
