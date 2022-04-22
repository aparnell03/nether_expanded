package com.austin.nether_expanded.item.custom.staffs;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class DiamondStaffItem extends Item {

    public DiamondStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.experienceLevel > 0) {
            user.addExperience(-5);
            LightningEntity summon = EntityType.LIGHTNING_BOLT.create(user.getWorld());
            BlockPos blockPos = new BlockPos(betterRaycast(world, user, RaycastContext.FluidHandling.NONE).getBlockPos());
            summon.setPosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());

            world.spawnEntity(summon);

            user.getItemCooldownManager().set(this, 50);
            itemStack.damage(1, user, (p) -> {
                p.sendToolBreakStatus(hand);
            });
            return TypedActionResult.success(itemStack, world.isClient());
        }else{
            return TypedActionResult.fail(itemStack);
        }
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
        double d = 12.0;
        Vec3d vec3d2 = vec3d.add((double)l * d, (double) k * d, (double)n * d);
        return world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, fluidHandling, player));
    }
}
