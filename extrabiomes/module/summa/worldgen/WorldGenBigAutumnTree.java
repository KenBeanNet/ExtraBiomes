package extrabiomes.module.summa.worldgen;

import extrabiomes.module.summa.worldgen.WorldGenAutumnTree$AutumnTreeType;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class WorldGenBigAutumnTree extends WorldGenAutumnTree
{
    private static Block trunkBlock = Block.wood;
    private static int trunkMetadata = 0;
    private static final byte[] otherCoordPairs = new byte[] {(byte)2, (byte)0, (byte)0, (byte)1, (byte)2, (byte)1};
    private final Random rand = new Random();
    private World world;
    private final int[] basePos = new int[] {0, 0, 0};
    private int heightLimit = 0;
    private int height;
    private final double heightAttenuation = 0.618D;
    private final double branchSlope = 0.381D;
    private double scaleWidth = 1.0D;
    private double leafDensity = 1.0D;
    private int heightLimitLimit = 12;
    private int leafDistanceLimit = 4;
    private int[][] leafNodes;

    public static void setTrunkBlock(Block var0, int var1)
    {
        trunkBlock = var0;
        trunkMetadata = var1;
    }

    public WorldGenBigAutumnTree(boolean var1, WorldGenAutumnTree$AutumnTreeType var2)
    {
        super(var1, var2);
    }

    private int checkBlockLine(int[] var1, int[] var2)
    {
        int[] var3 = new int[] {0, 0, 0};
        byte var4 = 0;
        byte var5;

        for (var5 = 0; var4 < 3; ++var4)
        {
            var3[var4] = var2[var4] - var1[var4];

            if (Math.abs(var3[var4]) > Math.abs(var3[var5]))
            {
                var5 = var4;
            }
        }

        if (var3[var5] == 0)
        {
            return -1;
        }
        else
        {
            byte var6 = otherCoordPairs[var5];
            byte var7 = otherCoordPairs[var5 + 3];
            byte var8;

            if (var3[var5] > 0)
            {
                var8 = 1;
            }
            else
            {
                var8 = -1;
            }

            double var9 = (double)var3[var6] / (double)var3[var5];
            double var11 = (double)var3[var7] / (double)var3[var5];
            int[] var13 = new int[] {0, 0, 0};
            int var14 = 0;
            int var15;

            for (var15 = var3[var5] + var8; var14 != var15; var14 += var8)
            {
                var13[var5] = var1[var5] + var14;
                var13[var6] = MathHelper.floor_double((double)var1[var6] + (double)var14 * var9);
                var13[var7] = MathHelper.floor_double((double)var1[var7] + (double)var14 * var11);
                int var16 = this.world.getBlockId(var13[0], var13[1], var13[2]);

                if (var16 != 0 && !Block.blocksList[var16].isLeaves(this.world, var13[0], var13[1], var13[2]))
                {
                    break;
                }
            }

            return var14 == var15 ? -1 : Math.abs(var14);
        }
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        this.world = var1;
        long var6 = var2.nextLong();
        this.rand.setSeed(var6);
        this.basePos[0] = var3;
        this.basePos[1] = var4;
        this.basePos[2] = var5;

        if (this.heightLimit == 0)
        {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }

        if (!this.validTreeLocation())
        {
            return false;
        }
        else
        {
            this.generateLeafNodeList();
            this.generateLeaves(this.type.getID(), this.type.getMetadata());
            this.generateTrunk(trunkBlock.blockID, trunkMetadata);
            this.generateLeafNodeBases(trunkBlock.blockID, trunkMetadata);
            return true;
        }
    }

    private void generateLeafNode(int var1, int var2, int var3, int var4, int var5)
    {
        int var6 = var2;

        for (int var7 = var2 + this.leafDistanceLimit; var6 < var7; ++var6)
        {
            float var8 = this.leafSize(var6 - var2);
            this.genTreeLayer(var1, var6, var3, var8, (byte)1, var4, var5);
        }
    }

    private void generateLeafNodeBases(int var1, int var2)
    {
        int var3 = 0;
        int var4 = this.leafNodes.length;

        for (int[] var5 = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]}; var3 < var4; ++var3)
        {
            int[] var6 = this.leafNodes[var3];
            int[] var7 = new int[] {var6[0], var6[1], var6[2]};
            var5[1] = var6[3];
            int var8 = var5[1] - this.basePos[1];

            if (this.leafNodeNeedsBase(var8))
            {
                this.placeBlockLine(var5, var7, var1, var2);
            }
        }
    }

    private void generateLeafNodeList()
    {
        this.height = (int)((double)this.heightLimit * 0.618D);

        if (this.height >= this.heightLimit)
        {
            this.height = this.heightLimit - 1;
        }

        int var1 = (int)(1.382D + Math.pow(this.leafDensity * (double)this.heightLimit / 13.0D, 2.0D));

        if (var1 < 1)
        {
            var1 = 1;
        }

        int[][] var2 = new int[var1 * this.heightLimit][4];
        int var3 = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
        int var4 = 1;
        int var5 = this.basePos[1] + this.height;
        int var6 = var3 - this.basePos[1];
        var2[0][0] = this.basePos[0];
        var2[0][1] = var3;
        var2[0][2] = this.basePos[2];
        var2[0][3] = var5;
        --var3;

        while (var6 >= 0)
        {
            int var7 = 0;
            float var8 = this.layerSize(var6);

            if (var8 < 0.0F)
            {
                --var3;
                --var6;
            }
            else
            {
                for (double var9 = 0.5D; var7 < var1; ++var7)
                {
                    double var11 = this.scaleWidth * (double)var8 * ((double)this.rand.nextFloat() + 0.328D);
                    double var13 = (double)this.rand.nextFloat() * 2.0D * Math.PI;
                    int var15 = MathHelper.floor_double(var11 * Math.sin(var13) + (double)this.basePos[0] + 0.5D);
                    int var16 = MathHelper.floor_double(var11 * Math.cos(var13) + (double)this.basePos[2] + 0.5D);
                    int[] var17 = new int[] {var15, var3, var16};
                    int[] var18 = new int[] {var15, var3 + this.leafDistanceLimit, var16};

                    if (this.checkBlockLine(var17, var18) == -1)
                    {
                        int[] var19 = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]};
                        double var20 = Math.sqrt(Math.pow((double)Math.abs(this.basePos[0] - var17[0]), 2.0D) + Math.pow((double)Math.abs(this.basePos[2] - var17[2]), 2.0D));
                        double var22 = var20 * 0.381D;

                        if ((double)var17[1] - var22 > (double)var5)
                        {
                            var19[1] = var5;
                        }
                        else
                        {
                            var19[1] = (int)((double)var17[1] - var22);
                        }

                        if (this.checkBlockLine(var19, var17) == -1)
                        {
                            var2[var4][0] = var15;
                            var2[var4][1] = var3;
                            var2[var4][2] = var16;
                            var2[var4][3] = var19[1];
                            ++var4;
                        }
                    }
                }

                --var3;
                --var6;
            }
        }

        this.leafNodes = new int[var4][4];
        System.arraycopy(var2, 0, this.leafNodes, 0, var4);
    }

    private void generateLeaves(int var1, int var2)
    {
        int var3 = 0;

        for (int var4 = this.leafNodes.length; var3 < var4; ++var3)
        {
            this.generateLeafNode(this.leafNodes[var3][0], this.leafNodes[var3][1], this.leafNodes[var3][2], var1, var2);
        }
    }

    private void generateTrunk(int var1, int var2)
    {
        int var3 = this.basePos[0];
        int var4 = this.basePos[1];
        int var5 = this.basePos[1] + this.height;
        int var6 = this.basePos[2];
        int[] var7 = new int[] {var3, var4, var6};
        int[] var8 = new int[] {var3, var5, var6};
        this.placeBlockLine(var7, var8, var1, var2);
    }

    private void genTreeLayer(int var1, int var2, int var3, float var4, byte var5, int var6, int var7)
    {
        int var8 = (int)((double)var4 + 0.618D);
        byte var9 = otherCoordPairs[var5];
        byte var10 = otherCoordPairs[var5 + 3];
        int[] var11 = new int[] {var1, var2, var3};
        int[] var12 = new int[] {0, 0, 0};
        int var13 = -var8;
        int var14 = -var8;

        for (var12[var5] = var11[var5]; var13 <= var8; ++var13)
        {
            var12[var9] = var11[var9] + var13;
            var14 = -var8;

            while (var14 <= var8)
            {
                double var15 = Math.pow((double)Math.abs(var13) + 0.5D, 2.0D) + Math.pow((double)Math.abs(var14) + 0.5D, 2.0D);

                if (var15 > (double)(var4 * var4))
                {
                    ++var14;
                }
                else
                {
                    var12[var10] = var11[var10] + var14;
                    int var17 = this.world.getBlockId(var12[0], var12[1], var12[2]);

                    if (var17 != 0 && !Block.blocksList[var17].isLeaves(this.world, var12[0], var12[1], var12[2]))
                    {
                        ++var14;
                    }
                    else
                    {
                        if (var17 == 0 || Block.blocksList[var17].canBeReplacedByLeaves(this.world, var12[0], var12[1], var12[2]))
                        {
                            this.setBlockAndMetadata(this.world, var12[0], var12[1], var12[2], var6, var7);
                        }

                        ++var14;
                    }
                }
            }
        }
    }

    private float layerSize(int var1)
    {
        if ((double)var1 < (double)this.heightLimit * 0.3D)
        {
            return -1.618F;
        }
        else
        {
            float var2 = (float)this.heightLimit / 2.0F;
            float var3 = (float)this.heightLimit / 2.0F - (float)var1;
            float var4;

            if (var3 == 0.0F)
            {
                var4 = var2;
            }
            else if (Math.abs(var3) >= var2)
            {
                var4 = 0.0F;
            }
            else
            {
                var4 = (float)Math.sqrt(Math.pow((double)Math.abs(var2), 2.0D) - Math.pow((double)Math.abs(var3), 2.0D));
            }

            var4 *= 0.5F;
            return var4;
        }
    }

    private boolean leafNodeNeedsBase(int var1)
    {
        return (double)var1 >= (double)this.heightLimit * 0.2D;
    }

    float leafSize(int var1)
    {
        return var1 >= 0 && var1 < this.leafDistanceLimit ? (var1 != 0 && var1 != this.leafDistanceLimit - 1 ? 3.0F : 2.0F) : -1.0F;
    }

    private void placeBlockLine(int[] var1, int[] var2, int var3, int var4)
    {
        int[] var5 = new int[] {0, 0, 0};
        byte var6 = 0;
        byte var7;

        for (var7 = 0; var6 < 3; ++var6)
        {
            var5[var6] = var2[var6] - var1[var6];

            if (Math.abs(var5[var6]) > Math.abs(var5[var7]))
            {
                var7 = var6;
            }
        }

        if (var5[var7] != 0)
        {
            byte var8 = otherCoordPairs[var7];
            byte var9 = otherCoordPairs[var7 + 3];
            byte var10;

            if (var5[var7] > 0)
            {
                var10 = 1;
            }
            else
            {
                var10 = -1;
            }

            double var11 = (double)var5[var8] / (double)var5[var7];
            double var13 = (double)var5[var9] / (double)var5[var7];
            int[] var15 = new int[] {0, 0, 0};
            int var16 = 0;

            for (int var17 = var5[var7] + var10; var16 != var17; var16 += var10)
            {
                var15[var7] = MathHelper.floor_double((double)(var1[var7] + var16) + 0.5D);
                var15[var8] = MathHelper.floor_double((double)var1[var8] + (double)var16 * var11 + 0.5D);
                var15[var9] = MathHelper.floor_double((double)var1[var9] + (double)var16 * var13 + 0.5D);
                byte var18 = (byte)var4;
                int var19 = Math.abs(var15[0] - var1[0]);
                int var20 = Math.abs(var15[2] - var1[2]);
                int var21 = Math.max(var19, var20);

                if (var21 > 0)
                {
                    if (var19 == var21)
                    {
                        var18 = (byte)(var18 | 4);
                    }
                    else if (var20 == var21)
                    {
                        var18 = (byte)(var18 | 8);
                    }
                }

                this.setBlockAndMetadata(this.world, var15[0], var15[1], var15[2], var3, var18);
            }
        }
    }

    /**
     * Rescales the generator settings, only used in WorldGenBigTree
     */
    public void setScale(double var1, double var3, double var5)
    {
        this.heightLimitLimit = (int)(var1 * 12.0D);

        if (var1 > 0.5D)
        {
            this.leafDistanceLimit = 5;
        }

        this.scaleWidth = var3;
        this.leafDensity = var5;
    }

    private boolean validTreeLocation()
    {
        int[] var1 = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]};
        int[] var2 = new int[] {this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2]};
        int var3 = this.world.getBlockId(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);

        if (var3 != 2 && var3 != 3)
        {
            return false;
        }
        else
        {
            int var4 = this.checkBlockLine(var1, var2);

            if (var4 == -1)
            {
                return true;
            }
            else if (var4 < 6)
            {
                return false;
            }
            else
            {
                this.heightLimit = var4;
                return true;
            }
        }
    }
}
