package com.austin.nether_expanded.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class ModBlastFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public ModBlastFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NETHER_BLAST_FURNACE, pos, state, RecipeType.BLASTING);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.blast_furnace");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}