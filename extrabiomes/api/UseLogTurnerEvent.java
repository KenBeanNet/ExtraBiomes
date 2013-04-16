package extrabiomes.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class UseLogTurnerEvent extends PlayerEvent
{
    public final ItemStack current;
    public final World world;
    public final int x;
    public final int y;
    public final int z;
    private boolean handled = false;

    public UseLogTurnerEvent(EntityPlayer var1, ItemStack var2, World var3, int var4, int var5, int var6)
    {
        super(var1);
        this.current = var2;
        this.world = var3;
        this.x = var4;
        this.y = var5;
        this.z = var6;
    }

    public boolean isHandled()
    {
        return this.handled;
    }

    public void setHandled()
    {
        this.handled = true;
    }
}
