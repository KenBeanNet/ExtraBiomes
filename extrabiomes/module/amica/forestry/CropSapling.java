package extrabiomes.module.amica.forestry;

import forestry.api.cultivation.ICropEntity;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class CropSapling implements ICropEntity
{
    private final World world;
    private final int x;
    private final int y;
    private final int z;
    private final int blockID;
    private final int metadata;

    public CropSapling(World var1, int var2, int var3, int var4)
    {
        this.world = var1;
        this.x = var2;
        this.y = var3;
        this.z = var4;
        this.blockID = var1.getBlockId(var2, var3, var4);
        this.metadata = var1.getBlockMetadata(var2, var3, var4);
    }

    public ArrayList doHarvest()
    {
        ArrayList var1 = Block.blocksList[this.blockID].getBlockDropped(this.world, this.x, this.y, this.z, this.metadata, 0);
        this.world.setBlockAndMetadataWithNotify(this.x, this.y, this.z, 0, 0);
        return var1;
    }

    public int[] getNextPosition()
    {
        int[] var1 = null;
        int var2 = 1;
        int var3;

        for (var3 = this.world.getBlockId(this.x, this.y + var2, this.z); Block.blocksList[var3] != null && Block.blocksList[var3].isWood(this.world, this.x, this.y + var2, this.z); var3 = this.world.getBlockId(this.x, this.y + var2, this.z))
        {
            var1 = new int[] {this.x, this.y + var2, this.z};
            ++var2;
        }

        if (var1 != null)
        {
            return var1;
        }
        else
        {
            var2 = -1;

            for (var3 = this.world.getBlockId(this.x, this.y + var2, this.z); Block.blocksList[var3] != null && Block.blocksList[var3].isWood(this.world, this.x, this.y + var2, this.z); var3 = this.world.getBlockId(this.x, this.y + var2, this.z))
            {
                var1 = new int[] {this.x, this.y + var2, this.z};
                --var2;
            }

            return var1;
        }
    }

    public boolean isHarvestable()
    {
        int var1 = this.world.getBlockId(this.x, this.y, this.z);
        return Block.blocksList[var1] != null && Block.blocksList[var1].isWood(this.world, this.x, this.y, this.z);
    }
}
