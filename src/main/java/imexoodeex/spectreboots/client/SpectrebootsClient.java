package imexoodeex.spectreboots.client;

import imexoodeex.spectreboots.registry.RegisterParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class SpectrebootsClient implements ClientModInitializer {

    public static KeyBinding spaceKeyBind;

    @Override
    public void onInitializeClient() {
//        spaceKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
//                "space", // The translation key of the keybinding's name
//                GLFW.GLFW_KEY_SPACE, // The keycode of the key
//                "category.spectreboots.on"
//        ));


        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/overspeed"));
        }));

        /* Registers our particle client-side.
         * First argument is our particle's instance, created previously on ExampleMod.
         * Second argument is the particle's factory. The factory controls how the particle behaves.
         * In this example, we'll use FlameParticle's Factory.*/
        ParticleFactoryRegistry.getInstance().register(RegisterParticles.OVERSPEED, FlameParticle.Factory::new);


    }
}
