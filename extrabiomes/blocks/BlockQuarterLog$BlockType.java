package extrabiomes.blocks;

public enum BlockQuarterLog$BlockType
{
    REDWOOD(0),
    FIR(1),
    OAK(2);
    private final int metadata;

    private BlockQuarterLog$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
