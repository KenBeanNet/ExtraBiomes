package extrabiomes.module.summa.worldgen;

import extrabiomes.module.summa.TreeSoilRegistry;
import extrabiomes.module.summa.worldgen.WorldGenAutumnTree$AutumnTreeType;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenAutumnTree extends WorldGenerator
{
    private static Block trunkBlock = Block.wood;
    private static int trunkMetadata = 1;
    private static ItemStack brownLeaves = new ItemStack(Block.leaves);
    private static ItemStack orangeLeaves = brownLeaves;
    private static ItemStack purpleLeaves = brownLeaves;
    private static ItemStack yellowLeaves = brownLeaves;
    private static final int BASE_HEIGHT = 4;
    private static final int CANOPY_HEIGHT = 3;
    private static final int CANOPY_RADIUS_EXTRA_RADIUS = 0;
    private static final int MAX_VARIANCE_HEIGHT = 2;
    protected final WorldGenAutumnTree$AutumnTreeType type;

    private static boolean isBlockSuitableForGrowing(World var0, int var1, int var2, int var3)
    {
        int var4 = var0.getBlockId(var1, var2, var3);
        return TreeSoilRegistry.isValidSoil(var4);
    }

    private static boolean isRoomToGrow(World var0, int var1, int var2, int var3, int var4)
    {
        for (int var5 = var2; var5 <= var2 + 1 + var4; ++var5)
        {
            if (var5 < 0 || var5 >= 256)
            {
                return false;
            }

            byte var6 = 1;

            if (var5 == var2)
            {
                var6 = 0;
            }

            if (var5 >= var2 + 1 + var4 - 2)
            {
                var6 = 2;
            }

            for (int var7 = var1 - var6; var7 <= var1 + var6; ++var7)
            {
                for (int var8 = var3 - var6; var8 <= var3 + var6; ++var8)
                {
                    int var9 = var0.getBlockId(var7, var5, var8);

                    if (Block.blocksList[var9] != null && !Block.blocksList[var9].isLeaves(var0, var7, var5, var8) && var9 != Block.grass.blockID && !Block.blocksList[var9].isWood(var0, var7, var5, var8))
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void setTrunkBlock(Block var0, int var1)
    {
        trunkBlock = var0;
        trunkMetadata = var1;
    }

    public WorldGenAutumnTree(boolean var1, WorldGenAutumnTree$AutumnTreeType var2)
    {
        super(var1);
        this.type = var2;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var2.nextInt(3) + 4;

        if (var4 >= 1 && var4 + var6 + 1 <= 256)
        {
            if (!isBlockSuitableForGrowing(var1, var3, var4 - 1, var5))
            {
                return false;
            }
            else if (!isRoomToGrow(var1, var3, var4, var5, var6))
            {
                return false;
            }
            else
            {
                var1.setBlock(var3, var4 - 1, var5, Block.dirt.blockID);
                this.growLeaves(var1, var2, var3, var4, var5, var6, this.type.getID(), this.type.getMetadata());
                this.growTrunk(var1, var3, var4, var5, var6, trunkBlock.blockID, trunkMetadata);
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    private void growLeaves(World var1, Random var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        for (int var9 = var4 - 3 + var6; var9 <= var4 + var6; ++var9)
        {
            int var10 = var9 - (var4 + var6);
            int var11 = 1 - var10 / 2;

            for (int var12 = var3 - var11; var12 <= var3 + var11; ++var12)
            {
                int var13 = var12 - var3;

                for (int var14 = var5 - var11; var14 <= var5 + var11; ++var14)
                {
                    int var15 = var14 - var5;
                    Block var16 = Block.blocksList[var1.getBlockId(var12, var9, var14)];

                    if ((Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) && (var16 == null || var16.canBeReplacedByLeaves(var1, var12, var9, var14)))
                    {
                        this.setBlockAndMetadata(var1, var12, var9, var14, var7, var8);
                    }
                }
            }
        }
    }

    private void growTrunk(World var1, int var2, int var3, int var4, int var5, int var6, int var7)
    {
        for (int var8 = 0; var8 < var5; ++var8)
        {
            int var9 = var1.getBlockId(var2, var3 + var8, var4);

            if (Block.blocksList[var9] == null || Block.blocksList[var9].isLeaves(var1, var2, var3 + var8, var4))
            {
                this.setBlockAndMetadata(var1, var2, var3 + var8, var4, var6, var7);
            }
        }
    }
}
