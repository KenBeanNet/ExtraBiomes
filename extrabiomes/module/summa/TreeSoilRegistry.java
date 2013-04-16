package extrabiomes.module.summa;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;

public enum TreeSoilRegistry
{
    INSTANCE;
    private static final List validSoil = new ArrayList();

    public static void addValidSoil(Block var0)
    {
        validSoil.add(var0);
    }

    public static boolean isValidSoil(Block var0)
    {
        return validSoil.contains(var0);
    }

    public static boolean isValidSoil(int var0)
    {
        return isValidSoil(Block.blocksList[var0]);
    }

    static {
        addValidSoil(Block.grass);
        addValidSoil(Block.dirt);
        addValidSoil(Block.tilledField);
    }
}
