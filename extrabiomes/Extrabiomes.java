package extrabiomes;

import com.google.common.base.Optional;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import extrabiomes.biomes.BiomeManagerImpl;
import extrabiomes.events.ModuleEvent$ModuleInitEvent;
import extrabiomes.events.ModulePreInitEvent;
import extrabiomes.handlers.BiomeHandler;
import extrabiomes.handlers.BlockHandler;
import extrabiomes.handlers.ConfigurationHandler;
import extrabiomes.handlers.ItemHandler;
import extrabiomes.handlers.RecipeHandler;
import extrabiomes.helpers.LogHelper;
import extrabiomes.localization.LocalizationHandler;
import extrabiomes.module.fabrica.recipe.RecipeManager;
import extrabiomes.proxy.CommonProxy;
import extrabiomes.utility.CreativeTab;
import java.io.File;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.EventBus;

@Mod(
        modid = "ExtrabiomesXL",
        name = "ExtrabiomesXL",
        version = "3.11.0"
)
@NetworkMod(
        clientSideRequired = true,
        serverSideRequired = false
)
public class Extrabiomes
{
    @Mod.Instance("ExtrabiomesXL")
    public static Extrabiomes instance;
    @SidedProxy(
            clientSide = "extrabiomes.proxy.ClientProxy",
            serverSide = "extrabiomes.proxy.CommonProxy"
    )
    public static CommonProxy proxy;
    public static final CreativeTabs tabsEBXL = new CreativeTab(CreativeTabs.creativeTabArray.length, "extrabiomesTab");
    private static final String LOG_MESSAGE_INITIALIZING = "log.message.initializing";
    private static final String LOG_MESSAGE_LOAD_SUCCESS = "log.message.load.success";
    private static Optional initBus = Optional.of(new EventBus());

    @Mod.Init
    public static void init(FMLInitializationEvent var0) throws InstantiationException, IllegalAccessException
    {
        proxy.registerRenderInformation();
        Module.postEvent(new ModuleEvent$ModuleInitEvent());
    }

    @Mod.PostInit
    public static void postInit(FMLPostInitializationEvent var0)
    {
        PluginManager.activatePlugins();
        RecipeHandler.init();
        initBus = Optional.absent();
        Module.releaseStaticResources();
        LogHelper.info(proxy.getStringLocalization("log.message.load.success"), new Object[0]);
    }

    public static boolean postInitEvent(Event var0)
    {
        return initBus.isPresent() ? ((EventBus)initBus.get()).post(var0) : false;
    }

    @Mod.PreInit
    public static void preInit(FMLPreInitializationEvent var0) throws Exception
    {
        LogHelper.info(proxy.getStringLocalization("log.message.initializing"), new Object[0]);
        LocalizationHandler.loadLanguages();
        ConfigurationHandler.init(new File(var0.getModConfigurationDirectory(), "/extrabiomes/extrabiomes.cfg"));
        BiomeHandler.init();
        BiomeManagerImpl.populateAPIBiomes();
        new BiomeManagerImpl();
        registerInitEventHandler(new RecipeManager());
        BlockHandler.createBlocks();
        ItemHandler.createItems();
        BiomeHandler.registerWorldGenerators();
        BiomeHandler.enableBiomes();
        BiomeManagerImpl.buildWeightedFloraLists();
        Module.registerModules();
        Module.postEvent(new ModulePreInitEvent());
        proxy.addStringLocalization("itemGroup.extrabiomesTab", "en_US", "ExtrabiomesXL");
    }

    public static void registerInitEventHandler(Object var0)
    {
        if (initBus.isPresent())
        {
            ((EventBus)initBus.get()).register(var0);
        }
    }
}
