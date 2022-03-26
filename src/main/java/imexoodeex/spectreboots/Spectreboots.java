package imexoodeex.spectreboots;

import imexoodeex.spectreboots.registry.RegisterParticles;
import imexoodeex.spectreboots.items.SpectreItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Spectreboots implements ModInitializer {
    public static final String MOD_ID = "spectreboots";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        SpectreItems.init();
        RegisterParticles.registerParticle();
    }
}
