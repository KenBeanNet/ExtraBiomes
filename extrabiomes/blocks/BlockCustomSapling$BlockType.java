package extrabiomes.blocks;

public enum BlockCustomSapling$BlockType
{
    BROWN(0),
    ORANGE(1),
    PURPLE(2),
    YELLOW(3),
    FIR(4),
    REDWOOD(5),
    ACACIA(6);
    private final int metadata;

    private BlockCustomSapling$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
