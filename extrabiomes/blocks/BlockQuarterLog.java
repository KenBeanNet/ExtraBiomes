package extrabiomes.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.api.UseLogTurnerEvent;
import extrabiomes.blocks.BlockQuarterLog$1;
import extrabiomes.blocks.BlockQuarterLog$BarkOn;
import extrabiomes.blocks.BlockQuarterLog$BlockType;
import extrabiomes.blocks.BlockQuarterLog$Orientation;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;

public class BlockQuarterLog extends BlockLog
{
    private static int renderId = 31;
    private final BlockQuarterLog$BarkOn barkOnSides;

    private static BlockQuarterLog$Orientation determineOrientation(World var0, int var1, int var2, int var3, EntityLiving var4)
    {
        int var5 = BlockPistonBase.determineOrientation(var0, var1, var2, var3, (EntityPlayer)var4);

        switch (var5)
        {
            case 0:
            case 1:
                return BlockQuarterLog$Orientation.UD;

            case 2:
            case 3:
                return BlockQuarterLog$Orientation.NS;

            default:
                return BlockQuarterLog$Orientation.EW;
        }
    }

    public static void setRenderId(int var0)
    {
        renderId = var0;
    }

    public BlockQuarterLog(int var1, int var2, BlockQuarterLog$BarkOn var3)
    {
        super(var1);
        this.barkOnSides = var3;
        BlockQuarterLog$BarkOn.access$002(var3, this.blockID);
        this.blockIndexInTexture = var2;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        int var3 = var2 & 12;
        int var4 = var2 & 3;

        if (var4 > 2)
        {
            var4 = 0;
        }

        int var5 = 0;

        switch (BlockQuarterLog$1.$SwitchMap$extrabiomes$blocks$BlockQuarterLog$BarkOn[this.barkOnSides.ordinal()])
        {
            case 1:
                var5 = this.getSETextureOffset(var1, var3);
                break;

            case 2:
                var5 = this.getSWTextureOffset(var1, var3);
                break;

            case 3:
                var5 = this.getNETextureOffset(var1, var3);
                break;

            case 4:
                var5 = this.getNWTextureOffset(var1, var3);
        }

        return this.blockIndexInTexture + var5 + var4 * 2;
    }

    private int getNETextureOffset(int var1, int var2)
    {
        byte var3 = 0;

        if (var2 == 0)
        {
            switch (var1)
            {
                case 0:
                case 1:
                    var3 = 17;
                    break;

                case 2:
                    var3 = 0;
                    break;

                case 3:
                    var3 = 49;
                    break;

                case 4:
                    var3 = 48;
                    break;

                default:
                    var3 = 1;
            }
        }
        else if (var2 == 4)
        {
            switch (var1)
            {
                case 0:
                    var3 = 49;
                    break;

                case 1:
                    var3 = 0;
                    break;

                case 2:
                    var3 = 1;
                    break;

                case 3:
                    var3 = 48;
                    break;

                case 4:
                    var3 = 16;
                    break;

                default:
                    var3 = 17;
            }
        }
        else if (var2 == 8)
        {
            switch (var1)
            {
                case 0:
                    var3 = 49;
                    break;

                case 1:
                default:
                    var3 = 1;
                    break;

                case 2:
                    var3 = 16;
                    break;

                case 3:
                    var3 = 17;
                    break;

                case 4:
                    var3 = 49;
            }
        }

        return var3;
    }

