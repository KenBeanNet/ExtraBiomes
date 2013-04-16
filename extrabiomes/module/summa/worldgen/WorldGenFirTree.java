package extrabiomes.module.summa.worldgen;

import extrabiomes.module.summa.TreeSoilRegistry;
import extrabiomes.module.summa.worldgen.WorldGenFirTree$TreeBlock;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFirTree extends WorldGenerator
{
    public WorldGenFirTree(boolean var1)
    {
        super(var1);
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var1.getBlockId(var3, var4 - 1, var5);
        int var7 = var2.nextInt(8) + 24;

        if (TreeSoilRegistry.isValidSoil(Integer.valueOf(var6).intValue()) && var4 < 256 - var7 - 1)
        {
            if (var4 >= 1 && var4 + var7 + 1 <= 256)
            {
                int var8 = 1 + var2.nextInt(12);
                int var9 = 2 + var2.nextInt(6);
                int var10;
                int var13;
                int var14;
                int var20;

                for (var10 = var4; var10 <= var4 + 1 + var7; ++var10)
                {
                    if (var10 < 0 || var10 >= 256)
                    {
                        return false;
                    }

                    boolean var11 = true;

                    if (var10 - var4 < var8)
                    {
                        var20 = 0;
                    }
                    else
                    {
                        var20 = var9;
                    }

                    for (int var12 = var3 - var20; var12 <= var3 + var20; ++var12)
                    {
                        for (var13 = var5 - var20; var13 <= var5 + var20; ++var13)
                        {
                            var14 = var1.getBlockId(var12, var10, var13);

                            if (Block.blocksList[var14] != null && !Block.blocksList[var14].isLeaves(var1, var12, var10, var13))
                            {
                                return false;
                            }
                        }
                    }
                }

                var1.setBlock(var3, var4 - 1, var5, Block.dirt.blockID);
                var10 = var2.nextInt(2);
                var20 = 1;
                boolean var21 = false;
                int var15;

                for (var13 = 0; var13 <= var7 - var8; ++var13)
                {
                    var14 = var4 + var7 - var13;

                    for (var15 = var3 - var10; var15 <= var3 + var10; ++var15)
                    {
                        int var16 = var15 - var3;

                        for (int var17 = var5 - var10; var17 <= var5 + var10; ++var17)
                        {
                            int var18 = var17 - var5;
                            Block var19 = Block.blocksList[var1.getBlockId(var15, var14, var17)];

                            if ((Math.abs(var16) != var10 || Math.abs(var18) != var10 || var10 <= 0) && (var19 == null || var19.canBeReplacedByLeaves(var1, var15, var14, var17)))
                            {
                                this.setBlockAndMetadata(var1, var15, var14, var17, WorldGenFirTree$TreeBlock.LEAVES.getID(), WorldGenFirTree$TreeBlock.LEAVES.getMetadata());
                            }
                        }
                    }

                    if (var10 >= var20)
                    {
                        var10 = var21 ? 1 : 0;
                        var21 = true;
                        ++var20;

                        if (var20 > var9)
                        {
                            var20 = var9;
                        }
                    }
                    else
                    {
                        ++var10;
                    }
                }

                var13 = var2.nextInt(3);

                for (var14 = 0; var14 < var7 - var13; ++var14)
                {
                    var15 = var1.getBlockId(var3, var4 + var14, var5);

                    if (Block.blocksList[var15] == null || Block.blocksList[var15].isLeaves(var1, var3, var4 + var14, var5))
                    {
                        this.setBlockAndMetadata(var1, var3, var4 + var14, var5, WorldGenFirTree$TreeBlock.TRUNK.getID(), WorldGenFirTree$TreeBlock.TRUNK.getMetadata());
                    }
                }

                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
