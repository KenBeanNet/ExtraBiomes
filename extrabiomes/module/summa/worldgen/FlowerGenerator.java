package extrabiomes.module.summa.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.api.BiomeManager;
import extrabiomes.blocks.BlockCustomFlower$BlockType;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class FlowerGenerator implements IWorldGenerator
{
    private final WorldGenerator autumnShrubGen;
    private final WorldGenerator hydrangeaGen;
    private final WorldGenerator orangeGen;
    private final WorldGenerator purpleGen;
    private final WorldGenerator rootGen;
    private final WorldGenerator tinyCactusGen;
    private final WorldGenerator toadStoolGen;
    private final WorldGenerator whiteGen;

    public FlowerGenerator(int var1)
    {
        this.autumnShrubGen = new WorldGenMetadataFlowers(var1, BlockCustomFlower$BlockType.AUTUMN_SHRUB.metadata());
        this.hydrangeaGen = new WorldGenMetadataFlowers(var1, BlockCustomFlower$BlockType.HYDRANGEA.metadata());
        this.orangeGen = new WorldGenMetadataFlowers(var1, BlockCustomFlower$BlockType.ORANGE.metadata());
        this.purpleGen = new WorldGenMetadataFlowers(var1, BlockCustomFlower$BlockType.PURPLE.metadata());
        this.rootGen = new WorldGenRoot(var1, BlockCustomFlower$BlockType.ROOT.metadata());
        this.tinyCactusGen = new WorldGenTinyCactus(var1, BlockCustomFlower$BlockType.TINY_CACTUS.metadata());
        this.toadStoolGen = new WorldGenMetadataFlowers(var1, BlockCustomFlower$BlockType.TOADSTOOL.metadata());
        this.whiteGen = new WorldGenMetadataFlowers(var1, BlockCustomFlower$BlockType.WHITE.metadata());
    }

    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        var2 <<= 4;
        var3 <<= 4;
        BiomeGenBase var7 = var4.getBiomeGenForCoords(var2, var2);
        int var8;
        int var9;
        int var10;
        int var11;

        if (BiomeManager.autumnwoods.isPresent() && var7 == BiomeManager.autumnwoods.get())
        {
            for (var8 = 0; var8 < 2; ++var8)
            {
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.autumnShrubGen.generate(var4, var1, var9, var10, var11);
            }
        }

        if (BiomeManager.autumnwoods.isPresent() && var7 == BiomeManager.autumnwoods.get() || BiomeManager.snowyrainforest.isPresent() && var7 == BiomeManager.snowyrainforest.get() || BiomeManager.temperaterainforest.isPresent() && var7 == BiomeManager.temperaterainforest.get() || BiomeManager.tundra.isPresent() && var7 == BiomeManager.tundra.get())
        {
            for (var8 = 0; var8 < 2; ++var8)
            {
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.toadStoolGen.generate(var4, var1, var9, var10, var11);
            }
        }

        if (BiomeManager.greenhills.isPresent() && var7 == BiomeManager.greenhills.get())
        {
            for (var8 = 0; var8 < 3; ++var8)
            {
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.orangeGen.generate(var4, var1, var9, var10, var11);
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.whiteGen.generate(var4, var1, var9, var10, var11);
            }
        }

        if (BiomeManager.greenswamp.isPresent() && var7 == BiomeManager.greenswamp.get())
        {
            var8 = var2 + var1.nextInt(16) + 8;
            var9 = var1.nextInt(128);
            var10 = var3 + var1.nextInt(16) + 8;
            this.hydrangeaGen.generate(var4, var1, var8, var9, var10);
        }

        if (BiomeManager.greenswamp.isPresent() && var7 == BiomeManager.greenswamp.get() || BiomeManager.redwoodlush.isPresent() && var7 == BiomeManager.redwoodlush.get())
        {
            for (var8 = 0; var8 < 5; ++var8)
            {
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.rootGen.generate(var4, var1, var9, var10, var11);
            }
        }

        if (BiomeManager.mountainridge.isPresent() && var7 == BiomeManager.mountainridge.get())
        {
            for (var8 = 0; var8 < 50; ++var8)
            {
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.tinyCactusGen.generate(var4, var1, var9, var10, var11);
            }

            for (var8 = 0; var8 < 12; ++var8)
            {
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.tinyCactusGen.generate(var4, var1, var9, var10, var11);
            }
        }

        if (BiomeManager.savanna.isPresent() && var7 == BiomeManager.savanna.get())
        {
            for (var8 = 0; var8 < 15; ++var8)
            {
                var9 = var2 + var1.nextInt(16) + 8;
                var10 = var1.nextInt(128);
                var11 = var3 + var1.nextInt(16) + 8;
                this.purpleGen.generate(var4, var1, var9, var10, var11);
            }
        }
    }
}
