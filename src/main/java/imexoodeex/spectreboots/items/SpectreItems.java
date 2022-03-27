package imexoodeex.spectreboots.items;

import imexoodeex.spectreboots.registry.ItemsRegister;
import imexoodeex.spectreboots.trinkets.HermesBoots;
import imexoodeex.spectreboots.trinkets.RocketBoots;
import imexoodeex.spectreboots.trinkets.SpectreBoots;
import imexoodeex.spectreboots.util.ModItemGroup;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

import static imexoodeex.spectreboots.registry.ItemsRegister.registerItems;

public class SpectreItems {

    private static final Item.Settings createGroup = new Item.Settings().group(ModItemGroup.SPECTRE_BOOTS).maxCount(1).maxDamage(100);

    public static Item hermes_boots = new HermesBoots(createGroup.rarity(Rarity.UNCOMMON));
    public static Item rocket_boots = new RocketBoots(createGroup.rarity(Rarity.RARE));
    public static Item spectre_boots = new SpectreBoots(createGroup.rarity(Rarity.EPIC));

    public static void init() {
        registerItems("hermes_boots", hermes_boots);
        registerItems("rocket_boots", rocket_boots);
        registerItems("spectre_boots", spectre_boots);
    }
}
