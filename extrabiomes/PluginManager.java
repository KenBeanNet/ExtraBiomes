package extrabiomes;

import com.google.common.base.Optional;
import extrabiomes.api.Api;
import extrabiomes.api.PluginEvent$Init;
import extrabiomes.api.PluginEvent$Post;
import extrabiomes.api.PluginEvent$Pre;
import net.minecraftforge.event.EventBus;

class PluginManager extends Api
{
    static void activatePlugins()
    {
        ((EventBus)Api.pluginBus.get()).post(new PluginEvent$Pre());
        ((EventBus)Api.pluginBus.get()).post(new PluginEvent$Init());
        ((EventBus)Api.pluginBus.get()).post(new PluginEvent$Post());
        Api.pluginBus = Optional.absent();
    }
}
