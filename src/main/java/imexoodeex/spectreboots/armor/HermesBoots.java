package imexoodeex.spectreboots.armor;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

import java.util.UUID;

import static net.minecraft.entity.attribute.EntityAttributeModifier.Operation.ADDITION;

public class HermesBoots extends TrinketItem {

    public HermesBoots(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(uuid, "spectreboots:movement_speed",
                2.0, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
        SlotAttributes.addSlotModifier(modifiers, "feet/shoes", uuid, 1, EntityAttributeModifier.Operation.ADDITION);
        return modifiers;
    }

//    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
//        var modifiers = super.getModifiers(stack, slot, entity, uuid);
//        // +200% movement speed
//        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(uuid, "spectreboots:movement_speed",
//                2.0, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
//        // If the player has access to ring slots, this will give them an extra one
//        SlotAttributes.addSlotModifier(modifiers, "feet/shoes", uuid, 1, ADDITION);
//        return modifiers;
//    }

}
