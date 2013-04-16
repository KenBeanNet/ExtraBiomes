package extrabiomes.blocks;

import extrabiomes.utility.IDRestrictionAnnotation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@IDRestrictionAnnotation(
        maxIDRValue = 255
)
public class GenericTerrainBlock extends Block
{
    public GenericTerrainBlock(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
    }
}
