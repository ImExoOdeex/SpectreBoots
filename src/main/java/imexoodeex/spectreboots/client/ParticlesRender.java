package imexoodeex.spectreboots.client;

import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;
import static imexoodeex.spectreboots.Spectreboots.LOGGER;

import java.util.Random;

public class ParticlesRender {

    private static Random rand = new Random();

    public static void spawnRocketParticles(LivingEntity entity, World world) {
        Vec3d rot = entity.getRotationVecClient();
        float yBodyRot = (float) rot.y;

        Vec3d playerPos = entity.getPos()/*.add(0, 1, 0)*/;
//        LOGGER.info(playerPos);
        float random = (rand.nextFloat() - 0.5F) * 0.1F;

        Vec3d vLeft = new Vec3d(-0.1, -1.15 , 0 ).rotateX(0).rotateY(yBodyRot);
        Vec3d vRight = new Vec3d(0.1, -1.15 , 0 ).rotateX(0).rotateY(yBodyRot);

        Vec3d right = playerPos.add(vRight).add(new Vec3d(new Vec3f(entity.getPos().multiply(0.01D))));
        Vec3d left = playerPos.add(vLeft).add(new Vec3d(new Vec3f(entity.getPos().multiply(0.01D))));

        spawnParticles(entity, random, world, left, right);
    }

    private static void spawnParticles(LivingEntity entity, float random, World world, Vec3d left, Vec3d right) {
        if (!entity.isSubmergedInWater()) {
            world.addParticle(ParticleTypes.FLAME, left.x, left.y, left.z, 0, -0.2D, 0);
            world.addParticle(ParticleTypes.SMOKE, right.x, right.y, right.z, 0, -0.2D, 0);

            world.addParticle(ParticleTypes.FLAME, left.x, left.y, left.z, 0, -0.2D, 0);
            world.addParticle(ParticleTypes.SMOKE, right.x, right.y, right.z, 0, -0.2D, 0);
        } else {
            world.addParticle(ParticleTypes.BUBBLE, left.x, left.y, left.z, random, -0.2D, random);
            world.addParticle(ParticleTypes.BUBBLE, right.x, right.y, right.z, random, -0.2D, random);
        }
    }

}
