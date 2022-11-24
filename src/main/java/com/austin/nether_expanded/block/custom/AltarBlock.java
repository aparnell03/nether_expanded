package com.austin.nether_expanded.block.custom;

import com.austin.nether_expanded.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class AltarBlock extends Block {
    public static final IntProperty CHARGES = IntProperty.of("charges", 0, 12);

    public AltarBlock(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(getChargesProperty(), 0));

    }
    public IntProperty getChargesProperty() {
        return CHARGES;
    }

    public int getMaxCharges() {
        return 12;
    }

    public static int getLightLevel(BlockState state, int maxLevel) {
        return MathHelper.floor((float)(state.get(CHARGES)) / 12.0f * (float)maxLevel);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (hand == Hand.MAIN_HAND && !AltarBlock.isChargeItem(itemStack) && AltarBlock.isChargeItem(player.getStackInHand(Hand.OFF_HAND))) {
            return ActionResult.PASS;
        }
        if (AltarBlock.isChargeItem(itemStack) && AltarBlock.canCharge(state)) {
            AltarBlock.charge(world, pos, state);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.SOUL_DUST) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(2) != 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.SAND_SOUL));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.PURE_GLOWSTONE_DUST) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(2) != 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.GLOW_SOUL));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(Items.BONE) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(new ItemStack(Items.CHARCOAL));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.LAVA_BOTTLE) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(Items.ROTTEN_FLESH) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(new ItemStack(Items.LEATHER));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(Items.LEATHER) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(new ItemStack(Items.COAL));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(Items.MAGMA_CREAM) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(new ItemStack(Items.SLIME_BALL));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(Items.GHAST_TEAR) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(new ItemStack(ModItems.CRIMSON_HEART));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(Items.ENDER_PEARL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(new ItemStack(Items.CHORUS_FRUIT));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.SOUL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(3) == 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.LEATHER));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }else if(random.nextInt(3) == 1) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.BONE));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            if(random.nextInt(2) != 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.ECTOPLASM));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            player.addExperience(5);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.UNDEAD_SOUL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(3) == 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.ROTTEN_FLESH));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }else if(random.nextInt(3) == 1) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.BONE));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            if(random.nextInt(4) == 1) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.VIRAL_ESSENCE));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            player.addExperience(5);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.WITHER_SOUL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(12) == 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.WITHER_SKELETON_SKULL));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            } else if(random.nextInt(4) == 1) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.COAL));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            } else if(random.nextInt(4) == 2) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.WITHER_BONE));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            if(random.nextInt(4) == 1) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.WITHER_POWDER));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            player.addExperience(5);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.FIRE_SOUL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(4) == 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.BLAZE_POWDER));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            } else if(random.nextInt(4) == 1) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(Items.MAGMA_CREAM));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            if(random.nextInt(2) == 1) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.FIRE_ESSENCE));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            player.addExperience(5);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.ENDER_SOUL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(9) != 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.ENDER_ESSENCE));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            player.addExperience(20);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.GLOW_SOUL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(9) != 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.BLIGHT));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            player.addExperience(1);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.SAND_SOUL) && state.get(CHARGES) > 0) {
            AltarBlock.uncharge(world, pos, state);
            Random random = new Random();
            if(random.nextInt(9) != 0) {
                ItemEntity item = EntityType.ITEM.create(world);
                item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                item.setStack(new ItemStack(ModItems.ECTOPLASM));
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
                world.spawnEntity(item);
            }
            player.addExperience(1);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        if (itemStack.isOf(ModItems.CRIMSONITE_SWORD) && state.get(CHARGES) == 12) {
            for(int i=0;i<2;i++){
                AltarBlock.uncharge(world, pos, state);
            }
            ItemEntity item = EntityType.ITEM.create(world);
            item.setPos(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
            item.setStack(new ItemStack(ModItems.BLOOD_SWORD));
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, item.getX(), item.getY(), item.getZ(), 0, 0, 0);
            world.spawnEntity(item);
            world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }

        if (state.get(CHARGES) == 0) {
            return ActionResult.PASS;
        }
        return ActionResult.success(world.isClient);
    }
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(CHARGES) == 0) {
            return;
        }
        if (random.nextInt(100) == 0) {
            world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_RESPAWN_ANCHOR_AMBIENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        double d = (double)pos.getX() + 0.5 + (0.5 - random.nextDouble());
        double e = (double)pos.getY() + 1.0;
        double f = (double)pos.getZ() + 0.5 + (0.5 - random.nextDouble());
        double g = (double)random.nextFloat() * 0.04;
        world.addParticle(ParticleTypes.CRIMSON_SPORE, d, e, f, 0.0, g, 0.0);
        if(random.nextInt(0,100) == 1){
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d, e, f, 0.0, g, 0.0);
        }
    }

    public static void charge(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, (BlockState)state.with(CHARGES, state.get(CHARGES) + 1), Block.NOTIFY_ALL);
        world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }

    public static void uncharge(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, (BlockState)state.with(CHARGES, state.get(CHARGES) - 1), Block.NOTIFY_ALL);
        if(state.get(CHARGES) == 0){
            world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.BLOCKS, 1.0f, 0.0f);
        } else{
            world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0f, 0.0f);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(getChargesProperty());
    }

    private static boolean isChargeItem(ItemStack stack) {
        return stack.isOf(ModItems.SOUL_FRAGMENT);
    }
    private static boolean canCharge(BlockState state) {
        return state.get(CHARGES) < 12;
    }

}
