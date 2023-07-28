package net.barasel321.pistachio.client.render;

import net.barasel321.pistachio.block.PistachioBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class PistachioBlockRenderer {

    public static void render(){
        BlockRenderLayerMap.INSTANCE.putBlock(PistachioBlocks.PHAGE_FIRE,RenderLayer.getCutout());
    }
}
