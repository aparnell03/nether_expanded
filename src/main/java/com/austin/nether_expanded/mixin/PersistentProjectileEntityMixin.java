package com.austin.nether_expanded.mixin;

import net.minecraft.entity.projectile.PersistentProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PersistentProjectileEntity.class)
public class PersistentProjectileEntityMixin {

    @Shadow
    private double damage = 4.0;
}
