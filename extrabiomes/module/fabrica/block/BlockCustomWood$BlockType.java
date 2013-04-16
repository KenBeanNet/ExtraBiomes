package extrabiomes.module.fabrica.block;

public enum BlockCustomWood$BlockType
{
    REDWOOD(0),
    FIR(1),
    ACACIA(2);
    private final int metadata;

    private BlockCustomWood$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
