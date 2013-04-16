package extrabiomes.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.api.BiomeManager;
import extrabiomes.blocks.BlockCustomFlower$BlockType;
import extrabiomes.proxy.CommonProxy;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockCustomFlower extends Block implements IPlantable
{
    public BlockCustomFlower(int var1, int var2, Material var3)
    {
        super(var1, var3);
        this.blockIndexInTexture = var2;
        float var4 = 0.2F;
        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.6F, 0.7F);
        CommonProxy var5 = Extrabiomes.proxy;
        var5.addGrassPlant(this, BlockCustomFlower$BlockType.AUTUMN_SHRUB.metadata(), 2);
        var5.addGrassPlant(this, BlockCustomFlower$BlockType.HYDRANGEA.metadata(), 2);
        var5.addGrassPlant(this, BlockCustomFlower$BlockType.ORANGE.metadata(), 5);
        var5.addGrassPlant(this, BlockCustomFlower$BlockType.PURPLE.metadata(), 5);
        var5.addGrassPlant(this, BlockCustomFlower$BlockType.WHITE.metadata(), 5);
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World var1, int var2, int var3, int var4)
    {
        return (var1.getFullBlockLightValue(var2, var3, var4) >= 8 || var1.canBlockSeeTheSky(var2, var3, var4)) && this.canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
    {
        return super.canPlaceBlockAt(var1, var2, var3, var4) && this.canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
    }

    private boolean canThisPlantGrowOnThisBlockID(int var1)
    {
        return var1 == Block.grass.blockID || var1 == Block.dirt.blockID || var1 == Block.tilledField.blockID || var1 == Block.sand.blockID || (byte)var1 == ((BiomeGenBase)BiomeManager.mountainridge.get()).topBlock;
    }

    private void checkFlowerChange(World var1, int var2, int var3, int var4)
    {
        if (!this.canBlockStay(var1, var2, var3, var4))
        {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1)
    {
        return var1;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        if (var2 > 7)
        {
            var2 = 7;
        }

        return super.getBlockTextureFromSideAndMetadata(var1, var2) + var2;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
    {
        return null;
    }

    public int getPlantID(World var1, int var2, int var3, int var4)
    {
        return this.blockID;
    }

    public int getPlantMetadata(World var1, int var2, int var3, int var4)
    {
        return var1.getBlockMetadata(var2, var3, var4);
    }

    public EnumPlantType getPlantType(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        return var5 == BlockCustomFlower$BlockType.TINY_CACTUS.metadata() ? EnumPlantType.Desert : EnumPlantType.Plains;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        return var5 == BlockCustomFlower$BlockType.TINY_CACTUS.metadata() ? super.getSelectedBoundingBoxFromPool(var1, var2, var3, var4) : AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)var3 + this.maxY, (double)(var4 + 1));
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        if (var2 == Extrabiomes.tabsEBXL)
        {
            BlockCustomFlower$BlockType[] var4 = BlockCustomFlower$BlockType.values();
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                BlockCustomFlower$BlockType var7 = var4[var6];
                var3.add(new ItemStack(this, 1, var7.metadata()));
            }
        }
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
