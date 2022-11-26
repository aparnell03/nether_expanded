package com.austin.nether_expanded.mixin;

import com.austin.nether_expanded.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeletonEntity.class)
public class WitherSkeletonEntityMixin extends MobEntity{
    protected WitherSkeletonEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V", at = @At(value = "TAIL"))
    protected void initEquipment(Random random, LocalDifficulty ld, CallbackInfo cb) {
        ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.BLACKSTONE_SWORD));
        if (random.nextFloat() <= 0.25f){
            ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        }else if (random.nextFloat() <= 0.01f){
            ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
        }else if (random.nextFloat() <= 0.005f){
            ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
            ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
            ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
            ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
            ((WitherSkeletonEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));

        }
    }


}

