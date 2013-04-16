package extrabiomes.module.summa.worldgen;

import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

class WorldGenOasis extends WorldGenerator
{
    private static final int AVERAGE_OASIS = 7;

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        if (var1.getBlockMaterial(var3, var4, var5) != Material.water)
        {
            return false;
        }
        else
        {
            int var6 = var2.nextInt(5) + 2;
            boolean var7 = true;

            for (int var8 = var3 - var6; var8 <= var3 + var6; ++var8)
            {
                for (int var9 = var5 - var6; var9 <= var5 + var6; ++var9)
                {
                    int var10 = var8 - var3;
                    int var11 = var9 - var5;

                    if (var10 * var10 + var11 * var11 <= var6 * var6)
                    {
                        for (int var12 = var4 - 2; var12 <= var4 + 2; ++var12)
                        {
                            int var13 = var1.getBlockId(var8, var12, var9);

                            if (var13 == Block.stone.blockID || var13 == Block.sand.blockID || var13 == Block.sandStone.blockID || var13 == ((BiomeGenBase)BiomeManager.mountainridge.get()).topBlock)
                            {
                                var1.setBlock(var8, var12, var9, Block.grass.blockID);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
