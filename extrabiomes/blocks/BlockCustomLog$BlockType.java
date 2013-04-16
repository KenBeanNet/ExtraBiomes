package extrabiomes.blocks;

public enum BlockCustomLog$BlockType
{
    FIR(0),
    ACACIA(1);
    private final int metadata;

    private BlockCustomLog$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
