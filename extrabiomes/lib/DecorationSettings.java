package extrabiomes.lib;

import com.google.common.collect.Maps;
import extrabiomes.lib.DecorationSettings$Decoration;
import extrabiomes.utility.EnhancedConfiguration;
import java.util.Map;
import net.minecraftforge.common.Property;

public enum DecorationSettings
{
    ALPINE((Integer)null, Integer.valueOf(7), Integer.valueOf(0), Integer.valueOf(0), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    AUTUMNWOODS((Integer)null, Integer.valueOf(9), (Integer)null, Integer.valueOf(6), (Integer)null, Integer.valueOf(3), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    BIRCHFOREST((Integer)null, Integer.valueOf(7), (Integer)null, Integer.valueOf(1), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    EXTREMEJUNGLE((Integer)null, Integer.valueOf(50), Integer.valueOf(4), Integer.valueOf(25), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    FORESTEDHILLS((Integer)null, Integer.valueOf(7), Integer.valueOf(1), Integer.valueOf(5), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    FORESTEDISLAND((Integer)null, Integer.valueOf(7), (Integer)null, Integer.valueOf(3), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    GLACIER((Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    GREENHILLS((Integer)null, Integer.valueOf(1), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    GREENSWAMP(Integer.valueOf(4), Integer.valueOf(4), Integer.valueOf(0), (Integer)null, Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(10), (Integer)null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), (Integer)null),
    ICEWASTELAND((Integer)null, Integer.valueOf(0), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    MARSH((Integer)null, Integer.valueOf(0), (Integer)null, Integer.valueOf(999), (Integer)null, (Integer)null, Integer.valueOf(10), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    MEADOW((Integer)null, Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(12), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    MINIJUNGLE(Integer.valueOf(12), Integer.valueOf(15), Integer.valueOf(5), (Integer)null, (Integer)null, Integer.valueOf(2), Integer.valueOf(70), (Integer)null, (Integer)null, (Integer)null, Integer.valueOf(3), (Integer)null),
    MOUNTAINDESERT((Integer)null, Integer.valueOf(0), (Integer)null, (Integer)null, Integer.valueOf(2), (Integer)null, Integer.valueOf(50), Integer.valueOf(10), (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    MOUNTAINRIDGE((Integer)null, Integer.valueOf(0), (Integer)null, Integer.valueOf(12), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    MOUNTAINTAIGA((Integer)null, Integer.valueOf(10), (Integer)null, Integer.valueOf(1), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    PINEFOREST((Integer)null, Integer.valueOf(10), (Integer)null, Integer.valueOf(1), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    RAINFOREST((Integer)null, Integer.valueOf(7), Integer.valueOf(2), Integer.valueOf(4), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    REDWOODFOREST((Integer)null, Integer.valueOf(17), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    REDWOODLUSH((Integer)null, Integer.valueOf(17), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    SAVANNA((Integer)null, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(17), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    SHRUBLAND((Integer)null, Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(1), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    SNOWYFOREST((Integer)null, Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(4), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    SNOWYRAINFOREST((Integer)null, Integer.valueOf(17), (Integer)null, Integer.valueOf(16), (Integer)null, Integer.valueOf(2), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    TEMPORATERAINFOREST((Integer)null, Integer.valueOf(17), (Integer)null, Integer.valueOf(16), (Integer)null, Integer.valueOf(2), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    TUNDRA((Integer)null, (Integer)null, Integer.valueOf(-999), Integer.valueOf(-999), (Integer)null, (Integer)null, (Integer)null, (Integer)null, Integer.valueOf(0), Integer.valueOf(0), (Integer)null, (Integer)null),
    WASTELAND((Integer)null, (Integer)null, (Integer)null, Integer.valueOf(1), Integer.valueOf(3), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null),
    WOODLANDS((Integer)null, Integer.valueOf(8), (Integer)null, Integer.valueOf(3), (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null);
    private final Map settings;



    private DecorationSettings(Integer var3, Integer var4, Integer var5, Integer var6, Integer var7, Integer var8, Integer var9, Integer var10, Integer var11, Integer var12, Integer var13, Integer var14)
    {
        this.settings = Maps.newHashMap();
        this.initSetting(DecorationSettings$Decoration.WATERLILY, var3);
        this.initSetting(DecorationSettings$Decoration.TREES, var4);
        this.initSetting(DecorationSettings$Decoration.FLOWERS, var5);
        this.initSetting(DecorationSettings$Decoration.GRASS, var6);
        this.initSetting(DecorationSettings$Decoration.DEADBUSH, var7);
        this.initSetting(DecorationSettings$Decoration.MUSHROOMS, var8);
        this.initSetting(DecorationSettings$Decoration.REEDS, var9);
        this.initSetting(DecorationSettings$Decoration.CACTI, var10);
        this.initSetting(DecorationSettings$Decoration.SAND, var11);
        this.initSetting(DecorationSettings$Decoration.SAND2, var12);
        this.initSetting(DecorationSettings$Decoration.CLAY, var13);
        this.initSetting(DecorationSettings$Decoration.BIGMUSHROOMS, var14);
    }

    private void initSetting(DecorationSettings$Decoration var1, Integer var2)
    {
        if (var2 != null && !var2.equals(Integer.valueOf(var1.def)))
        {
            this.settings.put(var1, var2);
        }
    }

    public void load(EnhancedConfiguration var1)
    {
        this.parseProperty(var1, DecorationSettings$Decoration.WATERLILY);
        this.parseProperty(var1, DecorationSettings$Decoration.TREES);
        this.parseProperty(var1, DecorationSettings$Decoration.FLOWERS);
        this.parseProperty(var1, DecorationSettings$Decoration.GRASS);
        this.parseProperty(var1, DecorationSettings$Decoration.DEADBUSH);
        this.parseProperty(var1, DecorationSettings$Decoration.MUSHROOMS);
        this.parseProperty(var1, DecorationSettings$Decoration.REEDS);
        this.parseProperty(var1, DecorationSettings$Decoration.CACTI);
        this.parseProperty(var1, DecorationSettings$Decoration.SAND);
        this.parseProperty(var1, DecorationSettings$Decoration.SAND2);
        this.parseProperty(var1, DecorationSettings$Decoration.CLAY);
        this.parseProperty(var1, DecorationSettings$Decoration.BIGMUSHROOMS);
    }

    private void parseProperty(EnhancedConfiguration var1, DecorationSettings$Decoration var2)
    {
        if (this.settings.containsKey(var2))
        {
            Property var3 = var1.get("decoration", this.toString() + var2.key, var2.def);
            var3.value = ((Integer)this.settings.get(var2)).toString();
        }
    }

    public int getValue(DecorationSettings$Decoration var1)
    {
        return this.settings.containsKey(var1) ? ((Integer)this.settings.get(var1)).intValue() : var1.def;
    }

    public Map getSettings()
    {
        return this.settings;
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }
}
