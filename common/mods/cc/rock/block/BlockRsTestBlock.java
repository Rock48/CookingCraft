
package mods.cc.rock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRsTestBlock extends Block
{
	private Icon on;
	private Icon off;
	private boolean isActive = false;
	public BlockRsTestBlock(int id)
	{
		super(id, Material.rock);
	}
	public void registerIcons(IconRegister iconRegister)
	{
		 this.on = iconRegister.registerIcon("cc:rsBlockOn");
		 this.off = iconRegister.registerIcon("cc:rsBlockOff");
		 this.blockIcon = this.off;
	}
	@Override
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return this.isActive ? this.on : this.off;
	}
    public void onBlockAdded(World par1World, int x, int y, int z)
    {
    	if(!par1World.isRemote)
    	{
            if(par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		this.isActive=true;
            }
            else
            {
            	this.isActive=false;
            }
    	}
    }
    public void onNeighborBlockChange(World par1World, int x, int y, int z, int par5)
    {	
    	if(!par1World.isRemote)
    	{
            if(par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
           		this.isActive=true;
            }
            else
            {
            	this.isActive=false;
            }
    	}
    }
}

