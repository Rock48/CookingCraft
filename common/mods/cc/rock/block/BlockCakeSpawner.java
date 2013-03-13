/*
package rock.minecraft.cc.block;

import mods.cc.rock.lib.Sprites;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockCakeSpawner extends Block
{
	public BlockCakeSpawner(int id, int texture)
	{
		super(id, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	public String getTextureFile()
	{
		return Sprites.CC_BLOCKS;
	}
    public void onBlockAdded(World world, int x, int y, int z)
    {
    	if(!world.isRemote)
    	{
            if(world.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		world.setBlock(x, y+1, z, Block.cake.blockID);
            }
    	}
    }
    public void onNeighborBlockChange(World world, int x, int y, int z, int par5)
    {	
    	if(!world.isRemote)
    	{
            if(world.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		world.func(x, y+1, z, Block.cake.blockID);
            }
    	}
    }
}
*/
