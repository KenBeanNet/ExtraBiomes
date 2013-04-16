package extrabiomes.module.summa.biome;

import com.google.common.base.Optional;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

abstract class ExtrabiomeGenBase extends BiomeGenBase
{
    protected ExtrabiomeGenBase(int var1)
    {
        super(var1);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random var1)
    {
        Optional var2 = BiomeManager.chooseRandomGrassGenforBiome(var1, this);
        return var2.isPresent() ? (WorldGenerator)var2.get() : super.getRandomWorldGenForGrass(var1);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        Optional var2 = BiomeManager.chooseRandomTreeGenforBiome(var1, this);
        return var2.isPresent() ? (WorldGenerator)var2.get() : super.getRandomWorldGenForTrees(var1);
    }
}
