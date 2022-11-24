package com.austin.nether_expanded.item.custom.swords;

import com.austin.nether_expanded.effect.ModStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class BloodSwordItem extends SwordItem {

    public BloodSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockPos blockPos = new BlockPos(betterRaycast(world, user, RaycastContext.FluidHandling.NONE).getBlockPos());
            user.setPosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SHULKER_TELEPORT, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            user.getItemCooldownManager().set(this, 50);
            itemStack.damage(1, user, (p) -> {
                p.sendToolBreakStatus(hand);
            });
            return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BLEEDING, 200, 0), attacker);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), attacker);
        return super.postHit(stack, target, attacker);
    }

    protected static BlockHitResult betterRaycast(World world, PlayerEntity player, RaycastContext.FluidHandling fluidHandling){
        float f = player.getPitch();
        float g = player.getYaw();
        Vec3d vec3d = player.getEyePos();
        float h = MathHelper.cos(-g * ((float)Math.PI / 180) - (float)Math.PI);
        float i = MathHelper.sin(-g * ((float)Math.PI / 180) - (float)Math.PI);
        float j = -MathHelper.cos(-f * ((float)Math.PI / 180));
        float k = MathHelper.sin(-f * ((float)Math.PI / 180));
        float l = i * j;
        float n = h * j;
        double d = 8.0;
        Vec3d vec3d2 = vec3d.add((double)l * d, (double) k * d, (double)n * d);
        return world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, fluidHandling, player));
    }
}
