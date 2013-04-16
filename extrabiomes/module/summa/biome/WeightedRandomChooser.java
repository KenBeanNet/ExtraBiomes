package extrabiomes.module.summa.biome;

import com.google.common.base.Optional;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.util.WeightedRandomItem;

public enum WeightedRandomChooser
{
    INSTANCE;

    public static Optional getRandomItem(Random var0, Collection var1)
    {
        return getRandomItem(var0, var1, getTotalWeight(var1));
    }

    static Optional getRandomItem(Random var0, Collection var1, int var2)
    {
        if (var2 > 0)
        {
            int var3 = var0.nextInt(var2);
            Iterator var4 = var1.iterator();

            while (var4.hasNext())
            {
                WeightedRandomItem var5 = (WeightedRandomItem)var4.next();
                var3 -= var5.itemWeight;

                if (var3 < 0)
                {
                    return Optional.of(var5);
                }
            }
        }

        return Optional.absent();
    }

    public static int getTotalWeight(Collection var0)
    {
        int var1 = 0;
        WeightedRandomItem var3;

        for (Iterator var2 = var0.iterator(); var2.hasNext(); var1 += var3.itemWeight)
        {
            var3 = (WeightedRandomItem)var2.next();
        }

        return var1;
    }
}
