package extrabiomes.events;

import net.minecraft.block.Block;
import net.minecraftforge.event.Event;

public abstract class BlockActiveEvent extends Event
{
    public final Block block;

    protected BlockActiveEvent(Block var1)
    {
        this.block = var1;
    }
}
