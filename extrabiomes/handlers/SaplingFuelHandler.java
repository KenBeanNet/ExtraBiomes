package extrabiomes.handlers;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class SaplingFuelHandler implements IFuelHandler
{
    private final int saplingID;

    public SaplingFuelHandler(int var1)
    {
        this.saplingID = var1;
    }

    public int getBurnTime(ItemStack var1)
    {
        return var1.itemID == this.saplingID ? 100 : 0;
    }
}
