package extrabiomes.module.summa.worldgen;

import extrabiomes.lib.Element;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

enum WorldGenAcacia$TreeBlock
{
    LEAVES(new ItemStack(Block.leaves)),
    TRUNK(new ItemStack(Block.wood));
    private ItemStack stack;
    private static boolean loadedCustomBlocks = false;

    private static void loadCustomBlocks()
    {
        if (Element.LEAVES_ACACIA.isPresent())
        {
            LEAVES.stack = Element.LEAVES_ACACIA.get();
        }

        if (Element.LOG_ACACIA.isPresent())
        {
            TRUNK.stack = Element.LOG_ACACIA.get();
        }

        loadedCustomBlocks = true;
    }

    private WorldGenAcacia$TreeBlock(ItemStack var3)
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
