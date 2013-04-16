package extrabiomes.renderers;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class RenderQuarterLog implements ISimpleBlockRenderingHandler
{
    public int getRenderId()
    {
        return 0;
    }

    public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4)
    {
        Tessellator var5 = Tessellator.instance;

        if (var4.useInventoryTint)
        {
            int var6 = var1.getRenderColor(var2);
            float var7 = (float)(var6 >> 16 & 255) / 255.0F;
            float var8 = (float)(var6 >> 8 & 255) / 255.0F;
            float var9 = (float)(var6 & 255) / 255.0F;
            GL11.glColor4f(var7, var8, var9, 1.0F);
        }

        var1.setBlockBoundsForItemRender();
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        var5.startDrawingQuads();
        var5.setNormal(0.0F, -1.0F, 0.0F);
        var4.renderBottomFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(0, var2));
        var5.draw();
        var5.startDrawingQuads();
        var5.setNormal(0.0F, 1.0F, 0.0F);
        var4.renderTopFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(1, var2));
        var5.draw();
        var5.startDrawingQuads();
        var5.setNormal(0.0F, 0.0F, -1.0F);
        var4.renderEastFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(2, var2));
        var5.draw();
        var5.startDrawingQuads();
        var5.setNormal(0.0F, 0.0F, 1.0F);
        var4.renderWestFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(3, var2));
        var5.draw();
        var5.startDrawingQuads();
        var5.setNormal(-1.0F, 0.0F, 0.0F);
        var4.renderNorthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(4, var2));
        var5.draw();
        var5.startDrawingQuads();
        var5.setNormal(1.0F, 0.0F, 0.0F);
        var4.renderSouthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(5, var2));
        var5.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7)
    {
        int var8 = var1.getBlockMetadata(var2, var3, var4);
        int var9 = var8 & 12;

        if (var9 == 4)
        {
            var7.uvRotateEast = 1;
            var7.uvRotateWest = 1;
            var7.uvRotateTop = 1;
            var7.uvRotateBottom = 1;
        }
        else if (var9 == 8)
        {
            var7.uvRotateSouth = 1;
            var7.uvRotateNorth = 2;
        }

        boolean var10 = var7.renderStandardBlock(var5, var2, var3, var4);
        var7.uvRotateSouth = 0;
        var7.uvRotateEast = 0;
        var7.uvRotateWest = 0;
        var7.uvRotateNorth = 0;
        var7.uvRotateTop = 0;
        var7.uvRotateBottom = 0;
        return var10;
    }

    public boolean shouldRender3DInInventory()
    {
        return true;
    }
}
