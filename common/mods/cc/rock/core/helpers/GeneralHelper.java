package mods.cc.rock.core.helpers;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GeneralHelper
{
    public static void spawnItemOnGround(World par1World, int par2, int par3, int par4, int par5, EntityLiving par6EntityLiving, ItemStack par7ItemStack)
    {
        if (!par1World.isRemote)
        {
            if ((par5 & 1) == 1)
            {
                EntityItem entityItem = new EntityItem(par1World, (double) par2 + Math.random(), (double) par3 + Math.random(), (double) par4 + Math.random(), par7ItemStack);
                par1World.spawnEntityInWorld(entityItem);
            }
        }
    }
}
