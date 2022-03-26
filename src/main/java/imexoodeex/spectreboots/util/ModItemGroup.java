package imexoodeex.spectreboots.util;

import imexoodeex.spectreboots.Spectreboots;
import imexoodeex.spectreboots.registry.ItemsRegister;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SPECTRE_BOOTS = FabricItemGroupBuilder.build(
            new Identifier(Spectreboots.MOD_ID, "spectreboots"),
            () -> new ItemStack(Items.LEATHER_BOOTS));
}
