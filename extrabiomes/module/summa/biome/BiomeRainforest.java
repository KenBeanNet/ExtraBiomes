package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeRainforest extends ExtrabiomeGenBase
{
    public BiomeRainforest()
    {
        super(BiomeSettings.RAINFOREST.getID());
        this.setColor(775718);
        this.setBiomeName("Rainforest");
        this.temperature = 1.1F;
        this.rainfall = 1.4F;
        this.minHeight = 0.4F;
        this.maxHeight = 1.3F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.RAINFOREST).build();
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
