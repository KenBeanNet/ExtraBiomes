package extrabiomes.module.summa.worldgen;

import extrabiomes.module.summa.TreeSoilRegistry;
import extrabiomes.module.summa.worldgen.WorldGenAcacia$TreeBlock;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenAcacia extends WorldGenerator
{
    public WorldGenAcacia(boolean var1)
    {
        super(var1);
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var2.nextInt(4) + 6;
        boolean var7 = true;

        if (var4 >= 1 && var4 + var6 + 1 <= 256)
        {
            int var10;
            int var11;
            int var12;

            for (int var8 = var4; var8 <= var4 + 1 + var6; ++var8)
            {
                byte var9 = 1;

                if (var8 == var4)
                {
                    var9 = 0;
                }

                if (var8 >= var4 + 1 + var6 - 2)
                {
                    var9 = 2;
                }

                for (var10 = var3 - var9; var10 <= var3 + var9 && var7; ++var10)
                {
                    for (var11 = var5 - var9; var11 <= var5 + var9 && var7; ++var11)
                    {
                        if (var8 >= 0 && var8 < 256)
                        {
                            var12 = var1.getBlockId(var10, var8, var11);

                            if (Block.blocksList[var12] != null && !Block.blocksList[var12].isLeaves(var1, var10, var8, var11) && var12 != Block.grass.blockID && var12 != Block.dirt.blockID && !Block.blocksList[var12].isWood(var1, var10, var8, var11))
                            {
                                var7 = false;
                            }
                        }
                        else
                        {
                            var7 = false;
                        }
                    }
                }
            }

            if (!var7)
            {
                return false;
            }
            else if (TreeSoilRegistry.isValidSoil(var1.getBlockId(var3, var4 - 1, var5)) && var4 < 256 - var6 - 1)
            {
                var1.setBlock(var3, var4 - 1, var5, Block.dirt.blockID);
                boolean var18 = true;
                boolean var19 = false;

                for (var10 = var4 - 3 + var6; var10 <= var4 + var6; ++var10)
                {
                    var11 = var10 - (var4 + var6);
                    var12 = 1 - var11;

                    for (int var13 = var3 - var12; var13 <= var3 + var12; ++var13)
                    {
                        int var14 = var13 - var3;

                        for (int var15 = var5 - var12; var15 <= var5 + var12; ++var15)
                        {
                            int var16 = var15 - var5;
                            Block var17 = Block.blocksList[var1.getBlockId(var13, var10, var15)];

                            if ((Math.abs(var14) != var12 || Math.abs(var16) != var12 || var2.nextInt(2) != 0 && var11 != 0) && (var17 == null || var17.canBeReplacedByLeaves(var1, var13, var10, var15)))
                            {
                                this.setBlockAndMetadata(var1, var13, var10, var15, WorldGenAcacia$TreeBlock.LEAVES.getID(), WorldGenAcacia$TreeBlock.LEAVES.getMetadata());
                            }
                        }
                    }
                }

                for (var10 = 0; var10 < var6; ++var10)
                {
                    var11 = var1.getBlockId(var3, var4 + var10, var5);

                    if (Block.blocksList[var11] == null || Block.blocksList[var11].isLeaves(var1, var3, var4 + var10, var5))
                    {
                        this.setBlockAndMetadata(var1, var3, var4 + var10, var5, WorldGenAcacia$TreeBlock.TRUNK.getID(), WorldGenAcacia$TreeBlock.TRUNK.getMetadata());
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
