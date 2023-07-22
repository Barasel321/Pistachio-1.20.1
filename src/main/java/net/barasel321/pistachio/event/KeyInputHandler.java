package net.barasel321.pistachio.event;

import net.barasel321.pistachio.networking.PistachioMessages;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATERGORY_PISTACHIO = "key.category.pistachio";
    public static final String KEY_CAST_ABILITY = "key.pistachio.cast";

    public static KeyBinding castingAbility;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(castingAbility.wasPressed()) {
                //check ability number
                ClientPlayNetworking.send(PistachioMessages.SMELL_ORE_ABILITY_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register(){
        castingAbility = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_CAST_ABILITY,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KEY_CATERGORY_PISTACHIO
        ));
        registerKeyInputs();
    }

}
