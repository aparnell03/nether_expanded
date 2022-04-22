package com.austin.nether_expanded.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkeletonEntity.class)
public class SkeletonEntityMixin extends MobEntity {

    protected SkeletonEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick",at = @At(value = "HEAD"))
    public void tick(CallbackInfo cb) {
        if(this.getWorld().getDimension().hasCeiling()){
            convertToWitherSkeleton();
        }
    }

    protected void convertToWitherSkeleton() {
        this.convertTo(EntityType.WITHER_SKELETON, true);
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.AIR));
        this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.AIR));
        this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.AIR));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.AIR));
    }
}
