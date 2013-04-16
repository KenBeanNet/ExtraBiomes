package extrabiomes.helpers;

import extrabiomes.lib.BiomeSettings;

class BiomeHelper$1
{
    static final int[] $SwitchMap$extrabiomes$lib$BiomeSettings = new int[BiomeSettings.values().length];

    static
    {
        try
        {
            $SwitchMap$extrabiomes$lib$BiomeSettings[BiomeSettings.DESERT.ordinal()] = 1;
        }
        catch (NoSuchFieldError var7)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$lib$BiomeSettings[BiomeSettings.EXTREMEHILLS.ordinal()] = 2;
        }
        catch (NoSuchFieldError var6)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$lib$BiomeSettings[BiomeSettings.FOREST.ordinal()] = 3;
        }
        catch (NoSuchFieldError var5)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$lib$BiomeSettings[BiomeSettings.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError var4)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$lib$BiomeSettings[BiomeSettings.SWAMPLAND.ordinal()] = 5;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$lib$BiomeSettings[BiomeSettings.TAIGA.ordinal()] = 6;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$lib$BiomeSettings[BiomeSettings.PLAINS.ordinal()] = 7;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
