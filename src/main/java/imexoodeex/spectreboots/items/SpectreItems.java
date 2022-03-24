package imexoodeex.spectreboots.items;

import imexoodeex.spectreboots.armor.HermesBoots;
import imexoodeex.spectreboots.armor.RocketBoots;
import imexoodeex.spectreboots.util.ModItemGroup;
import net.minecraft.item.Item;

import static imexoodeex.spectreboots.registry.ItemsRegister.registerItems;

public class SpectreItems {
    public static Item hermes_boots = new HermesBoots(new Item.Settings().group(ModItemGroup.SPECTRE_BOOTS).maxCount(1). maxDamage(100));
    public static Item rocket_boots = new RocketBoots(new Item.Settings().group(ModItemGroup.SPECTRE_BOOTS).maxCount(1). maxDamage(100));

    public static void init() {
        registerItems("hermes_boots", hermes_boots);
        registerItems("rocket_boots", rocket_boots);
    }
}
