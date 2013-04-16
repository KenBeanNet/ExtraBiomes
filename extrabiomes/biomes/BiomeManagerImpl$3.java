package extrabiomes.biomes;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;

final class BiomeManagerImpl$3 extends WorldGenerator
{
    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        WorldGenShrub var6 = new WorldGenShrub(3, var2.nextInt(3));
        return var6.generate(var1, var2, var3, var4, var5);
    }
}
