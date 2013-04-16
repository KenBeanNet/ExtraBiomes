package extrabiomes.module.summa.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MountainRidgeGenerator implements IWorldGenerator
{
    private static final WorldGenerator oasisGen = new WorldGenOasis();
    private static final WorldGenerator silverfishGen = new WorldGenMinable(Block.silverfish.blockID, 8);

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        BiomeGenBase var7 = var4.getBiomeGenForCoords(var2, var2);

        if (BiomeManager.mountainridge.isPresent() && var7 == BiomeManager.mountainridge.get())
        {
            this.trimPondsInGrass(var1, var2, var3, var4);
            this.generateEmeraldOre(var1, var2, var3, var4);
        }
    }

    private void generateEmeraldOre(Random var1, int var2, int var3, World var4)
    {
        int var5 = 3 + var1.nextInt(6);
        int var6;
        int var7;
        int var8;
        int var9;

        for (var6 = 0; var6 < var5; ++var6)
        {
            var7 = var2 + var1.nextInt(16);
            var8 = var1.nextInt(28) + 4;
            var9 = var3 + var1.nextInt(16);
            int var10 = var4.getBlockId(var7, var8, var9);

            if (var10 != 0 && Block.blocksList[var10].isGenMineableReplaceable(var4, var7, var8, var9))
            {
                var4.setBlock(var7, var8, var9, Block.oreEmerald.blockID);
            }
        }

        for (var6 = 0; var6 < 7; ++var6)
        {
            var7 = var2 + var1.nextInt(16);
            var8 = var1.nextInt(64);
            var9 = var3 + var1.nextInt(16);
            silverfishGen.generate(var4, var1, var7, var8, var9);
        }
    }

    private void trimPondsInGrass(Random var1, int var2, int var3, World var4)
    {
        for (int var5 = 0; var5 < 1000; ++var5)
        {
            int var6 = var2 + var1.nextInt(16) + 8;
            int var7 = var3 + var1.nextInt(16) + 8;
            int var8 = var4.getTopSolidOrLiquidBlock(var6, var7);
            oasisGen.generate(var4, var1, var6, var8, var7);
        }
    }
}
