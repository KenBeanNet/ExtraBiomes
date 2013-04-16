package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeMountainDesert extends ExtrabiomeGenBase
{
    public BiomeMountainDesert()
    {
        super(BiomeSettings.MOUNTAINDESERT.getID());
        this.setColor(16421912);
        this.setBiomeName("Mountainous Desert");
        this.temperature = BiomeGenBase.desertHills.temperature;
        this.rainfall = BiomeGenBase.desertHills.rainfall;
        this.minHeight = 0.4F;
        this.maxHeight = 1.4F;
        this.topBlock = (byte)Block.sand.blockID;
        this.fillerBlock = (byte)Block.sand.blockID;
        this.spawnableCreatureList.clear();
        this.setDisableRain();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.MOUNTAINDESERT).build();
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
