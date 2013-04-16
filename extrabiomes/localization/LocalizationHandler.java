package extrabiomes.localization;

import extrabiomes.Extrabiomes;

public class LocalizationHandler
{
    public static void loadLanguages()
    {
        Localization[] var0 = Localization.values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2)
        {
            Localization var3 = var0[var2];
            Extrabiomes.proxy.loadLocalization(var3.filename(), var3.locale());
        }
    }
}
