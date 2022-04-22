package com.austin.nether_expanded.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShinyItem extends Item {
    public ShinyItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}