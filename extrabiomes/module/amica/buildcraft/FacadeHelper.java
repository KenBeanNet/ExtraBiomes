package extrabiomes.module.amica.buildcraft;

import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.item.ItemStack;

public abstract class FacadeHelper
{
    public static void addBuildcraftFacade(int var0)
    {
        addBuildcraftFacade(var0, 0);
    }

    public static void addBuildcraftFacade(int var0, int var1)
    {
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", String.format("%d@%d", new Object[] {Integer.valueOf(var0), Integer.valueOf(var1)}));
    }

    public static void addBuildcraftFacade(ItemStack var0)
    {
        addBuildcraftFacade(var0.itemID, var0.getItemDamage());
    }
}
