package extrabiomes.module.fabrica.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.module.fabrica.block.BlockCustomWood$BlockType;
import java.util.List;
import net.minecraft.block.BlockWood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockCustomWood extends BlockWood
{
    public BlockCustomWood(int var1)
    {
        super(var1);
        this.blockIndexInTexture = 128;
        this.setTextureFile("/extrabiomes/extrabiomes.png");
        this.setStepSound(soundWoodFootstep);
        this.setRequiresSelfNotify();
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        setBurnProperties(this.blockID, 5, 20);
        this.setCreativeTab(Extrabiomes.tabsEBXL);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        return this.blockIndexInTexture + var2;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        BlockCustomWood$BlockType[] var4 = BlockCustomWood$BlockType.values();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            BlockCustomWood$BlockType var7 = var4[var6];
            var3.add(new ItemStack(var1, 1, var7.metadata()));
        }
    }
}
