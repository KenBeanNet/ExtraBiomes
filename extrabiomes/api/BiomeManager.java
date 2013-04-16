package extrabiomes.api;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import extrabiomes.api.BiomeManager$GenType;
import java.util.Collection;
import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

@Deprecated
public abstract class BiomeManager
{
    public static Optional alpine = Optional.absent();
    public static Optional autumnwoods = Optional.absent();
    public static Optional birchforest = Optional.absent();
    public static Optional extremejungle = Optional.absent();
    public static Optional forestedisland = Optional.absent();
    public static Optional forestedhills = Optional.absent();
    public static Optional glacier = Optional.absent();
    public static Optional greenhills = Optional.absent();
    public static Optional icewasteland = Optional.absent();
    public static Optional greenswamp = Optional.absent();
    public static Optional marsh = Optional.absent();
    public static Optional meadow = Optional.absent();
    public static Optional minijungle = Optional.absent();
    public static Optional mountaindesert = Optional.absent();
    public static Optional mountainridge = Optional.absent();
    public static Optional mountaintaiga = Optional.absent();
    public static Optional pineforest = Optional.absent();
    public static Optional rainforest = Optional.absent();
    public static Optional redwoodforest = Optional.absent();
    public static Optional redwoodlush = Optional.absent();
    public static Optional savanna = Optional.absent();
    public static Optional shrubland = Optional.absent();
    public static Optional snowforest = Optional.absent();
    public static Optional snowyrainforest = Optional.absent();
    public static Optional temperaterainforest = Optional.absent();
    public static Optional tundra = Optional.absent();
    public static Optional wasteland = Optional.absent();
    public static Optional woodlands = Optional.absent();
    protected static Optional instance = Optional.absent();

    public static void addWeightedGrassGenForBiome(BiomeGenBase var0, WorldGenerator var1, int var2)
    {
        Preconditions.checkArgument(instance.isPresent(), "Cannot add weighted grass gens until after API is initialized.");
        Preconditions.checkNotNull(var0, "Biome is required.");
        Preconditions.checkNotNull(var1, "Grass generator is required.");
        Preconditions.checkArgument(var2 > 0, "Weight must be greater than zero.");
        ((BiomeManager)instance.get()).addBiomeGen(BiomeManager$GenType.GRASS, var0, var1, var2);
    }

    public static void addWeightedTreeGenForBiome(BiomeGenBase var0, WorldGenerator var1, int var2)
    {
        Preconditions.checkArgument(instance.isPresent(), "Cannot add weighted tree gens until after API is initialized.");
        Preconditions.checkNotNull(var0, "Biome is required.");
        Preconditions.checkNotNull(var1, "Tree Generator is required.");
        Preconditions.checkArgument(var2 > 0, "Weight must be greater than zero.");
        ((BiomeManager)instance.get()).addBiomeGen(BiomeManager$GenType.TREE, var0, var1, var2);
    }

    public static Optional chooseRandomGrassGenforBiome(Random var0, BiomeGenBase var1)
    {
        return ((BiomeManager)instance.get()).chooseBiomeRandomGen(BiomeManager$GenType.GRASS, var0, var1);
    }

    public static Optional chooseRandomTreeGenforBiome(Random var0, BiomeGenBase var1)
    {
        return ((BiomeManager)instance.get()).chooseBiomeRandomGen(BiomeManager$GenType.TREE, var0, var1);
    }

    public static Collection getBiomes()
    {
        Preconditions.checkArgument(instance.isPresent(), "Biome list not available until after API is initialized.");
        return ((BiomeManager)instance.get()).getBiomeCollection();
    }

    public static int getTotalGrassWeightForBiome(BiomeGenBase var0)
    {
        Preconditions.checkNotNull(var0, "Biome is required.");
        return ((BiomeManager)instance.get()).getBiomeTotalWeight(BiomeManager$GenType.GRASS, var0);
    }

    public static int getTotalTreeWeightForBiome(BiomeGenBase var0)
    {
        Preconditions.checkNotNull(var0, "Biome is required.");
        return ((BiomeManager)instance.get()).getBiomeTotalWeight(BiomeManager$GenType.TREE, var0);
    }

    static boolean isActive()
    {
        return instance.isPresent();
    }

    protected abstract void addBiomeGen(BiomeManager$GenType var1, BiomeGenBase var2, WorldGenerator var3, int var4);

    protected abstract Optional chooseBiomeRandomGen(BiomeManager$GenType var1, Random var2, BiomeGenBase var3);

    protected abstract Collection getBiomeCollection();

    protected abstract int getBiomeTotalWeight(BiomeManager$GenType var1, BiomeGenBase var2);
}
