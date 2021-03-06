package imexoodeex.spectreboots.client.particles;

import imexoodeex.spectreboots.registry.RegisterParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import static imexoodeex.spectreboots.Spectreboots.LOGGER;

import java.util.Random;

public class SpectreBootsParticles {

    private static Random rand = new Random();

    public static void spawnRocketParticles(LivingEntity entity, World world) {
        float yBodyRot = entity.getYaw();

        Vec3d playerPos = entity.getPos();
        float random = (rand.nextFloat() - 0.005F) * 0.1F;

        // -58 minimalnie za wolno; -57 minimalnie za szybko; -57.25 ultra minimalnie za szybko; -57.299f minimalnie za wolno; -57.295 za szybko minimalnie tak że idealnie;
        Vec3d vLeft = new Vec3d(-0.2, 0 , 0 ).rotateX(0).rotateY((yBodyRot / -57.295f));
        Vec3d vRight = new Vec3d(0.2, 0 , 0 ).rotateX(0).rotateY((yBodyRot / -57.295f));


        Vec3d right = playerPos.add(vRight).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));
        Vec3d left = playerPos.add(vLeft).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));

        spawnParticles(entity, random, world, left, right);
    }

    private static void spawnParticles(LivingEntity entity, float random, World world, Vec3d left, Vec3d right) {
        if (!entity.isSubmergedInWater()) {
            for (int i = 0; i < 6; i++) {
                //left
                world.addParticle(RegisterParticles.PURPLE_PIECE, left.x, left.y, left.z, 0, -0.2D, 0);
                world.addParticle(RegisterParticles.PINK_PIECE, left.x, left.y, left.z, 0, -0.2D, 0);
                world.addParticle(RegisterParticles.GREEN_PIECE, left.x, left.y, left.z, 0, -0.2D, 0);
                //right
                world.addParticle(RegisterParticles.PURPLE_PIECE, right.x, right.y, right.z, 0, -0.2D,0);
                world.addParticle(RegisterParticles.PINK_PIECE, right.x, right.y, right.z, 0, -0.2D, 0);
                world.addParticle(RegisterParticles.GREEN_PIECE, right.x, right.y, right.z, 0, -0.2D, 0);
            }
            world.addParticle(ParticleTypes.SMOKE, left.x, left.y, left.z, 0, -0.2D, 0);
            world.addParticle(ParticleTypes.SMOKE, right.x, right.y, right.z, 0, -0.2D, 0);
        } else {
            for (int i = 0; i < 4; i++) {
                world.addParticle(ParticleTypes.BUBBLE, left.x, left.y, left.z, random, -0.02D, random);
                world.addParticle(ParticleTypes.BUBBLE, right.x, right.y, right.z, random, -0.02D, random);
            }
        }
    }

}
