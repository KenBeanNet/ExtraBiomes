package extrabiomes.module.amica.forestry;

import com.google.common.base.Optional;
import cpw.mods.fml.common.event.FMLInterModComms;
import extrabiomes.Extrabiomes;
import extrabiomes.api.PluginEvent$Init;
import extrabiomes.api.PluginEvent$Pre;
import extrabiomes.api.Stuff;
import extrabiomes.blocks.BlockCustomSapling;
import extrabiomes.helpers.ForestryModHelper;
import extrabiomes.helpers.LogHelper;
import extrabiomes.lib.Element;
import extrabiomes.module.summa.TreeSoilRegistry;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.liquids.LiquidStack;

public class ForestryPlugin
{
    private Object fermenterManager;
    private Object carpenterManager;
    private static boolean enabled = true;
    private ArrayList arborealCrops;
    private ArrayList plainFlowers;
    private ArrayList leafBlockIds;
    private ArrayList[] backpackItems;
    public static ArrayList loggerWindfall;
    private Optional carpenterAddRecipe = Optional.absent();
    private Optional fermenterAddRecipe = Optional.absent();
    private Optional getForestryItem = Optional.absent();
    private static Optional getForestryBlock = Optional.absent();
    private static final int DIGGER = 1;
    private static final int FORESTER = 2;

    static ItemStack getBlock(String var0)
    {
        try
        {
            return (ItemStack)((Method)getForestryBlock.get()).invoke((Object)null, new Object[] {var0});
        }
        catch (Exception var2)
        {
            return null;
        }
    }

    private void addBackPackItems()
    {
        Collection var1 = ForestryModHelper.getForesterBackPackItems();
        Iterator var2 = var1.iterator();
        ItemStack var3;

        while (var2.hasNext())
        {
            var3 = (ItemStack)var2.next();
            this.backpackItems[2].add(var3);
        }

        var1 = ForestryModHelper.getDiggerBackPackItems();
        var2 = var1.iterator();

        while (var2.hasNext())
        {
            var3 = (ItemStack)var2.next();
            this.backpackItems[1].add(var3);
        }

        if (Stuff.quickSand.isPresent())
        {
            this.backpackItems[1].add(new ItemStack((Block)Stuff.quickSand.get()));
        }
    }

    private void addBasicFlowers()
    {
        Iterator var1 = ForestryModHelper.getBasicFlowers().iterator();

        while (var1.hasNext())
        {
            ItemStack var2 = (ItemStack)var1.next();
            this.plainFlowers.add(var2);
        }
    }

    private void addFermenterRecipeSapling(ItemStack var1) throws Exception
    {
        ((Method)this.fermenterAddRecipe.get()).invoke(this.fermenterManager, new Object[] {var1, Integer.valueOf(800), Float.valueOf(1.0F), this.getLiquidStack("liquidBiomass"), new LiquidStack(Block.waterStill.blockID, 1, 0)});
        ((Method)this.fermenterAddRecipe.get()).invoke(this.fermenterManager, new Object[] {var1, Integer.valueOf(800), Float.valueOf(1.5F), this.getLiquidStack("liquidBiomass"), this.getLiquidStack("liquidJuice")});
        ((Method)this.fermenterAddRecipe.get()).invoke(this.fermenterManager, new Object[] {var1, Integer.valueOf(800), Float.valueOf(1.5F), this.getLiquidStack("liquidBiomass"), this.getLiquidStack("liquidHoney")});
    }

    private void addGlobals()
    {
        Collection var1 = ForestryModHelper.getLeaves();
        Iterator var2 = var1.iterator();

        while (var2.hasNext())
        {
            ItemStack var3 = (ItemStack)var2.next();
            this.leafBlockIds.add(Integer.valueOf(var3.itemID));
        }
    }

    private void addRecipes() throws Exception
    {
        if (this.fermenterAddRecipe.isPresent() && this.getForestryItem.isPresent())
        {
            Iterator var1 = ForestryModHelper.getSaplings().iterator();

            while (var1.hasNext())
            {
                ItemStack var2 = (ItemStack)var1.next();
                this.addFermenterRecipeSapling(var2);
            }
        }

        if (this.carpenterAddRecipe.isPresent() && Element.RED_COBBLE.isPresent())
        {
            ((Method)this.carpenterAddRecipe.get()).invoke(this.carpenterManager, new Object[] {Integer.valueOf(10), new LiquidStack(Block.waterStill.blockID, 3000, 0), null, new ItemStack(Item.clay, 4), new Object[]{"#", '#', Element.RED_COBBLE.get()}});
        }
    }

