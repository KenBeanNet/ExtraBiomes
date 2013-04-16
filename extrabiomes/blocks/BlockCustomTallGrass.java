package extrabiomes.blocks;

import com.google.common.base.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.api.BiomeManager;
import extrabiomes.blocks.BlockCustomTallGrass$BlockType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.IShearable;

public class BlockCustomTallGrass extends BlockFlower implements IShearable
{
    public BlockCustomTallGrass(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
        float var4 = 0.4F;
        this.setBlockBounds(0.099999994F, 0.0F, 0.099999994F, 0.9F, 0.8F, 0.9F);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int var1)
    {
        return BiomeManager.mountainridge.isPresent() && (byte)var1 == ((BiomeGenBase)BiomeManager.mountainridge.get()).topBlock || BiomeManager.wasteland.isPresent() && (byte)var1 == ((BiomeGenBase)BiomeManager.wasteland.get()).topBlock || super.canThisPlantGrowOnThisBlockID(var1);
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double var1 = 0.5D;
        double var3 = 1.0D;
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    public ArrayList getBlockDropped(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        int var8 = 8;

        if (var5 == BlockCustomTallGrass$BlockType.DEAD.metadata() || var5 == BlockCustomTallGrass$BlockType.DEAD_TALL.metadata() || var5 == BlockCustomTallGrass$BlockType.DEAD_YELLOW.metadata())
        {
            var8 *= 2;
        }

        if (var1.rand.nextInt(var8) != 0)
        {
            return var7;
        }
        else
        {
            Optional var9 = Extrabiomes.proxy.getGrassSeed(var1);

            if (var9.isPresent())
            {
                var7.add(var9.get());
            }

            return var7;
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        if (var2 > 4)
        {
            var2 = 4;
        }

        return super.getBlockTextureFromSideAndMetadata(var1, var2) + var2;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        if (var2 == Extrabiomes.tabsEBXL)
        {
            BlockCustomTallGrass$BlockType[] var4 = BlockCustomTallGrass$BlockType.values();
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                BlockCustomTallGrass$BlockType var7 = var4[var6];
                var3.add(new ItemStack(this, 1, var7.metadata()));
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return 0;
    }

    public boolean isBlockReplaceable(World var1, int var2, int var3, int var4)
    {
        return true;
    }

    public boolean isShearable(ItemStack var1, World var2, int var3, int var4, int var5)
    {
        return true;
    }

    public ArrayList onSheared(ItemStack var1, World var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        var7.add(new ItemStack(this, 1, var2.getBlockMetadata(var3, var4, var5)));
        return var7;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int var1, Random var2)
    {
        return 1 + var2.nextInt(var1 * 2 + 1);
    }
}
