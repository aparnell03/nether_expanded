package com.austin.nether_expanded.item.custom.staffs;

import com.austin.nether_expanded.potion.ModPotions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
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

import java.util.Random;

public class QuartzStaffItem extends Item {

    public QuartzStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.experienceLevel > 0) {
            user.addExperience(-1);
            Random rand = new Random();
            int random = rand.nextInt(5);
            Potion potion = null;
            if (random == 0) {
                potion = ModPotions.BLEEDING;
            } else if (random == 1) {
                potion = ModPotions.BLIGHT;
            } else if (random == 2) {
                potion = Potions.SLOWNESS;
            } else if (random == 3) {
                potion = Potions.POISON;
            } else {
                potion = Potions.WEAKNESS;
            }

            PotionEntity potionEntity = new PotionEntity(world, user);
            potionEntity.setItem(PotionUtil.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
            potionEntity.setVelocity(user, user.getPitch(), user.getYaw(), -20.0f, 1.0f, 1.0f);
            world.spawnEntity(potionEntity);

            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 0.5f, 0.1f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            itemStack.damage(1, user, (p) -> {
                p.sendToolBreakStatus(hand);
            });
            return TypedActionResult.success(itemStack, world.isClient());
        }else{
            return TypedActionResult.fail(itemStack);
        }
    }
}
