package extrabiomes.module.summa.biome;

import extrabiomes.module.summa.biome.CustomBiomeDecorator$1;
import extrabiomes.module.summa.biome.CustomBiomeDecorator$Builder;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

class CustomBiomeDecorator extends BiomeDecorator
{
    private CustomBiomeDecorator()
    {
        super((BiomeGenBase)null);
    }

    private CustomBiomeDecorator(CustomBiomeDecorator$Builder var1)
    {
        super(CustomBiomeDecorator$Builder.access$100(var1));
        this.waterlilyPerChunk = CustomBiomeDecorator$Builder.access$200(var1);
        this.treesPerChunk = CustomBiomeDecorator$Builder.access$300(var1);
        this.flowersPerChunk = CustomBiomeDecorator$Builder.access$400(var1);
        this.grassPerChunk = CustomBiomeDecorator$Builder.access$500(var1);
        this.deadBushPerChunk = CustomBiomeDecorator$Builder.access$600(var1);
        this.mushroomsPerChunk = CustomBiomeDecorator$Builder.access$700(var1);
        this.reedsPerChunk = CustomBiomeDecorator$Builder.access$800(var1);
        this.cactiPerChunk = CustomBiomeDecorator$Builder.access$900(var1);
        this.sandPerChunk = CustomBiomeDecorator$Builder.access$1000(var1);
        this.sandPerChunk2 = CustomBiomeDecorator$Builder.access$1100(var1);
        this.clayPerChunk = CustomBiomeDecorator$Builder.access$1200(var1);
        this.bigMushroomsPerChunk = CustomBiomeDecorator$Builder.access$1300(var1);
    }

    CustomBiomeDecorator(CustomBiomeDecorator$Builder var1, CustomBiomeDecorator$1 var2)
    {
        this(var1);
    }
}
