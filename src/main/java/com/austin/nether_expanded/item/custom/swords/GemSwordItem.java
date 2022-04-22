package com.austin.nether_expanded.item.custom.swords;

import com.austin.nether_expanded.effect.ModStatusEffects;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GemSwordItem extends SwordItem {

    public GemSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        SmallFireballEntity fireball = new SmallFireballEntity(world, user, 0.0, 0.0, 0.0);
        BlockPos blockPos = user.getBlockPos();
        fireball.setPosition((double) blockPos.getX()+0.5, (double) blockPos.getY()+1, (double) blockPos.getZ()+0.5);
        fireball.setVelocity(user, user.getPitch(), user.getYaw(), user.getRoll(), 3, 1);
        user.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1, 1);
        user.getWorld().spawnEntity(fireball);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20, 1, false, false));
        user.getItemCooldownManager().set(this, 40);

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target.getHealth()/target.getMaxHealth() <= 0.5 && target.getMaxHealth() <= 50){
            target.kill();
        }
        return super.postHit(stack, target, attacker);
    }
}
