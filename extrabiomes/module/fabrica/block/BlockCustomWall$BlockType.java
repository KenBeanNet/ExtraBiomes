package extrabiomes.module.fabrica.block;

public enum BlockCustomWall$BlockType
{
    RED_COBBLE(0);
    private final int metadata;

    private BlockCustomWall$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
