package extrabiomes.module.summa.worldgen;

import extrabiomes.lib.Element;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

enum WorldGenFirTree$TreeBlock
{
    LEAVES(new ItemStack(Block.leaves, 1, 1)),
    TRUNK(new ItemStack(Block.wood, 1, 1));
    private ItemStack stack;
    private static boolean loadedCustomBlocks = false;

    private static void loadCustomBlocks()
    {
        if (Element.LEAVES_FIR.isPresent())
        {
            LEAVES.stack = Element.LEAVES_FIR.get();
        }

        if (Element.LOG_FIR.isPresent())
        {
            TRUNK.stack = Element.LOG_FIR.get();
        }

        loadedCustomBlocks = true;
    }

    private WorldGenFirTree$TreeBlock(ItemStack var3)
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
