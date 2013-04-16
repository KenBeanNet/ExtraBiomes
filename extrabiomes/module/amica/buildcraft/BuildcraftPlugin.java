package extrabiomes.module.amica.buildcraft;

import com.google.common.base.Optional;
import extrabiomes.Extrabiomes;
import extrabiomes.api.PluginEvent$Init;
import extrabiomes.api.PluginEvent$Post;
import extrabiomes.api.PluginEvent$Pre;
import extrabiomes.helpers.LogHelper;
import net.minecraftforge.event.ForgeSubscribe;

public class BuildcraftPlugin
{
    private static final String MOD_NAME = "Buildcraft";
    private Optional api = Optional.absent();

    private void addOilSpawns()
    {
        if (((BuildcraftAPI)this.api.get()).modifyWorld() && this.api.isPresent())
        {
            Extrabiomes.proxy.registerWorldGenerator(new OilGenerator((BuildcraftAPI)this.api.get()));
        }
    }

    @ForgeSubscribe
    public void init(PluginEvent$Init var1)
    {
        if (this.api.isPresent())
        {
            this.addOilSpawns();
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
        if (Extrabiomes.proxy.isModLoaded("BuildCraft|Energy"))
        {
            LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.init"), new Object[] {"Buildcraft"});

            try
            {
                this.api = Optional.of(new BuildcraftAPI());
            }
            catch (Exception var3)
            {
                var3.printStackTrace();
                LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.error"), new Object[] {"Buildcraft"});
                this.api = Optional.absent();
            }
        }
    }
}
