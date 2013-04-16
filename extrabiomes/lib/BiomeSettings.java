package extrabiomes.lib;

import com.google.common.base.Optional;
import extrabiomes.module.summa.biome.BiomeAlpine;
import extrabiomes.module.summa.biome.BiomeAutumnWoods;
import extrabiomes.module.summa.biome.BiomeBirchForest;
import extrabiomes.module.summa.biome.BiomeExtremeJungle;
import extrabiomes.module.summa.biome.BiomeForestedHills;
import extrabiomes.module.summa.biome.BiomeForestedIsland;
import extrabiomes.module.summa.biome.BiomeGlacier;
import extrabiomes.module.summa.biome.BiomeGreenHills;
import extrabiomes.module.summa.biome.BiomeGreenSwamp;
import extrabiomes.module.summa.biome.BiomeIceWasteland;
import extrabiomes.module.summa.biome.BiomeMarsh;
import extrabiomes.module.summa.biome.BiomeMeadow;
import extrabiomes.module.summa.biome.BiomeMiniJungle;
import extrabiomes.module.summa.biome.BiomeMountainDesert;
import extrabiomes.module.summa.biome.BiomeMountainRidge;
import extrabiomes.module.summa.biome.BiomeMountainTaiga;
import extrabiomes.module.summa.biome.BiomePineForest;
import extrabiomes.module.summa.biome.BiomeRainforest;
import extrabiomes.module.summa.biome.BiomeRedwoodForest;
import extrabiomes.module.summa.biome.BiomeRedwoodLush;
import extrabiomes.module.summa.biome.BiomeSavanna;
import extrabiomes.module.summa.biome.BiomeShrubland;
import extrabiomes.module.summa.biome.BiomeSnowForest;
import extrabiomes.module.summa.biome.BiomeSnowRainforest;
import extrabiomes.module.summa.biome.BiomeTemporateRainforest;
import extrabiomes.module.summa.biome.BiomeTundra;
import extrabiomes.module.summa.biome.BiomeWasteland;
import extrabiomes.module.summa.biome.BiomeWoodlands;
import extrabiomes.utility.EnhancedConfiguration;
import net.minecraftforge.common.Property;

public enum BiomeSettings
{
    DESERT,
    EXTREMEHILLS,
    FOREST,
    JUNGLE,
    PLAINS,
    SWAMPLAND,
    TAIGA,
    ALPINE(32, BiomeAlpine.class),
    AUTUMNWOODS(33, BiomeAutumnWoods.class),
    BIRCHFOREST(34, BiomeBirchForest.class),
    EXTREMEJUNGLE(35, BiomeExtremeJungle.class),
    FORESTEDHILLS(36, BiomeForestedHills.class),
    FORESTEDISLAND(37, BiomeForestedIsland.class),
    GLACIER(38, BiomeGlacier.class),
    GREENHILLS(39, BiomeGreenHills.class),
    GREENSWAMP(40, BiomeGreenSwamp.class),
    ICEWASTELAND(41, BiomeIceWasteland.class),
    MARSH(42, BiomeMarsh.class),
    MEADOW(43, BiomeMeadow.class),
    MINIJUNGLE(44, BiomeMiniJungle.class),
    MOUNTAINDESERT(45, BiomeMountainDesert.class),
    MOUNTAINRIDGE(46, BiomeMountainRidge.class),
    MOUNTAINTAIGA(47, BiomeMountainTaiga.class),
    PINEFOREST(48, BiomePineForest.class),
    RAINFOREST(49, BiomeRainforest.class),
    REDWOODFOREST(50, BiomeRedwoodForest.class),
    REDWOODLUSH(51, BiomeRedwoodLush.class),
    SAVANNA(52, BiomeSavanna.class),
    SHRUBLAND(53, BiomeShrubland.class),
    SNOWYFOREST(54, BiomeSnowForest.class),
    SNOWYRAINFOREST(55, BiomeSnowRainforest.class),
    TEMPORATERAINFOREST(56, BiomeTemporateRainforest.class),
    TUNDRA(57, BiomeTundra.class),
    WASTELAND(58, BiomeWasteland.class),
    WOODLANDS(59, BiomeWoodlands.class);
    private final int defaultID;
    private int biomeID;
    private boolean enabled;
    private boolean allowVillages;
    private final Optional biomeClass;
    private Optional biome;

    private BiomeSettings()
    {
        this(0, (Class)null);
    }

    private BiomeSettings(int var3, Class var4)
    {
        this.biomeID = 0;
        this.enabled = true;
        this.allowVillages = true;
        this.biome = Optional.absent();
        this.defaultID = var3;
        this.biomeID = this.defaultID;
        this.biomeClass = Optional.fromNullable(var4);
    }

    public boolean allowVillages()
    {
        return this.allowVillages;
    }

    public void createBiome() throws Exception {
        if (this.biomeClass.isPresent() && !this.biome.isPresent())
        {
            this.biome = Optional.of(((Class)this.biomeClass.get()).newInstance());
        }
    }

    public Optional getBiome()
    {
        return this.biome;
    }

    public int getID()
    {
        return this.biomeID;
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    public boolean isVanilla()
    {
        return !this.biomeClass.isPresent();
    }

    private String keyAllowVillages()
    {
        return this.keyVanillaPrefix() + this.toString() + ".allowvillages";
    }

    private String keyEnabled()
    {
        return this.keyVanillaPrefix() + this.toString() + ".enablegeneration";
    }

    private String keyID()
    {
        return this.toString() + ".id";
    }

    private String keyVanillaPrefix()
    {
        return this.isVanilla() ? "vanilla." : "";
    }

    public void load(EnhancedConfiguration var1)
    {
        Property var2;

        if (!this.isVanilla())
        {
            var2 = var1.getBiome(this.keyID(), this.defaultID);
            this.biomeID = var2.getInt(0);
        }

        var2 = var1.get("biome", this.keyEnabled(), true);

        if (!this.isVanilla() && this.biomeID == 0)
        {
            var2.value = Boolean.toString(false);
        }

        this.enabled = var2.getBoolean(false);
        var2 = var1.get("biome", this.keyAllowVillages(), true);

        if (!this.isVanilla() && this.biomeID == 0)
        {
            var2.value = Boolean.toString(false);
        }

        this.allowVillages = var2.getBoolean(false);
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }
}
