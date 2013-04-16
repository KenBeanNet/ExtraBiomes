package extrabiomes.module.fabrica.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.module.fabrica.block.BlockRedRockSlab$BlockType;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockStep;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockRedRockSlab extends BlockStep
{
    private static int singleSlabID = 0;

    public BlockRedRockSlab(int var1, boolean var2)
    {
        super(var1, var2);

        if (!var2)
        {
            singleSlabID = this.blockID;
        }

        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundStoneFootstep);
        this.setTextureFile("/extrabiomes/extrabiomes.png");
        this.setLightOpacity(0);
        this.setCreativeTab(Extrabiomes.tabsEBXL);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int var1)
    {
        return new ItemStack(singleSlabID, 2, var1 & 7);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        var2 &= 7;
        return var2 == BlockRedRockSlab$BlockType.REDROCK.metadata() ? (var1 < 2 ? 14 : 13) : (var2 == BlockRedRockSlab$BlockType.REDROCKBRICK.metadata() ? 11 : 12);
    }

    /**
     * Returns the slab block name with step type.
     */
    public String getFullSlabName(int var1)
    {
        String var2;

        switch (var1 & 7)
        {
            case 1:
                var2 = BlockRedRockSlab$BlockType.REDROCK.toString();
                break;

            case 2:
                var2 = BlockRedRockSlab$BlockType.REDROCKBRICK.toString();
                break;

            default:
                var2 = BlockRedRockSlab$BlockType.REDCOBBLE.toString();
        }

        return super.getBlockName() + "." + var2;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        if (var1 == singleSlabID)
        {
            BlockRedRockSlab$BlockType[] var4 = BlockRedRockSlab$BlockType.values();
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                BlockRedRockSlab$BlockType var7 = var4[var6];
                var3.add(new ItemStack(var1, 1, var7.metadata()));
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return singleSlabID;
    }
}
