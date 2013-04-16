package extrabiomes.items;

import extrabiomes.utility.MultiItemBlock;
import net.minecraft.item.ItemStack;

public class ItemFlower extends MultiItemBlock
{
    public ItemFlower(int var1)
    {
        super(var1);
    }

    public String getItemNameIS(ItemStack var1)
    {
        int var2 = var1.getItemDamage();

        if (var2 > 7)
        {
            var2 = 7;
        }

        var1 = var1.copy();
        var1.setItemDamage(var2);
        return super.getItemNameIS(var1);
    }
}
