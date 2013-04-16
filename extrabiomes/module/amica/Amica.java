package extrabiomes.module.amica;

import extrabiomes.api.Api;
import extrabiomes.events.ModuleEvent$ModuleInitEvent;
import extrabiomes.module.amica.buildcraft.BuildcraftPlugin;
import extrabiomes.module.amica.forestry.ForestryPlugin;
import extrabiomes.module.amica.ic2.IC2Plugin;
import extrabiomes.module.amica.thermalexpansion.ThermalExpansionPlugin;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class Amica
{
    public static final String LOG_MESSAGE_PLUGIN_ERROR = "log.message.plugin.error";
    public static final String LOG_MESSAGE_PLUGIN_INIT = "log.message.plugin.init";

    @ForgeSubscribe(
            priority = EventPriority.LOWEST
    )
    public void init(ModuleEvent$ModuleInitEvent var1) throws InstantiationException, IllegalAccessException
    {
        Api.registerPlugin(new BuildcraftPlugin());
        Api.registerPlugin(new ForestryPlugin());
        Api.registerPlugin(new IC2Plugin());
        Api.registerPlugin(new ThermalExpansionPlugin());
    }
}
