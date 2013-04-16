package extrabiomes.module.summa.biome;

import extrabiomes.lib.BiomeSettings;
import extrabiomes.lib.DecorationSettings;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeAlpine extends ExtrabiomeGenBase
{
    public BiomeAlpine()
    {
        super(BiomeSettings.ALPINE.getID());
        this.topBlock = (byte)Block.stone.blockID;
        this.fillerBlock = (byte)Block.stone.blockID;
        this.setColor(9284804);
        this.setEnableSnow();
        this.setBiomeName("Alpine");
        this.temperature = 0.0F;
        this.rainfall = 0.1F;
        this.minHeight = 1.3F;
        this.maxHeight = 2.1F;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return (new CustomBiomeDecorator$Builder(this)).loadSettings(DecorationSettings.ALPINE).build();
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
