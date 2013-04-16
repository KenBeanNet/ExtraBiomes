package extrabiomes.module.summa.biome;

import net.minecraft.util.WeightedRandomItem;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WeightedWorldGenerator extends WeightedRandomItem
{
    private final WorldGenerator worldGen;

    public WeightedWorldGenerator(WorldGenerator var1, int var2)
    {
        super(var2);
        this.worldGen = var1;
    }

    public WorldGenerator getWorldGen()
    {
        return this.worldGen;
    }
}
