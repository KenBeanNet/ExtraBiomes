package extrabiomes.module.summa.biome;

import extrabiomes.lib.DecorationSettings;
import extrabiomes.lib.DecorationSettings$Decoration;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$1;
import java.util.Map;
import net.minecraft.world.biome.BiomeGenBase;

class CustomBiomeDecorator$Builder
{
    private final BiomeGenBase biome;
    private int waterlilyPerChunk = 0;
    private int treesPerChunk = 0;
    private int flowersPerChunk = 2;
    private int grassPerChunk = 1;
    private int deadBushPerChunk = 0;
    private int mushroomsPerChunk = 0;
    private int reedsPerChunk = 0;
    private int cactiPerChunk = 0;
    private int sandPerChunk = 1;
    private int sandPerChunk2 = 3;
    private int clayPerChunk = 1;
    private int bigMushroomsPerChunk = 0;

    CustomBiomeDecorator$Builder(BiomeGenBase var1)
    {
        this.biome = var1;
    }

    CustomBiomeDecorator$Builder loadSettings(DecorationSettings var1)
    {
        Map var2 = var1.getSettings();

        if (var2.containsKey(DecorationSettings$Decoration.BIGMUSHROOMS))
        {
            this.bigMushroomsPerChunk(((Integer)var2.get(DecorationSettings$Decoration.BIGMUSHROOMS)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.CACTI))
        {
            this.cactiPerChunk(((Integer)var2.get(DecorationSettings$Decoration.CACTI)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.CLAY))
        {
            this.clayPerChunk(((Integer)var2.get(DecorationSettings$Decoration.CLAY)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.DEADBUSH))
        {
            this.deadBushPerChunk(((Integer)var2.get(DecorationSettings$Decoration.DEADBUSH)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.FLOWERS))
        {
            this.flowersPerChunk(((Integer)var2.get(DecorationSettings$Decoration.FLOWERS)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.GRASS))
        {
            this.grassPerChunk(((Integer)var2.get(DecorationSettings$Decoration.GRASS)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.MUSHROOMS))
        {
            this.mushroomsPerChunk(((Integer)var2.get(DecorationSettings$Decoration.MUSHROOMS)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.REEDS))
        {
            this.reedsPerChunk(((Integer)var2.get(DecorationSettings$Decoration.REEDS)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.SAND) && var2.containsKey(DecorationSettings$Decoration.SAND2))
        {
            this.sandPerChunk(((Integer)var2.get(DecorationSettings$Decoration.SAND)).intValue(), ((Integer)var2.get(DecorationSettings$Decoration.SAND2)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.TREES))
        {
            this.treesPerChunk(((Integer)var2.get(DecorationSettings$Decoration.TREES)).intValue());
        }

        if (var2.containsKey(DecorationSettings$Decoration.WATERLILY))
        {
            this.waterlilyPerChunk(((Integer)var2.get(DecorationSettings$Decoration.WATERLILY)).intValue());
        }

        return this;
    }

    CustomBiomeDecorator$Builder bigMushroomsPerChunk(int var1)
    {
        this.bigMushroomsPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator build()
    {
        return new CustomBiomeDecorator(this, (CustomBiomeDecorator$1)null);
    }

    CustomBiomeDecorator$Builder cactiPerChunk(int var1)
    {
        this.cactiPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder clayPerChunk(int var1)
    {
        this.clayPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder deadBushPerChunk(int var1)
    {
        this.deadBushPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder flowersPerChunk(int var1)
    {
        this.flowersPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder grassPerChunk(int var1)
    {
        this.grassPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder mushroomsPerChunk(int var1)
    {
        this.mushroomsPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder reedsPerChunk(int var1)
    {
        this.reedsPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder sandPerChunk(int var1, int var2)
    {
        this.sandPerChunk = var1;
        this.sandPerChunk2 = var2;
        return this;
    }

    CustomBiomeDecorator$Builder treesPerChunk(int var1)
    {
        this.treesPerChunk = var1;
        return this;
    }

    CustomBiomeDecorator$Builder waterlilyPerChunk(int var1)
    {
        this.waterlilyPerChunk = var1;
        return this;
    }

    static BiomeGenBase access$100(CustomBiomeDecorator$Builder var0)
    {
        return var0.biome;
    }

    static int access$200(CustomBiomeDecorator$Builder var0)
    {
        return var0.waterlilyPerChunk;
    }

    static int access$300(CustomBiomeDecorator$Builder var0)
    {
        return var0.treesPerChunk;
    }

    static int access$400(CustomBiomeDecorator$Builder var0)
    {
        return var0.flowersPerChunk;
    }

    static int access$500(CustomBiomeDecorator$Builder var0)
    {
        return var0.grassPerChunk;
    }

    static int access$600(CustomBiomeDecorator$Builder var0)
    {
        return var0.deadBushPerChunk;
    }

    static int access$700(CustomBiomeDecorator$Builder var0)
    {
        return var0.mushroomsPerChunk;
    }

    static int access$800(CustomBiomeDecorator$Builder var0)
    {
        return var0.reedsPerChunk;
    }

    static int access$900(CustomBiomeDecorator$Builder var0)
    {
        return var0.cactiPerChunk;
    }

    static int access$1000(CustomBiomeDecorator$Builder var0)
    {
        return var0.sandPerChunk;
    }

    static int access$1100(CustomBiomeDecorator$Builder var0)
    {
        return var0.sandPerChunk2;
    }

    static int access$1200(CustomBiomeDecorator$Builder var0)
    {
        return var0.clayPerChunk;
    }

    static int access$1300(CustomBiomeDecorator$Builder var0)
    {
        return var0.bigMushroomsPerChunk;
    }
}
