package extrabiomes.blocks;

public enum BlockRedRock$BlockType
{
    RED_ROCK(0),
    RED_COBBLE(1),
    RED_ROCK_BRICK(2);
    private final int metadata;

    private BlockRedRock$BlockType(int var3)
    {
        this.metadata = var3;
    }

    public int metadata()
    {
        return this.metadata;
    }
}
