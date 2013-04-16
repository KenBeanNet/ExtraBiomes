package extrabiomes.module.summa.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWastelandGrass extends WorldGenerator
{
    private final int grassID;
    private final int grassMeta;

    public WorldGenWastelandGrass(int var1, int var2)
    {
        this.grassID = var1;
        this.grassMeta = var2;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        Block var6 = null;
        int var7 = 0;

        while (var7 < 128)
        {
            int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
            int var10 = var1.getHeightValue(var8, var9);

            while (true)
            {
                if (var10 > 0)
                {
                    var6 = Block.blocksList[var1.getBlockId(var8, var10, var9)];

                    if (var6 == null || !var6.isOpaqueCube())
                    {
                        --var10;
                        continue;
                    }
                }

                ++var10;

                if (var1.isAirBlock(var8, var10, var9) && Block.blocksList[this.grassID].canBlockStay(var1, var8, var10, var9))
                {
                    var1.setBlockAndMetadata(var8, var10, var9, this.grassID, this.grassMeta);
                }

                ++var7;
                break;
            }
        }

        return true;
    }
}
