package com.austin.nether_expanded.block.custom;

import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;

import java.util.Map;

public class EnchantedCauldronBlock extends AbstractCauldronBlock {

    public EnchantedCauldronBlock(Settings settings, Map<Item, CauldronBehavior> behaviorMap) {
        super(settings, behaviorMap);
    }

    @Override
    public boolean isFull(BlockState state) {
        return false;
    }
}
