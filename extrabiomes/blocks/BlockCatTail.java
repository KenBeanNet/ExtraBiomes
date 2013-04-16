package extrabiomes.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockCatTail extends BlockFlower
{
    public BlockCatTail(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
        this.disableStats();
        float var4 = 0.375F;
        this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World var1, int var2, int var3, int var4)
    {
        return this.canPlaceBlockAt(var1, var2, var3, var4);
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getBlockId(var2, var3 - 1, var4);

        if (var5 != Block.grass.blockID && var5 != Block.dirt.blockID)
        {
            return false;
        }
        else
        {
            --var3;

            for (int var6 = -1; var6 < 2; var6 += 2)
            {
                if (var1.getBlockMaterial(var2 + var6, var3, var4) == Material.water || var1.getBlockMaterial(var2, var3, var4 + var6) == Material.water)
                {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 6;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        if (!this.canBlockStay(var1, var2, var3, var4))
        {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }
    }
}
