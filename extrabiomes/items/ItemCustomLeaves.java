package extrabiomes.items;

import extrabiomes.utility.MultiItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCustomLeaves extends MultiItemBlock
{
    private static final int METADATA_BITMASK = 3;
    private static final int METADATA_USERPLACEDBIT = 4;

    protected static int unmarkedMetadata(int var0)
    {
        return var0 & 3;
    }

    public String getItemNameIS(ItemStack var1)
    {
        int var2 = unmarkedMetadata(var1.getItemDamage());

        if (var2 > 3)
        {
            var2 = 3;
        }

        var1 = var1.copy();
        var1.setItemDamage(var2);
        return super.getItemNameIS(var1);
    }

    private static int setUserPlacedOnMetadata(int var0)
    {
        return var0 | 4;
    }

    public ItemCustomLeaves(int var1)
    {
        super(var1);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int var1)
    {
        return setUserPlacedOnMetadata(var1);
    }
}
