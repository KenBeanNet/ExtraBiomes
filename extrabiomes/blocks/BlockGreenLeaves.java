package extrabiomes.blocks;

import com.google.common.base.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.Extrabiomes;
import extrabiomes.blocks.BlockGreenLeaves$BlockType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockGreenLeaves extends BlockLeavesBase implements IShearable
{
    private static final int METADATA_BITMASK = 3;
    private static final int METADATA_USERPLACEDBIT = 4;
    private static final int METADATA_DECAYBIT = 8;
    private static final int METADATA_CLEARDECAYBIT = -9;
    int[] adjacentTreeBlocks;

    private static int calcSmoothedBiomeFoliageColor(IBlockAccess var0, int var1, int var2)
    {
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;

        for (int var6 = -1; var6 <= 1; ++var6)
        {
            for (int var7 = -1; var7 <= 1; ++var7)
            {
                int var8 = var0.getBiomeGenForCoords(var1 + var7, var2 + var6).getBiomeFoliageColor();
                var3 += (var8 & 16711680) >> 16;
                var4 += (var8 & 65280) >> 8;
                var5 += var8 & 255;
            }
        }

        return (var3 / 9 & 255) << 16 | (var4 / 9 & 255) << 8 | var5 / 9 & 255;
    }

    private static int clearDecayOnMetadata(int var0)
    {
        return var0 & -9;
    }

    private static boolean isDecaying(int var0)
    {
        return (var0 & 8) != 0;
    }

    private static boolean isUserPlaced(int var0)
    {
        return (var0 & 4) != 0;
    }

    private static int setDecayOnMetadata(int var0)
    {
        return var0 | 8;
    }

    private static int unmarkedMetadata(int var0)
    {
        return var0 & 3;
    }

    public BlockGreenLeaves(int var1, int var2, Material var3, boolean var4)
    {
        super(var1, var2, var3, var4);
    }

    public void beginLeavesDecay(World var1, int var2, int var3, int var4)
    {
        var1.setBlockMetadata(var2, var3, var4, setDecayOnMetadata(var1.getBlockMetadata(var2, var3, var4)));
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        boolean var7 = true;
        boolean var8 = true;

        if (var1.checkChunksExist(var2 - 2, var3 - 2, var4 - 2, var2 + 2, var3 + 2, var4 + 2))
        {
            for (int var9 = -1; var9 <= 1; ++var9)
            {
                for (int var10 = -1; var10 <= 1; ++var10)
                {
                    for (int var11 = -1; var11 <= 1; ++var11)
                    {
                        int var12 = var1.getBlockId(var2 + var9, var3 + var10, var4 + var11);

                        if (Block.blocksList[var12] != null)
                        {
                            Block.blocksList[var12].beginLeavesDecay(var1, var2 + var9, var3 + var10, var4 + var11);
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess var1, int var2, int var3, int var4)
    {
        int var5 = unmarkedMetadata(var1.getBlockMetadata(var2, var3, var4));
        return var5 != BlockGreenLeaves$BlockType.REDWOOD.metadata() ? this.getRenderColor(var5) : calcSmoothedBiomeFoliageColor(var1, var2, var4);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1)
    {
        Optional var2 = Optional.fromNullable(BlockGreenLeaves$BlockType.fromMetadata(var1));
        return var2.isPresent() ? ((BlockGreenLeaves$BlockType)var2.get()).getSaplingMetadata() : 0;
    }

    private void doSaplingDrop(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        int var7 = this.idDropped(var5, var1.rand, var6);
        int var8 = this.damageDropped(var5);
        this.dropBlockAsItem_do(var1, var2, var3, var4, new ItemStack(var7, 1, var8));
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6, int var7)
    {
        if (!var1.isRemote)
        {
            if (var1.rand.nextInt(20) == 0)
            {
                this.doSaplingDrop(var1, var2, var3, var4, var5, var7);
            }
        }
    }

    public int getBlockColor()
    {
        return ColorizerFoliage.getFoliageColor(0.5D, 1.0D);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        var2 = unmarkedMetadata(var2);

        if (var2 > 2)
        {
            var2 = 0;
        }

        return this.blockIndexInTexture + unmarkedMetadata(var2) * 2 + (!this.isOpaqueCube() ? 0 : 1);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World var1, int var2, int var3, int var4)
    {
        return unmarkedMetadata(var1.getBlockMetadata(var2, var3, var4));
    }

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int var1)
    {
        var1 = unmarkedMetadata(var1);
        return var1 == 0 ? ColorizerFoliage.getFoliageColorPine() : (var1 == 1 ? ColorizerFoliage.getFoliageColorBasic() : ColorizerFoliage.getFoliageColor(0.8999999761581421D, 0.10000000149011612D));
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        if (var2 == Extrabiomes.tabsEBXL)
        {
            BlockGreenLeaves$BlockType[] var4 = BlockGreenLeaves$BlockType.values();
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                BlockGreenLeaves$BlockType var7 = var4[var6];
                var3.add(new ItemStack(this, 1, var7.metadata()));
            }
        }
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6)
    {
        super.harvestBlock(var1, var2, var3, var4, var5, var6);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        Optional var4 = Optional.fromNullable(BlockGreenLeaves$BlockType.fromMetadata(var1));
        return var4.isPresent() ? ((BlockGreenLeaves$BlockType)var4.get()).getSaplingID() : Block.sapling.blockID;
    }

    public boolean isLeaves(World var1, int var2, int var3, int var4)
    {
        return true;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return Block.leaves.isOpaqueCube();
    }

    public boolean isShearable(ItemStack var1, World var2, int var3, int var4, int var5)
    {
        return true;
    }

    /**
     * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
     */
    public void onEntityWalking(World var1, int var2, int var3, int var4, Entity var5)
    {
        this.beginLeavesDecay(var1, var2, var3, var4);
    }

    public ArrayList onSheared(ItemStack var1, World var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        var7.add(new ItemStack(this, 1, unmarkedMetadata(var2.getBlockMetadata(var3, var4, var5))));
        return var7;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return var1.nextInt(20) == 0 ? 1 : 0;
    }

    private void removeLeaves(World var1, int var2, int var3, int var4)
    {
        this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
        var1.setBlockWithNotify(var2, var3, var4, 0);
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5)
    {
        this.graphicsLevel = !Block.leaves.isOpaqueCube();
        return super.shouldSideBeRendered(var1, var2, var3, var4, var5);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (!var1.isRemote)
        {
            int var6 = var1.getBlockMetadata(var2, var3, var4);

            if (!isUserPlaced(var6) && isDecaying(var6))
            {
                boolean var7 = true;
                boolean var8 = true;
                boolean var9 = true;
                boolean var10 = true;
                boolean var11 = true;

                if (this.adjacentTreeBlocks == null)
                {
                    this.adjacentTreeBlocks = new int[32768];
                }

                if (var1.checkChunksExist(var2 - 7, var3 - 7, var4 - 7, var2 + 7, var3 + 7, var4 + 7))
                {
                    int var12;
                    int var13;
                    int var14;
                    int var15;

                    for (var12 = -6; var12 <= 6; ++var12)
                    {
                        for (var13 = -6; var13 <= 6; ++var13)
                        {
                            for (var14 = -6; var14 <= 6; ++var14)
                            {
                                var15 = var1.getBlockId(var2 + var12, var3 + var13, var4 + var14);
                                Block var16 = Block.blocksList[var15];

                                if (var16 != null && var16.canSustainLeaves(var1, var2 + var12, var3 + var13, var4 + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = 0;
                                }
                                else if (var16 != null && var16.isLeaves(var1, var2 + var12, var3 + var13, var4 + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = -2;
                                }
                                else
                                {
                                    this.adjacentTreeBlocks[(var12 + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = -1;
                                }
                            }
                        }
                    }

                    for (var12 = 1; var12 <= 4; ++var12)
                    {
                        for (var13 = -6; var13 <= 6; ++var13)
                        {
                            for (var14 = -6; var14 <= 6; ++var14)
                            {
                                for (var15 = -6; var15 <= 6; ++var15)
                                {
                                    if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16] == var12 - 1)
                                    {
                                        if (this.adjacentTreeBlocks[(var13 + 16 - 1) * 1024 + (var14 + 16) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16 - 1) * 1024 + (var14 + 16) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16 + 1) * 1024 + (var14 + 16) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16 + 1) * 1024 + (var14 + 16) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 - 1) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 - 1) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 + 1) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 + 1) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 - 1] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 - 1] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 + 1] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 + 1] = var12;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (this.adjacentTreeBlocks[16912] >= 0)
                {
                    var1.setBlockMetadata(var2, var3, var4, clearDecayOnMetadata(var6));
                }
                else
                {
                    this.removeLeaves(var1, var2, var3, var4);
                }
            }
        }
    }

    static int access$000(int var0)
    {
        return unmarkedMetadata(var0);
    }
}
