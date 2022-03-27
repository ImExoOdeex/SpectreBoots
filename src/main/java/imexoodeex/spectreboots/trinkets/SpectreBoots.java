package imexoodeex.spectreboots.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.spectreboots.client.particles.HermesBootsParticles;
import imexoodeex.spectreboots.client.particles.SpectreBootsParticles;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static imexoodeex.spectreboots.Spectreboots.LOGGER;

import java.util.List;
import java.util.UUID;

public class SpectreBoots extends TrinketItem {

    public SpectreBoots(Settings settings) {
        super(settings);
    }

    int a = 0;

    private void resetTimer() {
        a = 0;
    }
    private final int activeValue = 15;

    /* 20 tick is 1 second, so 7 * 1 sec is 7 seconds of flying*/
    private double flightTime = 7 * 20;
    private final double flightTimeMax = 7 * 20;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

            boolean isSprinting = entity.isSprinting();
            boolean isGrounded = entity.isOnGround();
            boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
            boolean isRocketFlying = isJumping && !isGrounded && !entity.isClimbing() && a >= activeValue;
            Vec3d v = entity.getVelocity();
            double yVelocity = v.getY();

            World world = entity.world;

            if (isSprinting && isGrounded) {
                HermesBootsParticles.spawnRocketParticles(entity, world);
            }

            if (yVelocity < -2.2) {
                entity.fallDistance = 24.0F;
            } else if (yVelocity > -2.2 && yVelocity < -1.8) {
                entity.fallDistance = 10.0F;
            } else if (yVelocity > -1.8 && yVelocity < -1.5) {
                entity.fallDistance = 4.0F;
            } else if (yVelocity > -1.5) {
                entity.fallDistance = 3.0F;
            } else {
                entity.fallDistance = 0.0F;
            }

            if (isJumping || !isGrounded) {
                a++;
            } else {
                resetTimer();
            }

            if (entity.isSwimming() && entity.isInSwimmingPose()) {
                entity.setVelocity(v.getX(), v.getY(), v.getZ());
            }
            else if (entity.isSubmergedInWater() && isJumping) {
                entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.01, v.getZ());
                SpectreBootsParticles.spawnRocketParticles(entity, world);
            }
            else if (isJumping && !isGrounded && !entity.isClimbing() && a >= activeValue ) {
                if (flightTime > 0) {
                    flightTime--;
                    entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
                    SpectreBootsParticles.spawnRocketParticles(entity, world);
                }
            }
            if (!isRocketFlying) {
                flightTime = flightTime + 0.2;
            }

            if (flightTime > flightTimeMax) {
                flightTime = flightTimeMax;
            }

        super.tick(stack, slot, entity);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);

        EntityAttributeModifier speedModifier = new EntityAttributeModifier(uuid, "specreboots:movement_speed",
                0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
        return modifiers;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        flightTime = flightTime + 0.2;
        if (flightTime > flightTimeMax) {
            flightTime = flightTimeMax;
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("spectreboots"));
        } else if (Screen.hasControlDown()) {
            tooltip.add(new TranslatableText("ctrl"));
        } else if (Screen.hasAltDown()) {
            tooltip.add(new TranslatableText("alt"));
        } else {
            tooltip.add(new TranslatableText("shift"));
        }
    }

}
