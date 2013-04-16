package extrabiomes.helpers;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import extrabiomes.Extrabiomes;
import extrabiomes.api.Api;
import extrabiomes.api.DiscoverWorldTypesEvent;
import extrabiomes.helpers.BiomeHelper$1;
import extrabiomes.lib.BiomeSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeManager;

public abstract class BiomeHelper
{
    private static final Set worldTypes = new HashSet();
    private static Optional activeBiomes = Optional.absent();

    public static void addTerrainBlockstoBiome(BiomeSettings var0, int var1, int var2)
    {
        if (var0.getBiome().isPresent())
        {
            BiomeGenBase var3 = (BiomeGenBase)var0.getBiome().get();
            var3.topBlock = (byte)var1;
            var3.fillerBlock = (byte)var2;
        }
    }

    public static void createBiome(BiomeSettings var0) throws Exception
    {
        if (BiomeGenBase.biomeList[var0.getID()] != null)
        {
            throw new IllegalArgumentException(String.format("Biome id %d is already in use by %s when adding %s. Please review the configuration file.", new Object[] {Integer.valueOf(var0.getID()), BiomeGenBase.biomeList[var0.getID()].biomeName, var0.toString()}));
        }
        else
        {
            var0.createBiome();
        }
    }

    public static Set discoverWorldTypes()
    {
        if (worldTypes.isEmpty())
        {
            worldTypes.add(WorldType.DEFAULT);
            worldTypes.add(WorldType.LARGE_BIOMES);
            DiscoverWorldTypesEvent var0 = new DiscoverWorldTypesEvent(worldTypes);
            Api.getExtrabiomesXLEventBus().post(var0);
        }

        return ImmutableSet.copyOf(worldTypes);
    }

    public static void enableBiome(Set var0, BiomeGenBase var1)
    {
        Extrabiomes.proxy.addBiome(var0, var1);
        BiomeManager.addSpawnBiome(var1);
        BiomeManager.addStrongholdBiome(var1);
    }

    public static Collection getActiveBiomes()
    {
        if (!activeBiomes.isPresent())
        {
            activeBiomes = Optional.of(new ArrayList(BiomeSettings.values().length));
            BiomeSettings[] var0 = BiomeSettings.values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                BiomeSettings var3 = var0[var2];

                if (var3.getBiome().isPresent() && !var3.isVanilla())
                {
                    ((ArrayList)activeBiomes.get()).add(var3.getBiome().get());
                }
            }

            ((ArrayList)activeBiomes.get()).trimToSize();
        }

        return ImmutableSet.copyOf((Collection)activeBiomes.get());
    }

    public static BiomeGenBase settingToBiomeGenBase(BiomeSettings var0)
    {
        switch (BiomeHelper$1.$SwitchMap$extrabiomes$lib$BiomeSettings[var0.ordinal()])
        {
            case 1:
                return BiomeGenBase.desert;

            case 2:
                return BiomeGenBase.extremeHills;

            case 3:
                return BiomeGenBase.forest;

            case 4:
                return BiomeGenBase.jungle;

            case 5:
                return BiomeGenBase.swampland;

            case 6:
                return BiomeGenBase.taiga;

            case 7:
                return BiomeGenBase.plains;

            default:
                return (BiomeGenBase)var0.getBiome().get();
        }
    }

    public static void addWeightedGrassGen(Optional var0, WorldGenerator var1, int var2)
    {
        if (var0.isPresent())
        {
            extrabiomes.api.BiomeManager.addWeightedGrassGenForBiome((BiomeGenBase)var0.get(), var1, var2);
        }
    }
}
