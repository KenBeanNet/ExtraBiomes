package extrabiomes.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.blocks.BlockRedRock$BlockType;
import extrabiomes.utility.IDRestrictionAnnotation;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@IDRestrictionAnnotation(
        maxIDRValue = 255
)
public class BlockRedRock extends Block
{
    public BlockRedRock(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
    }

    public void addCreativeItems(ArrayList var1)
    {
        BlockRedRock$BlockType[] var2 = BlockRedRock$BlockType.values();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            BlockRedRock$BlockType var5 = var2[var4];
            var1.add(new ItemStack(this, 1, var5.metadata()));
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1)
    {
        return var1 == BlockRedRock$BlockType.RED_ROCK_BRICK.metadata() ? BlockRedRock$BlockType.RED_ROCK_BRICK.metadata() : BlockRedRock$BlockType.RED_COBBLE.metadata();
    }

    /**
     * Returns the block hardness at a location. Args: world, x, y, z
     */
    public float getBlockHardness(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        return var5 == BlockRedRock$BlockType.RED_COBBLE.metadata() ? 2.0F : this.blockHardness;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        if (var2 > 2)
        {
            var2 = 2;
        }

        return var2 == BlockRedRock$BlockType.RED_ROCK_BRICK.metadata() ? 11 : (var2 == BlockRedRock$BlockType.RED_COBBLE.metadata() ? 12 : super.getBlockTextureFromSideAndMetadata(var1, var2));
    }

    @SideOnly(Side.CLIENT)

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World var1, int var2, int var3, int var4)
    {
        return var1.getBlockMetadata(var2, var3, var4);
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        if (var2 == Extrabiomes.tabsEBXL)
        {
            BlockRedRock$BlockType[] var4 = BlockRedRock$BlockType.values();
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                BlockRedRock$BlockType var7 = var4[var6];
                var3.add(new ItemStack(this, 1, var7.metadata()));
            }
        }
    }
}
