package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeIceWasteland extends ExtrabiomeGenBase
{
    public BiomeIceWasteland()
    {
        super(BiomeSettings.ICEWASTELAND.getID());
        this.spawnableCreatureList.clear();
        this.topBlock = (byte)Block.blockSnow.blockID;
        this.fillerBlock = (byte)Block.blockSnow.blockID;
        this.setEnableSnow();
        this.setColor(8233141);
        this.setBiomeName("Ice Wasteland");
        this.temperature = 0.0F;
        this.rainfall = 0.1F;
        this.minHeight = 0.3F;
        this.maxHeight = 0.4F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.ICEWASTELAND).build();
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
