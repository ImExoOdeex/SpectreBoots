package imexoodeex.spectreboots.registry;

import imexoodeex.spectreboots.util.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static imexoodeex.spectreboots.Spectreboots.MOD_ID;

public class ItemsRegister extends Item {

    public ItemsRegister(Item.Settings settings) {
        super(settings);
    }

    public static Item registerItems(String itemName, Item item) {
        Registry.register(Registry.ITEM, createIdentifier(itemName), item);
        return item;
    }

    public static Identifier createIdentifier(String name) {
        return new Identifier(MOD_ID, name);
    }
}
