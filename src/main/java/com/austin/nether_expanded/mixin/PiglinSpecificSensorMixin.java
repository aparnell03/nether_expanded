package com.austin.nether_expanded.mixin;

import com.austin.nether_expanded.NetherExpanded;
import com.austin.nether_expanded.entity.BloodZombieEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.LivingTargetCache;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.PiglinSpecificSensor;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Mixin(PiglinSpecificSensor.class)
public class PiglinSpecificSensorMixin {
    @Inject(method = "sense(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LivingEntity;)V", at = @At(ordinal = 5, value = "INVOKE_ASSIGN", target = "Ljava/util/Optional;of(Ljava/lang/Object;)Ljava/util/Optional;"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void senseInject(ServerWorld world, LivingEntity entity, CallbackInfo ci, Brain brain, Optional optional, Optional optional2, Optional optional3, Optional optional4, Optional optional5, Optional optional6, Optional optional7, int i, List list, List list2, LivingTargetCache livingTargetCache, Iterator var15, LivingEntity livingEntity2) {
        if (livingEntity2 instanceof GhastEntity || livingEntity2 instanceof BlazeEntity || livingEntity2 instanceof MagmaCubeEntity || livingEntity2 instanceof BloodZombieEntity) {
            optional = Optional.of((MobEntity)livingEntity2);
            brain.remember(MemoryModuleType.NEAREST_VISIBLE_NEMESIS, optional);
        }
    }
}
