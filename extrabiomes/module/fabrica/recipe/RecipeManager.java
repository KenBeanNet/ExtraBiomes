package extrabiomes.module.fabrica.recipe;

import com.google.common.base.Optional;
import extrabiomes.Extrabiomes;
import extrabiomes.blocks.BlockRedRock$BlockType;
import extrabiomes.events.BlockActiveEvent$AcaciaStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$FirStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$PlankActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedCobbleStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedRockActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedRockBrickStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedRockSlabActiveEvent;
import extrabiomes.events.BlockActiveEvent$RedwoodStairsActiveEvent;
import extrabiomes.events.BlockActiveEvent$WallActiveEvent;
import extrabiomes.events.BlockActiveEvent$WoodSlabActiveEvent;
import extrabiomes.module.fabrica.block.BlockCustomWall$BlockType;
import extrabiomes.module.fabrica.block.BlockCustomWood$BlockType;
import extrabiomes.module.fabrica.block.BlockCustomWoodSlab$BlockType;
import extrabiomes.module.fabrica.block.BlockRedRockSlab$BlockType;
import extrabiomes.proxy.CommonProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeManager
{
    private Optional plankAcaciaItem = Optional.absent();
    private Optional plankFirItem = Optional.absent();
    private Optional plankRedwoodItem = Optional.absent();
    private Optional redRockItem = Optional.absent();
    private Optional redCobbleItem = Optional.absent();
    private Optional redRockBrickItem = Optional.absent();
    private final ItemStack charcoal;
    private final List acaciaLogs;
    private final List firLogs;
    private final List oakLogs;
    private final List redwoodLogs;

    public RecipeManager()
    {
        this.charcoal = new ItemStack(Item.coal, 1, 1);
        this.acaciaLogs = new ArrayList();
        this.firLogs = new ArrayList();
        this.oakLogs = new ArrayList();
        this.redwoodLogs = new ArrayList();
    }

    @ForgeSubscribe
    public void acaciaStairsRecipeHandler(BlockActiveEvent$AcaciaStairsActiveEvent var1)
    {
        if (this.plankAcaciaItem.isPresent())
        {
            this.addStairsRecipe((ItemStack)this.plankAcaciaItem.get(), var1.block);
        }
    }

    private void addStairsRecipe(ItemStack var1, Block var2)
    {
        ShapedOreRecipe var3 = new ShapedOreRecipe(new ItemStack(var2, 4), new Object[] {new String[]{"r  ", "rr ", "rrr"}, 'r', var1});
        Extrabiomes.proxy.addRecipe(var3);
    }

    @ForgeSubscribe
    public void firStairsRecipeHandler(BlockActiveEvent$FirStairsActiveEvent var1)
    {
        if (this.plankFirItem.isPresent())
        {
            this.addStairsRecipe((ItemStack)this.plankFirItem.get(), var1.block);
        }
    }

    @ForgeSubscribe
    public void plankRecipeHandler(BlockActiveEvent$PlankActiveEvent var1)
    {
        ItemStack var2 = new ItemStack(var1.block, 4, BlockCustomWood$BlockType.ACACIA.metadata());
        Iterator var3 = this.acaciaLogs.iterator();
        ItemStack var4;
        ShapelessOreRecipe var5;

        while (var3.hasNext())
        {
            var4 = (ItemStack)var3.next();
            var5 = new ShapelessOreRecipe(var2, new Object[] {var4});
            Extrabiomes.proxy.addRecipe(var5);
        }

        this.plankAcaciaItem = Optional.of(new ItemStack(var1.block, 1, BlockCustomWood$BlockType.ACACIA.metadata()));
        var2 = new ItemStack(var1.block, 4, BlockCustomWood$BlockType.FIR.metadata());
        var3 = this.firLogs.iterator();

        while (var3.hasNext())
        {
            var4 = (ItemStack)var3.next();
            var5 = new ShapelessOreRecipe(var2, new Object[] {var4});
            Extrabiomes.proxy.addRecipe(var5);
        }

        this.plankFirItem = Optional.of(new ItemStack(var1.block, 1, BlockCustomWood$BlockType.FIR.metadata()));
        var2 = new ItemStack(Block.planks, 4);
        var3 = this.oakLogs.iterator();

        while (var3.hasNext())
        {
            var4 = (ItemStack)var3.next();
            var5 = new ShapelessOreRecipe(var2, new Object[] {var4});
            Extrabiomes.proxy.addRecipe(var5);
        }

        var2 = new ItemStack(var1.block, 4, BlockCustomWood$BlockType.REDWOOD.metadata());
        var3 = this.redwoodLogs.iterator();

        while (var3.hasNext())
        {
            var4 = (ItemStack)var3.next();
            var5 = new ShapelessOreRecipe(var2, new Object[] {var4});
            Extrabiomes.proxy.addRecipe(var5);
        }

        this.plankRedwoodItem = Optional.of(new ItemStack(var1.block, 1, BlockCustomWood$BlockType.REDWOOD.metadata()));
    }

    @ForgeSubscribe
    public void redCobbleStairsRecipeHandler(BlockActiveEvent$RedCobbleStairsActiveEvent var1)
    {
        if (this.redCobbleItem.isPresent())
        {
            this.addStairsRecipe((ItemStack)this.redCobbleItem.get(), var1.block);
        }
    }

    @ForgeSubscribe
    public void redRockBrickStairsRecipeHandler(BlockActiveEvent$RedRockBrickStairsActiveEvent var1)
    {
        if (this.redRockBrickItem.isPresent())
        {
            this.addStairsRecipe((ItemStack)this.redRockBrickItem.get(), var1.block);
        }
    }

    @ForgeSubscribe
    public void redRockRecipeHandler(BlockActiveEvent$RedRockActiveEvent var1)
    {
        CommonProxy var2 = Extrabiomes.proxy;
        this.redRockItem = Optional.of(new ItemStack(var1.block, 1, BlockRedRock$BlockType.RED_ROCK.metadata()));
        this.redCobbleItem = Optional.of(new ItemStack(var1.block, 1, BlockRedRock$BlockType.RED_COBBLE.metadata()));
        this.redRockBrickItem = Optional.of(new ItemStack(var1.block, 1, BlockRedRock$BlockType.RED_ROCK_BRICK.metadata()));
        ShapelessOreRecipe var3 = new ShapelessOreRecipe(new ItemStack(Item.clay, 4), new Object[] {this.redCobbleItem.get(), Item.bucketWater, Item.bucketWater, Item.bucketWater});
        var2.addRecipe(var3);
        ShapedOreRecipe var4 = new ShapedOreRecipe(new ItemStack(var1.block, 4, BlockRedRock$BlockType.RED_ROCK_BRICK.metadata()), new Object[] {new String[]{"rr", "rr"}, 'r', this.redRockItem.get()});
        var2.addRecipe(var4);
        var2.addSmelting(var1.block.blockID, BlockRedRock$BlockType.RED_COBBLE.metadata(), (ItemStack)this.redRockItem.get(), 0.1F);
    }

    @ForgeSubscribe
    public void redRockSlabRecipeHandler(BlockActiveEvent$RedRockSlabActiveEvent var1)
    {
        CommonProxy var2 = Extrabiomes.proxy;
        ShapedOreRecipe var3;

        if (this.redRockItem.isPresent())
        {
            var3 = new ShapedOreRecipe(new ItemStack(var1.block, 6, BlockRedRockSlab$BlockType.REDROCK.metadata()), new Object[] {new String[]{"rrr"}, 'r', this.redRockItem.get()});
            var2.addRecipe(var3);
        }

        if (this.redCobbleItem.isPresent())
        {
            var3 = new ShapedOreRecipe(new ItemStack(var1.block, 6, BlockRedRockSlab$BlockType.REDCOBBLE.metadata()), new Object[] {new String[]{"rrr"}, 'r', this.redCobbleItem.get()});
            var2.addRecipe(var3);
        }

        if (this.redRockBrickItem.isPresent())
        {
            var3 = new ShapedOreRecipe(new ItemStack(var1.block, 6, BlockRedRockSlab$BlockType.REDROCKBRICK.metadata()), new Object[] {new String[]{"rrr"}, 'r', this.redRockBrickItem.get()});
            var2.addRecipe(var3);
        }
    }

    @ForgeSubscribe
    public void redwoodStairsRecipeHandler(BlockActiveEvent$RedwoodStairsActiveEvent var1)
    {
        if (this.plankRedwoodItem.isPresent())
        {
            this.addStairsRecipe((ItemStack)this.plankRedwoodItem.get(), var1.block);
        }
    }

    @ForgeSubscribe
    public void wallRecipeHandler(BlockActiveEvent$WallActiveEvent var1)
    {
        if (this.redCobbleItem.isPresent())
        {
            ShapedOreRecipe var2 = new ShapedOreRecipe(new ItemStack(var1.block, 6, BlockCustomWall$BlockType.RED_COBBLE.metadata()), new Object[] {new String[]{"ppp", "ppp"}, 'p', this.redCobbleItem.get()});
            Extrabiomes.proxy.addRecipe(var2);
        }
    }

    @ForgeSubscribe
    public void woodSlabRecipeHandler(BlockActiveEvent$WoodSlabActiveEvent var1)
    {
        ShapedOreRecipe var2;

        if (this.plankAcaciaItem.isPresent())
        {
            var2 = new ShapedOreRecipe(new ItemStack(var1.block, 6, BlockCustomWoodSlab$BlockType.ACACIA.metadata()), new Object[] {new String[]{"ppp"}, 'p', this.plankAcaciaItem.get()});
            Extrabiomes.proxy.addRecipe(var2);
        }

        if (this.plankFirItem.isPresent())
        {
            var2 = new ShapedOreRecipe(new ItemStack(var1.block, 6, BlockCustomWoodSlab$BlockType.FIR.metadata()), new Object[] {new String[]{"ppp"}, 'p', this.plankFirItem.get()});
            Extrabiomes.proxy.addRecipe(var2);
        }

        if (this.plankRedwoodItem.isPresent())
        {
            var2 = new ShapedOreRecipe(new ItemStack(var1.block, 6, BlockCustomWoodSlab$BlockType.REDWOOD.metadata()), new Object[] {new String[]{"ppp"}, 'p', this.plankRedwoodItem.get()});
            Extrabiomes.proxy.addRecipe(var2);
        }
    }
}
