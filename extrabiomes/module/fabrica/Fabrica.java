package extrabiomes.module.fabrica;

import com.google.common.base.Optional;
import extrabiomes.Extrabiomes;
import extrabiomes.api.Stuff;
import extrabiomes.events.ModuleEvent$ModuleInitEvent;
import extrabiomes.events.ModulePreInitEvent;
import extrabiomes.lib.Element;
import extrabiomes.lib.ItemSettings;
import extrabiomes.module.fabrica.block.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Fabrica
{
    private int pasteID = 0;

    @ForgeSubscribe(
            priority = EventPriority.LOW
    )
    public void init(ModuleEvent$ModuleInitEvent var1) throws InstantiationException, IllegalAccessException
    {
        BlockManager.init();

        if (this.pasteID > 0)
        {
            Stuff.paste = Optional.of((new Item(this.pasteID)).setItemName("extrabiomes.paste").setIconIndex(111).setCreativeTab(Extrabiomes.tabsEBXL).setTextureFile("/extrabiomes/extrabiomes.png"));

            if (Element.TINY_CACTUS.isPresent())
            {
                ShapelessOreRecipe var4 = new ShapelessOreRecipe((Item)Stuff.paste.get(), new Object[] {Block.cactus});
                Extrabiomes.proxy.addRecipe(var4);
                var4 = new ShapelessOreRecipe((Item)Stuff.paste.get(), new Object[] {Element.TINY_CACTUS.get(), Element.TINY_CACTUS.get(), Element.TINY_CACTUS.get(), Element.TINY_CACTUS.get()});
                Extrabiomes.proxy.addRecipe(var4);
                Extrabiomes.proxy.addSmelting(((Item)Stuff.paste.get()).itemID, 0, new ItemStack(Item.dyePowder, 1, 2), 0.2F);
            }
        }
    }

    @ForgeSubscribe(
            priority = EventPriority.LOW
    )
    public void preInit(ModulePreInitEvent var1) throws Exception
    {
        BlockManager.preInit();
        this.pasteID = ItemSettings.PASTE.getID();

    }
}
