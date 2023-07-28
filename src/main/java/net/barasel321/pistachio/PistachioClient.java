package net.barasel321.pistachio;

import net.barasel321.pistachio.block.PistachioBlocks;
import net.barasel321.pistachio.client.render.PistachioBlockRenderer;
import net.barasel321.pistachio.event.KeyInputHandler;
import net.barasel321.pistachio.networking.PistachioMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class PistachioClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(){

        KeyInputHandler.register();
        PistachioMessages.registerS2CPackets();

        PistachioBlockRenderer.render();
    }
}
