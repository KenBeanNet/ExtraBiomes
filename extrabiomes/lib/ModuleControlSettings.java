package extrabiomes.lib;

import extrabiomes.Extrabiomes;
import extrabiomes.utility.EnhancedConfiguration;
import net.minecraftforge.common.Property;

public enum ModuleControlSettings
{
    SUMMA,
    CAUTIA,
    FABRICA,
    AMICA;
    private static final String CATEGORY_MODULE_CONTROL = "module_control";
    private boolean enabled;

    private String commentLangKey()
    {
        return "config." + this.toString() + ".comment";
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    private String keyEnabled()
    {
        return this.toString() + ".enabled";
    }

    public void load(EnhancedConfiguration var1)
    {
        Property var2 = var1.get("module_control", this.keyEnabled(), true, Extrabiomes.proxy.getStringLocalization(this.commentLangKey()));
        this.enabled = var2.getBoolean(false);
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }
}
