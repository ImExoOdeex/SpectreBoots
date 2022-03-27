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

        //overspeed particle
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/overspeed"));
        }));
        ParticleFactoryRegistry.getInstance().register(RegisterParticles.OVERSPEED, FlameParticle.Factory::new);

        //second overspeed particle
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/second_overspeed"));
        }));
        ParticleFactoryRegistry.getInstance().register(RegisterParticles.SEC0ND_OVERSPEED, FlameParticle.Factory::new);

        //purple piece
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/purple_piece"));
        }));
        ParticleFactoryRegistry.getInstance().register(RegisterParticles.PURPLE_PIECE, FlameParticle.Factory::new);

        //pink piece
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/pink_piece"));
        }));
        ParticleFactoryRegistry.getInstance().register(RegisterParticles.PINK_PIECE, FlameParticle.Factory::new);

        //green piece
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/green_piece"));
        }));
        ParticleFactoryRegistry.getInstance().register(RegisterParticles.GREEN_PIECE, FlameParticle.Factory::new);

    }
}
