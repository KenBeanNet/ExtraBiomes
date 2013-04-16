package extrabiomes.module.summa.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MarshGenerator implements IWorldGenerator
{
    private static final WorldGenerator genMarsh = new WorldGenMarshGrass();
    private static final WorldGenerator genDirtBed = new WorldGenMarshDirt();

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        BiomeGenBase var7 = var4.getBiomeGenForCoords(var2, var3);

        if (BiomeManager.marsh.isPresent() && var7 == BiomeManager.marsh.get())
        {
            this.generateMarsh(var1, var2, var3, var4);
        }
    }

    private void generateMarsh(Random var1, int var2, int var3, World var4)
    {
        int var5;
        int var6;
        int var7;

        for (var5 = 0; var5 < 127; ++var5)
        {
            var6 = var2 + var1.nextInt(16) + 8;
            var7 = var3 + var1.nextInt(16) + 8;
            genMarsh.generate(var4, var1, var6, 0, var7);
        }

        for (var5 = 0; var5 < 256; ++var5)
        {
            var6 = var2 + var1.nextInt(1) + 8;
            var7 = var3 + var1.nextInt(1) + 8;
            genDirtBed.generate(var4, var1, var6, 0, var7);
        }
    }
}
