package imexoodeex.spectreboots.armor;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import static imexoodeex.spectreboots.Spectreboots.LOGGER;
import static net.minecraft.block.PointedDripstoneBlock.createParticle;

public class HermesBoots extends TrinketItem {

    public HermesBoots(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(uuid, "specreboots:movement_speed",
                0.2, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
        return modifiers;
    }
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        Vec3d v = entity.getVelocity();
        double xSpeed = v.getX();
        double zSpeed = v.getZ();

        boolean isWalking = xSpeed > 0 || xSpeed < 0 || zSpeed > 0 || zSpeed < 0;

        LOGGER.info(isWalking);

        if (isWalking) {

        }

        super.tick(stack, slot, entity);
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
