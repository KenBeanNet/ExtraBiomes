package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeMountainRidge extends ExtrabiomeGenBase
{
    public BiomeMountainRidge()
    {
        super(BiomeSettings.MOUNTAINRIDGE.getID());
        this.setColor(12874287);
        this.setBiomeName("Mountain Ridge");
        this.temperature = BiomeGenBase.desert.temperature;
        this.rainfall = BiomeGenBase.desert.rainfall;
        this.minHeight = 1.7F;
        this.maxHeight = 1.7F;
        this.setDisableRain();
        this.spawnableCreatureList.clear();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.MOUNTAINRIDGE).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        return super.getRandomWorldGenForTrees(var1);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random var1)
    {
        return super.getRandomWorldGenForGrass(var1);
    }
}
