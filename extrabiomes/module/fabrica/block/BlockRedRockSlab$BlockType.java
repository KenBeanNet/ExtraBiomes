package extrabiomes.module.fabrica.block;

public enum BlockRedRockSlab$BlockType
{
    REDCOBBLE(0),
    REDROCK(1),
    REDROCKBRICK(2);
    private final int metadata;

    private BlockRedRockSlab$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }

    public String toString()
    {
        return this.name().toLowerCase();
    }
}
