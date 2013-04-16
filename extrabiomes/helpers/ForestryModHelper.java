package extrabiomes.helpers;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.item.ItemStack;

public abstract class ForestryModHelper
{
    private static List backpackDigger = new ArrayList();
    private static List backpackForester = new ArrayList();
    private static List basicFlowers = new ArrayList();
    private static List germlings = new ArrayList();
    private static List leaves = new ArrayList();
    private static List saplings = new ArrayList();

    public static void addToForesterBackpack(ItemStack var0)
    {
        backpackForester.add(var0);
    }

    public static void addToDiggerBackpack(ItemStack var0)
    {
        backpackDigger.add(var0);
    }

    public static Collection getBasicFlowers()
    {
        return ImmutableList.copyOf(basicFlowers);
    }

    public static Collection getDiggerBackPackItems()
    {
        return ImmutableList.copyOf(backpackDigger);
    }

    public static Collection getForesterBackPackItems()
    {
        return ImmutableList.copyOf(backpackForester);
    }

    public static Collection getLeaves()
    {
        return ImmutableList.copyOf(leaves);
    }

    public static Collection getSaplings()
    {
        return ImmutableList.copyOf(saplings);
    }

    public static boolean isGermling(ItemStack var0)
    {
        Iterator var1 = germlings.iterator();
        ItemStack var2;

        do
        {
            if (!var1.hasNext())
            {
                return false;
            }

            var2 = (ItemStack)var1.next();
        }
        while (!ItemStack.areItemStacksEqual(var2, var0));

        return true;
    }

    public static void registerBasicFlower(ItemStack var0)
    {
        Iterator var1 = basicFlowers.iterator();
        ItemStack var2;

        do
        {
            if (!var1.hasNext())
            {
                basicFlowers.add(var0);
                return;
            }

            var2 = (ItemStack)var1.next();
        }
        while (!ItemStack.areItemStacksEqual(var2, var0));
    }

    public static void registerGermling(ItemStack var0)
    {
        Iterator var1 = germlings.iterator();
        ItemStack var2;

        do
        {
            if (!var1.hasNext())
            {
                germlings.add(var0);
                return;
            }

            var2 = (ItemStack)var1.next();
        }
        while (!ItemStack.areItemStacksEqual(var2, var0));
    }

    public static void registerLeaves(ItemStack var0)
    {
        Iterator var1 = leaves.iterator();
        ItemStack var2;

        do
        {
            if (!var1.hasNext())
            {
                leaves.add(var0);
                return;
            }

            var2 = (ItemStack)var1.next();
        }
        while (!ItemStack.areItemStacksEqual(var2, var0));
    }

    public static void registerSapling(ItemStack var0)
    {
        Iterator var1 = saplings.iterator();
        ItemStack var2;

        do
        {
            if (!var1.hasNext())
            {
                saplings.add(var0);
                return;
            }

            var2 = (ItemStack)var1.next();
        }
        while (!ItemStack.areItemStacksEqual(var2, var0));
    }
}
