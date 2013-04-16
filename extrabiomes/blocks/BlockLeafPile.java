package extrabiomes.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeafPile extends Block
{
    private static boolean canThisPlantGrowOnThisBlockID(int var0)
    {
        return var0 == Block.grass.blockID || var0 == Block.dirt.blockID;
    }

    public BlockLeafPile(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
        float var4 = 0.5F;
        float var5 = 0.015625F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.015625F, 1.0F);
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World var1, int var2, int var3, int var4)
    {
        return canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
    {
        return super.canPlaceBlockAt(var1, var2, var3, var4) && canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
    }

    private void checkFlowerChange(World var1, int var2, int var3, int var4)
    {
        if (!this.canBlockStay(var1, var2, var3, var4))
        {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess var1, int var2, int var3, int var4)
    {
        return var1.getBiomeGenForCoords(var2, var4).getBiomeFoliageColor();
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int var1)
    {
        return this.getBlockColor();
    }

    public boolean isBlockReplaceable(World var1, int var2, int var3, int var4)
    {
        return true;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        super.onNeighborBlockChange(var1, var2, var3, var4, var5);
        this.checkFlowerChange(var1, var2, var3, var4);
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        this.checkFlowerChange(var1, var2, var3, var4);
    }
}
