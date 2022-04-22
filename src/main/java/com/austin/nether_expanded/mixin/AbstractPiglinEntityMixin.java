package com.austin.nether_expanded.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.*;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractPiglinEntity.class)
public class AbstractPiglinEntityMixin extends MobEntity {
    protected AbstractPiglinEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    protected void initGoals() {
        this.targetSelector.add(3, new ActiveTargetGoal<GhastEntity>((MobEntity)this, GhastEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<BlazeEntity>((MobEntity)this, BlazeEntity.class, true));
    }
}
