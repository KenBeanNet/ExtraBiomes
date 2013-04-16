package extrabiomes.module.summa.worldgen;

import extrabiomes.module.summa.worldgen.WorldGenLegendOak$Acuteness;
import extrabiomes.module.summa.worldgen.WorldGenLegendOak$BendDirection;

class WorldGenLegendOak$1
{
    static final int[] $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection;

    static final int[] $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$Acuteness = new int[WorldGenLegendOak$Acuteness.values().length];

    static
    {
        try
        {
            $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$Acuteness[WorldGenLegendOak$Acuteness.LOOSE.ordinal()] = 1;
        }
        catch (NoSuchFieldError var6)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$Acuteness[WorldGenLegendOak$Acuteness.TIGHTER.ordinal()] = 2;
        }
        catch (NoSuchFieldError var5)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$Acuteness[WorldGenLegendOak$Acuteness.TIGHT.ordinal()] = 3;
        }
        catch (NoSuchFieldError var4)
        {
            ;
        }

        $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection = new int[WorldGenLegendOak$BendDirection.values().length];

        try
        {
            $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[WorldGenLegendOak$BendDirection.STRAIGHT.ordinal()] = 1;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[WorldGenLegendOak$BendDirection.RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            $SwitchMap$extrabiomes$module$summa$worldgen$WorldGenLegendOak$BendDirection[WorldGenLegendOak$BendDirection.LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
