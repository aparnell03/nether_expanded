package com.austin.nether_expanded.entity;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;


@SuppressWarnings("EntityConstructor")
public class ElixrBlob extends ThrownItemEntity {
    public ElixrBlob(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ElixrBlob(World world, LivingEntity owner) {
        super(ModEntities.ELIXR_BLOB, owner, world);
    }

    public ElixrBlob(World world, double x, double y, double z) {
        super(ModEntities.ELIXR_BLOB, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ELIXR;
    }

    @Environment(EnvType.CLIENT)
    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return (ParticleEffect) (itemStack.isEmpty() ? ParticleTypes.DRAGON_BREATH : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 3.0F);

        if (entity instanceof LivingEntity) {
            if (!this.world.isClient) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(ModStatusEffects.TRANSFIGURE, 100, 1));
                this.discard();
            }
            entity.playSound(SoundEvents.ENTITY_SLIME_SQUISH_SMALL, 2F, 1F);
            this.discard();
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte) 3);
            this.remove(RemovalReason.DISCARDED);
        }

    }
}
