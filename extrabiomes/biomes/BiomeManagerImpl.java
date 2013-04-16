package extrabiomes.biomes;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import extrabiomes.api.BiomeManager;
import extrabiomes.api.BiomeManager$GenType;
import extrabiomes.biomes.BiomeManagerImpl$1;
import extrabiomes.biomes.BiomeManagerImpl$2;
import extrabiomes.biomes.BiomeManagerImpl$3;
import extrabiomes.biomes.BiomeManagerImpl$4;
import extrabiomes.helpers.BiomeHelper;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.module.summa.biome.WeightedRandomChooser;
import extrabiomes.module.summa.biome.WeightedWorldGenerator;
import extrabiomes.module.summa.worldgen.WorldGenAcacia;
import extrabiomes.module.summa.worldgen.WorldGenAutumnTree;
import extrabiomes.module.summa.worldgen.WorldGenAutumnTree$AutumnTreeType;
import extrabiomes.module.summa.worldgen.WorldGenBigAutumnTree;
import extrabiomes.module.summa.worldgen.WorldGenCustomSwamp;
import extrabiomes.module.summa.worldgen.WorldGenFirTree;
import extrabiomes.module.summa.worldgen.WorldGenFirTreeHuge;
import extrabiomes.module.summa.worldgen.WorldGenRedwood;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeManagerImpl extends BiomeManager
{
    private static final WorldGenerator ACACIA_TREE_GEN = new WorldGenAcacia(false);
    private static final WorldGenerator ALT_TAIGA_GEN = new WorldGenTaiga2(false);
    private static final WorldGenerator BIG_FIR_TREE_GEN = new WorldGenFirTreeHuge(false);
    private static final WorldGenerator BIG_OAK_TREE_GEN = new WorldGenBigTree(false);
    private static final WorldGenerator BIRCH_TREE_GEN = new WorldGenForest(false);
    private static final WorldGenerator CUSTOM_SWAMP_TREE_GEN = new WorldGenCustomSwamp();
    private static final WorldGenerator FERN_GEN = new WorldGenTallGrass(Block.tallGrass.blockID, 2);
    private static final WorldGenerator FIR_TREE_GEN = new WorldGenFirTree(false);
    private static final WorldGenerator GRASS_GEN = new WorldGenTallGrass(Block.tallGrass.blockID, 1);
    private static final WorldGenerator OAK_TREE_GEN = new WorldGenTrees(false);
    private static final WorldGenerator REDWOOD_TREE_GEN = new WorldGenRedwood(false);
    private static final WorldGenerator SHRUB_GEN = new WorldGenShrub(3, 0);
    private static final WorldGenerator SWAMP_TREE_GEN = new WorldGenSwamp();
    private static final WorldGenerator TAIGA_GEN = new WorldGenTaiga1();
    private static final Collection disableDefaultGrassBiomes = new ArrayList();
    private static final Map weightedChoices = new EnumMap(BiomeManager$GenType.class);

    private static void addAlpineTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), FIR_TREE_GEN, 100);
        }
    }

    private static void addAutumnTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.BROWN), 90);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenBigAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.BROWN), 10);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.ORANGE), 90);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenBigAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.ORANGE), 10);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.PURPLE), 90);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenBigAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.PURPLE), 10);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.YELLOW), 90);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new WorldGenBigAutumnTree(false, WorldGenAutumnTree$AutumnTreeType.YELLOW), 10);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), OAK_TREE_GEN, 90);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIG_OAK_TREE_GEN, 10);
        }
    }

    private static void addBirchForestTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), OAK_TREE_GEN, 99);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIG_OAK_TREE_GEN, 1);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIRCH_TREE_GEN, 9900);
        }
    }

    private static void addDefaultTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), OAK_TREE_GEN, 90);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIG_OAK_TREE_GEN, 10);
        }
    }

    private static void addExtremeJungleTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIG_OAK_TREE_GEN, 2);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), SHRUB_GEN, 9);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new BiomeManagerImpl$1(), 3);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new BiomeManagerImpl$2(), 6);
        }
    }

    private static void addGrass(Optional var0)
    {
        if (var0.isPresent())
        {
            if (!disableDefaultGrassBiomes.contains(var0.get()))
            {
                addWeightedGrassGenForBiome((BiomeGenBase)var0.get(), GRASS_GEN, 100);
            }
        }
    }

    private static void addGrassandFerns(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedGrassGenForBiome((BiomeGenBase)var0.get(), FERN_GEN, 25);
            addWeightedGrassGenForBiome((BiomeGenBase)var0.get(), GRASS_GEN, 75);
        }
    }

    private static void addGreenSwampTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), SWAMP_TREE_GEN, 20);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), CUSTOM_SWAMP_TREE_GEN, 80);
        }
    }

    private static void addMiniJungleTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), SWAMP_TREE_GEN, 100);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), OAK_TREE_GEN, 1);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIG_OAK_TREE_GEN, 99);
        }
    }

    private static void addRainforestTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIRCH_TREE_GEN, 2);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIG_OAK_TREE_GEN, 49999);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), OAK_TREE_GEN, 149997);
        }
    }

    private static void addRedwoodForestTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), REDWOOD_TREE_GEN, 100);
        }
    }

    private static void addRedwoodLushTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), REDWOOD_TREE_GEN, 50);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), FIR_TREE_GEN, 50);
        }
    }

    private static void addSavannaTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), ACACIA_TREE_GEN, 100);
        }
    }

    private static void addShrublandTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new BiomeManagerImpl$3(), 200);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), new BiomeManagerImpl$4(), 100);
        }
    }

    private static void addTaigaTrees(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), TAIGA_GEN, 50);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), ALT_TAIGA_GEN, 100);
        }
    }

    private static void addTemporateRainforest(Optional var0)
    {
        if (var0.isPresent())
        {
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), BIG_FIR_TREE_GEN, 200);
            addWeightedTreeGenForBiome((BiomeGenBase)var0.get(), FIR_TREE_GEN, 100);
        }
    }

    private static void buildWeightedBiomeGrassList()
    {
        addGrass(alpine);
        addGrass(autumnwoods);
        addGrass(birchforest);
        addGrassandFerns(extremejungle);
        addGrass(forestedhills);
        addGrass(forestedisland);
        addGrass(glacier);
        addGrass(greenhills);
        addGrass(greenswamp);
        addGrass(icewasteland);
        addGrass(marsh);
        addGrass(meadow);
        addGrassandFerns(minijungle);
        addGrass(mountaindesert);
        addGrass(mountainridge);
        addGrass(mountaintaiga);
        addGrass(pineforest);
        addGrassandFerns(rainforest);
        addGrassandFerns(redwoodforest);
        addGrassandFerns(redwoodlush);
        addGrass(savanna);
        addGrass(shrubland);
        addGrass(snowforest);
        addGrass(snowyrainforest);
        addGrassandFerns(temperaterainforest);
        addGrass(tundra);
        addGrass(wasteland);
        addGrass(woodlands);
    }

    private static void buildWeightedBiomeTreeList()
    {
        addAlpineTrees(alpine);
        addAutumnTrees(autumnwoods);
        addBirchForestTrees(birchforest);
        addExtremeJungleTrees(extremejungle);
        addDefaultTrees(forestedhills);
        addDefaultTrees(forestedisland);
        addDefaultTrees(glacier);
        addDefaultTrees(greenhills);
        addGreenSwampTrees(greenswamp);
        addDefaultTrees(icewasteland);
        addDefaultTrees(marsh);
        addDefaultTrees(meadow);
        addMiniJungleTrees(minijungle);
        addDefaultTrees(mountaindesert);
        addDefaultTrees(mountainridge);
        addTaigaTrees(mountaintaiga);
        addTaigaTrees(pineforest);
        addRainforestTrees(rainforest);
        addRedwoodForestTrees(redwoodforest);
        addRedwoodLushTrees(redwoodlush);
        addSavannaTrees(savanna);
        addShrublandTrees(shrubland);
        addDefaultTrees(snowforest);
        addTemporateRainforest(snowyrainforest);
        addTemporateRainforest(temperaterainforest);
        addDefaultTrees(tundra);
        addDefaultTrees(wasteland);
        addDefaultTrees(woodlands);
    }

    public static void disableDefaultGrassforBiomes(Collection var0)
    {
        disableDefaultGrassBiomes.addAll(var0);
    }

    public static void populateAPIBiomes()
    {
        alpine = BiomeSettings.ALPINE.getBiome();
        autumnwoods = BiomeSettings.AUTUMNWOODS.getBiome();
        birchforest = BiomeSettings.BIRCHFOREST.getBiome();
        extremejungle = BiomeSettings.EXTREMEJUNGLE.getBiome();
        forestedhills = BiomeSettings.FORESTEDHILLS.getBiome();
        forestedisland = BiomeSettings.FORESTEDISLAND.getBiome();
        glacier = BiomeSettings.GLACIER.getBiome();
        greenhills = BiomeSettings.GREENHILLS.getBiome();
        greenswamp = BiomeSettings.GREENSWAMP.getBiome();
        icewasteland = BiomeSettings.ICEWASTELAND.getBiome();
        marsh = BiomeSettings.MARSH.getBiome();
        meadow = BiomeSettings.MEADOW.getBiome();
        minijungle = BiomeSettings.MINIJUNGLE.getBiome();
        mountaindesert = BiomeSettings.MOUNTAINDESERT.getBiome();
        mountainridge = BiomeSettings.MOUNTAINRIDGE.getBiome();
        mountaintaiga = BiomeSettings.MOUNTAINTAIGA.getBiome();
        pineforest = BiomeSettings.PINEFOREST.getBiome();
        rainforest = BiomeSettings.RAINFOREST.getBiome();
        redwoodforest = BiomeSettings.REDWOODFOREST.getBiome();
        redwoodlush = BiomeSettings.REDWOODLUSH.getBiome();
        savanna = BiomeSettings.SAVANNA.getBiome();
        shrubland = BiomeSettings.SHRUBLAND.getBiome();
        snowforest = BiomeSettings.SNOWYFOREST.getBiome();
        snowyrainforest = BiomeSettings.SNOWYRAINFOREST.getBiome();
        temperaterainforest = BiomeSettings.TEMPORATERAINFOREST.getBiome();
        tundra = BiomeSettings.TUNDRA.getBiome();
        wasteland = BiomeSettings.WASTELAND.getBiome();
        woodlands = BiomeSettings.WOODLANDS.getBiome();
    }

    public BiomeManagerImpl()
    {
        ArrayListMultimap var1 = ArrayListMultimap.create();
        weightedChoices.put(BiomeManager$GenType.TREE, var1);
        ArrayListMultimap var2 = ArrayListMultimap.create();
        weightedChoices.put(BiomeManager$GenType.GRASS, var2);
        instance = Optional.of(this);
    }

    protected void addBiomeGen(BiomeManager$GenType var1, BiomeGenBase var2, WorldGenerator var3, int var4)
    {
        Multimap var5 = (Multimap)weightedChoices.get(var1);
        var5.put(var2, new WeightedWorldGenerator(var3, var4));
    }

    public static void buildWeightedFloraLists()
    {
        buildWeightedBiomeTreeList();
        buildWeightedBiomeGrassList();
    }

    protected Optional chooseBiomeRandomGen(BiomeManager$GenType var1, Random var2, BiomeGenBase var3)
    {
        Optional var4 = Optional.fromNullable(weightedChoices.get(var1));

        if (var4.isPresent())
        {
            Collection var5 = ((Multimap)var4.get()).get(var3);
            Optional var6 = WeightedRandomChooser.getRandomItem(var2, var5);

            if (var6.isPresent())
            {
                return Optional.of(((WeightedWorldGenerator)var6.get()).getWorldGen());
            }
        }

        return Optional.absent();
    }

    protected Collection getBiomeCollection()
    {
        return ImmutableSet.copyOf(BiomeHelper.getActiveBiomes());
    }

    protected int getBiomeTotalWeight(BiomeManager$GenType var1, BiomeGenBase var2)
    {
        return WeightedRandomChooser.getTotalWeight(((Multimap)weightedChoices.get(var1)).get(var2));
    }
}
