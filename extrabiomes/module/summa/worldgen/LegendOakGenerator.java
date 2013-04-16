package extrabiomes.module.summa.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LegendOakGenerator implements IWorldGenerator
{
    private final WorldGenerator treeGen = new WorldGenLegendOak(false);

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        short var7 = 0;
        BiomeGenBase var8 = var4.getBiomeGenForCoords(var2, var2);

        if (var8 == BiomeGenBase.forest || var8 == BiomeGenBase.forestHills || BiomeManager.forestedhills.isPresent() && var8 == BiomeManager.forestedhills.get() || BiomeManager.forestedisland.isPresent() && var8 == BiomeManager.forestedisland.get() || BiomeManager.rainforest.isPresent() && var8 == BiomeManager.rainforest.get())
        {
            var7 = 100;
        }

        if (var8 == BiomeGenBase.plains || var8 == BiomeGenBase.extremeHillsEdge)
        {
            var7 = 1000;
        }

        if (var7 != 0)
        {
            if (var1.nextInt(var7) == 0)
            {
                int var9 = var2 + var1.nextInt(16) + 8;
                int var10 = var3 + var1.nextInt(16) + 8;
                int var11 = var4.getHeightValue(var9, var10);
                this.treeGen.generate(var4, var1, var9, var11, var10);
            }
        }
    }
}
