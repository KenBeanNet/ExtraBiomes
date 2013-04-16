package extrabiomes.module.summa.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MountainDesertGenerator implements IWorldGenerator
{
    private static final WorldGenerator vineGen = new WorldGenVines();

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        BiomeGenBase var7 = var4.getBiomeGenForCoords(var2, var2);

        if (BiomeManager.mountaindesert.isPresent() && var7 == BiomeManager.mountaindesert.get())
        {
            this.generateRareDesertWell(var1, var2, var3, var4);
        }
    }

    private void generateRareDesertWell(Random var1, int var2, int var3, World var4)
    {
        if (var1.nextInt(1000) == 0)
        {
            int var5 = var2 + var1.nextInt(16) + 8;
            int var6 = var3 + var1.nextInt(16) + 8;
            WorldGenDesertWells var7 = new WorldGenDesertWells();
            var7.generate(var4, var1, var5, var4.getHeightValue(var5, var6) + 1, var6);
        }
    }
}
