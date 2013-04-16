package extrabiomes.handlers;

import extrabiomes.blocks.BlockCustomSapling;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class SaplingBonemealEventHandler
{
    private final BlockCustomSapling sapling;

    public SaplingBonemealEventHandler(BlockCustomSapling var1)
    {
        this.sapling = var1;
    }

    @ForgeSubscribe
    public void onBonemealEvent(BonemealEvent var1)
    {
        if (var1.getResult() == Result.DEFAULT && var1.ID == this.sapling.blockID)
        {
            if (!var1.world.isRemote)
            {
                this.sapling.growTree(var1.world, var1.X, var1.Y, var1.Z, var1.world.rand);
            }

            var1.setResult(Result.ALLOW);
        }
    }
}
