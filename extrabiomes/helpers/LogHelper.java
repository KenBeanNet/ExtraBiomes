package extrabiomes.helpers;

import com.google.common.base.Optional;
import extrabiomes.Extrabiomes;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum LogHelper
{
    INSTANCE;
    private Optional logger = Optional.absent();

    public static void fine(String var0, Object ... var1)
    {
        INSTANCE.log(Level.FINE, var0, var1);
    }

    public static void finer(String var0, Object ... var1)
    {
        INSTANCE.log(Level.FINER, var0, var1);
    }

    public static void finest(String var0, Object ... var1)
    {
        INSTANCE.log(Level.FINEST, var0, var1);
    }

    public static void info(String var0, Object ... var1)
    {
        INSTANCE.log(Level.INFO, var0, var1);
    }

    public static void log(Level var0, Throwable var1, String var2, Object ... var3)
    {
        INSTANCE.getLogger().log(var0, String.format(var2, var3), var1);
    }

    public static void severe(String var0, Object ... var1)
    {
        INSTANCE.log(Level.SEVERE, var0, var1);
    }

    public static void warning(String var0, Object ... var1)
    {
        INSTANCE.log(Level.WARNING, var0, var1);
    }

    private Logger getLogger()
    {
        if (!this.logger.isPresent())
        {
            this.init();
        }

        return (Logger)this.logger.get();
    }

    private void init()
    {
        if (!this.logger.isPresent())
        {
            this.logger = Optional.of(Logger.getLogger("ExtrabiomesXL"));
            ((Logger)this.logger.get()).setParent(Extrabiomes.proxy.getFMLLogger());
        }
    }

    private void log(Level var1, String var2, Object ... var3)
    {
        this.getLogger().log(var1, String.format(var2, var3));
    }
}
