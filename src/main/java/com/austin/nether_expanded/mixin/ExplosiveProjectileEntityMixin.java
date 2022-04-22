package com.austin.nether_expanded.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExplosiveProjectileEntity.class)
public class ExplosiveProjectileEntityMixin{
    @Inject(method = "tick",at = @At(value = "TAIL"))
    public void tick(CallbackInfo cb) {
        ((ExplosiveProjectileEntity) (Object) this).setVelocity(((ExplosiveProjectileEntity) (Object) this).getVelocity().multiply(1.1));
    if(((ExplosiveProjectileEntity) (Object) this).age > 200){
        ((ExplosiveProjectileEntity) (Object) this).discard();
    }
    }
}
