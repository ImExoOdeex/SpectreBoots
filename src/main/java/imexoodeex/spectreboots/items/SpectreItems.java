package imexoodeex.spectreboots.items;

import imexoodeex.spectreboots.armor.HermesBoots;
import imexoodeex.spectreboots.util.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;

import static imexoodeex.spectreboots.registry.ItemsRegister.createGroup;
import static imexoodeex.spectreboots.registry.ItemsRegister.registerItems;

public class SpectreItems {
    public static Item hermes_boots = new HermesBoots(new Item.Settings().group(ModItemGroup.SPECTRE_BOOTS).maxCount(1). maxDamage(100));

    public static void init() {
        registerItems("hermes_boots", hermes_boots);
    }
}
