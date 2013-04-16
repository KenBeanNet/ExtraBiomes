package extrabiomes.module.fabrica.block;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

class FuelHandlerWoodSlabs implements IFuelHandler
{
    private final int slabID;

    FuelHandlerWoodSlabs(int var1)
    {
        this.slabID = var1;
    }

    public int getBurnTime(ItemStack var1)
    {
        return var1.itemID == this.slabID ? 150 : 0;
    }
}
