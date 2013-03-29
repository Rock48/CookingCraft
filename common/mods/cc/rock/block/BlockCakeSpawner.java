
package mods.cc.rock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
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
}

