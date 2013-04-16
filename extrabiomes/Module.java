package extrabiomes;

import com.google.common.base.Optional;
import extrabiomes.Module$1;
import extrabiomes.helpers.LogHelper;
import extrabiomes.lib.ModuleControlSettings;
import extrabiomes.module.amica.Amica;
import extrabiomes.module.cautia.Cautia;
import extrabiomes.module.fabrica.Fabrica;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.EventBus;

enum Module
{
    CAUTIA(Cautia.class),
    FABRICA(Fabrica.class),
    AMICA(Amica.class);
    private static final String MODULE_STATUS_DISABLED = "module.status.disabled";
    private static final String MODULE_STATUS_ENABLED = "module.status.enabled";
    private static Optional eventBus = Optional.of(new EventBus());
    private boolean enabled = false;
    private final Class pluginClass;

    public static boolean postEvent(Event var0)
    {
        return eventBus.isPresent() ? ((EventBus)eventBus.get()).post(var0) : false;
    }

    static void registerModules() throws InstantiationException, IllegalAccessException {
        Module[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2)
        {
            Module var3 = var0[var2];

            switch (Module$1.$SwitchMap$extrabiomes$Module[var3.ordinal()])
            {
                case 1:
                    var3.enabled = ModuleControlSettings.CAUTIA.isEnabled();
                    break;

                case 2:
                    var3.enabled = ModuleControlSettings.FABRICA.isEnabled();
                    break;

                case 3:
                    var3.enabled = ModuleControlSettings.AMICA.isEnabled();
            }

            LogHelper.info(Extrabiomes.proxy.getStringLocalization(var3.enabled ? "module.status.enabled" : "module.status.disabled"), new Object[] {var3.toString()});

            if (var3.enabled && eventBus.isPresent())
            {
                ((EventBus)eventBus.get()).register(var3.pluginClass.newInstance());
            }
        }
    }

    public static void releaseStaticResources()
    {
        eventBus = Optional.absent();
    }

    private Module(Class var3)
    {
        this.pluginClass = var3;
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }
}
