package extrabiomes.module.summa.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGreenHills extends ExtrabiomeGenBase
{
    public BiomeGreenHills()
    {
        super(BiomeSettings.GREENHILLS.getID());
        this.setColor(6866036);
        this.setBiomeName("Green Hills");
        this.temperature = BiomeGenBase.forest.temperature - 0.1F;
        this.rainfall = BiomeGenBase.forest.rainfall + 0.1F;
        this.minHeight = 0.6F;
        this.maxHeight = 1.2F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.GREENHILLS).build();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        return ColorizerFoliage.getFoliageColor(0.699999988079071D, 0.800000011920929D);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        return ColorizerGrass.getGrassColor(0.699999988079071D, 0.800000011920929D);
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
