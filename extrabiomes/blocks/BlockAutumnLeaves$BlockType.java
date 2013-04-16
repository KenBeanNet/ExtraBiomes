package extrabiomes.blocks;

import extrabiomes.lib.Element;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public enum BlockAutumnLeaves$BlockType
{
    BROWN(0),
    ORANGE(1),
    PURPLE(2),
    YELLOW(3);
    private final int metadata;
    private ItemStack sapling;
    private static boolean loadedCustomBlocks = false;

    static BlockAutumnLeaves$BlockType fromMetadata(int var0)
    {
        var0 = BlockAutumnLeaves.access$000(var0);
        BlockAutumnLeaves$BlockType[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3)
        {
            BlockAutumnLeaves$BlockType var4 = var1[var3];

            if (var4.metadata() == var0)
            {
                return var4;
            }
        }

        return null;
    }

    private static void loadCustomBlocks()
    {
        if (Element.SAPLING_AUTUMN_BROWN.isPresent())
        {
            BROWN.sapling = Element.SAPLING_AUTUMN_BROWN.get();
        }

        if (Element.SAPLING_AUTUMN_ORANGE.isPresent())
        {
            ORANGE.sapling = Element.SAPLING_AUTUMN_ORANGE.get();
        }

        if (Element.SAPLING_AUTUMN_PURPLE.isPresent())
        {
            PURPLE.sapling = Element.SAPLING_AUTUMN_PURPLE.get();
        }

        if (Element.SAPLING_AUTUMN_YELLOW.isPresent())
        {
            YELLOW.sapling = Element.SAPLING_AUTUMN_YELLOW.get();
        }

        loadedCustomBlocks = true;
    }

    private BlockAutumnLeaves$BlockType(int var3)
    {
        this.sapling = new ItemStack(Block.sapling);
        this.metadata = var3;
    }

    int getSaplingID()
    {
        if (!loadedCustomBlocks)
        {
            loadCustomBlocks();
        }

        return this.sapling.itemID;
    }

    int getSaplingMetadata()
    {
        if (!loadedCustomBlocks)
        {
            loadCustomBlocks();
        }

        return this.sapling.getItemDamage();
    }

    public int metadata()
    {
        return this.metadata;
    }
}
