package extrabiomes.lib;

import extrabiomes.Extrabiomes;
import extrabiomes.lib.BlockSettings$1;
import extrabiomes.utility.EnhancedConfiguration;
import net.minecraftforge.common.Property;

public enum BlockSettings
{
    AUTUMNLEAVES(2200),
    CATTAIL(2201),
    CRACKEDSAND(255),
    FLOWER(2202),
    GRASS(2203),
    GREENLEAVES(2204),
    LEAFPILE(2205),
    REDROCK(254),
    SAPLING(2207),
    CUSTOMLOG(2208),
    QUARTERLOG0(2209),
    QUARTERLOG1(2211),
    QUARTERLOG2(2212),
    QUARTERLOG3(2213),
    QUICKSAND(2214),
    PLANKS(2215),
    WOODSLAB(2216),
    DOUBLEWOODSLAB(2217),
    REDWOODSTAIRS(2218),
    FIRSTAIRS(2219),
    ACACIASTAIRS(2220),
    REDROCKSLAB(2206),
    DOUBLEREDROCKSLAB(2222),
    REDCOBBLESTAIRS(2223),
    REDROCKBRICKSTAIRS(2221),
    WALL(2210);
    private int blockID;
    private final int defaultID;
    private static boolean clearedQuarterLogs = false;
    static boolean clearedWoodSlabs = false;

    private BlockSettings(int var3)
    {
        this.defaultID = var3;
        this.blockID = this.defaultID;
    }

    public int getID()
    {
        return this.blockID;
    }

    private String idKey()
    {
        return this.toString() + ".id";
    }

    private boolean isQuarterLog()
    {
        return this == QUARTERLOG0 || this == QUARTERLOG1 || this == QUARTERLOG2 || this == QUARTERLOG3;
    }

    public void load(EnhancedConfiguration var1)
    {
        Property var2;

        switch (BlockSettings$1.$SwitchMap$extrabiomes$lib$BlockSettings[this.ordinal()])
        {
            case 1:
            case 2:
                var2 = var1.getTerrainBlock("block", this.idKey(), this.defaultID, String.format(Extrabiomes.proxy.getStringLocalization("config.block.terraingen.comment"), new Object[] {this.toString()}));
                break;

            default:
                var2 = var1.getBlock(this.idKey(), this.defaultID);
        }

        this.blockID = var2.getInt(0);
        BlockSettings[] var3;
        BlockSettings[] var4;
        int var5;
        int var6;
        BlockSettings var7;

        if (this.isQuarterLog() && this.blockID == 0 && !clearedQuarterLogs)
        {
            var3 = new BlockSettings[] {QUARTERLOG0, QUARTERLOG1, QUARTERLOG2, QUARTERLOG3};
            var4 = var3;
            var5 = var3.length;

            for (var6 = 0; var6 < var5; ++var6)
            {
                var7 = var4[var6];
                var7.setToZero(var1);
            }

            clearedQuarterLogs = true;
        }

        if (this == PLANKS && this.blockID == 0)
        {
            var3 = new BlockSettings[] {WOODSLAB, DOUBLEWOODSLAB, FIRSTAIRS, REDWOODSTAIRS, ACACIASTAIRS};
            var4 = var3;
            var5 = var3.length;

            for (var6 = 0; var6 < var5; ++var6)
            {
                var7 = var4[var6];
                var7.setToZero(var1);
            }
        }

        if (this == REDROCK && this.blockID == 0)
        {
            var3 = new BlockSettings[] {REDROCKSLAB, WALL};
            var4 = var3;
            var5 = var3.length;

            for (var6 = 0; var6 < var5; ++var6)
            {
                var7 = var4[var6];
                var7.setToZero(var1);
            }
        }

        if ((this == WOODSLAB || this == DOUBLEWOODSLAB) && this.blockID == 0 && !clearedWoodSlabs)
        {
            var3 = new BlockSettings[] {WOODSLAB, DOUBLEWOODSLAB};
            var4 = var3;
            var5 = var3.length;

            for (var6 = 0; var6 < var5; ++var6)
            {
                var7 = var4[var6];
                var7.setToZero(var1);
            }

            clearedWoodSlabs = true;
        }

        if ((this == REDROCKSLAB || this == DOUBLEREDROCKSLAB) && this.blockID == 0 && !clearedWoodSlabs)
        {
            var3 = new BlockSettings[] {REDROCKSLAB, DOUBLEREDROCKSLAB};
            var4 = var3;
            var5 = var3.length;

            for (var6 = 0; var6 < var5; ++var6)
            {
                var7 = var4[var6];
                var7.setToZero(var1);
            }

            clearedWoodSlabs = true;
        }
    }

    private void setToZero(EnhancedConfiguration var1)
    {
        Property var2 = var1.getBlock(this.idKey(), 0);
        var2.value = Integer.toString(0);
        this.blockID = 0;
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }
}
