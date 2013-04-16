package extrabiomes.module.cautia.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

class WorldGenQuicksand extends WorldGenerator
{
    private final int quicksandID;

    WorldGenQuicksand(int var1)
    {
        this.quicksandID = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        while ((var1.isAirBlock(var3, var4, var5) || !Block.isNormalCube(var1.getBlockId(var3, var4, var5))) && var4 > 2)
        {
            --var4;
        }

        int var6 = var1.getBlockId(var3, var4, var5);

        if (var6 != Block.grass.blockID && var6 != Block.sand.blockID)
        {
            return false;
        }
        else
        {
            int var7;
            int var8;

            for (var7 = -2; var7 <= 2; ++var7)
            {
                for (var8 = -2; var8 <= 2; ++var8)
                {
                    if (var1.isAirBlock(var3 + var7, var4 - 1, var5 + var8) && var1.isAirBlock(var3 + var7, var4 - 2, var5 + var8))
                    {
                        return false;
                    }
                }
            }

            for (var7 = -1; var7 <= 1; ++var7)
            {
                for (var8 = -1; var8 <= 1; ++var8)
                {
                    for (int var9 = -2; var9 <= 0; ++var9)
                    {
                        var1.setBlock(var3 + var7, var4 + var9, var5 + var8, this.quicksandID);
                    }
                }
            }

            return true;
        }
    }
}
