package extrabiomes.module.summa.worldgen;

import extrabiomes.lib.Element;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

enum WorldGenRedwood$TreeBlock
{
    LEAVES(new ItemStack(Block.leaves)),
    TRUNK_NE(new ItemStack(Block.wood, 1, 1)),
    TRUNK_NW(new ItemStack(Block.wood, 1, 1)),
    TRUNK_SE(new ItemStack(Block.wood, 1, 1)),
    TRUNK_SW(new ItemStack(Block.wood, 1, 1));
    private ItemStack stack;
    private static boolean loadedCustomBlocks = false;

    private static void loadCustomBlocks()
    {
        if (Element.LEAVES_REDWOOD.isPresent())
        {
            LEAVES.stack = Element.LEAVES_REDWOOD.get();
        }

        if (Element.LOG_HUGE_REDWOOD_NE.isPresent())
        {
            TRUNK_NE.stack = Element.LOG_HUGE_REDWOOD_NE.get();
        }

        if (Element.LOG_HUGE_REDWOOD_NW.isPresent())
        {
            TRUNK_NW.stack = Element.LOG_HUGE_REDWOOD_NW.get();
        }

        if (Element.LOG_HUGE_REDWOOD_SE.isPresent())
        {
            TRUNK_SE.stack = Element.LOG_HUGE_REDWOOD_SE.get();
        }

        if (Element.LOG_HUGE_REDWOOD_SW.isPresent())
        {
            TRUNK_SW.stack = Element.LOG_HUGE_REDWOOD_SW.get();
        }

        loadedCustomBlocks = true;
    }

    private WorldGenRedwood$TreeBlock(ItemStack var3)
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
