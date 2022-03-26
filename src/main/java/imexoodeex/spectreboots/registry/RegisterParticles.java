package imexoodeex.spectreboots.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterParticles {

    public static final DefaultParticleType OVERSPEED = FabricParticleTypes.simple();

    public static void registerParticle() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("spectreboots", "overspeed"), OVERSPEED);
    }

}
