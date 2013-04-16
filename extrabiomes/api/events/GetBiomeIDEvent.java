package extrabiomes.api.events;

import net.minecraftforge.event.Event;

public class GetBiomeIDEvent extends Event
{
    public final String targetBiome;
    public int biomeID;

    public GetBiomeIDEvent(String var1)
    {
        this.targetBiome = var1;
    }
}
