package imexoodeex.spectreboots.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.spectreboots.client.particles.HermesBootsParticles;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class HermesBoots extends TrinketItem {


    public HermesBoots(Settings settings) {
        super(settings);
    }

//    double value = 0.6;
//    int a = 0;
//
//    void resetTimer() {
//        a = 0;
//    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        World world = entity.world;
        boolean isSprinting = entity.isSprinting();
        boolean isGrounded = entity.isOnGround();
        if (isSprinting && isGrounded) {
            HermesBootsParticles.spawnRocketParticles(entity, world);
        }
        /*
         * <p>Trinkets getModifiers function does updates only on game load, so fuck it
         * */
        /*add 0.05 to value with every 20 ticks, stop adding at 0.2 value*/
       /* if (entity.isSprinting()) {
            a++;
            LOGGER.info(a);
        } else if (!entity.isSprinting()){
            LOGGER.info("reset timer, beacuse not sprinting");
            resetTimer();
        }
        if (a >= 50) {
            value = 0.2;
            LOGGER.info("50 ticks");
        } else {
            value = 0.0;
        }*/

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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("hermesboots"));
        } else if (Screen.hasControlDown()) {
            tooltip.add(new TranslatableText("ctrl"));
        } else if (Screen.hasAltDown()) {
            tooltip.add(new TranslatableText("alt"));
        } else {
            tooltip.add(new TranslatableText("shift"));
        }
    }

}
