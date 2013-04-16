package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeWasteland extends ExtrabiomeGenBase
{
    public BiomeWasteland()
    {
        super(BiomeSettings.WASTELAND.getID());
        this.setColor(10386497);
        this.setBiomeName("Wasteland");
        this.temperature = BiomeGenBase.desert.temperature;
        this.rainfall = BiomeGenBase.desert.rainfall;
        this.minHeight = 0.0F;
        this.maxHeight = 0.0F;
        this.waterColorMultiplier = 15761408;
        this.spawnableCreatureList.clear();
        this.setDisableRain();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.WASTELAND).build();
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
