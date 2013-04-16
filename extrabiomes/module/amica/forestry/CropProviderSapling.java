package extrabiomes.module.amica.forestry;

import com.google.common.collect.Lists;
import extrabiomes.helpers.ForestryModHelper;
import forestry.api.cultivation.ICropEntity;
import forestry.api.cultivation.ICropProvider;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CropProviderSapling implements ICropProvider
{
    private static int forestrySoilBlockID = 0;

    public boolean isGermling(ItemStack var1)
    {
        return ForestryModHelper.isGermling(var1);
    }

    public boolean isCrop(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getBlockId(var2, var3, var4);
        return var5 != 0 && Block.blocksList[var5] != null ? Block.blocksList[var5].isWood(var1, var2, var3, var4) : false;
    }

    public ItemStack[] getWindfall()
    {
        ArrayList var1 = Lists.newArrayList(ForestryModHelper.getSaplings());
        Iterator var2 = ForestryPlugin.loggerWindfall.iterator();

        while (var2.hasNext())
        {
            Object var3 = var2.next();
            var1.add(var3);
        }

        return (ItemStack[])((ItemStack[])var1.toArray(new ItemStack[0]));
    }

    private static int forestrySoilID()
    {
        if (forestrySoilBlockID == 0)
        {
            forestrySoilBlockID = ForestryPlugin.getBlock("soil").itemID;
        }

        return forestrySoilBlockID;
    }

    public boolean doPlant(ItemStack var1, World var2, int var3, int var4, int var5)
    {
        int var6 = var2.getBlockId(var3, var4, var5);

        if (var6 != 0)
        {
            return false;
        }
        else if (!this.isGermling(var1))
        {
            return false;
        }
        else
        {
            int var7 = var2.getBlockId(var3, var4 - 1, var5);
            int var8 = var2.getBlockMetadata(var3, var4 - 1, var5);

            if (var7 == forestrySoilID() && (var8 & 3) == 0)
            {
                var2.setBlockAndMetadataWithNotify(var3, var4, var5, var1.itemID, var1.getItemDamage());
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public ICropEntity getCrop(World var1, int var2, int var3, int var4)
    {
        return new CropSapling(var1, var2, var3, var4);
    }
}
