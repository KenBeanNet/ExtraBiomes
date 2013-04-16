package extrabiomes.module.summa.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

class WorldGenLeafPile extends WorldGenerator
{
    private final int blockID;

    WorldGenLeafPile(int var1)
    {
        this.blockID = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6;

        while ((Block.blocksList[var6 = var1.getBlockId(var3, var4, var5)] == null || Block.blocksList[var6].isLeaves(var1, var3, var4, var5)) && var4 > 0)
        {
            --var4;
        }

        for (int var7 = 0; var7 < 128; ++var7)
        {
            int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);

            if (var1.isAirBlock(var8, var9, var10) && Block.blocksList[this.blockID].canBlockStay(var1, var8, var9, var10))
            {
                var1.setBlock(var8, var9, var10, this.blockID);
            }
        }

        return true;
    }
}
