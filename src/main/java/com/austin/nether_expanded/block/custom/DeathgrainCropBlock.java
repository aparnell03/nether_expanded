package com.austin.nether_expanded.block.custom;


import com.austin.nether_expanded.block.ModBlocks;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;


public class DeathgrainCropBlock extends CropBlock {

    public DeathgrainCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (entity instanceof LivingEntity){
            entity.damage(DamageSource.MAGIC, 1);
        }
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.DEATHGRAIN_SEEDS;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.FERMENTED_WARPED_WART_BLOCK) ;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f;
        int i;
        if ((i = this.getAge(state)) < this.getMaxAge() && random.nextInt((int)+1+(i/2)) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return (world.getBaseLightLevel(pos, 8) <= 8 || !world.isSkyVisible(pos)) && super.canPlaceAt(state, world, pos);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return (false);
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, stack, dropExperience);
        this.dropExperienceWhenMined(world, pos, stack, UniformIntProvider.create(0, 2));
    }
}
