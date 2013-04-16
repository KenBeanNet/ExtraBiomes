package extrabiomes.module.summa.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

class WorldGenMetadataFlowers extends WorldGenerator
{
    private final int blockId;
    private final int metadata;

    WorldGenMetadataFlowers(int var1, int var2)
    {
        this.blockId = var1;
        this.metadata = var2;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        for (int var6 = 0; var6 < 64; ++var6)
        {
            int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);

            if (var1.isAirBlock(var7, var8, var9) && Block.blocksList[this.blockId].canBlockStay(var1, var7, var8, var9))
            {
                var1.setBlockAndMetadata(var7, var8, var9, this.blockId, this.metadata);
            }
        }

        return true;
    }
}
