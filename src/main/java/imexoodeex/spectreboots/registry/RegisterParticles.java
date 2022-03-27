package imexoodeex.spectreboots.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterParticles {

    public static final DefaultParticleType OVERSPEED = FabricParticleTypes.simple();
    public static final DefaultParticleType SEC0ND_OVERSPEED = FabricParticleTypes.simple();
    public static final DefaultParticleType PURPLE_PIECE = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_PIECE = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_PIECE = FabricParticleTypes.simple();

    public static void registerParticle() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("spectreboots", "overspeed"), OVERSPEED);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("spectreboots", "second_overspeed"), SEC0ND_OVERSPEED);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("spectreboots", "purple_piece"), PURPLE_PIECE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("spectreboots", "pink_piece"), PINK_PIECE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("spectreboots", "green_piece"), GREEN_PIECE);
    }

}
