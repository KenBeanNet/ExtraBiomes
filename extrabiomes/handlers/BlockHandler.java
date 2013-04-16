package extrabiomes.handlers;

import extrabiomes.Extrabiomes;
import extrabiomes.blocks.BlockAutumnLeaves;
import extrabiomes.blocks.BlockAutumnLeaves$BlockType;
import extrabiomes.blocks.BlockCatTail;
import extrabiomes.blocks.BlockCustomFlower;
import extrabiomes.blocks.BlockCustomFlower$BlockType;
import extrabiomes.blocks.BlockCustomLog;
import extrabiomes.blocks.BlockCustomLog$BlockType;
import extrabiomes.blocks.BlockCustomSapling;
import extrabiomes.blocks.BlockCustomSapling$BlockType;
import extrabiomes.blocks.BlockCustomTallGrass;
import extrabiomes.blocks.BlockCustomTallGrass$BlockType;
import extrabiomes.blocks.BlockGreenLeaves;
import extrabiomes.blocks.BlockGreenLeaves$BlockType;
import extrabiomes.blocks.BlockLeafPile;
import extrabiomes.blocks.BlockQuarterLog;
import extrabiomes.blocks.BlockQuarterLog$BarkOn;
import extrabiomes.blocks.BlockQuarterLog$BlockType;
import extrabiomes.blocks.BlockRedRock;
import extrabiomes.blocks.BlockRedRock$BlockType;
import extrabiomes.blocks.GenericTerrainBlock;
import extrabiomes.events.BlockActiveEvent$RedRockActiveEvent;
import extrabiomes.helpers.BiomeHelper;
import extrabiomes.helpers.ForestryModHelper;
import extrabiomes.items.ItemCatTail;
import extrabiomes.items.ItemCustomGreenLeaves;
import extrabiomes.items.ItemCustomLeaves;
import extrabiomes.items.ItemFlower;
import extrabiomes.items.ItemGrass;
import extrabiomes.items.ItemRedRock;
import extrabiomes.items.ItemSapling;
import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.BlockSettings;
import extrabiomes.lib.Element;
import extrabiomes.lib.ModuleControlSettings;
import extrabiomes.module.amica.buildcraft.FacadeHelper;
import extrabiomes.module.summa.worldgen.CatTailGenerator;
import extrabiomes.module.summa.worldgen.FlowerGenerator;
import extrabiomes.module.summa.worldgen.LeafPileGenerator;
import extrabiomes.proxy.CommonProxy;
import extrabiomes.renderers.RenderQuarterLog;
import extrabiomes.utility.MultiItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.WorldGenTallGrass;

