package extrabiomes.module.amica.ic2;

import com.google.common.base.Optional;
import java.lang.reflect.Method;
import net.minecraft.world.biome.BiomeGenBase;

class IC2API
{
    private Optional addBiomeBonus = Optional.absent();

    IC2API()
    {
        try
        {
            Class var1 = Class.forName("ic2.api.Crops");
            this.addBiomeBonus = Optional.fromNullable(var1.getMethod("addBiomeBonus", new Class[] {BiomeGenBase.class, Integer.TYPE, Integer.TYPE}));
        }
        catch (Exception var3)
        {
            var3.printStackTrace();
            this.addBiomeBonus = Optional.absent();
        }
    }

    void addBiomeBonus(BiomeGenBase var1, int var2, int var3)
    {
        try
        {
            ((Method)this.addBiomeBonus.get()).invoke((Object)null, new Object[] {var1, Integer.valueOf(var2), Integer.valueOf(var3)});
        }
        catch (IllegalStateException var5)
        {
            ;
        }
        catch (Exception var6)
        {
            var6.printStackTrace();
        }
    }

    void addBiomeBonus(Optional var1, int var2, int var3)
    {
        if (var1.isPresent())
        {
            this.addBiomeBonus((BiomeGenBase)var1.get(), var2, var3);
        }
    }
}
