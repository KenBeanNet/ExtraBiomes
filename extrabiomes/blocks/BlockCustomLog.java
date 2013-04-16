package extrabiomes.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.api.UseLogTurnerEvent;
import extrabiomes.blocks.BlockCustomLog$BlockType;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;

public class BlockCustomLog extends BlockLog
{
    public BlockCustomLog(int var1, int var2)
    {
        super(var1);
        this.blockIndexInTexture = var2;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        int var3 = var2 & 12;
        int var4 = var2 & 3;

        if (var4 > 1)
        {
            var4 = 0;
        }

        return (var3 != 0 || var1 != 1 && var1 != 0) && (var3 != 4 || var1 != 5 && var1 != 4) && (var3 != 8 || var1 != 2 && var1 != 3) ? this.blockIndexInTexture + var4 : this.blockIndexInTexture + 16 + var4;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        BlockCustomLog$BlockType[] var4 = BlockCustomLog$BlockType.values();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            BlockCustomLog$BlockType var7 = var4[var6];
            var3.add(new ItemStack(var1, 1, var7.metadata()));
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return this.blockID;
    }

    @ForgeSubscribe
    public void onUseLogTurnerEvent(UseLogTurnerEvent var1)
    {
        int var2 = var1.world.getBlockId(var1.x, var1.y, var1.z);

        if (var2 == this.blockID)
        {
            Block var3 = Block.wood;
            var1.world.playSoundEffect((double)((float)var1.x + 0.5F), (double)((float)var1.y + 0.5F), (double)((float)var1.z + 0.5F), var3.stepSound.getStepSound(), (var3.stepSound.getVolume() + 1.0F) / 2.0F, var3.stepSound.getPitch() * 1.55F);

            if (!var1.world.isRemote)
            {
                int var4 = var1.world.getBlockMetadata(var1.x, var1.y, var1.z);
                int var5 = var4 & 12;
                int var6 = var4 & 3;
                var5 = var5 == 0 ? 4 : (var5 == 4 ? 8 : 0);
                var1.world.setBlockAndMetadata(var1.x, var1.y, var1.z, this.blockID, var6 | var5);
            }

            var1.setHandled();
        }
    }
}
