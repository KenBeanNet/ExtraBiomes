package extrabiomes.module.summa.worldgen;

import extrabiomes.module.summa.TreeSoilRegistry;
import extrabiomes.module.summa.worldgen.WorldGenLegendOak$1;
import extrabiomes.module.summa.worldgen.WorldGenLegendOak$Acuteness;
import extrabiomes.module.summa.worldgen.WorldGenLegendOak$BendDirection;
import extrabiomes.module.summa.worldgen.WorldGenLegendOak$TreeBlock;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLegendOak extends WorldGenerator
{
    public WorldGenLegendOak(boolean var1)
    {
        super(var1);
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        if (!TreeSoilRegistry.isValidSoil(var1.getBlockId(var3, var4 - 1, var5)))
        {
            return false;
        }
        else
        {
            int var6 = var2.nextInt(4) + 3;
            int var7 = 15 + var2.nextInt(25);
            this.growTree(var1, var2, var3, var4, var5, var6, 0, var7);
            return true;
        }
    }

    private void growLeafNode(World var1, int var2, int var3, int var4)
    {
        for (int var5 = -3; var5 <= 3; ++var5)
        {
            for (int var6 = -3; var6 <= 3; ++var6)
            {
                if ((Math.abs(var5) != 3 || Math.abs(var6) != 3) && (Math.abs(var5) != 3 || Math.abs(var6) != 2) && (Math.abs(var5) != 2 || Math.abs(var6) != 3) && (var5 != 0 || var6 != 0) && var1.getBlockId(var2 + var5, var3, var4 + var6) == 0)
                {
                    this.setBlockAndMetadata(var1, var2 + var5, var3, var4 + var6, WorldGenLegendOak$TreeBlock.LEAVES.getID(), WorldGenLegendOak$TreeBlock.LEAVES.getMetadata());
                }

                if (Math.abs(var5) < 3 && Math.abs(var6) < 3 && (Math.abs(var5) != 2 || Math.abs(var6) != 2))
                {
                    if (var1.getBlockId(var2 + var5, var3 - 1, var4 + var6) == 0)
                    {
                        this.setBlockAndMetadata(var1, var2 + var5, var3 - 1, var4 + var6, WorldGenLegendOak$TreeBlock.LEAVES.getID(), WorldGenLegendOak$TreeBlock.LEAVES.getMetadata());
                    }

                    if (var1.getBlockId(var2 + var5, var3 + 1, var4 + var6) == 0)
                    {
                        this.setBlockAndMetadata(var1, var2 + var5, var3 + 1, var4 + var6, WorldGenLegendOak$TreeBlock.LEAVES.getID(), WorldGenLegendOak$TreeBlock.LEAVES.getMetadata());
                    }
                }
            }
        }
    }

    protected void growLeaves(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        WorldGenLegendOak$BendDirection[] var9 = WorldGenLegendOak$BendDirection.values();
        int var10 = var9.length;

        for (int var11 = 0; var11 < var10; ++var11)
        {
            WorldGenLegendOak$BendDirection var12 = var9[var11];
            WorldGenLegendOak$BendDirection[] var13 = WorldGenLegendOak$BendDirection.values();
            int var14 = var13.length;

            for (int var15 = 0; var15 < var14; ++var15)
            {
                WorldGenLegendOak$BendDirection var16 = var13[var15];

                if (var12 != WorldGenLegendOak$BendDirection.STRAIGHT || var16 != WorldGenLegendOak$BendDirection.STRAIGHT)
                {
                    this.primary(var1, var2, var8, var12, var16, var3, var4 + var6, var5);
                    this.inside(var1, var2, var8, var12, var16, var3, var4 + var6, var5);
                    this.insideSmall(var1, var2, var8, var12, var16, var3, var4 + var6, var5);
                }
            }
        }
    }

    protected void growTree(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        var1.setBlock(var3, var4 - 1, var5, Block.dirt.blockID);
        var1.setBlock(var3 - 1, var4 - 1, var5, Block.dirt.blockID);
        var1.setBlock(var3, var4 - 1, var5 - 1, Block.dirt.blockID);
        var1.setBlock(var3 - 1, var4 - 1, var5 - 1, Block.dirt.blockID);
        this.growTrunk(var1, var2, var3, var4, var5, var6);
        this.growLeaves(var1, var2, var3, var4, var5, var6, var7, var8);
    }

    protected void growTrunk(World var1, Random var2, int var3, int var4, int var5, int var6)
    {
        for (int var7 = 0; var7 < var6 + 1; ++var7)
        {
            this.setBlockAndMetadata(var1, var3, var4 + var7, var5, WorldGenLegendOak$TreeBlock.TRUNK_SE.getID(), WorldGenLegendOak$TreeBlock.TRUNK_SE.getMetadata());
            this.setBlockAndMetadata(var1, var3 - 1, var4 + var7, var5, WorldGenLegendOak$TreeBlock.TRUNK_SW.getID(), WorldGenLegendOak$TreeBlock.TRUNK_SW.getMetadata());
            this.setBlockAndMetadata(var1, var3, var4 + var7, var5 - 1, WorldGenLegendOak$TreeBlock.TRUNK_NE.getID(), WorldGenLegendOak$TreeBlock.TRUNK_NE.getMetadata());
            this.setBlockAndMetadata(var1, var3 - 1, var4 + var7, var5 - 1, WorldGenLegendOak$TreeBlock.TRUNK_NW.getID(), WorldGenLegendOak$TreeBlock.TRUNK_NW.getMetadata());
        }
    }

    private void inside(World var1, Random var2, int var3, WorldGenLegendOak$BendDirection var4, WorldGenLegendOak$BendDirection var5, int var6, int var7, int var8)
    {
        for (int var9 = 0; var9 < 2 * var3 / 3; ++var9)
        {
            this.setBlockAndMetadata(var1, var6, var7, var8, WorldGenLegendOak$TreeBlock.BRANCH.getID(), WorldGenLegendOak$TreeBlock.BRANCH.getMetadata());

            if (var2.nextInt(3) == 0 || var9 == 2 * var3 / 3 - 1)
            {
                this.growLeafNode(var1, var6, var7, var8);
            }

            switch (WorldGenLegendOak$1.$SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[var4.ordinal()])
            {
                case 1:
                    var6 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var6 += var2.nextInt(2);
                    break;

                case 3:
                    var6 -= var2.nextInt(2);
            }

            switch (WorldGenLegendOak$1.$SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[var5.ordinal()])
            {
                case 1:
                    var8 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var8 += var2.nextInt(2);
                    break;

                case 3:
                    var8 -= var2.nextInt(2);
            }

            if (var2.nextInt(6) == 0 && var9 > var3 / 3)
            {
                this.secondary(var1, var2, var3 / 3 - var9 / 3, var4, var5, var6, var7, var8);
            }

            ++var7;
        }
    }

    private void insideSmall(World var1, Random var2, int var3, WorldGenLegendOak$BendDirection var4, WorldGenLegendOak$BendDirection var5, int var6, int var7, int var8)
    {
        for (int var9 = 0; var9 < var3 / 3; ++var9)
        {
            this.setBlockAndMetadata(var1, var6, var7, var8, WorldGenLegendOak$TreeBlock.BRANCH.getID(), WorldGenLegendOak$TreeBlock.BRANCH.getMetadata());

            if (var2.nextInt(3) == 0 || var9 == var3 / 3 - 1)
            {
                this.growLeafNode(var1, var6, var7, var8);
            }

            switch (WorldGenLegendOak$1.$SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[var4.ordinal()])
            {
                case 1:
                    var6 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var6 += var2.nextInt(2);
                    break;

                case 3:
                    var6 -= var2.nextInt(2);
            }

            switch (WorldGenLegendOak$1.$SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[var5.ordinal()])
            {
                case 1:
                    var8 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var8 += var2.nextInt(2);
                    break;

                case 3:
                    var8 -= var2.nextInt(2);
            }

            if (var2.nextInt(6) == 0 && var9 > var3 / 6)
            {
                this.secondary(var1, var2, var3 / 6 - var9 / 6, var4, var5, var6, var7, var8);
            }

            ++var7;
        }
    }

    private void primary(World var1, Random var2, int var3, WorldGenLegendOak$BendDirection var4, WorldGenLegendOak$BendDirection var5, int var6, int var7, int var8)
    {
        WorldGenLegendOak$Acuteness var9 = WorldGenLegendOak$Acuteness.LOOSE;
        int var10 = 0;

        if (var4 == WorldGenLegendOak$BendDirection.RIGHT)
        {
            var6 += 2;
        }

        if (var4 == WorldGenLegendOak$BendDirection.LEFT)
        {
            var6 -= 2;
        }

        if (var5 == WorldGenLegendOak$BendDirection.RIGHT)
        {
            var8 += 2;
        }

        if (var5 == WorldGenLegendOak$BendDirection.LEFT)
        {
            var8 -= 2;
        }

        for (; var10 < var3; ++var10)
        {
            switch (WorldGenLegendOak$1.$SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$Acuteness[var9.ordinal()])
            {
                case 1:
                    if (var2.nextInt(4) == 0)
                    {
                        ++var7;
                    }

                    break;

                case 2:
                    if (var2.nextInt(2) == 0)
                    {
                        ++var7;
                    }

                    break;

                case 3:
                    ++var7;
            }

            this.setBlockAndMetadata(var1, var6, var7, var8, WorldGenLegendOak$TreeBlock.BRANCH.getID(), WorldGenLegendOak$TreeBlock.BRANCH.getMetadata());

            if (var2.nextInt(3) == 0 || var10 == var3 - 1)
            {
                this.growLeafNode(var1, var6, var7, var8);
            }

            switch (WorldGenLegendOak$1.$SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[var4.ordinal()])
            {
                case 1:
                    var6 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var6 += var2.nextInt(2);
                    break;

                case 3:
                    var6 -= var2.nextInt(2);
            }

            switch (WorldGenLegendOak$1.$SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[var5.ordinal()])
            {
                case 1:
                    var8 += var2.nextInt(3) - 1;
                    break;

                case 2:
                    var8 += var2.nextInt(2);
                    break;

                case 3:
                    var8 -= var2.nextInt(2);
            }

            if (var10 == var3 / 3)
            {
                var9 = WorldGenLegendOak$Acuteness.TIGHTER;
            }

            if (var10 == 2 * var3 / 3)
            {
                var9 = WorldGenLegendOak$Acuteness.TIGHT;
            }

            if (var2.nextInt(4) == 0)
            {
                this.secondary(var1, var2, var3 / 2 - var10 / 2, var4, var5, var6, var7, var8);
            }
        }
    }

    private void secondary(World var1, Random var2, int var3, WorldGenLegendOak$BendDirection var4, WorldGenLegendOak$BendDirection var5, int var6, int var7, int var8)
    {
        int var9 = 0;

        for (int var10 = 0; var10 < 2; ++var10)
        {
            int var11 = var6;
            int var12 = var7;

            for (int var13 = var8; var9 < var3; ++var9)
            {
                if (var2.nextInt(2) == 0)
                {
                    ++var12;
                }

                this.setBlockAndMetadata(var1, var11, var12, var13, WorldGenLegendOak$TreeBlock.BRANCH.getID(), WorldGenLegendOak$TreeBlock.BRANCH.getMetadata());

                if (var2.nextInt(4) == 0 || var9 == var3 - 1)
                {
                    this.growLeafNode(var1, var11, var12, var13);
                }

                if (var5 == WorldGenLegendOak$BendDirection.STRAIGHT)
                {
                    if (var4 == WorldGenLegendOak$BendDirection.RIGHT)
                    {
                        var11 += var2.nextInt(2);
                    }
                    else
                    {
                        var11 -= var2.nextInt(2);
                    }

                    if (var10 == 0)
                    {
                        var13 += var2.nextInt(2);
                    }
                    else
                    {
                        var13 -= var2.nextInt(2);
                    }
                }

                if (var4 == WorldGenLegendOak$BendDirection.STRAIGHT)
                {
                    if (var5 == WorldGenLegendOak$BendDirection.RIGHT)
                    {
                        var13 += var2.nextInt(2);
                    }
                    else
                    {
                        var13 -= var2.nextInt(2);
                    }

                    if (var10 == 0)
                    {
                        var11 += var2.nextInt(2);
                    }
                    else
                    {
                        var11 -= var2.nextInt(2);
                    }
                }

                if (var4 == WorldGenLegendOak$BendDirection.RIGHT)
                {
                    if (var5 == WorldGenLegendOak$BendDirection.RIGHT)
                    {
                        if (var10 == 0)
                        {
                            var13 += var2.nextInt(2);
                        }
                        else
                        {
                            var11 += var2.nextInt(2);
                        }
                    }

                    if (var5 == WorldGenLegendOak$BendDirection.LEFT)
                    {
                        if (var10 == 0)
                        {
                            var13 -= var2.nextInt(2);
                        }
                        else
                        {
                            var11 += var2.nextInt(2);
                        }
                    }
                }

                if (var4 == WorldGenLegendOak$BendDirection.LEFT)
                {
                    if (var5 == WorldGenLegendOak$BendDirection.RIGHT)
                    {
                        if (var10 == 0)
                        {
                            var13 += var2.nextInt(2);
                        }
                        else
                        {
                            var11 -= var2.nextInt(2);
                        }
                    }

                    if (var5 == WorldGenLegendOak$BendDirection.LEFT)
                    {
                        if (var10 == 0)
                        {
                            var13 -= var2.nextInt(2);
                        }
                        else
                        {
                            var11 -= var2.nextInt(2);
                        }
                    }
                }
            }
        }
    }
}