    private int getNextBlockID()
    {
        return this.blockID == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW) ? BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE) : (this.blockID == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE) ? BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW) : (this.blockID == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW) ? BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE) : BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW)));
    }

    private int getNWTextureOffset(int var1, int var2)
    {
        byte var3 = 0;

        if (var2 == 0)
        {
            switch (var1)
            {
                case 0:
                case 1:
                    var3 = 16;
                    break;

                case 2:
                    var3 = 1;
                    break;

                case 3:
                    var3 = 48;
                    break;

                case 4:
                    var3 = 0;
                    break;

                default:
                    var3 = 49;
            }
        }
        else if (var2 == 4)
        {
            switch (var1)
            {
                case 0:
                    var3 = 48;
                    break;

                case 1:
                    var3 = 1;
                    break;

                case 2:
                    var3 = 49;
                    break;

                case 3:
                    var3 = 0;
                    break;

                case 4:
                    var3 = 17;
                    break;

                default:
                    var3 = 16;
            }
        }
        else if (var2 == 8)
        {
            switch (var1)
            {
                case 0:
                    var3 = 48;
                    break;

                case 1:
                    var3 = 0;
                    break;

                case 2:
                    var3 = 17;
                    break;

                case 3:
                    var3 = 16;
                    break;

                case 4:
                    var3 = 1;
                    break;

                default:
                    var3 = 49;
            }
        }

        return var3;
    }

    public ItemStack getPickBlock(MovingObjectPosition var1, World var2, int var3, int var4, int var5)
    {
        ItemStack var6 = super.getPickBlock(var1, var2, var3, var4, var5);
        var6.itemID = BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE);
        return var6;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return renderId;
    }

    private int getSETextureOffset(int var1, int var2)
    {
        byte var3 = 0;

        if (var2 == 0)
        {
            switch (var1)
            {
                case 0:
                case 1:
                    var3 = 33;
                    break;

                case 2:
                    var3 = 48;
                    break;

                case 3:
                    var3 = 1;
                    break;

                case 4:
                    var3 = 49;
                    break;

                default:
                    var3 = 0;
            }
        }
        else if (var2 == 4)
        {
            switch (var1)
            {
                case 0:
                    var3 = 0;
                    break;

                case 1:
                    var3 = 49;
                    break;

                case 2:
                    var3 = 48;
                    break;

                case 3:
                    var3 = 1;
                    break;

                case 4:
                    var3 = 33;
                    break;

                default:
                    var3 = 32;
            }
        }
        else if (var2 == 8)
        {
            switch (var1)
            {
                case 0:
                    var3 = 1;
                    break;

                case 1:
                    var3 = 49;
                    break;

                case 2:
                    var3 = 32;
                    break;

                case 3:
                    var3 = 33;
                    break;

                case 4:
                    var3 = 48;
                    break;

                default:
                    var3 = 0;
            }
        }

        return var3;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        BlockQuarterLog$BlockType[] var4 = BlockQuarterLog$BlockType.values();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            BlockQuarterLog$BlockType var7 = var4[var6];
            var3.add(new ItemStack(var1, 1, var7.metadata()));
        }
    }

    private int getSWTextureOffset(int var1, int var2)
    {
        byte var3 = 0;

        if (var2 == 0)
        {
            switch (var1)
            {
                case 0:
                case 1:
                    var3 = 32;
                    break;

                case 2:
                    var3 = 49;
                    break;

                case 3:
                    var3 = 0;
                    break;

                case 4:
                    var3 = 1;
                    break;

                default:
                    var3 = 48;
            }
        }
        else if (var2 == 4)
        {
            switch (var1)
            {
                case 0:
                    var3 = 1;
                    break;

                case 1:
                    var3 = 48;
                    break;

                case 2:
                    var3 = 0;
                    break;

                case 3:
                    var3 = 49;
                    break;

                case 4:
                    var3 = 32;
                    break;

                default:
                    var3 = 33;
            }
        }
        else if (var2 == 8)
        {
            switch (var1)
            {
                case 0:
                    var3 = 0;
                    break;

                case 1:
                    var3 = 48;
                    break;

                case 2:
                    var3 = 33;
                    break;

                case 3:
                    var3 = 32;
                    break;

                case 4:
                    var3 = 0;
                    break;

                default:
                    var3 = 48;
            }
        }

        return var3;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5)
    {
        super.onBlockPlacedBy(var1, var2, var3, var4, var5);
        BlockQuarterLog$Orientation var6 = determineOrientation(var1, var2, var3, var4, var5);
        int var7;
        int var8;
        int var9;
        int var10;
        int var11;
        int var12;
        int var13;
        int var14;
        int var15;

        if (var6 == BlockQuarterLog$Orientation.UD)
        {
            var7 = var1.getBlockId(var2, var3, var4 - 1);
            var8 = var1.getBlockMetadata(var2, var3, var4 - 1);
            var9 = var1.getBlockId(var2, var3, var4 + 1);
            var10 = var1.getBlockMetadata(var2, var3, var4 + 1);
            var11 = var1.getBlockId(var2 - 1, var3, var4);
            var12 = var1.getBlockMetadata(var2 - 1, var3, var4);
            var13 = var1.getBlockId(var2 + 1, var3, var4);
            var14 = var1.getBlockMetadata(var2 + 1, var3, var4);
            var15 = var1.getBlockMetadata(var2, var3, var4);

            if (var15 == var8)
            {
                if (var7 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW), var15);
                    return;
                }

                if (var7 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE), var15);
                    return;
                }
            }

            if (var15 == var14)
            {
                if (var13 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW), var15);
                    return;
                }

                if (var13 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW), var15);
                    return;
                }
            }

            if (var15 == var10)
            {
                if (var9 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW), var15);
                    return;
                }

                if (var9 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE), var15);
                    return;
                }
            }

            if (var15 == var12)
            {
                if (var11 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE), var15);
                    return;
                }

                if (var11 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE), var15);
                    return;
                }
            }
        }

        if (var6 == BlockQuarterLog$Orientation.NS)
        {
            var7 = var1.getBlockId(var2, var3 + 1, var4);
            var8 = var1.getBlockMetadata(var2, var3 + 1, var4);
            var9 = var1.getBlockId(var2, var3 - 1, var4);
            var10 = var1.getBlockMetadata(var2, var3 - 1, var4);
            var11 = var1.getBlockId(var2 - 1, var3, var4);
            var12 = var1.getBlockMetadata(var2 - 1, var3, var4);
            var13 = var1.getBlockId(var2 + 1, var3, var4);
            var14 = var1.getBlockMetadata(var2 + 1, var3, var4);
            var15 = var1.getBlockMetadata(var2, var3, var4);

            if (var15 == var8)
            {
                if (var7 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW), var15);
                    return;
                }

                if (var7 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE), var15);
                    return;
                }
            }

            if (var15 == var14)
            {
                if (var13 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW), var15);
                    return;
                }

                if (var13 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW), var15);
                    return;
                }
            }

            if (var15 == var10)
            {
                if (var9 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW), var15);
                    return;
                }

                if (var9 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE), var15);
                    return;
                }
            }

            if (var15 == var12)
            {
                if (var11 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE), var15);
                    return;
                }

                if (var11 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE), var15);
                    return;
                }
            }
        }

        if (var6 == BlockQuarterLog$Orientation.EW)
        {
            var7 = var1.getBlockId(var2, var3, var4 - 1);
            var8 = var1.getBlockMetadata(var2, var3, var4 - 1);
            var9 = var1.getBlockId(var2, var3, var4 + 1);
            var10 = var1.getBlockMetadata(var2, var3, var4 + 1);
            var11 = var1.getBlockId(var2, var3 + 1, var4);
            var12 = var1.getBlockMetadata(var2, var3 + 1, var4);
            var13 = var1.getBlockId(var2, var3 - 1, var4);
            var14 = var1.getBlockMetadata(var2, var3 - 1, var4);
            var15 = var1.getBlockMetadata(var2, var3, var4);

            if (var15 == var8)
            {
                if (var7 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE), var15);
                    return;
                }

                if (var7 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW), var15);
                    return;
                }
            }

            if (var15 == var12)
            {
                if (var11 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE), var15);
                    return;
                }

                if (var11 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW), var15);
                    return;
                }
            }

            if (var15 == var10)
            {
                if (var9 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW), var15);
                    return;
                }

                if (var9 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE), var15);
                    return;
                }
            }

            if (var15 == var14)
            {
                if (var13 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SW))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NE), var15);
                    return;
                }

                if (var13 == BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.SE))
                {
                    var1.setBlockAndMetadataWithNotify(var2, var3, var4, BlockQuarterLog$BarkOn.access$000(BlockQuarterLog$BarkOn.NW), var15);
                    return;
                }
            }
        }
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

                if (var5 == 0)
                {
                    var2 = this.getNextBlockID();
                }

                var1.world.setBlockAndMetadata(var1.x, var1.y, var1.z, var2, var6 | var5);
            }

            var1.setHandled();
        }
    }
}
