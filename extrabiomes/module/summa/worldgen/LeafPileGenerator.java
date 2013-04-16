package extrabiomes.module.summa.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LeafPileGenerator implements IWorldGenerator
{
    private final WorldGenerator leafPileGen;

    public LeafPileGenerator(int var1)
    {
        this.leafPileGen = new WorldGenLeafPile(var1);
    }

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        BiomeGenBase var7 = var4.getBiomeGenForCoords(var2, var2);

        if (BiomeManager.greenswamp.isPresent() && var7 == BiomeManager.greenswamp.get() || BiomeManager.mountainridge.isPresent() && var7 == BiomeManager.mountainridge.get() || BiomeManager.redwoodlush.isPresent() && var7 == BiomeManager.redwoodlush.get() || BiomeManager.woodlands.isPresent() && var7 == BiomeManager.woodlands.get())
        {
            for (int var8 = 0; var8 < 2; ++var8)
            {
                int var9 = var2 + var1.nextInt(16) + 8;
                int var10 = var1.nextInt(128);
                int var11 = var3 + var1.nextInt(16) + 8;
                this.leafPileGen.generate(var4, var1, var9, var10, var11);
            }
        }
    }
}
