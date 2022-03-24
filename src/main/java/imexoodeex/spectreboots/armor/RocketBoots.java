package imexoodeex.spectreboots.armor;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.spectreboots.client.ParticlesRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

import static imexoodeex.spectreboots.Spectreboots.LOGGER;

public class RocketBoots extends TrinketItem {

    public RocketBoots(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
            boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
            entity.handleFallDamage(1 ,0, DamageSource.FALL);
            Vec3d v = entity.getVelocity();
            double yVelocity = v.getY();

            World world = entity.world;

        for (int i = 0; i < 4; i++) {
            float fallBlocks0 = 1;
            float fallBlocks = (float) (fallBlocks0 + 0.3);

            entity.fallDistance = fallBlocks;
        }
            if (yVelocity < -2.2) {
                entity.fallDistance = 16.0F;
            } else if (yVelocity > -2.2 && yVelocity < -1.8) {
                entity.fallDistance = 8.0F;
            } else if (yVelocity > -1.8 && yVelocity < -1.3) {
                entity.fallDistance = 4.0F;
            } else if (yVelocity > -1.3) {
                entity.fallDistance = 3.0F;
            } else {
                entity.fallDistance = 0.0F;
            }
            if (isJumping) {
                entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
                ParticlesRender.spawnRocketParticles(entity, world);
            }
        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("rocketboots"));
        } else if (Screen.hasControlDown()) {
            tooltip.add(new TranslatableText("ctrl"));
        } else if (Screen.hasAltDown()) {
            tooltip.add(new TranslatableText("alt"));
        } else {
            tooltip.add(new TranslatableText("shift"));
        }
    }

}