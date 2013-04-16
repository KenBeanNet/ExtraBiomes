package extrabiomes.module.fabrica.block;

import extrabiomes.Extrabiomes;
import net.minecraft.block.Block;

public class BlockWoodStairs extends BlockCustomStairs
{
    public BlockWoodStairs(int var1, Block var2, int var3)
    {
        super(var1, var2, var3);
        setBurnProperties(this.blockID, 5, 20);
        this.setCreativeTab(Extrabiomes.tabsEBXL);
    }
}
