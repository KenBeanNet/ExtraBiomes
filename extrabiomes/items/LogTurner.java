package extrabiomes.items;

import extrabiomes.Extrabiomes;
import extrabiomes.api.UseLogTurnerEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class LogTurner extends ItemTool
{
    public LogTurner(int var1)
    {
        super(var1, 1, EnumToolMaterial.WOOD, new Block[0]);
    }

    public boolean isDamageable()
    {
        return false;
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack var1)
    {
        return true;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10)
    {
        if (!var2.canPlayerEdit(var4, var5, var6, var7, var1))
        {
            return false;
        }
        else
        {
            UseLogTurnerEvent var11 = new UseLogTurnerEvent(var2, var1, var3, var4, var5, var6);

            if (Extrabiomes.proxy.postEventToBus(var11))
            {
                return false;
            }
            else if (var11.isHandled())
            {
                return true;
            }
            else
            {
                int var12 = var3.getBlockId(var4, var5, var6);

                if (var12 != Block.wood.blockID)
                {
                    return false;
                }
                else
                {
                    Block var13 = Block.wood;
                    var3.playSoundEffect((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var13.stepSound.getStepSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 1.55F);

                    if (!var3.isRemote)
                    {
                        int var14 = var3.getBlockMetadata(var4, var5, var6);
                        int var15 = var14 & 12;
                        int var16 = var14 & 3;
                        var15 = var15 == 0 ? 4 : (var15 == 4 ? 8 : 0);
                        var3.setBlockAndMetadata(var4, var5, var6, var12, var16 | var15);
                    }

                    return true;
                }
            }
        }
    }
}
