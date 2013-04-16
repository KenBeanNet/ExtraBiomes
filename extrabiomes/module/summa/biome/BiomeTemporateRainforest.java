package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeTemporateRainforest extends ExtrabiomeGenBase
{
    public BiomeTemporateRainforest()
    {
        this(BiomeSettings.TEMPORATERAINFOREST.getID());
    }

    BiomeTemporateRainforest(int var1)
    {
        super(var1);
        this.setColor(3375669);
        this.setBiomeName("Temperate Rainforest");
        this.temperature = 0.6F;
        this.rainfall = 0.9F;
        this.minHeight = 0.4F;
        this.maxHeight = 1.5F;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.TEMPORATERAINFOREST).build();
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
