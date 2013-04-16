package extrabiomes.blocks;

public enum BlockCustomFlower$BlockType
{
    AUTUMN_SHRUB(0),
    HYDRANGEA(1),
    ORANGE(2),
    PURPLE(3),
    TINY_CACTUS(4),
    ROOT(5),
    TOADSTOOL(6),
    WHITE(7);
    private final int metadata;

    private BlockCustomFlower$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
