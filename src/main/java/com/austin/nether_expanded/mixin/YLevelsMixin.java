package com.austin.nether_expanded.mixin;

import net.minecraft.world.dimension.YLevels;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(YLevels.class)
public class YLevelsMixin{
    @Shadow @Final public static int NETHER_GENERATION_HEIGHT = 256;
    @Shadow @Final public static int NETHER_LOGICAL_HEIGHT = 256;
}