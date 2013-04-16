package extrabiomes.module.fabrica.block;

import extrabiomes.Extrabiomes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockCustomStairs extends BlockStairs
{
    public BlockCustomStairs(int var1, Block var2, int var3)
    {
        super(var1, var2, var3);
        this.setRequiresSelfNotify();
        this.setTextureFile("/extrabiomes/extrabiomes.png");
        this.setLightOpacity(0);
        this.setCreativeTab(Extrabiomes.tabsEBXL);
    }
}
