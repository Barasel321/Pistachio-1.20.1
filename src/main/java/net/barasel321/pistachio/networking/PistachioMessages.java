package net.barasel321.pistachio.networking;

import net.barasel321.pistachio.Pistachio;
import net.barasel321.pistachio.networking.packet.OreSmellC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class PistachioMessages {
    public static final Identifier SMELL_ORE_ABILITY_ID = new Identifier(Pistachio.MOD_ID, "smell_ore_ability");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(SMELL_ORE_ABILITY_ID, OreSmellC2SPacket::receive);
    }

    public static void registerS2CPackets() {

    }
}
