package extrabiomes.module.cautia.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class QuicksandGenerator implements IWorldGenerator
{
    private final WorldGenQuicksand genPit;

    public QuicksandGenerator(int var1)
    {
        this.genPit = new WorldGenQuicksand(var1);
    }

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        BiomeGenBase var7 = var4.getBiomeGenForCoords(var2, var3);

        if (BiomeManager.minijungle.isPresent() && var7 == BiomeManager.minijungle.get())
        {
            int var8 = var1.nextInt(1) + var1.nextInt(1) + 1;

            for (int var9 = 0; var9 < var8; ++var9)
            {
                if (var1.nextInt(1) == 0)
                {
                    int var10 = this.randomizedCoord(var1, var2);
                    int var11 = this.randomizedCoord(var1, var3);
                    this.genPit.generate(var4, var1, var10, var4.getHeightValue(var10, var11) + 1, var11);
                }
            }
        }
    }

    private int randomizedCoord(Random var1, int var2)
    {
        return var2 + var1.nextInt(16) + 8;
    }
}
