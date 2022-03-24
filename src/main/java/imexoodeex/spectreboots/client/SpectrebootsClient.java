package imexoodeex.spectreboots.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class SpectrebootsClient implements ClientModInitializer {

    public static KeyBinding spaceKeyBind;

    @Override
    public void onInitializeClient() {
        spaceKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "space", // The translation key of the keybinding's name
                GLFW.GLFW_KEY_SPACE, // The keycode of the key
                "category.spectreboots.on"
        ));
    }
}
