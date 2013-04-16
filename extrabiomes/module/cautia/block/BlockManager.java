package extrabiomes.module.cautia.block;

import net.minecraft.block.Block;

import com.google.common.base.Optional;

import extrabiomes.Extrabiomes;
import extrabiomes.api.Stuff;
import extrabiomes.lib.BlockSettings;
import extrabiomes.module.amica.buildcraft.FacadeHelper;
import extrabiomes.module.cautia.worldgen.QuicksandGenerator;
import extrabiomes.proxy.CommonProxy;

public enum BlockManager
{
    QUICKSAND {
    	protected void create()
        {
            Stuff.quickSand = Optional.of(new BlockQuicksand(this.getSettings().getID()));
        }

        protected BlockSettings getSettings()
        {
            return BlockSettings.QUICKSAND;
        }

        protected void prepare()
        {
            CommonProxy var1 = Extrabiomes.proxy;
            Block var2 = (Block)Stuff.quickSand.get();
            var2.setBlockName("extrabiomes.quicksand");
            var1.setBlockHarvestLevel(var2, "shovel", 0);
            var1.registerBlock(var2);
            FacadeHelper.addBuildcraftFacade(var2.blockID);
            var1.registerWorldGenerator(new QuicksandGenerator(var2.blockID));
        }
	};
    private boolean blockCreated;

    private BlockManager()
    {
        this.blockCreated = false;
    }

    private static void createBlocks() throws Exception {
        BlockManager[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2)
        {
            BlockManager var3 = var0[var2];

            if (var3.getSettings().getID() > 0)
            {
                try
                {
                    var3.create();
                }
                catch (Exception var5)
                {
                    throw var5;
                }

                var3.blockCreated = true;
            }
        }
    }

    public static void init() throws InstantiationException, IllegalAccessException {
        BlockManager[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2)
        {
            BlockManager var3 = var0[var2];

            if (var3.blockCreated)
            {
                var3.prepare();
            }
        }
    }

    public static void preInit() throws Exception {
        createBlocks();
    }

    protected abstract void create();

    protected abstract BlockSettings getSettings();

    protected abstract void prepare();
}
