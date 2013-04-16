package extrabiomes.module.summa.worldgen;

import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

class WorldGenTinyCactus extends WorldGenerator
{
    private final int blockID;
    private final int metadata;

    WorldGenTinyCactus(int var1, int var2)
    {
        this.blockID = var1;
        this.metadata = var2;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        for (int var6 = 0; var6 < 10; ++var6)
        {
            int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);

            if (var1.isAirBlock(var7, var8, var9))
            {
                int var10 = 1 + var2.nextInt(var2.nextInt(3) + 1);

                for (int var11 = 0; var11 < var10; ++var11)
                {
                    int var12 = var1.getBlockId(var7, var8 + var11 - 1, var9);

                    if (var12 == Block.sand.blockID || (byte)var12 == ((BiomeGenBase)BiomeManager.mountainridge.get()).topBlock)
                    {
                        var1.setBlockAndMetadata(var7, var8 + var11, var9, this.blockID, this.metadata);
                    }
                }
            }
        }

        return true;
    }
}
