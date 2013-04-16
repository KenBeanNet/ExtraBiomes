package extrabiomes.proxy;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy
{
    public void addBiome(Collection var1, BiomeGenBase var2)
    {
        Iterator var3 = var1.iterator();

        while (var3.hasNext())
        {
            WorldType var4 = (WorldType)var3.next();
            var4.addNewBiome(var2);
        }
    }

    public void addGrassPlant(Block var1, int var2, int var3)
    {
        MinecraftForge.addGrassPlant(var1, var2, var3);
    }

    public void addName(Object var1, String var2)
    {
        LanguageRegistry.addName(var1, var2);
    }

    public void addRecipe(IRecipe var1)
    {
        CraftingManager.getInstance().getRecipeList().add(var1);
    }

    public void addSmelting(int var1, int var2, ItemStack var3, float var4)
    {
        FurnaceRecipes.smelting().addSmelting(var1, var2, var3, var4);
    }

    public void addSmelting(ItemStack var1, ItemStack var2, float var3)
    {
        this.addSmelting(var1.itemID, var1.getItemDamage(), var2, var3);
    }

    public void addStringLocalization(String var1, String var2, String var3)
    {
        LanguageRegistry.instance().addStringLocalization(var1, var2, var3);
    }

    public int findGlobalUniqueEntityId()
    {
        return EntityRegistry.findGlobalUniqueEntityId();
    }

    public Logger getFMLLogger()
    {
        return FMLLog.getLogger();
    }

    public Optional getGrassSeed(World var1)
    {
        return Optional.fromNullable(ForgeHooks.getGrassSeed(var1));
    }

    public ArrayList getOres(String var1)
    {
        return OreDictionary.getOres(var1);
    }

    public String getStringLocalization(String var1)
    {
        return LanguageRegistry.instance().getStringLocalization(var1);
    }

    public boolean isModLoaded(String var1)
    {
        return Loader.isModLoaded(var1);
    }

    public void loadLocalization(String var1, String var2)
    {
        LanguageRegistry.instance().loadLocalization(var1, var2, true);
    }

    public boolean postEventToBus(Event var1)
    {
        return MinecraftForge.EVENT_BUS.post(var1);
    }

    public void registerBlock(Block var1)
    {
        GameRegistry.registerBlock(var1);
    }

    public void registerBlock(Block var1, Class var2)
    {
        GameRegistry.registerBlock(var1, var2);
    }

    public int registerBlockHandler(ISimpleBlockRenderingHandler var1)
    {
        return 0;
    }

    public void registerEntity(Class var1, String var2, Object var3, int var4, int var5, int var6, boolean var7)
    {
        EntityRegistry.registerModEntity(var1, var2, var4, var3, var5, var6, var7);
    }

    public void registerEntityID(Class var1, String var2, int var3)
    {
        EntityRegistry.registerGlobalEntityID(var1, var2, var3);
    }

    public void registerEventHandler(Object var1)
    {
        MinecraftForge.EVENT_BUS.register(var1);
    }

    public void registerFuelHandler(IFuelHandler var1)
    {
        GameRegistry.registerFuelHandler((IFuelHandler)Preconditions.checkNotNull(var1));
    }

    public void registerOre(int var1, Block var2)
    {
        OreDictionary.registerOre(var1, new ItemStack(var2));
    }

    public void registerOre(int var1, Item var2)
    {
        OreDictionary.registerOre(var1, new ItemStack(var2));
    }

    public void registerOre(int var1, ItemStack var2)
    {
        OreDictionary.registerOre(var1, var2);
    }

    public void registerOre(String var1, Block var2)
    {
        OreDictionary.registerOre(var1, new ItemStack(var2));
    }

    public void registerOre(String var1, Item var2)
    {
        OreDictionary.registerOre(var1, new ItemStack(var2));
    }

    public void registerOre(String var1, ItemStack var2)
    {
        OreDictionary.registerOre(var1, var2);
    }

    public void registerOreInAllSubblocks(String var1, Block var2)
    {
        OreDictionary.registerOre(var1, new ItemStack(var2, 1, -1));
    }

    public void registerRenderInformation() {}

    public void registerWorldGenerator(IWorldGenerator var1)
    {
        GameRegistry.registerWorldGenerator(var1);
    }

    public void removeBiome(BiomeGenBase var1)
    {
        WorldType.DEFAULT.removeBiome((BiomeGenBase)Preconditions.checkNotNull(var1));
        WorldType.LARGE_BIOMES.removeBiome(var1);
    }

    public void setBlockHarvestLevel(Block var1, String var2, int var3)
    {
        MinecraftForge.setBlockHarvestLevel(var1, var2, var3);
    }

    public void setBurnProperties(int var1, int var2, int var3)
    {
        Block.setBurnProperties(var1, var2, var3);
    }
}
