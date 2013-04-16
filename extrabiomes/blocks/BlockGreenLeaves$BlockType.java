package extrabiomes.blocks;

import extrabiomes.lib.Element;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public enum BlockGreenLeaves$BlockType
{
    FIR(0),
    REDWOOD(1),
    ACACIA(2);
    private final int metadata;
    private ItemStack sapling;
    private static boolean loadedCustomBlocks = false;

    static BlockGreenLeaves$BlockType fromMetadata(int var0)
    {
        var0 = BlockGreenLeaves.access$000(var0);
        BlockGreenLeaves$BlockType[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3)
        {
            BlockGreenLeaves$BlockType var4 = var1[var3];

            if (var4.metadata() == var0)
            {
                return var4;
            }
        }

        return null;
    }

    private static void loadCustomBlocks()
    {
        if (Element.SAPLING_FIR.isPresent())
        {
            FIR.sapling = Element.SAPLING_FIR.get();
        }

        if (Element.SAPLING_REDWOOD.isPresent())
        {
            REDWOOD.sapling = Element.SAPLING_REDWOOD.get();
        }

        if (Element.SAPLING_ACACIA.isPresent())
        {
            ACACIA.sapling = Element.SAPLING_ACACIA.get();
        }

        loadedCustomBlocks = true;
    }

    private BlockGreenLeaves$BlockType(int var3)
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
