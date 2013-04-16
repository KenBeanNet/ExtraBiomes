package extrabiomes.lib;

class BlockSettings$1
{
    static final int[] $SwitchMap$extrabiomes$lib$BlockSettings = new int[BlockSettings.values().length];

    static
    {
        try
        {
            $SwitchMap$extrabiomes$lib$BlockSettings[BlockSettings.CRACKEDSAND.ordinal()] = 1;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$lib$BlockSettings[BlockSettings.REDROCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
