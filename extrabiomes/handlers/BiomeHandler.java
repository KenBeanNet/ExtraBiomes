package extrabiomes.handlers;

import com.google.common.base.Optional;
import extrabiomes.Extrabiomes;
import extrabiomes.api.Api;
import extrabiomes.api.events.GetBiomeIDEvent;
import extrabiomes.helpers.BiomeHelper;
import extrabiomes.helpers.LogHelper;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.module.summa.worldgen.LegendOakGenerator;
import extrabiomes.module.summa.worldgen.MarshGenerator;
import extrabiomes.module.summa.worldgen.MountainDesertGenerator;
import extrabiomes.module.summa.worldgen.MountainRidgeGenerator;
import extrabiomes.module.summa.worldgen.VanillaFloraGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.ForgeSubscribe;

public enum BiomeHandler
{
    INSTANCE;
    private static List biomes = new ArrayList();

    public static void enableBiomes()
    {
        Set var0 = BiomeHelper.discoverWorldTypes();
        BiomeSettings[] var1 = BiomeSettings.values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3)
        {
            BiomeSettings var4 = var1[var3];
            Optional var5 = var4.getBiome();

            if (!var4.isVanilla())
            {
                if (var4.isEnabled() && var5.isPresent())
                {
                    BiomeHelper.enableBiome(var0, (BiomeGenBase)var5.get());
                }
                else
                {
                    LogHelper.fine("Custom biome %s disabled.", new Object[] {var4.toString()});
                }
            }
            else if (!var4.isEnabled())
            {
                Extrabiomes.proxy.removeBiome(BiomeHelper.settingToBiomeGenBase(var4));
                LogHelper.fine("Vanilla biome %s disabled.", new Object[] {var5.toString()});
            }

            if (var4.allowVillages() && var5.isPresent())
            {
                BiomeManager.addVillageBiome((BiomeGenBase)var5.get(), true);
                LogHelper.fine("Village spawning enabled for custom biome %s.", new Object[] {var4.toString()});
            }
        }
    }

    public static void init() throws Exception {
        BiomeSettings[] var0 = BiomeSettings.values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2)
        {
            BiomeSettings var3 = var0[var2];

            if (var3.getID() > 0)
            {
                BiomeHelper.createBiome(var3);
            }
        }

        Api.getExtrabiomesXLEventBus().register(INSTANCE);
    }

    public static void registerWorldGenerators()
    {
        if (BiomeSettings.MARSH.getBiome().isPresent())
        {
            Extrabiomes.proxy.registerWorldGenerator(new MarshGenerator());
        }

        if (BiomeSettings.MOUNTAINDESERT.getBiome().isPresent())
        {
            Extrabiomes.proxy.registerWorldGenerator(new MountainDesertGenerator());
        }

        if (BiomeSettings.MOUNTAINRIDGE.getBiome().isPresent())
        {
            Extrabiomes.proxy.registerWorldGenerator(new MountainRidgeGenerator());
        }

        Extrabiomes.proxy.registerWorldGenerator(new VanillaFloraGenerator());
        Extrabiomes.proxy.registerWorldGenerator(new LegendOakGenerator());
    }

    @ForgeSubscribe
    public void handleBiomeIDRequestsFromAPI(GetBiomeIDEvent var1)
    {
        Optional var2 = Optional.fromNullable(BiomeSettings.valueOf(var1.targetBiome.toUpperCase()));

        if (var2.isPresent())
        {
            var1.biomeID = ((BiomeSettings)var2.get()).getID();
        }
    }
}
