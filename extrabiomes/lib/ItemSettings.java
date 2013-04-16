package extrabiomes.lib;

import extrabiomes.utility.EnhancedConfiguration;

public enum ItemSettings
{
    LOGTURNER(12870),
    PASTE(12872);
    private final int defaultID;
    private int itemID;

    private ItemSettings(int var3)
    {
        this.defaultID = var3;
        this.itemID = this.defaultID;
    }

    public int getID()
    {
        return this.itemID;
    }

    public void load(EnhancedConfiguration var1)
    {
        this.itemID = var1.getItem(this.toString() + ".id", this.defaultID).getInt(0);
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }
}
