package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeShrubland extends ExtrabiomeGenBase
{
    public BiomeShrubland()
    {
        super(BiomeSettings.SHRUBLAND.getID());
        this.setColor(5354877);
        this.setBiomeName("Shrubland");
        this.temperature = 0.4F;
        this.rainfall = 0.6F;
        this.minHeight = 0.1F;
        this.maxHeight = 0.3F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.SHRUBLAND).build();
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
