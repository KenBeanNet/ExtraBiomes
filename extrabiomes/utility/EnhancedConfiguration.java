package extrabiomes.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class EnhancedConfiguration extends Configuration
{
    public static final String CATEGORY_BIOME = "biome";
    public static final String CATEGORY_DECORATION = "decoration";
    private final List assignedIdsList = new ArrayList();
    private final boolean[] configBiomes;

    public EnhancedConfiguration(File var1)
    {
        super(var1);
        this.configBiomes = new boolean[BiomeGenBase.biomeList.length];
    }

    public Property getBiome(String var1, int var2)
    {
        return this.getBiome("biome", var1, var2);
    }

    public Property getBiome(String var1, String var2, int var3)
    {
        Property var4 = this.get(var1, var2, -1);

        if (var4.getInt() != -1)
        {
            this.configBiomes[var4.getInt()] = true;
            return var4;
        }
        else if (BiomeGenBase.biomeList[var3] == null && !this.configBiomes[var3])
        {
            var4.value = Integer.toString(var3);
            this.configBiomes[var3] = true;
            return var4;
        }
        else
        {
            for (int var5 = this.configBiomes.length - 1; var5 > 0; --var5)
            {
                if (BiomeGenBase.biomeList[var5] == null && !this.configBiomes[var5])
                {
                    var4.value = Integer.toString(var5);
                    this.configBiomes[var5] = true;
                    return var4;
                }
            }

            throw new RuntimeException("No more biome ids available for " + var2);
        }
    }
}