    private void addSaplings()
    {
        Optional var1 = Optional.fromNullable(getBlock("soil"));

        if (var1.isPresent())
        {
            TreeSoilRegistry.addValidSoil(Block.blocksList[((ItemStack)var1.get()).itemID]);
            BlockCustomSapling.setForestrySoilID(((ItemStack)var1.get()).itemID);
        }

        this.arborealCrops.add(new CropProviderSapling());
        Iterator var2 = ForestryModHelper.getSaplings().iterator();

        while (var2.hasNext())
        {
            ItemStack var3 = (ItemStack)var2.next();
            FMLInterModComms.sendMessage("Forestry", "add-farmable-sapling", String.format("farmArboreal@%s.%s", new Object[] {Integer.valueOf(var3.itemID), Integer.valueOf(var3.getItemDamage())}));
        }
    }

    private LiquidStack getLiquidStack(String var1) throws Exception
    {
        ItemStack var2 = (ItemStack)((Method)this.getForestryItem.get()).invoke((Object)null, new Object[] {var1});
        return new LiquidStack(var2.itemID, 1, var2.getItemDamage());
    }

    @ForgeSubscribe
    public void init(PluginEvent$Init var1) throws Exception
    {
        if (this.isEnabled())
        {
            this.addSaplings();
            this.addBasicFlowers();
            this.addGlobals();
            this.addBackPackItems();
            this.addRecipes();
        }
    }

    private boolean isEnabled()
    {
        return enabled && Extrabiomes.proxy.isModLoaded("Forestry");
    }

    @ForgeSubscribe
    public void preInit(PluginEvent$Pre var1)
    {
        if (this.isEnabled())
        {
            LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.init"), new Object[] {"Forestry"});

            try
            {
                Class var2 = Class.forName("forestry.api.core.ItemInterface");
                this.getForestryItem = Optional.fromNullable(var2.getMethod("getItem", new Class[] {String.class}));
                var2 = Class.forName("forestry.api.core.BlockInterface");
                getForestryBlock = Optional.fromNullable(var2.getMethod("getBlock", new Class[] {String.class}));
                var2 = Class.forName("forestry.api.recipes.RecipeManagers");
                Field var3 = var2.getField("fermenterManager");
                this.fermenterManager = var3.get((Object)null);
                var3 = var2.getField("carpenterManager");
                this.carpenterManager = var3.get((Object)null);
                var2 = Class.forName("forestry.api.core.ForestryAPI");
                var3 = var2.getField("loggerWindfall");
                loggerWindfall = (ArrayList)var3.get((Object)null);
                var2 = Class.forName("forestry.api.cultivation.CropProviders");
                var3 = var2.getField("arborealCrops");
                this.arborealCrops = (ArrayList)var3.get((Object)null);
                var2 = Class.forName("forestry.api.apiculture.FlowerManager");
                var3 = var2.getField("plainFlowers");
                this.plainFlowers = (ArrayList)var3.get((Object)null);
                var2 = Class.forName("forestry.api.core.GlobalManager");
                var3 = var2.getField("leafBlockIds");
                this.leafBlockIds = (ArrayList)var3.get((Object)null);
                var2 = Class.forName("forestry.api.storage.BackpackManager");
                var3 = var2.getField("backpackItems");
                this.backpackItems = (ArrayList[])((ArrayList[])var3.get((Object)null));
                var2 = Class.forName("forestry.api.recipes.IFermenterManager");
                this.fermenterAddRecipe = Optional.fromNullable(var2.getMethod("addRecipe", new Class[] {ItemStack.class, Integer.TYPE, Float.TYPE, LiquidStack.class, LiquidStack.class}));
                var2 = Class.forName("forestry.api.recipes.ICarpenterManager");
                this.carpenterAddRecipe = Optional.fromNullable(var2.getMethod("addRecipe", new Class[] {Integer.TYPE, LiquidStack.class, ItemStack.class, ItemStack.class, Object[].class}));
            }
            catch (Exception var4)
            {
                var4.printStackTrace();
                LogHelper.fine(Extrabiomes.proxy.getStringLocalization("log.message.plugin.error"), new Object[] {"Forestry"});
                enabled = false;
            }
        }
    }
}
