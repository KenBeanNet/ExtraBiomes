package extrabiomes.biomes;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

final class BiomeManagerImpl$2 extends WorldGenerator
{
    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        WorldGenTrees var6 = new WorldGenTrees(false, 4 + var2.nextInt(7), 3, 3, true);
        return var6.generate(var1, var2, var3, var4, var5);
    }
}
