package extrabiomes.handlers;

import extrabiomes.Extrabiomes;
import extrabiomes.items.LogTurner;
import extrabiomes.lib.Element;
import extrabiomes.lib.ItemSettings;
import extrabiomes.lib.ModuleControlSettings;
import net.minecraft.item.ItemStack;

public abstract class ItemHandler
{
    public static void createItems()
    {
        createLogTurner();
    }

    private static void createLogTurner()
    {
        int var0 = ItemSettings.LOGTURNER.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            LogTurner var1 = new LogTurner(var0);
            var1.setItemName("extrabiomes.logturner").setIconIndex(112).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            Element.LOGTURNER.set(new ItemStack(var1));
        }
    }
}
