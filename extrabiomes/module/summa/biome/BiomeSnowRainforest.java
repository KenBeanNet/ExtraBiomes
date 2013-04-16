package extrabiomes.module.summa.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSnowRainforest extends BiomeTemporateRainforest
{
    public BiomeSnowRainforest()
    {
        super(BiomeSettings.SNOWYRAINFOREST.getID());
        this.setColor(3375735);
        this.setBiomeName("Snowy Rainforest");
        this.temperature = BiomeGenBase.taigaHills.temperature;
        this.rainfall = 1.3F;
        this.minHeight = 0.4F;
        this.maxHeight = 1.5F;
        this.setEnableSnow();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.SNOWYRAINFOREST).build();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        return ColorizerFoliage.getFoliageColor(0.0D, 0.10000000149011612D);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        return ColorizerGrass.getGrassColor(0.0D, 0.10000000149011612D);
    }
}
