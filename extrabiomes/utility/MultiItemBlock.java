package extrabiomes.utility;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MultiItemBlock extends ItemBlock
{
    public MultiItemBlock(int var1)
    {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    private Block getBlock()
    {
        return Block.blocksList[this.getBlockID()];
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack var1, int var2)
    {
        return this.getBlock().getRenderColor(var1.getItemDamage());
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int var1)
    {
        return this.getBlock().getBlockTextureFromSideAndMetadata(0, var1);
    }

    public String getItemNameIS(ItemStack var1)
    {
        return super.getItemNameIS(var1) + "." + var1.getItemDamage();
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int var1)
    {
        return var1;
    }
}
