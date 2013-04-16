package extrabiomes.items;

import extrabiomes.utility.MultiItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSapling extends MultiItemBlock
{
    private static final int METADATA_BITMASK = 7;

    public ItemSapling(int var1)
    {
        super(var1);
    }

    private static int unmarkedMetadata(int var0)
    {
        return var0 & 7;
    }

    public String getItemNameIS(ItemStack var1)
    {
        int var2 = unmarkedMetadata(var1.getItemDamage());

        if (var2 > 6)
        {
            var2 = 0;
        }

        var1 = var1.copy();
        var1.setItemDamage(var2);
        return super.getItemNameIS(var1);
    }
}
