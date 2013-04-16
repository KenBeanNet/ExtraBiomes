package extrabiomes.lib;

import com.google.common.base.Optional;
import net.minecraft.item.ItemStack;

public enum Element
{
    AUTUMN_SHRUB,
    CATTAIL,
    CRACKEDSAND,
    FLOWER_ORANGE,
    FLOWER_PURPLE,
    FLOWER_WHITE,
    GRASS_BROWN,
    GRASS_BROWN_SHORT,
    GRASS_DEAD,
    GRASS_DEAD_TALL,
    GRASS_DEAD_YELLOW,
    HYDRANGEA,
    LEAFPILE,
    LEAVES_ACACIA,
    LEAVES_AUTUMN_BROWN,
    LEAVES_AUTUMN_ORANGE,
    LEAVES_AUTUMN_PURPLE,
    LEAVES_AUTUMN_YELLOW,
    LEAVES_FIR,
    LEAVES_REDWOOD,
    LOG_ACACIA,
    LOG_FIR,
    LOG_HUGE_FIR_NE,
    LOG_HUGE_FIR_NW,
    LOG_HUGE_FIR_SE,
    LOG_HUGE_FIR_SW,
    LOG_HUGE_OAK_NE,
    LOG_HUGE_OAK_NW,
    LOG_HUGE_OAK_SE,
    LOG_HUGE_OAK_SW,
    LOG_HUGE_REDWOOD_NE,
    LOG_HUGE_REDWOOD_NW,
    LOG_HUGE_REDWOOD_SE,
    LOG_HUGE_REDWOOD_SW,
    LOGTURNER,
    RED_COBBLE,
    RED_ROCK,
    RED_ROCK_BRICK,
    ROOT,
    SAPLING_ACACIA,
    SAPLING_AUTUMN_BROWN,
    SAPLING_AUTUMN_ORANGE,
    SAPLING_AUTUMN_PURPLE,
    SAPLING_AUTUMN_YELLOW,
    SAPLING_FIR,
    SAPLING_REDWOOD,
    TINY_CACTUS,
    TOADSTOOL;
    private Optional stack = Optional.absent();

    public ItemStack get()
    {
        return (ItemStack)this.stack.get();
    }

    public boolean isPresent()
    {
        return this.stack.isPresent();
    }

    public void set(ItemStack var1)
    {
        this.stack = Optional.of(var1);
    }
}
