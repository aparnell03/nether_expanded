package com.austin.nether_expanded.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.SideShapeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;

public class HemomossBlock extends CarpetBlock {
    public HemomossBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSideSolid(world, pos, Direction.UP, SideShapeType.RIGID);
    }
}
