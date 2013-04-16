package extrabiomes.blocks;

public enum BlockCustomTallGrass$BlockType
{
    BROWN(0),
    SHORT_BROWN(1),
    DEAD(2),
    DEAD_TALL(3),
    DEAD_YELLOW(4);
    private final int metadata;

    private BlockCustomTallGrass$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
