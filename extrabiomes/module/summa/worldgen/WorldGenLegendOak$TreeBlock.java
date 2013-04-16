package extrabiomes.module.summa.worldgen;

import extrabiomes.lib.Element;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

enum WorldGenLegendOak$TreeBlock
{
    LEAVES(new ItemStack(Block.leaves)),
    TRUNK_NE(new ItemStack(Block.wood)),
    TRUNK_NW(new ItemStack(Block.wood)),
    TRUNK_SE(new ItemStack(Block.wood)),
    TRUNK_SW(new ItemStack(Block.wood)),
    BRANCH(new ItemStack(Block.wood));
    private ItemStack stack;
    private static boolean loadedCustomBlocks = false;

    private static void loadCustomBlocks()
    {
        if (Element.LOG_HUGE_OAK_NE.isPresent())
        {
            TRUNK_NE.stack = Element.LOG_HUGE_OAK_NE.get();
        }

        if (Element.LOG_HUGE_OAK_NW.isPresent())
        {
            TRUNK_NW.stack = Element.LOG_HUGE_OAK_NW.get();
        }

        if (Element.LOG_HUGE_OAK_SE.isPresent())
        {
            TRUNK_SE.stack = Element.LOG_HUGE_OAK_SE.get();
        }

        if (Element.LOG_HUGE_OAK_SW.isPresent())
        {
            TRUNK_SW.stack = Element.LOG_HUGE_OAK_SW.get();
        }

        loadedCustomBlocks = true;
    }

    private WorldGenLegendOak$TreeBlock(ItemStack var3)
    {
        this.stack = var3;
    }

    public int getID()
    {
        if (!loadedCustomBlocks)
        {
            loadCustomBlocks();
        }

        return this.stack.itemID;
    }

    public int getMetadata()
    {
        if (!loadedCustomBlocks)
        {
            loadCustomBlocks();
        }

        return this.stack.getItemDamage();
    }
}
