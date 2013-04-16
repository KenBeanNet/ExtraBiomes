package extrabiomes.module.amica.thermalexpansion;

import com.google.common.base.Optional;
import extrabiomes.Extrabiomes;
import extrabiomes.api.PluginEvent$Init;
import extrabiomes.api.PluginEvent$Post;
import extrabiomes.api.PluginEvent$Pre;
import extrabiomes.api.Stuff;
import extrabiomes.helpers.LogHelper;
import extrabiomes.lib.Element;
import extrabiomes.module.fabrica.block.BlockCustomWood$BlockType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;

public class ThermalExpansionPlugin
{
    private static final String MODID = "ThermalExpansion";
    private static final String MOD_NAME = "Thermal Expansion";
    private Optional api = Optional.absent();

    private void addSawmillRecipe(Element var1, Optional var2)
    {
        if (var2.isPresent() && var1.isPresent())
        {
            ((ThermalExpansionAPI)this.api.get()).addSawmillLogToPlankRecipe(var1.get(), (ItemStack)var2.get());
        }
    }

    private void addSawmillRecipes()
    {
        if (this.api.isPresent())
        {
            this.addSawmillRecipe(Element.LOG_ACACIA, Optional.of(new ItemStack((Block)Stuff.planks.get(), 1, BlockCustomWood$BlockType.ACACIA.metadata())));
            Element[] var1 = new Element[] {Element.LOG_FIR, Element.LOG_HUGE_FIR_NE, Element.LOG_HUGE_FIR_NW, Element.LOG_HUGE_FIR_SE, Element.LOG_HUGE_FIR_SW};
            int var2 = var1.length;
            int var3;
            Element var4;

            for (var3 = 0; var3 < var2; ++var3)
            {
                var4 = var1[var3];
                this.addSawmillRecipe(var4, Optional.of(new ItemStack((Block)Stuff.planks.get(), 1, BlockCustomWood$BlockType.FIR.metadata())));
            }

            var1 = new Element[] {Element.LOG_HUGE_REDWOOD_NE, Element.LOG_HUGE_REDWOOD_NW, Element.LOG_HUGE_REDWOOD_SE, Element.LOG_HUGE_REDWOOD_SW};
            var2 = var1.length;

            for (var3 = 0; var3 < var2; ++var3)
            {
                var4 = var1[var3];
                this.addSawmillRecipe(var4, Optional.of(new ItemStack((Block)Stuff.planks.get(), 1, BlockCustomWood$BlockType.REDWOOD.metadata())));
            }

            var1 = new Element[] {Element.LOG_HUGE_OAK_NE, Element.LOG_HUGE_OAK_NW, Element.LOG_HUGE_OAK_SE, Element.LOG_HUGE_OAK_SW};
            var2 = var1.length;

            for (var3 = 0; var3 < var2; ++var3)
            {
                var4 = var1[var3];
                this.addSawmillRecipe(var4, Optional.of(new ItemStack(Block.planks)));
            }
        }
    }

    @ForgeSubscribe
    public void init(PluginEvent$Init var1)
    {
        if (this.api.isPresent())
        {
            this.addSawmillRecipes();
        }
    }

    @ForgeSubscribe
    public void postInit(PluginEvent$Post var1)
    {
        this.api = Optional.absent();
    }

    @ForgeSubscribe
    public void preInit(PluginEvent$Pre var1)
    {
        if (Extrabiomes.proxy.isModLoaded("ThermalExpansion"))
        {
            LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.init"), new Object[] {"Thermal Expansion"});

            try
            {
                this.api = Optional.of(new ThermalExpansionAPI());
            }
            catch (Exception var3)
            {
                var3.printStackTrace();
                LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.error"), new Object[] {"Thermal Expansion"});
                this.api = Optional.absent();
            }
        }
    }
}
