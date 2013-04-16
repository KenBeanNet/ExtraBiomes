package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGlacier extends ExtrabiomeGenBase
{
    public BiomeGlacier()
    {
        super(BiomeSettings.GLACIER.getID());
        this.spawnableCreatureList.clear();
        this.topBlock = (byte)Block.blockSnow.blockID;
        this.fillerBlock = (byte)Block.ice.blockID;
        this.setColor(7841430);
        this.setBiomeName("Glacier");
        this.setEnableSnow();
        this.temperature = 0.0F;
        this.rainfall = 0.0F;
        this.minHeight = 1.4F;
        this.maxHeight = 2.1F;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        return super.getRandomWorldGenForTrees(var1);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random var1)
    {
        return super.getRandomWorldGenForGrass(var1);
    }
}
