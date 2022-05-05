/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */
package com.austin.nether_expanded.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BloodZombieEntityRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE = new Identifier("nether_expanded","textures/entity/blood_zombie.png");

    public BloodZombieEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    protected void scale(ZombieEntity zombieEntity, MatrixStack matrixStack, float f) {
        float g = 1.0625F;
        matrixStack.scale(g, g, g);
        super.scale(zombieEntity, matrixStack, f);
    }

    public Identifier getTexture(ZombieEntity zombieEntity) {
        return TEXTURE;
    }
}

