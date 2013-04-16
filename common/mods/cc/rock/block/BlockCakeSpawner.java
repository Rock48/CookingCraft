
package mods.cc.rock.block;

import java.util.Random;

import mods.cc.rock.mod_CookingCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCakeSpawner extends Block
{
	public BlockCakeSpawner(int id)
	{
		super(id, Material.rock);
	}
	public void registerIcons(IconRegister iconRegister)
	{
		 this.blockIcon = iconRegister.registerIcon("cc:BlockCakeSpawner");
	}
    public void onBlockAdded(World par1World, int x, int y, int z)
    {
    	if(!par1World.isRemote)
    	{
            if(par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		par1World.setBlock(x, y+1, z, Block.cake.blockID);
            }
    	}
    }
    public void onNeighborBlockChange(World par1World, int x, int y, int z, int par5)
    {	
    	if(!par1World.isRemote)
    	{
            if(par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		par1World.setBlock(x, y+1, z, Block.cake.blockID);
            }
    	}
    }
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 1;
    }
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if(par5EntityPlayer.getHeldItem() != null)
    	{
    		if(par5EntityPlayer.getHeldItem().itemID == mod_CookingCraft.fryingPan.itemID)
    		{
    			par1World.setBlockToAir(par2, par3, par4);
    			par1World.spawnEntityInWorld(new EntityItem(par1World,par2,par3,par4,new ItemStack(this)));
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		return false;
    	}
    }
}

