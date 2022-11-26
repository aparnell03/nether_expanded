package com.austin.nether_expanded.client.render.block;

import com.austin.nether_expanded.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ModBlockRenderer {
    public static void setRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOODROOT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEATHGRAIN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOUL_SHROOM_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOUL_FRUIT_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEMOMOSS_BLOCK, RenderLayer.getCutout());
    }
}
