package com.austin.nether_expanded.entity;

import com.austin.nether_expanded.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


public class BloodZombieEntity extends ZombieEntity {
    public BloodZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    protected boolean burnsInDaylight() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DROWNED_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DROWNED_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DROWNED_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_DROWNED_STEP;
    }

    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);
        if (bl && this.getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = this.world.getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20, 10), this);
        }

        return bl;
    }

    @Override
    protected void initEquipment(LocalDifficulty difficulty) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.BLOOD_SWORD));
        this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0f);
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new ZombieAttackGoal(this, 1.0, false));
        this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0, true, 4, this::canBreakDoors));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>((MobEntity)this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<PiglinEntity>((MobEntity)this, PiglinEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<IronGolemEntity>((MobEntity)this, IronGolemEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal<ZombifiedPiglinEntity>(this, ZombifiedPiglinEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }



    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }
}
