package extrabiomes.module.cautia.block;

import extrabiomes.Extrabiomes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

class BlockQuicksand extends Block
{
    BlockQuicksand(int var1)
    {
        super(var1, 1, Material.sand);
        this.setHardness(4.0F);
        this.setStepSound(Block.soundSandFootstep);
        this.setTextureFile("/extrabiomes/extrabiomes.png");
        this.setCreativeTab(Extrabiomes.tabsEBXL);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
    {
        return null;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return true;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5)
    {
        var5.setInWeb();
    }
}
