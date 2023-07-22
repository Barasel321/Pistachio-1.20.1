package net.barasel321.pistachio.networking.packet;

import net.barasel321.pistachio.util.PistachioTags;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;


public class OreSmellC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //ONLY SERVER DOES THINGS HERE
        ServerWorld world = (ServerWorld) player.getWorld();
        String[] ores = isOresAround(player, world, 4);
        if(ores.length>0) {

            String out = "I smell ";

            for (String ore : ores) {
                out = out + ore + ", ";
            }

            out = out.substring(0,out.length()-2);
            //BLOCK GLOW???
            player.sendMessage(Text.literal(out));
        } else {
            player.sendMessage(Text.literal("I smell nothing"));
        }
    }


    private static String[] isOresAround(ServerPlayerEntity player, ServerWorld world, int size) {
        return BlockPos.stream(player.getBoundingBox().expand(size))
                .map(world::getBlockState).filter(state -> state.isIn(PistachioTags.ORES))
                .map(BlockState::getBlock).map(Block::asItem).map(Item::getName).map(Text::getString)
                .toArray(String[]::new);

    }
}
