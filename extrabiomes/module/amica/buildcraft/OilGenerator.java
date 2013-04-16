package extrabiomes.module.amica.buildcraft;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class OilGenerator implements IWorldGenerator
{
    private final BuildcraftAPI api;

    OilGenerator(BuildcraftAPI var1)
    {
        this.api = var1;
    }

    private void doPopulate(Random var1, World var2, int var3, int var4)
    {
        BiomeGenBase var5 = var2.getWorldChunkManager().getBiomeGenAt(var3, var4);

        if ((BiomeManager.mountaindesert.isPresent() && var5 == BiomeManager.mountaindesert.get() || BiomeManager.wasteland.isPresent() && var5 == BiomeManager.wasteland.get()) && (double)var1.nextFloat() > 0.97D)
        {
            int var6 = var1.nextInt(10) + 2;
            int var7 = var1.nextInt(10) + 2;

            for (int var8 = 128; var8 > 65; --var8)
            {
                int var9 = var6 + var3;
                int var10 = var7 + var4;
                int var11 = var2.getBlockId(var9, var8, var10);

                if (var11 != 0)
                {
                    if (var11 == Block.sand.blockID || BiomeManager.wasteland.isPresent() && (byte)var11 == ((BiomeGenBase)BiomeManager.wasteland.get()).topBlock)
                    {
                        this.api.generateSurfaceDeposit(var2, var1, var9, var8, var10, 3);
                    }

                    break;
                }
            }
        }
    }

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        this.doPopulate(var1, var4, var2, var3);
    }
}
