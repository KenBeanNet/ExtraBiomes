package extrabiomes.module.fabrica.block;

import com.google.common.base.Optional;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemWoodSlab extends ItemSlab
{
    private static Optional singleSlab = Optional.absent();
    private static Optional doubleSlab = Optional.absent();

    static void setSlabs(BlockHalfSlab var0, BlockHalfSlab var1)
    {
        singleSlab = Optional.of(var0);
        doubleSlab = Optional.of(var1);
    }

    public ItemWoodSlab(int var1)
    {
        super(var1, (BlockHalfSlab)singleSlab.get(), (BlockHalfSlab)doubleSlab.get(), var1 == ((BlockHalfSlab)doubleSlab.get()).blockID);
    }

    public String getItemNameIS(ItemStack var1)
    {
        return ((BlockHalfSlab)singleSlab.get()).getFullSlabName(var1.getItemDamage());
    }
}
