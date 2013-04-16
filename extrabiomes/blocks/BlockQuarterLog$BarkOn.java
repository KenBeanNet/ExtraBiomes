package extrabiomes.blocks;

public enum BlockQuarterLog$BarkOn
{
    SW,
    SE,
    NW,
    NE;
    private int blockID;

    static int access$002(BlockQuarterLog$BarkOn var0, int var1)
    {
        return var0.blockID = var1;
    }

    static int access$000(BlockQuarterLog$BarkOn var0)
    {
        return var0.blockID;
    }
}
