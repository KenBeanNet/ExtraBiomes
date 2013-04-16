package extrabiomes.module.amica.ic2;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import extrabiomes.Extrabiomes;
import extrabiomes.api.PluginEvent$Init;
import extrabiomes.api.PluginEvent$Post;
import extrabiomes.api.PluginEvent$Pre;
import extrabiomes.helpers.LogHelper;
import extrabiomes.lib.BiomeSettings;
import java.util.Collection;
import java.util.Iterator;
import net.minecraftforge.event.ForgeSubscribe;

public class IC2Plugin
{
    private static final String MOD_ID = "IC2";
    private static final String MOD_NAME = "IndustrialCraft 2";
    private Optional api = Optional.absent();

    private void addBiomeBonus(Collection var1, int var2, int var3)
    {
        Iterator var4 = var1.iterator();

        while (var4.hasNext())
        {
            Optional var5 = (Optional)var4.next();
            this.addBiomeBonus(var5, var2, var3);
        }
    }

    private void addBiomeBonus(Optional var1, int var2, int var3)
    {
        ((IC2API)this.api.get()).addBiomeBonus(var1, var2, var3);
    }

    private void addBiomeBonuses()
    {
        this.addBiomeBonus(BiomeSettings.GREENSWAMP.getBiome(), 2, 2);
        this.addBiomeBonus((Collection)Lists.newArrayList(new Optional[] {BiomeSettings.AUTUMNWOODS.getBiome(), BiomeSettings.BIRCHFOREST.getBiome(), BiomeSettings.FORESTEDHILLS.getBiome(), BiomeSettings.FORESTEDISLAND.getBiome(), BiomeSettings.PINEFOREST.getBiome(), BiomeSettings.RAINFOREST.getBiome(), BiomeSettings.REDWOODFOREST.getBiome(), BiomeSettings.REDWOODLUSH.getBiome(), BiomeSettings.TEMPORATERAINFOREST.getBiome(), BiomeSettings.WOODLANDS.getBiome()}), 1, 1);
        this.addBiomeBonus((Collection)Lists.newArrayList(new Optional[] {BiomeSettings.EXTREMEJUNGLE.getBiome(), BiomeSettings.MINIJUNGLE.getBiome()}), 1, 2);
        this.addBiomeBonus((Collection)Lists.newArrayList(new Optional[] {BiomeSettings.MOUNTAINDESERT.getBiome(), BiomeSettings.MOUNTAINRIDGE.getBiome(), BiomeSettings.WASTELAND.getBiome()}), 0, 0);
    }

    @ForgeSubscribe
    public void init(PluginEvent$Init var1)
    {
        if (this.api.isPresent())
        {
            this.addBiomeBonuses();
        }
    }

    @ForgeSubscribe
    public void postInit(PluginEvent$Post var1)
    {
        this.api = Optional.absent();
    }

    @ForgeSubscribe
    public void preInit(PluginEvent$Pre var1)
    {
        if (Extrabiomes.proxy.isModLoaded("IC2"))
        {
            LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.init"), new Object[] {"IndustrialCraft 2"});

            try
            {
                this.api = Optional.of(new IC2API());
            }
            catch (Exception var3)
            {
                var3.printStackTrace();
                LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.error"), new Object[] {"IndustrialCraft 2"});
                this.api = Optional.absent();
            }
        }
    }
}
