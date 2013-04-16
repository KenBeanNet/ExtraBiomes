package extrabiomes.handlers;

import com.google.common.base.Optional;
import extrabiomes.helpers.LogHelper;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.BlockSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.lib.ItemSettings;
import extrabiomes.lib.ModuleControlSettings;
import extrabiomes.utility.EnhancedConfiguration;
import java.io.File;
import java.util.logging.Level;

public abstract class ConfigurationHandler
{
    public static void init(File var0)
    {
        Optional var1 = Optional.absent();

        try
        {
            var1 = Optional.of(new EnhancedConfiguration(var0));
            EnhancedConfiguration var2 = (EnhancedConfiguration)var1.get();
            BiomeSettings[] var3 = BiomeSettings.values();
            int var4 = var3.length;
            int var5;

            for (var5 = 0; var5 < var4; ++var5)
            {
                BiomeSettings var6 = var3[var5];
                var6.load(var2);
            }

            DecorationSettings[] var12 = DecorationSettings.values();
            var4 = var12.length;

            for (var5 = 0; var5 < var4; ++var5)
            {
                DecorationSettings var17 = var12[var5];
                var17.load(var2);
            }

            BlockSettings[] var13 = BlockSettings.values();
            var4 = var13.length;

            for (var5 = 0; var5 < var4; ++var5)
            {
                BlockSettings var16 = var13[var5];
                var16.load(var2);
            }

            ItemSettings[] var14 = ItemSettings.values();
            var4 = var14.length;

            for (var5 = 0; var5 < var4; ++var5)
            {
                ItemSettings var19 = var14[var5];
                var19.load(var2);
            }

            ModuleControlSettings[] var15 = ModuleControlSettings.values();
            var4 = var15.length;

            for (var5 = 0; var5 < var4; ++var5)
            {
                ModuleControlSettings var18 = var15[var5];
                var18.load(var2);
            }
        }
        catch (Exception var10)
        {
            LogHelper.log(Level.SEVERE, var10, "%s had had a problem loading its configuration", new Object[] {"ExtrabiomesXL"});
        }
        finally
        {
            if (var1.isPresent())
            {
                ((EnhancedConfiguration)var1.get()).save();
            }
        }
    }
}
