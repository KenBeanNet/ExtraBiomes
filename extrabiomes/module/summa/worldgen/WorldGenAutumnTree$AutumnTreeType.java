package extrabiomes.module.summa.worldgen;

import extrabiomes.lib.Element;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public enum WorldGenAutumnTree$AutumnTreeType
{
    BROWN,
    ORANGE,
    PURPLE,
    YELLOW;
    private ItemStack leaves;
    private static boolean loadedCustomBlocks = false;

    private WorldGenAutumnTree$AutumnTreeType()
    {
        this.leaves = new ItemStack(Block.leaves);
    }

    private static void loadCustomBlocks()
    {
        if (Element.LEAVES_AUTUMN_BROWN.isPresent())
        {
            BROWN.leaves = Element.LEAVES_AUTUMN_BROWN.get();
        }

        if (Element.LEAVES_AUTUMN_ORANGE.isPresent())
        {
            ORANGE.leaves = Element.LEAVES_AUTUMN_ORANGE.get();
        }

        if (Element.LEAVES_AUTUMN_PURPLE.isPresent())
        {
            PURPLE.leaves = Element.LEAVES_AUTUMN_PURPLE.get();
        }

        if (Element.LEAVES_AUTUMN_YELLOW.isPresent())
        {
            YELLOW.leaves = Element.LEAVES_AUTUMN_YELLOW.get();
        }

        loadedCustomBlocks = true;
    }

    public int getID()
    {
        if (!loadedCustomBlocks)
        {
            loadCustomBlocks();
        }

        return this.leaves.itemID;
    }

    public int getMetadata()
    {
        if (!loadedCustomBlocks)
        {
            loadCustomBlocks();
        }

        return this.leaves.getItemDamage();
    }
}
