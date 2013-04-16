package extrabiomes.api;

import com.google.common.base.Optional;
import net.minecraftforge.event.EventBus;

public class Api
{
    private static final EventBus eventBus = new EventBus();
    protected static Optional pluginBus = Optional.of(new EventBus());

    public static EventBus getExtrabiomesXLEventBus()
    {
        return eventBus;
    }

    @Deprecated
    public static boolean isActive()
    {
        return isExtrabiomesXLActive();
    }

    public static boolean isExtrabiomesXLActive()
    {
        return BiomeManager.isActive();
    }

    public static void registerPlugin(Object var0)
    {
        if (pluginBus.isPresent())
        {
            ((EventBus)pluginBus.get()).register(var0);
        }
    }
}
