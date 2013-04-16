package extrabiomes.module.summa.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

class WorldGenCatTail extends WorldGenerator
{
    private final int blockID;

    WorldGenCatTail(int var1)
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

        ++var4;

        for (int var7 = 0; var7 < 20; ++var7)
        {
            int var8 = var3 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(4) - var2.nextInt(4);

            if (var1.isAirBlock(var8, var4, var9) && (var1.getBlockMaterial(var8 - 1, var4 - 1, var9) == Material.water || var1.getBlockMaterial(var8 + 1, var4 - 1, var9) == Material.water || var1.getBlockMaterial(var8, var4 - 1, var9 - 1) == Material.water || var1.getBlockMaterial(var8, var4 - 1, var9 + 1) == Material.water))
            {
                int var10 = 1 + var2.nextInt(var2.nextInt(1) + 1);

                for (var6 = 0; var6 < var10; ++var6)
                {
                    if (Block.blocksList[this.blockID].canBlockStay(var1, var8, var4 + var6, var9))
                    {
                        var1.setBlock(var8, var4 + var6, var9, this.blockID);
                    }
                }
            }
        }

        return true;
    }
}
