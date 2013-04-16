package extrabiomes.module.summa.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomePineForest extends ExtrabiomeGenBase
{
    public BiomePineForest()
    {
        super(BiomeSettings.PINEFOREST.getID());
        this.setColor(4627582);
        this.setBiomeName("Pine Forest");
        this.temperature = BiomeGenBase.forest.temperature;
        this.rainfall = BiomeGenBase.forest.rainfall;
        this.minHeight = 0.1F;
        this.maxHeight = 0.3F;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.PINEFOREST).build();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        return ColorizerFoliage.getFoliageColor(0.4000000059604645D, 0.6000000238418579D);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        return ColorizerGrass.getGrassColor(0.4000000059604645D, 0.6000000238418579D);
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
