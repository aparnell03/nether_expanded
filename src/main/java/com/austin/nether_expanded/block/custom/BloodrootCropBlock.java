package com.austin.nether_expanded.block.custom;


import com.austin.nether_expanded.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;


public class BloodrootCropBlock extends CropBlock {

    public BloodrootCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BLOODROOT_SEEDS;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.CRIMSON_NYLIUM) ;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f;
        int i;
        if (world.getBaseLightLevel(pos, 0) >= 5 && (i = this.getAge(state)) < this.getMaxAge() && random.nextInt((int) + 1) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos)) && super.canPlaceAt(state, world, pos);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return (false);
    }
}
