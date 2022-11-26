package com.austin.nether_expanded.block.custom;

import com.austin.nether_expanded.block.ModBlocks;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CryingObsidianBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;


public class FesteringNetherWartBlock extends CryingObsidianBlock {
    public FesteringNetherWartBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f;
        int i;
        if (random.nextInt(10) == 0 && world.getBlockState(pos.up()).isAir()) {
            world.setBlockState(pos.up(), ModBlocks.HEMOMOSS_BLOCK.getDefaultState(), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) != 0) {
            return;
        }
        Direction direction = Direction.random(random);
        if (direction == Direction.UP) {
            return;
        }
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        if (state.isOpaque() && blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
            return;
        }
        double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetX() * 0.6;
        double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetY() * 0.6;
        double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetZ() * 0.6;
        world.addParticle(ParticleTypes.DRIPPING_LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 0.0, 0.0, 0.0);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player2.getStackInHand(hand);
            Item item = itemStack.getItem();
            if (itemStack.isOf(ModItems.TINTED_GLASS_BOTTLE)) {
                itemStack.decrement(1);
                world.playSound(player2, player2.getX(), player2.getY(), player2.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                if (itemStack.isEmpty()) {
                    player2.setStackInHand(hand, new ItemStack(ModItems.ICHOR_BOTTLE));
                } else if (!player2.getInventory().insertStack(new ItemStack(ModItems.ICHOR_BOTTLE))) {
                    player2.dropItem(new ItemStack(ModItems.ICHOR_BOTTLE), false);
                }
                world.emitGameEvent((Entity)player2, GameEvent.FLUID_PICKUP, pos);
                world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, Blocks.NETHER_WART_BLOCK.getDefaultState(), world, pos));
            }
            if (!world.isClient()) {
                player2.incrementStat(Stats.USED.getOrCreateStat(item));
            }
        return super.onUse(state, world, pos, player2, hand, hit);
    }
}
