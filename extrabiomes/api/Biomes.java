package extrabiomes.api;

import com.google.common.base.Optional;
import extrabiomes.api.events.GetBiomeIDEvent;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class Biomes
{
    public static Optional getBiome(String var0)
    {
        GetBiomeIDEvent var1 = new GetBiomeIDEvent(var0);
        Api.getExtrabiomesXLEventBus().post(var1);
        return var1.biomeID <= 0 ? Optional.absent() : Optional.of(BiomeGenBase.biomeList[var1.biomeID]);
    }
}
