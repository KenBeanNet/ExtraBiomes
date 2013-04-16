package extrabiomes.proxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public int registerBlockHandler(ISimpleBlockRenderingHandler var1)
    {
        int var2 = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(var2, var1);
        return var2;
    }

    public void registerRenderInformation()
    {
        MinecraftForgeClient.preloadTexture("/extrabiomes/extrabiomes.png");
    }
}
