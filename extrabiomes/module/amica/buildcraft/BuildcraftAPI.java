package extrabiomes.module.amica.buildcraft;

import com.google.common.base.Optional;
import extrabiomes.helpers.LogHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import net.minecraft.world.World;

public class BuildcraftAPI
{
    private boolean modifyWorld = false;
    private static Optional generateSurfaceDeposit = Optional.absent();
    boolean useRandom = false;

    BuildcraftAPI()
    {
        Class var1;

        try
        {
            var1 = Class.forName("buildcraft.BuildCraftCore");
            Field var2 = var1.getField("modifyWorld");
            this.modifyWorld = var2.getBoolean((Object)null);
        }
        catch (Exception var6)
        {
            var6.printStackTrace();
        }

        try
        {
            var1 = Class.forName("buildcraft.energy.OilPopulate");
            generateSurfaceDeposit = Optional.fromNullable(var1.getMethod("generateSurfaceDeposit", new Class[] {World.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
        }
        catch (Exception var5)
        {
            try
            {
                var1 = Class.forName("buildcraft.energy.OilPopulate");
                generateSurfaceDeposit = Optional.fromNullable(var1.getMethod("generateSurfaceDeposit", new Class[] {World.class, Random.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
                this.useRandom = true;
            }
            catch (Exception var4)
            {
                LogHelper.fine("Buildcraft Oil Generator could not be accessed. Extra oil in wastelands and mountainous deserts has been disabled.", new Object[0]);
                generateSurfaceDeposit = Optional.absent();
            }
        }
    }

    void generateSurfaceDeposit(World var1, Random var2, int var3, int var4, int var5, int var6)
    {
        try
        {
            if (this.useRandom)
            {
                ((Method)generateSurfaceDeposit.get()).invoke((Object)null, new Object[] {var1, var2, Integer.valueOf(var3), Integer.valueOf(var4), Integer.valueOf(var5), Integer.valueOf(var6)});
            }
            else
            {
                ((Method)generateSurfaceDeposit.get()).invoke((Object)null, new Object[] {var1, Integer.valueOf(var3), Integer.valueOf(var4), Integer.valueOf(var5), Integer.valueOf(var6)});
            }
        }
        catch (IllegalStateException var8)
        {
            ;
        }
        catch (Exception var9)
        {
            LogHelper.fine("Buildcraft oil generation failed. Exception caught.", new Object[0]);
        }
    }

    boolean modifyWorld()
    {
        return this.modifyWorld;
    }
}
