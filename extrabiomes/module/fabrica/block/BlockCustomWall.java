package extrabiomes.module.fabrica.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.lib.Element;
import extrabiomes.module.fabrica.block.BlockCustomWall$BlockType;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCustomWall extends BlockWall
{
    public BlockCustomWall(int var1)
    {
        super(var1, Block.blocksList[Element.RED_COBBLE.get().itemID]);
        this.setTextureFile("/extrabiomes/extrabiomes.png");
        this.setCreativeTab(Extrabiomes.tabsEBXL);
    }

    public void addCreativeItems(ArrayList var1)
    {
        BlockCustomWall$BlockType[] var2 = BlockCustomWall$BlockType.values();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            BlockCustomWall$BlockType var5 = var2[var4];
            var1.add(new ItemStack(this, 1, var5.metadata()));
        }
    }

    public boolean canPlaceTorchOnTop(World var1, int var2, int var3, int var4)
    {
        return true;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        return 12;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        BlockCustomWall$BlockType[] var4 = BlockCustomWall$BlockType.values();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            BlockCustomWall$BlockType var7 = var4[var6];
            var3.add(new ItemStack(this, 1, var7.metadata()));
        }
    }
}
