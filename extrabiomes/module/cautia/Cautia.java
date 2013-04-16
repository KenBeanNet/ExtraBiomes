package extrabiomes.module.cautia;

import extrabiomes.events.ModuleEvent$ModuleInitEvent;
import extrabiomes.events.ModulePreInitEvent;
import extrabiomes.module.cautia.block.BlockManager;
import net.minecraftforge.event.ForgeSubscribe;

public class Cautia
{
    @ForgeSubscribe
    public void init(ModuleEvent$ModuleInitEvent var1) throws InstantiationException, IllegalAccessException
    {
        BlockManager.init();
    }

    @ForgeSubscribe
    public void preInit(ModulePreInitEvent var1) throws Exception
    {
        BlockManager.preInit();
    }
}
