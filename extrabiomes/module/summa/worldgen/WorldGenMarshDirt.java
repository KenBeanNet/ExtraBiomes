package extrabiomes.module.summa.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

class WorldGenMarshDirt extends WorldGenerator
{
    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var3;
        int var7 = var5;

        for (int var8 = var4; var8 < 62; ++var8)
        {
            if (!var1.isAirBlock(var6, var8, var7))
            {
                for (int var9 = 2; var9 <= 5; ++var9)
                {
                    if (Block.dirt.canPlaceBlockOnSide(var1, var6, var8, var7, var9))
                    {
                        var1.setBlockAndMetadata(var6, var8, var7, Block.dirt.blockID, 1 << Direction.vineGrowth[Facing.faceToSide[var9]]);
                        break;
                    }
                }
            }
            else
            {
                var6 = var3 + 16;
                var7 = var5 + 16;
            }
        }

        return true;
    }
}
