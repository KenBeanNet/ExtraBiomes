package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeRedwoodForest extends ExtrabiomeGenBase
{
    public BiomeRedwoodForest()
    {
        super(BiomeSettings.REDWOODFOREST.getID());
        this.setColor(775718);
        this.setBiomeName("Redwood Forest");
        this.temperature = 1.1F;
        this.rainfall = 1.4F;
        this.minHeight = 0.9F;
        this.maxHeight = 1.5F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.REDWOODFOREST).build();
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
