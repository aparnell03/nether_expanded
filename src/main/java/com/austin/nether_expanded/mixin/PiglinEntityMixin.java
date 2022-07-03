package com.austin.nether_expanded.mixin;

import com.austin.nether_expanded.item.ModItems;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinEntity.class)
public abstract class PiglinEntityMixin extends AbstractPiglinEntity{

    private static final TrackedData<Boolean> WARRIOR = DataTracker.registerData(PiglinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> COMMANDER = DataTracker.registerData(PiglinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> CHIEFTAIN = DataTracker.registerData(PiglinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> HELLION = DataTracker.registerData(PiglinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> WARLORD = DataTracker.registerData(PiglinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> CHAMPION = DataTracker.registerData(PiglinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> HERETIC = DataTracker.registerData(PiglinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public PiglinEntityMixin(EntityType<? extends AbstractPiglinEntity> entityType, World world) {
        super(entityType, world);
    }


    @Overwrite
    private ItemStack makeInitialWeapon() {
        if(isWarrior()){
            return new ItemStack(Items.IRON_SWORD);
        }
        if(isCommander()){
            return new ItemStack(ModItems.BRONZE_SWORD);
        }
        if (isChieftain()){
            return new ItemStack(ModItems.STEEL_SWORD);
        }
        if (isHellion()){
            return new ItemStack(Items.NETHERITE_SWORD);
        }
        if (isWarlord()){
            return new ItemStack(ModItems.GILDED_NETHERITE_SWORD);
        }
        if (isHeretic()){
            return new ItemStack(ModItems.WITHER_SWORD);
        }
        if ((double)this.random.nextFloat() < 0.5) {
            return new ItemStack(Items.CROSSBOW);
        }
        return new ItemStack(Items.GOLDEN_SWORD);
    }

    @Inject(method = "initDataTracker()V", at = @At("TAIL"))
    public void initDataTracker(CallbackInfo ci){
        this.dataTracker.startTracking(WARRIOR, false);
        this.dataTracker.startTracking(COMMANDER, false);
        this.dataTracker.startTracking(CHIEFTAIN, false);
        this.dataTracker.startTracking(HELLION, false);
        this.dataTracker.startTracking(WARLORD, false);
        this.dataTracker.startTracking(CHAMPION, false);
        this.dataTracker.startTracking(HERETIC, false);
    }
    @Inject(method = "initialize", at = @At("HEAD"))
    public void initializeInjectHead(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, NbtCompound entityNbt, CallbackInfoReturnable<EntityData> cir) {
        if (world.getRandom().nextFloat() < 0.075f) {
            this.setWarrior(true);
        }else if (world.getRandom().nextFloat() < 0.05f) {
            this.setCommander(true);
        }else if (world.getRandom().nextFloat() < 0.01f) {
            this.setChieftain(true);
        }else if (world.getRandom().nextFloat() < 0.005f) {
            this.setHellion(true);
        }else if (world.getRandom().nextFloat() < 0.005f) {
            this.setWarlord(true);
        }else if (world.getRandom().nextFloat() < 0.005f) {
            this.setChampion(true);
        }else if (world.getRandom().nextFloat() < 0.005f) {
            this.setHeretic(true);
        }
        this.equipStack(EquipmentSlot.MAINHAND, this.makeInitialWeapon());
    }

    @Inject(method = "initialize", at = @At("TAIL"))
    public void initializeInjectTail(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, NbtCompound entityNbt, CallbackInfoReturnable<EntityData> cir) {
        if (isCommander() || isChieftain() || isHellion() || isWarlord() || isChampion() || isHeretic()){
            if (isHellion() || isWarlord() || isChampion() || isHeretic()) {
                this.setEquipmentDropChance(EquipmentSlot.HEAD, 0f);
                this.setEquipmentDropChance(EquipmentSlot.CHEST, 0f);
                this.setEquipmentDropChance(EquipmentSlot.LEGS, 0f);
                this.setEquipmentDropChance(EquipmentSlot.FEET, 0f);
                this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0f);
            }
            if (isChieftain()){
                this.setEquipmentDropChance(EquipmentSlot.HEAD, 0.01f);
                this.setEquipmentDropChance(EquipmentSlot.CHEST, 0.01f);
                this.setEquipmentDropChance(EquipmentSlot.LEGS, 0.01f);
                this.setEquipmentDropChance(EquipmentSlot.FEET, 0.01f);
                this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.01f);
            }
        }
    }
        @Inject(method = "initEquipment(Lnet/minecraft/world/LocalDifficulty;)V", at = @At(value = "TAIL"))
    protected void initEquipment(LocalDifficulty ld, CallbackInfo cb) {
        if(isWarrior()){
            this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
            this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
        }else if(isCommander()){
            this.equipStack(EquipmentSlot.HEAD, new ItemStack(ModItems.BRONZE_HELMET));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(ModItems.BRONZE_CHESTPLATE));
            this.equipStack(EquipmentSlot.LEGS, new ItemStack(ModItems.BRONZE_LEGGINGS));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(ModItems.BRONZE_BOOTS));
        }else if(isChieftain()){
            this.equipStack(EquipmentSlot.HEAD, new ItemStack(ModItems.STEEL_HELMET));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(ModItems.STEEL_CHESTPLATE));
            this.equipStack(EquipmentSlot.LEGS, new ItemStack(ModItems.STEEL_LEGGINGS));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(ModItems.STEEL_BOOTS));
        }else if(isHellion()){
            this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
            this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
        }else if(isWarlord()){
            this.equipStack(EquipmentSlot.HEAD, new ItemStack(ModItems.GILDED_NETHERITE_HELMET));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(ModItems.GILDED_NETHERITE_CHESTPLATE));
            this.equipStack(EquipmentSlot.LEGS, new ItemStack(ModItems.GILDED_NETHERITE_LEGGINGS));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(ModItems.GILDED_NETHERITE_BOOTS));
        }else if(isChampion()){
            this.equipStack(EquipmentSlot.HEAD, new ItemStack(ModItems.ENCRUSTED_CRIMSONITE_HELMET));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(ModItems.ENCRUSTED_CRIMSONITE_CHESTPLATE));
            this.equipStack(EquipmentSlot.LEGS, new ItemStack(ModItems.ENCRUSTED_CRIMSONITE_LEGGINGS));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(ModItems.ENCRUSTED_CRIMSONITE_BOOTS));
        }else if(isHeretic()) {
            this.equipStack(EquipmentSlot.HEAD, new ItemStack(ModItems.WITHER_HELMET));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(ModItems.WITHER_CHESTPLATE));
            this.equipStack(EquipmentSlot.LEGS, new ItemStack(ModItems.WITHER_LEGGINGS));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(ModItems.WITHER_BOOTS));
        }
    }

    public boolean isWarrior() {
        return this.dataTracker.get(WARRIOR);
    }
    public boolean isCommander() {
        return this.dataTracker.get(COMMANDER);
    }
    public boolean isChieftain() {
        return this.dataTracker.get(CHIEFTAIN);
    }
    public boolean isHellion() {
        return this.dataTracker.get(HELLION);
    }
    public boolean isWarlord() {
        return this.dataTracker.get(WARLORD);
    }
    public boolean isChampion() {
        return this.dataTracker.get(CHAMPION);
    }
    public boolean isHeretic() {
        return this.dataTracker.get(HERETIC);
    }

    public void setWarrior(boolean warrior) {
        this.dataTracker.set(WARRIOR, warrior);
    }
    public void setCommander(boolean commander) {
        this.dataTracker.set(COMMANDER, commander);
    }
    public void setChieftain(boolean chieftain) {
        this.dataTracker.set(CHIEFTAIN, chieftain);
    }
    public void setHellion(boolean hellion) {
        this.dataTracker.set(HELLION, hellion);
    }
    public void setWarlord(boolean warlord) {
        this.dataTracker.set(WARLORD, warlord);
    }
    public void setChampion(boolean champion) {
        this.dataTracker.set(CHAMPION, champion);
    }
    public void setHeretic(boolean heretic) {
        this.dataTracker.set(HERETIC, heretic);
    }

}
