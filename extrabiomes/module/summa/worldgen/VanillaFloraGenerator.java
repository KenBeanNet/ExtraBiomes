package extrabiomes.module.summa.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VanillaFloraGenerator implements IWorldGenerator
{
    private static final WorldGenerator vineGen = new WorldGenVines();

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        BiomeGenBase var7 = var4.getBiomeGenForCoords(var2, var2);
        boolean var8 = BiomeManager.extremejungle.isPresent() && var7 == BiomeManager.extremejungle.get();

        if (var8)
        {
            this.generateVines(var1, var2, var3, var4);
        }

        boolean var9 = BiomeManager.minijungle.isPresent() && var7 == BiomeManager.minijungle.get();
        boolean var10 = BiomeManager.temperaterainforest.isPresent() && var7 == BiomeManager.temperaterainforest.get();

        if ((var8 || var9 || var10 || var7 == BiomeGenBase.jungle || var7 == BiomeGenBase.jungleHills) && var1.nextInt(48) == 0)
        {
            this.generateMelonPatch(var4, var1, var2, var3);
        }
    }

    private void generateMelonPatch(World var1, Random var2, int var3, int var4)
    {
        var3 += var2.nextInt(16) + 8;
        int var5 = var2.nextInt(128);
        var4 += var2.nextInt(16) + 8;
        (new WorldGenMelon()).generate(var1, var2, var3, var5, var4);
    }

    private void generateVines(Random var1, int var2, int var3, World var4)
    {
        for (int var5 = 0; var5 < 50; ++var5)
        {
            int var6 = var2 + var1.nextInt(16) + 8;
            int var7 = var3 + var1.nextInt(16) + 8;
            vineGen.generate(var4, var1, var6, 64, var7);
        }
    }
}
