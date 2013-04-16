package extrabiomes.handlers;

import extrabiomes.Extrabiomes;
import extrabiomes.api.Stuff;
import extrabiomes.lib.Element;
import extrabiomes.module.fabrica.block.BlockCustomWood$BlockType;
import extrabiomes.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public abstract class RecipeHandler
{
    public static void init()
    {
        writeLogTurnerRecipe();
        writeCrackedSandRecipes();
        writeLogRecipes();
        writeFlowerRecipes();
        writeLeafPileRecipes();
    }

    private static void writeCrackedSandRecipes()
    {
        if (Element.CRACKEDSAND.isPresent())
        {
            ShapelessOreRecipe var0 = new ShapelessOreRecipe(Block.sand, new Object[] {Element.CRACKEDSAND.get(), Item.bucketWater});
            Extrabiomes.proxy.addRecipe(var0);
        }
    }

    private static void writeFlowerRecipes()
    {
        CommonProxy var0 = Extrabiomes.proxy;
        ItemStack var1;
        ShapelessOreRecipe var2;

        if (Element.HYDRANGEA.isPresent())
        {
            var1 = new ItemStack(Item.dyePowder, 1, 12);
            var2 = new ShapelessOreRecipe(var1, new Object[] {Element.HYDRANGEA.get()});
            var0.addRecipe(var2);
        }

        if (Element.FLOWER_ORANGE.isPresent())
        {
            var1 = new ItemStack(Item.dyePowder, 1, 14);
            var2 = new ShapelessOreRecipe(var1, new Object[] {Element.FLOWER_ORANGE.get()});
            var0.addRecipe(var2);
        }

        if (Element.FLOWER_PURPLE.isPresent())
        {
            var1 = new ItemStack(Item.dyePowder, 1, 5);
            var2 = new ShapelessOreRecipe(var1, new Object[] {Element.FLOWER_PURPLE.get()});
            var0.addRecipe(var2);
        }

        if (Element.FLOWER_WHITE.isPresent())
        {
            var1 = new ItemStack(Item.dyePowder, 1, 7);
            var2 = new ShapelessOreRecipe(var1, new Object[] {Element.FLOWER_WHITE.get()});
            var0.addRecipe(var2);
        }

        if (Element.TOADSTOOL.isPresent())
        {
            var1 = Element.TOADSTOOL.get();
            var2 = new ShapelessOreRecipe(Item.bowlSoup, new Object[] {Block.mushroomBrown, var1, var1, Item.bowlEmpty});
            var0.addRecipe(var2);
            var2 = new ShapelessOreRecipe(Item.bowlSoup, new Object[] {Block.mushroomRed, var1, var1, Item.bowlEmpty});
            var0.addRecipe(var2);
        }
    }

    private static void writeLeafPileRecipes()
    {
        if (Element.LEAFPILE.isPresent())
        {
            ShapedOreRecipe var0 = new ShapedOreRecipe(Block.leaves, new Object[] {new String[]{"lll", "lll", "lll"}, 'l', Element.LEAFPILE.get()});
            Extrabiomes.proxy.addRecipe(var0);
        }
    }

    private static void writeLogRecipes()
    {
        if (Stuff.planks.isPresent())
        {
            CommonProxy var0 = Extrabiomes.proxy;
            Block var1 = (Block)Stuff.planks.get();
            ItemStack var2 = new ItemStack(Item.coal, 1, 1);

            if (Element.LOG_ACACIA.isPresent())
            {
                ItemStack var3 = Element.LOG_ACACIA.get();
                ItemStack var4 = new ItemStack(var1, 4, BlockCustomWood$BlockType.ACACIA.metadata());
                ShapelessOreRecipe var5 = new ShapelessOreRecipe(var4, new Object[] {var3});
                var0.addRecipe(var5);
                var0.addSmelting(var3, var2, 0.15F);
            }

            Element[] var9 = new Element[] {Element.LOG_FIR, Element.LOG_HUGE_FIR_NE, Element.LOG_HUGE_FIR_NW, Element.LOG_HUGE_FIR_SE, Element.LOG_HUGE_FIR_SW};
            int var10 = var9.length;
            Element var6;
            ItemStack var7;
            ShapelessOreRecipe var8;
            int var11;

            for (var11 = 0; var11 < var10; ++var11)
            {
                var6 = var9[var11];

                if (var6.isPresent())
                {
                    var7 = new ItemStack(var1, 4, BlockCustomWood$BlockType.FIR.metadata());
                    var8 = new ShapelessOreRecipe(var7, new Object[] {var6.get()});
                    var0.addRecipe(var8);
                    var0.addSmelting(var6.get(), var2, 0.15F);
                }
            }

            var9 = new Element[] {Element.LOG_HUGE_REDWOOD_NE, Element.LOG_HUGE_REDWOOD_NW, Element.LOG_HUGE_REDWOOD_SE, Element.LOG_HUGE_REDWOOD_SW};
            var10 = var9.length;

            for (var11 = 0; var11 < var10; ++var11)
            {
                var6 = var9[var11];

                if (var6.isPresent())
                {
                    var7 = new ItemStack(var1, 4, BlockCustomWood$BlockType.REDWOOD.metadata());
                    var8 = new ShapelessOreRecipe(var7, new Object[] {var6.get()});
                    var0.addRecipe(var8);
                    var0.addSmelting(var6.get(), var2, 0.15F);
                }
            }

            var9 = new Element[] {Element.LOG_HUGE_OAK_NE, Element.LOG_HUGE_OAK_NW, Element.LOG_HUGE_OAK_SE, Element.LOG_HUGE_OAK_SW};
            var10 = var9.length;

            for (var11 = 0; var11 < var10; ++var11)
            {
                var6 = var9[var11];

                if (var6.isPresent())
                {
                    var7 = new ItemStack(Block.planks, 4);
                    var8 = new ShapelessOreRecipe(var7, new Object[] {var6.get()});
                    var0.addRecipe(var8);
                    var0.addSmelting(var6.get(), var2, 0.15F);
                }
            }
        }
    }

    private static void writeLogTurnerRecipe()
    {
        if (Element.LOGTURNER.isPresent())
        {
            ShapedOreRecipe var0 = new ShapedOreRecipe(Element.LOGTURNER.get(), new Object[] {new String[]{"ss", " s", "ss"}, 's', "stickWood"});
            Extrabiomes.proxy.addRecipe(var0);
        }
    }
}
