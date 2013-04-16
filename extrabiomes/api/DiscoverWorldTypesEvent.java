package extrabiomes.api;

import java.util.Collection;
import net.minecraft.world.WorldType;
import net.minecraftforge.event.Event;

public class DiscoverWorldTypesEvent extends Event
{
    private final Collection worldTypes;

    public DiscoverWorldTypesEvent(Collection var1)
    {
        this.worldTypes = var1;
    }

    public boolean addWorldType(WorldType var1)
    {
        return this.worldTypes.contains(var1) ? false : this.worldTypes.add(var1);
    }
}