public abstract class BlockHandler
{
    private static void createAutumnLeaves()
    {
        int var0 = BlockSettings.AUTUMNLEAVES.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockAutumnLeaves var1 = new BlockAutumnLeaves(var0, 3, Material.leaves, false);
            var1.setBlockName("extrabiomes.autumnleaves").setTickRandomly(true).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify().setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.registerBlock(var1, ItemCustomLeaves.class);
            var2.registerOreInAllSubblocks("treeLeaves", var1);
            var2.setBurnProperties(var1.blockID, 30, 60);
            Element.LEAVES_AUTUMN_BROWN.set(new ItemStack(var1, 1, BlockAutumnLeaves$BlockType.BROWN.metadata()));
            Element.LEAVES_AUTUMN_ORANGE.set(new ItemStack(var1, 1, BlockAutumnLeaves$BlockType.ORANGE.metadata()));
            Element.LEAVES_AUTUMN_PURPLE.set(new ItemStack(var1, 1, BlockAutumnLeaves$BlockType.PURPLE.metadata()));
            Element.LEAVES_AUTUMN_YELLOW.set(new ItemStack(var1, 1, BlockAutumnLeaves$BlockType.YELLOW.metadata()));
            ItemStack var3 = new ItemStack(var1, 1, -1);
            ForestryModHelper.registerLeaves(var3);
            ForestryModHelper.addToForesterBackpack(var3);
        }
    }

    public static void createBlocks()
    {
        createAutumnLeaves();
        createCattail();
        createCrackedSand();
        createFlower();
        createGrass();
        createGreenLeaves();
        createLeafPile();
        createRedRock();
        createSapling();
        createLogs();
    }

    private static void createCattail()
    {
        int var0 = BlockSettings.CATTAIL.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockCatTail var1 = new BlockCatTail(var0, 79, Material.plants);
            var1.setBlockName("extrabiomes.cattail").setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.registerBlock(var1, ItemCatTail.class);
            var2.registerOre("reedTypha", (Block)var1);
            Element.CATTAIL.set(new ItemStack(var1));
            var2.registerWorldGenerator(new CatTailGenerator(var1.blockID));
        }
    }

    private static void createCrackedSand()
    {
        int var0 = BlockSettings.CRACKEDSAND.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            GenericTerrainBlock var1 = new GenericTerrainBlock(var0, 0, Material.rock);
            var1.setBlockName("extrabiomes.crackedsand").setHardness(1.2F).setStepSound(Block.soundStoneFootstep).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.setBlockHarvestLevel(var1, "pickaxe", 0);
            var2.registerBlock(var1);
            var2.registerOre("sandCracked", (Block)var1);
            ItemStack var3 = new ItemStack(var1);
            Element.CRACKEDSAND.set(var3);
            BiomeHelper.addTerrainBlockstoBiome(BiomeSettings.WASTELAND, var1.blockID, var1.blockID);
            ForestryModHelper.addToDiggerBackpack(var3);
            FacadeHelper.addBuildcraftFacade(var1.blockID);
        }
    }

    private static void createFlower()
    {
        int var0 = BlockSettings.FLOWER.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockCustomFlower var1 = new BlockCustomFlower(var0, 32, Material.plants);
            var1.setBlockName("extrabiomes.flower").setTickRandomly(true).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.registerBlock(var1, ItemFlower.class);
            Element.AUTUMN_SHRUB.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.AUTUMN_SHRUB.metadata()));
            Element.HYDRANGEA.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.HYDRANGEA.metadata()));
            Element.FLOWER_ORANGE.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.ORANGE.metadata()));
            Element.FLOWER_PURPLE.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.PURPLE.metadata()));
            Element.FLOWER_WHITE.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.WHITE.metadata()));
            Element.ROOT.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.ROOT.metadata()));
            Element.TINY_CACTUS.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.TINY_CACTUS.metadata()));
            Element.TOADSTOOL.set(new ItemStack(var1, 1, BlockCustomFlower$BlockType.TOADSTOOL.metadata()));
            ForestryModHelper.addToForesterBackpack(new ItemStack(var1, 1, -1));
            ForestryModHelper.registerBasicFlower(Element.HYDRANGEA.get());
            ForestryModHelper.registerBasicFlower(Element.FLOWER_ORANGE.get());
            ForestryModHelper.registerBasicFlower(Element.FLOWER_PURPLE.get());
            ForestryModHelper.registerBasicFlower(Element.FLOWER_WHITE.get());
            var2.registerWorldGenerator(new FlowerGenerator(var1.blockID));
        }
    }

    private static void createGrass()
    {
        int var0 = BlockSettings.GRASS.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockCustomTallGrass var1 = new BlockCustomTallGrass(var0, 48, Material.vine);
            var1.setBlockName("extrabiomes.tallgrass").setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.registerBlock(var1, ItemGrass.class);
            var2.setBurnProperties(var1.blockID, 60, 100);
            Element.GRASS_BROWN.set(new ItemStack(var1, 1, BlockCustomTallGrass$BlockType.BROWN.metadata()));
            Element.GRASS_DEAD.set(new ItemStack(var1, 1, BlockCustomTallGrass$BlockType.DEAD.metadata()));
            Element.GRASS_BROWN_SHORT.set(new ItemStack(var1, 1, BlockCustomTallGrass$BlockType.SHORT_BROWN.metadata()));
            Element.GRASS_DEAD_TALL.set(new ItemStack(var1, 1, BlockCustomTallGrass$BlockType.DEAD_TALL.metadata()));
            Element.GRASS_DEAD_YELLOW.set(new ItemStack(var1, 1, BlockCustomTallGrass$BlockType.DEAD_YELLOW.metadata()));
            ItemStack var3 = Element.GRASS_BROWN.get();
            BiomeHelper.addWeightedGrassGen(BiomeSettings.MOUNTAINRIDGE.getBiome(), new WorldGenTallGrass(var3.itemID, var3.getItemDamage()), 100);
            var3 = Element.GRASS_BROWN_SHORT.get();
            BiomeHelper.addWeightedGrassGen(BiomeSettings.MOUNTAINRIDGE.getBiome(), new WorldGenTallGrass(var3.itemID, var3.getItemDamage()), 100);
            var3 = Element.GRASS_DEAD.get();
            BiomeHelper.addWeightedGrassGen(BiomeSettings.WASTELAND.getBiome(), new WorldGenTallGrass(var3.itemID, var3.getItemDamage()), 90);
            var3 = Element.GRASS_DEAD_YELLOW.get();
            BiomeHelper.addWeightedGrassGen(BiomeSettings.WASTELAND.getBiome(), new WorldGenTallGrass(var3.itemID, var3.getItemDamage()), 90);
            var3 = Element.GRASS_DEAD_TALL.get();
            BiomeHelper.addWeightedGrassGen(BiomeSettings.WASTELAND.getBiome(), new WorldGenTallGrass(var3.itemID, var3.getItemDamage()), 35);
        }
    }

    private static void createGreenLeaves()
    {
        int var0 = BlockSettings.GREENLEAVES.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockGreenLeaves var1 = new BlockGreenLeaves(var0, 80, Material.leaves, false);
            var1.setBlockName("extrabiomes.greenleaves").setTickRandomly(true).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify().setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.registerBlock(var1, ItemCustomGreenLeaves.class);
            var2.registerOreInAllSubblocks("treeLeaves", var1);
            var2.setBurnProperties(var1.blockID, 30, 60);
            Element.LEAVES_ACACIA.set(new ItemStack(var1, 1, BlockGreenLeaves$BlockType.ACACIA.metadata()));
            Element.LEAVES_FIR.set(new ItemStack(var1, 1, BlockGreenLeaves$BlockType.FIR.metadata()));
            Element.LEAVES_REDWOOD.set(new ItemStack(var1, 1, BlockGreenLeaves$BlockType.REDWOOD.metadata()));
            ItemStack var3 = new ItemStack(var1, 1, -1);
            ForestryModHelper.registerLeaves(var3);
            ForestryModHelper.addToForesterBackpack(var3);
        }
    }

    private static void createLeafPile()
    {
        int var0 = BlockSettings.LEAFPILE.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockLeafPile var1 = new BlockLeafPile(var0, 64, Material.vine);
            var1.setBlockName("extrabiomes.leafpile").setHardness(0.0F).setTickRandomly(true).setStepSound(Block.soundGrassFootstep).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.registerBlock(var1);
            var2.setBurnProperties(var1.blockID, 30, 60);
            Element.LEAFPILE.set(new ItemStack(var1));
            var2.registerWorldGenerator(new LeafPileGenerator(var1.blockID));
        }
    }

    private static void createLogs()
    {
        createWood();
        createQuarterLogs();
    }

    private static void createQuarterLogs()
    {
        int var0 = BlockSettings.QUARTERLOG0.getID();
        int var1 = BlockSettings.QUARTERLOG1.getID();
        int var2 = BlockSettings.QUARTERLOG2.getID();
        int var3 = BlockSettings.QUARTERLOG3.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var1 > 0 && var0 > 0 && var3 > 0 && var2 > 0)
        {
            BlockQuarterLog var4 = new BlockQuarterLog(var0, 144, BlockQuarterLog$BarkOn.NW);
            BlockQuarterLog var5 = new BlockQuarterLog(var1, 144, BlockQuarterLog$BarkOn.NE);
            BlockQuarterLog var6 = new BlockQuarterLog(var2, 144, BlockQuarterLog$BarkOn.SW);
            BlockQuarterLog var7 = new BlockQuarterLog(var3, 144, BlockQuarterLog$BarkOn.SE);
            Block[] var8 = new Block[] {var4, var5, var6, var7};
            int var9 = var8.length;
            int var10;

            for (var10 = 0; var10 < var9; ++var10)
            {
                Block var11 = var8[var10];
                var11.setBlockName("extrabiomes.log.quarter").setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify().setHardness(2.0F).setResistance(Block.wood.getExplosionResistance((Entity)null) * 5.0F).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
                CommonProxy var12 = Extrabiomes.proxy;
                var12.setBlockHarvestLevel(var11, "axe", 0);
                var12.registerBlock(var11, MultiItemBlock.class);
                var12.registerOre("logWood", new ItemStack(var11, 1, -1));
                var12.registerEventHandler(var11);
                var12.setBurnProperties(var11.blockID, 5, 5);
            }

            Element.LOG_HUGE_FIR_NW.set(new ItemStack(var4, 1, BlockQuarterLog$BlockType.FIR.metadata()));
            Element.LOG_HUGE_FIR_NE.set(new ItemStack(var5, 1, BlockQuarterLog$BlockType.FIR.metadata()));
            Element.LOG_HUGE_FIR_SW.set(new ItemStack(var6, 1, BlockQuarterLog$BlockType.FIR.metadata()));
            Element.LOG_HUGE_FIR_SE.set(new ItemStack(var7, 1, BlockQuarterLog$BlockType.FIR.metadata()));
            Element.LOG_HUGE_OAK_NW.set(new ItemStack(var4, 1, BlockQuarterLog$BlockType.OAK.metadata()));
            Element.LOG_HUGE_OAK_NE.set(new ItemStack(var5, 1, BlockQuarterLog$BlockType.OAK.metadata()));
            Element.LOG_HUGE_OAK_SW.set(new ItemStack(var6, 1, BlockQuarterLog$BlockType.OAK.metadata()));
            Element.LOG_HUGE_OAK_SE.set(new ItemStack(var7, 1, BlockQuarterLog$BlockType.OAK.metadata()));
            Element.LOG_HUGE_REDWOOD_NW.set(new ItemStack(var4, 1, BlockQuarterLog$BlockType.REDWOOD.metadata()));
            Element.LOG_HUGE_REDWOOD_NE.set(new ItemStack(var5, 1, BlockQuarterLog$BlockType.REDWOOD.metadata()));
            Element.LOG_HUGE_REDWOOD_SW.set(new ItemStack(var6, 1, BlockQuarterLog$BlockType.REDWOOD.metadata()));
            Element.LOG_HUGE_REDWOOD_SE.set(new ItemStack(var7, 1, BlockQuarterLog$BlockType.REDWOOD.metadata()));
            BlockQuarterLog.setRenderId(Extrabiomes.proxy.registerBlockHandler(new RenderQuarterLog()));
            BlockQuarterLog$BlockType[] var13 = BlockQuarterLog$BlockType.values();
            var9 = var13.length;

            for (var10 = 0; var10 < var9; ++var10)
            {
                BlockQuarterLog$BlockType var14 = var13[var10];
                FacadeHelper.addBuildcraftFacade(var7.blockID, var14.metadata());
            }
        }
    }

    private static void createRedRock()
    {
        int var0 = BlockSettings.REDROCK.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockRedRock var1 = new BlockRedRock(var0, 2, Material.rock);
            var1.setBlockName("extrabiomes.redrock").setHardness(1.5F).setResistance(2.0F).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.setBlockHarvestLevel(var1, "pickaxe", 0);
            var2.registerBlock(var1, ItemRedRock.class);
            Element.RED_ROCK.set(new ItemStack(var1, 1, BlockRedRock$BlockType.RED_ROCK.metadata()));
            Element.RED_COBBLE.set(new ItemStack(var1, 1, BlockRedRock$BlockType.RED_COBBLE.metadata()));
            Element.RED_ROCK_BRICK.set(new ItemStack(var1, 1, BlockRedRock$BlockType.RED_ROCK_BRICK.metadata()));
            Extrabiomes.postInitEvent(new BlockActiveEvent$RedRockActiveEvent(var1));
            BiomeHelper.addTerrainBlockstoBiome(BiomeSettings.MOUNTAINRIDGE, var1.blockID, var1.blockID);
            ForestryModHelper.addToDiggerBackpack(new ItemStack(var1, 1, -1));
            BlockRedRock$BlockType[] var3 = BlockRedRock$BlockType.values();
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5)
            {
                BlockRedRock$BlockType var6 = var3[var5];
                FacadeHelper.addBuildcraftFacade(var1.blockID, var6.metadata());
            }
        }
    }

    private static void createSapling()
    {
        int var0 = BlockSettings.SAPLING.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockCustomSapling var1 = new BlockCustomSapling(var0, 16);
            var1.setBlockName("extrabiomes.sapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify().setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.registerBlock(var1, ItemSapling.class);
            var2.registerOreInAllSubblocks("treeSapling", var1);
            Element.SAPLING_ACACIA.set(new ItemStack(var1, 1, BlockCustomSapling$BlockType.ACACIA.metadata()));
            Element.SAPLING_AUTUMN_BROWN.set(new ItemStack(var1, 1, BlockCustomSapling$BlockType.BROWN.metadata()));
            Element.SAPLING_AUTUMN_ORANGE.set(new ItemStack(var1, 1, BlockCustomSapling$BlockType.ORANGE.metadata()));
            Element.SAPLING_AUTUMN_PURPLE.set(new ItemStack(var1, 1, BlockCustomSapling$BlockType.PURPLE.metadata()));
            Element.SAPLING_AUTUMN_YELLOW.set(new ItemStack(var1, 1, BlockCustomSapling$BlockType.YELLOW.metadata()));
            Element.SAPLING_FIR.set(new ItemStack(var1, 1, BlockCustomSapling$BlockType.FIR.metadata()));
            Element.SAPLING_REDWOOD.set(new ItemStack(var1, 1, BlockCustomSapling$BlockType.REDWOOD.metadata()));
            ItemStack var3 = new ItemStack(var1, 1, -1);
            ForestryModHelper.registerSapling(var3);
            ForestryModHelper.addToForesterBackpack(var3);
            Element[] var4 = new Element[] {Element.SAPLING_ACACIA, Element.SAPLING_AUTUMN_BROWN, Element.SAPLING_AUTUMN_ORANGE, Element.SAPLING_AUTUMN_PURPLE, Element.SAPLING_AUTUMN_YELLOW, Element.SAPLING_FIR};
            Element[] var5 = var4;
            int var6 = var4.length;

            for (int var7 = 0; var7 < var6; ++var7)
            {
                Element var8 = var5[var7];
                ForestryModHelper.registerGermling(var8.get());
            }

            var2.registerEventHandler(new SaplingBonemealEventHandler(var1));
            var2.registerFuelHandler(new SaplingFuelHandler(var1.blockID));
        }
    }

    private static void createWood()
    {
        int var0 = BlockSettings.CUSTOMLOG.getID();

        if (ModuleControlSettings.SUMMA.isEnabled() && var0 > 0)
        {
            BlockCustomLog var1 = new BlockCustomLog(var0, 97);
            var1.setBlockName("extrabiomes.log").setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify().setHardness(2.0F).setResistance(Block.wood.getExplosionResistance((Entity)null) * 5.0F).setTextureFile("/extrabiomes/extrabiomes.png").setCreativeTab(Extrabiomes.tabsEBXL);
            CommonProxy var2 = Extrabiomes.proxy;
            var2.setBlockHarvestLevel(var1, "axe", 0);
            var2.registerBlock(var1, MultiItemBlock.class);
            var2.registerOre("logWood", new ItemStack(var1, 1, -1));
            var2.registerEventHandler(var1);
            var2.setBurnProperties(var1.blockID, 5, 5);
            Element.LOG_ACACIA.set(new ItemStack(var1, 1, BlockCustomLog$BlockType.ACACIA.metadata()));
            Element.LOG_FIR.set(new ItemStack(var1, 1, BlockCustomLog$BlockType.FIR.metadata()));
            ForestryModHelper.addToForesterBackpack(new ItemStack(var1, 1, -1));
            BlockCustomLog$BlockType[] var3 = BlockCustomLog$BlockType.values();
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5)
            {
                BlockCustomLog$BlockType var6 = var3[var5];
                FacadeHelper.addBuildcraftFacade(var1.blockID, var6.metadata());
            }
        }
    }
}
