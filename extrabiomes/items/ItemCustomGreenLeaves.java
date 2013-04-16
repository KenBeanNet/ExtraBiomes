package extrabiomes.items;

import net.minecraft.item.ItemStack;

public class ItemCustomGreenLeaves extends ItemCustomLeaves
{
    public ItemCustomGreenLeaves(int var1)
    {
        super(var1);
    }

    public String getItemNameIS(ItemStack var1)
    {
        int var2 = unmarkedMetadata(var1.getItemDamage());

        if (var2 > 2)
        {
            var2 = 0;
        }

        var1 = var1.copy();
        var1.setItemDamage(var2);
        return super.getItemNameIS(var1);
    }
}
