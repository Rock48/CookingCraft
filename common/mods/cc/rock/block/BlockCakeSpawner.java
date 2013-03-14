
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
	public void func_94332_a(IconRegister iconRegister)
	{
		 this.field_94336_cN = iconRegister.func_94245_a("cc:BlockCakeSpawner");
	}
    public void onBlockAdded(World world, int x, int y, int z)
    {
    	if(!world.isRemote)
    	{
            if(world.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		world.func_94575_c(x, y+1, z, Block.cake.blockID);
            }
    	}
    }
    public void onNeighborBlockChange(World world, int x, int y, int z, int par5)
    {	
    	if(!world.isRemote)
    	{
            if(world.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		world.func_94575_c(x, y+1, z, Block.cake.blockID);
            }
    	}
    }
}

