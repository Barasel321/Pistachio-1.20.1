package net.barasel321.pistachio;

import net.barasel321.pistachio.event.KeyInputHandler;
import net.barasel321.pistachio.networking.PistachioMessages;
import net.fabricmc.api.ClientModInitializer;

public class PistachioClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(){

        KeyInputHandler.register();
        PistachioMessages.registerS2CPackets();
    }
}
