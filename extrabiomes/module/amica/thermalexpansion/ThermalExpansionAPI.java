package extrabiomes.module.amica.thermalexpansion;

import com.google.common.base.Optional;
import java.lang.reflect.Method;
import net.minecraft.item.ItemStack;

class ThermalExpansionAPI
{
    private Optional craftingHelpers = Optional.absent();
    private Optional addSawmillLogToPlankRecipe = Optional.absent();

    ThermalExpansionAPI()
    {
        try
        {
            Class var1 = Class.forName("thermalexpansion.api.crafting.CraftingHelpers");
            this.addSawmillLogToPlankRecipe = Optional.fromNullable(var1.getMethod("addSawmillLogToPlankRecipe", new Class[] {ItemStack.class, ItemStack.class}));
            this.craftingHelpers = Optional.of(var1.newInstance());
        }
        catch (Exception var2)
        {
            var2.printStackTrace();
            this.craftingHelpers = Optional.absent();
            this.addSawmillLogToPlankRecipe = Optional.absent();
        }
    }

    public void addSawmillLogToPlankRecipe(ItemStack var1, ItemStack var2)
    {
        if (this.craftingHelpers.isPresent() && this.addSawmillLogToPlankRecipe.isPresent())
        {
            try
            {
                ((Method)this.addSawmillLogToPlankRecipe.get()).invoke(this.craftingHelpers.get(), new Object[] {var1, var2});
            }
            catch (IllegalStateException var4)
            {
                ;
            }
            catch (Exception var5)
            {
                var5.printStackTrace();
            }
        }
    }
}
