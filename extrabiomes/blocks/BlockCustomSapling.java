package extrabiomes.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.blocks.BlockCustomSapling$BlockType;
import extrabiomes.module.summa.TreeSoilRegistry;
import extrabiomes.module.summa.worldgen.WorldGenAcacia;
import extrabiomes.module.summa.worldgen.WorldGenAutumnTree;
import extrabiomes.module.summa.worldgen.WorldGenAutumnTree$AutumnTreeType;
import extrabiomes.module.summa.worldgen.WorldGenBigAutumnTree;
import extrabiomes.module.summa.worldgen.WorldGenFirTree;
import extrabiomes.module.summa.worldgen.WorldGenFirTreeHuge;
import extrabiomes.module.summa.worldgen.WorldGenRedwood;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockCustomSapling extends BlockFlower
{
    private static final int METADATA_BITMASK = 7;
    private static final int METADATA_MARKBIT = 8;
    private static int forestrySoilID = 0;

    private static boolean isEnoughLightToGrow(World var0, int var1, int var2, int var3)
    {
        return var0.getBlockLightValue(var1, var2, var3) >= 9;
    }

    private static boolean isMarkedMetadata(int var0)
    {
        return (var0 & 8) != 0;
    }

    private static int markedMetadata(int var0)
    {
        return var0 | 8;
    }

    public static void setForestrySoilID(int var0)
    {
        forestrySoilID = var0;
    }

    private static int unmarkedMetadata(int var0)
    {
        return var0 & 7;
    }

    public BlockCustomSapling(int var1, int var2)
    {
        super(var1, var2);
        float var3 = 0.4F;
        this.setBlockBounds(0.099999994F, 0.0F, 0.099999994F, 0.9F, 0.8F, 0.9F);
    }

    private void attemptGrowTree(World var1, int var2, int var3, int var4, Random var5)
    {
        if (isEnoughLightToGrow(var1, var2, var3 + 1, var4) && var5.nextInt(7) == 0)
        {
            int var6 = var1.getBlockMetadata(var2, var3, var4);

            if (!isMarkedMetadata(var6))
            {
                var1.setBlockMetadataWithNotify(var2, var3, var4, markedMetadata(var6));
            }
            else
            {
                this.growTree(var1, var2, var3, var4, var5);
            }
        }
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int var1)
    {
        return TreeSoilRegistry.isValidSoil(var1);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1)
    {
        return unmarkedMetadata(var1);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        var2 = unmarkedMetadata(var2);

        if (var2 > 6)
        {
            var2 = 0;
        }

        return super.getBlockTextureFromSide(var1) + var2;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        if (var2 == Extrabiomes.tabsEBXL)
        {
            BlockCustomSapling$BlockType[] var4 = BlockCustomSapling$BlockType.values();
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                BlockCustomSapling$BlockType var7 = var4[var6];
                var3.add(new ItemStack(this, 1, var7.metadata()));
            }
        }
    }

    public void growTree(World var1, int var2, int var3, int var4, Random var5)
    {
        int var6 = unmarkedMetadata(var1.getBlockMetadata(var2, var3, var4));
        Object var7 = null;
        int var8 = 0;
        int var9 = 0;
        boolean var10 = false;
        boolean var11 = var1.getBlockId(var2, var3 - 1, var4) == forestrySoilID;

        if (var6 == BlockCustomSapling$BlockType.BROWN.metadata())
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = new WorldGenBigAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.BROWN);
            }
            else
            {
                var7 = new WorldGenAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.BROWN);
            }
        }
        else if (var6 == BlockCustomSapling$BlockType.ORANGE.metadata())
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = new WorldGenBigAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.ORANGE);
            }
            else
            {
                var7 = new WorldGenAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.ORANGE);
            }
        }
        else if (var6 == BlockCustomSapling$BlockType.PURPLE.metadata())
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = new WorldGenBigAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.PURPLE);
            }
            else
            {
                var7 = new WorldGenAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.PURPLE);
            }
        }
        else if (var6 == BlockCustomSapling$BlockType.YELLOW.metadata())
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = new WorldGenBigAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.YELLOW);
            }
            else
            {
                var7 = new WorldGenAutumnTree(true, WorldGenAutumnTree$AutumnTreeType.YELLOW);
            }
        }
        else if (var6 == BlockCustomSapling$BlockType.ACACIA.metadata())
        {
            var7 = new WorldGenAcacia(true);
        }
        else
        {
            for (var8 = 0; var8 >= -1; --var8)
            {
                for (var9 = 0; var9 >= -1; --var9)
                {
                    if (this.isSameSapling(var1, var2 + var8, var3, var4 + var9, var6) && this.isSameSapling(var1, var2 + var8 + 1, var3, var4 + var9, var6) && this.isSameSapling(var1, var2 + var8, var3, var4 + var9 + 1, var6) && this.isSameSapling(var1, var2 + var8 + 1, var3, var4 + var9 + 1, var6))
                    {
                        if (var6 == BlockCustomSapling$BlockType.FIR.metadata())
                        {
                            var7 = new WorldGenFirTreeHuge(true);
                        }
                        else
                        {
                            var7 = new WorldGenRedwood(true);
                        }

                        var10 = true;
                        break;
                    }
                }

                if (var7 != null)
                {
                    break;
                }
            }

            if (var7 == null && var6 == BlockCustomSapling$BlockType.FIR.metadata())
            {
                var9 = 0;
                var8 = 0;
                var7 = new WorldGenFirTree(true);
            }
        }

        if (var7 != null)
        {
            if (var10)
            {
                var1.setBlock(var2 + var8, var3, var4 + var9, 0);
                var1.setBlock(var2 + var8 + 1, var3, var4 + var9, 0);
                var1.setBlock(var2 + var8, var3, var4 + var9 + 1, 0);
                var1.setBlock(var2 + var8 + 1, var3, var4 + var9 + 1, 0);
            }
            else
            {
                var1.setBlock(var2, var3, var4, 0);
            }

            int var12 = var10 ? 1 : 0;

            if (!((WorldGenerator)var7).generate(var1, var5, var2 + var8 + var12, var3, var4 + var9 + var12))
            {
                if (var10)
                {
                    var1.setBlockAndMetadata(var2 + var8, var3, var4 + var9, this.blockID, var6);
                    var1.setBlockAndMetadata(var2 + var8 + 1, var3, var4 + var9, this.blockID, var6);
                    var1.setBlockAndMetadata(var2 + var8, var3, var4 + var9 + 1, this.blockID, var6);
                    var1.setBlockAndMetadata(var2 + var8 + 1, var3, var4 + var9 + 1, this.blockID, var6);
                }
                else
                {
                    var1.setBlockAndMetadata(var2, var3, var4, this.blockID, var6);
                }
            }
            else if (var11)
            {
                if (var10)
                {
                    var1.setBlock(var2 + var8, var3 - 1, var4 + var9, Block.sand.blockID);
                    var1.setBlock(var2 + var8 + 1, var3 - 1, var4 + var9, Block.sand.blockID);
                    var1.setBlock(var2 + var8, var3 - 1, var4 + var9 + 1, Block.sand.blockID);
                    var1.setBlock(var2 + var8 + 1, var3 - 1, var4 + var9 + 1, Block.sand.blockID);
                }
                else
                {
                    var1.setBlock(var2, var3 - 1, var4, Block.sand.blockID);
                }
            }
        }
    }

    public boolean isSameSapling(World var1, int var2, int var3, int var4, int var5)
    {
        return var1.getBlockId(var2, var3, var4) == this.blockID && unmarkedMetadata(var1.getBlockMetadata(var2, var3, var4)) == var5;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (!var1.isRemote)
        {
            super.updateTick(var1, var2, var3, var4, var5);
            this.attemptGrowTree(var1, var2, var3, var4, var5);
        }
    }
}
