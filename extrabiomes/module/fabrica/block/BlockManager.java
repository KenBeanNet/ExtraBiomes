package extrabiomes.module.fabrica.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.item.ItemStack;

import com.google.common.base.Optional;

import extrabiomes.Extrabiomes;
import extrabiomes.api.Stuff;
import extrabiomes.events.BlockActiveEvent$AcaciaStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$FirStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$PlankActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedCobbleStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedRockBrickStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedRockSlabActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedwoodStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$WallActiveEvent;
import extrabiomes.events.BlockActiveEvent$WoodSlabActiveEvent;
import extrabiomes.lib.BlockSettings;
import extrabiomes.lib.Element;
import extrabiomes.module.amica.buildcraft.FacadeHelper;
import extrabiomes.proxy.CommonProxy;
import extrabiomes.utility.MultiItemBlock;

public enum BlockManager
{
    PLANKS {
    	protected void create()
        {
            Stuff.planks = Optional.of(new BlockCustomWood(this.getSettings().getID()));
        }

        protected BlockSettings getSettings()
        {
            return BlockSettings.PLANKS;
        }

        protected void prepare()
        {
            CommonProxy var1 = Extrabiomes.proxy;
            Block var2 = (Block)Stuff.planks.get();
            var2.setBlockName("extrabiomes.planks");
            var1.setBlockHarvestLevel(var2, "axe", 0);
            var1.registerBlock(var2, MultiItemBlock.class);
            BlockCustomWood$BlockType[] var3 = BlockCustomWood$BlockType.values();
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5)
            {
                BlockCustomWood$BlockType var6 = var3[var5];
                FacadeHelper.addBuildcraftFacade(var2.blockID, var6.metadata());
            }

            var1.registerOre("plankWood", new ItemStack(var2, 1, -1));
            Extrabiomes.postInitEvent(new BlockActiveEvent$PlankActiveEvent(var2));
        }
	},
    WOODSLAB {
		protected void create()
	    {
	        Stuff.slabWood = Optional.of(new BlockCustomWoodSlab(this.getSettings().getID(), false));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.WOODSLAB;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.slabWood.get();
	        var2.setBlockName("extrabiomes.woodslab");
	        var1.setBlockHarvestLevel(var2, "axe", 0);
	        var1.registerFuelHandler(new FuelHandlerWoodSlabs(var2.blockID));
	        Extrabiomes.postInitEvent(new BlockActiveEvent$WoodSlabActiveEvent(var2));
	    }
	},
    DOUBLEWOODSLAB {
		protected void create()
	    {
	        Stuff.slabWoodDouble = Optional.of(new BlockCustomWoodSlab(this.getSettings().getID(), true));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.DOUBLEWOODSLAB;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.slabWoodDouble.get();
	        var2.setBlockName("extrabiomes.woodslab");
	        var1.setBlockHarvestLevel(var2, "axe", 0);
	        ItemWoodSlab.setSlabs((BlockHalfSlab)Stuff.slabWood.get(), (BlockHalfSlab)Stuff.slabWoodDouble.get());
	        var1.registerBlock((Block)Stuff.slabWood.get(), ItemWoodSlab.class);
	        var1.registerBlock(var2, ItemWoodSlab.class);
	        var1.registerOre("slabWood", new ItemStack((Block)Stuff.slabWood.get(), 1, -1));
	        new ItemStack((Block)Stuff.slabWood.get(), 1, BlockCustomWoodSlab$BlockType.FIR.metadata());
	        new ItemStack((Block)Stuff.slabWood.get(), 1, BlockCustomWoodSlab$BlockType.REDWOOD.metadata());
	        new ItemStack((Block)Stuff.slabWood.get(), 1, BlockCustomWoodSlab$BlockType.ACACIA.metadata());
	    }
	},
    REDWOODSTAIRS {
		protected void create()
	    {
	        Stuff.stairsRedwood = Optional.of(new BlockWoodStairs(this.getSettings().getID(), (Block)Stuff.planks.get(), BlockCustomWood$BlockType.REDWOOD.metadata()));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.REDWOODSTAIRS;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.stairsRedwood.get();
	        var2.setBlockName("extrabiomes.stairs.redwood");
	        var1.setBlockHarvestLevel(var2, "axe", 0);
	        var1.registerBlock(var2);
	        var1.registerOre("stairWood", var2);
	        Extrabiomes.postInitEvent(new BlockActiveEvent$RedwoodStairsActiveEvent(var2));
	    }
	},
    FIRSTAIRS {
		protected void create()
	    {
	        Stuff.stairsFir = Optional.of(new BlockWoodStairs(this.getSettings().getID(), (Block)Stuff.planks.get(), BlockCustomWood$BlockType.FIR.metadata()));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.FIRSTAIRS;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.stairsFir.get();
	        var2.setBlockName("extrabiomes.stairs.fir");
	        var1.setBlockHarvestLevel(var2, "axe", 0);
	        var1.registerBlock(var2);
	        var1.registerOre("stairWood", var2);
	        Extrabiomes.postInitEvent(new BlockActiveEvent$FirStairsActiveEvent(var2));
	    }
	},
    ACACIASTAIRS {
		protected void create()
	    {
	        Stuff.stairsAcacia = Optional.of(new BlockWoodStairs(this.getSettings().getID(), (Block)Stuff.planks.get(), BlockCustomWood$BlockType.ACACIA.metadata()));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.ACACIASTAIRS;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.stairsAcacia.get();
	        var2.setBlockName("extrabiomes.stairs.acacia");
	        var1.setBlockHarvestLevel(var2, "axe", 0);
	        var1.registerBlock(var2);
	        var1.registerOre("stairWood", var2);
	        Extrabiomes.postInitEvent(new BlockActiveEvent$AcaciaStairsActiveEvent(var2));
	    }
	},
    REDROCKSLAB {
		protected void create()
	    {
	        Stuff.slabRedRock = Optional.of(new BlockRedRockSlab(this.getSettings().getID(), false));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.REDROCKSLAB;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.slabRedRock.get();
	        var2.setBlockName("extrabiomes.redrockslab");
	        var1.setBlockHarvestLevel(var2, "pickaxe", 0);
	        Extrabiomes.postInitEvent(new BlockActiveEvent$RedRockSlabActiveEvent(var2));
	    }
	},
    DOUBLEREDROCKSLAB {
		protected void create()
	    {
	        Stuff.slabRedRockDouble = Optional.of(new BlockRedRockSlab(this.getSettings().getID(), true));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.DOUBLEREDROCKSLAB;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.slabRedRockDouble.get();
	        var2.setBlockName("extrabiomes.redrockslab");
	        var1.setBlockHarvestLevel(var2, "pickaxe", 0);
	        ItemRedRockSlab.setSlabs((BlockHalfSlab)Stuff.slabRedRock.get(), (BlockHalfSlab)Stuff.slabRedRockDouble.get());
	        var1.registerBlock((Block)Stuff.slabRedRock.get(), ItemRedRockSlab.class);
	        var1.registerBlock(var2, ItemRedRockSlab.class);
	    }
	},
    REDCOBBLESTAIRS {
		protected void create()
	    {
	        Stuff.stairsRedCobble = Optional.of(new BlockCustomStairs(this.getSettings().getID(), Block.blocksList[Element.RED_COBBLE.get().itemID], Element.RED_COBBLE.get().getItemDamage()));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.REDCOBBLESTAIRS;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.stairsRedCobble.get();
	        var2.setBlockName("extrabiomes.stairs.redcobble");
	        var1.setBlockHarvestLevel(var2, "pickaxe", 0);
	        var1.registerBlock(var2);
	        Extrabiomes.postInitEvent(new BlockActiveEvent$RedCobbleStairsActiveEvent(var2));
	    }
	},
    REDROCKBRICKSTAIRS {
		protected void create()
	    {
	        Stuff.stairsRedRockBrick = Optional.of(new BlockCustomStairs(this.getSettings().getID(), Block.blocksList[Element.RED_ROCK_BRICK.get().itemID], Element.RED_ROCK_BRICK.get().getItemDamage()));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.REDROCKBRICKSTAIRS;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.stairsRedRockBrick.get();
	        var2.setBlockName("extrabiomes.stairs.redrockbrick");
	        var1.setBlockHarvestLevel(var2, "pickaxe", 0);
	        var1.registerBlock(var2);
	        Extrabiomes.postInitEvent(new BlockActiveEvent$RedRockBrickStairsActiveEvent(var2));
	    }
	},
    WALL {
		protected void create()
	    {
	        Stuff.wall = Optional.of(new BlockCustomWall(this.getSettings().getID()));
	    }

	    protected BlockSettings getSettings()
	    {
	        return BlockSettings.WALL;
	    }

	    protected void prepare()
	    {
	        CommonProxy var1 = Extrabiomes.proxy;
	        Block var2 = (Block)Stuff.wall.get();
	        var2.setBlockName("extrabiomes.wall");
	        var1.setBlockHarvestLevel(var2, "pickaxe", 0);
	        var1.registerBlock(var2, MultiItemBlock.class);
	        Extrabiomes.postInitEvent(new BlockActiveEvent$WallActiveEvent(var2));
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
