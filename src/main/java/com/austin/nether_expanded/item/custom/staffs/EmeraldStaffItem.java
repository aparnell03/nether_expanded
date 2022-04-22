package com.austin.nether_expanded.item.custom.staffs;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.google.common.collect.Sets;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Set;

public class EmeraldStaffItem extends Item {

    private Set<StatusEffectInstance> effects = Sets.newHashSet();

    public EmeraldStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.experienceLevel > 0) {
            user.addExperience(-4);
            ArrowEntity summon = EntityType.ARROW.create(user.getWorld());
            summon.addEffect(new StatusEffectInstance(ModStatusEffects.TRANSFIGURE, 100, 1));
            summon.setPosition((double) user.getX() + 0.5, (double) user.getY() + 1.5, (double) user.getZ() + 0.5);
            summon.setVelocity(user, user.getPitch(), user.getYaw(), user.getRoll(), 3.5f, 1.0f);
            world.spawnEntity(summon);

            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SHULKER_SHOOT, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            user.getItemCooldownManager().set(this, 50);
            itemStack.damage(1, user, (p) -> {
                p.sendToolBreakStatus(hand);
            });
            return TypedActionResult.success(itemStack, world.isClient());
        }else{
            return TypedActionResult.fail(itemStack);
        }
    }
}
