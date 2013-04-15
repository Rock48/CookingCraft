
package mods.cc.rock.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRsTestBlock extends Block
{
	private boolean isActive;
	public BlockRsTestBlock(int id, boolean par2Active)
	{
		super(id, Material.rock);
		this.isActive = par2Active;
	}
	public void registerIcons(IconRegister iconRegister)
	{
		if(this.isActive)
		this.blockIcon = iconRegister.registerIcon("cc:rsBlockOn");
		else if(!this.isActive)
		this.blockIcon = iconRegister.registerIcon("cc:rsBlockOff");
	}
    public void onBlockAdded(World par1World, int x, int y, int z)
    {
    	if(!par1World.isRemote)
    	{
            if(this.isActive && !par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.scheduleBlockUpdate(x, y, z, this.blockID, 4);
            }
            else if (!this.isActive && par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.setBlock(x, y, z, ModBlocks.rsTestBlockOn.blockID, 0, 2);
            }
    	}
    }
    public void onNeighborBlockChange(World par1World, int x, int y, int z, int par5)
    {	
    	if(!par1World.isRemote)
    	{
            if(this.isActive && !par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.scheduleBlockUpdate(x, y, z, this.blockID, 4);
            }
            else if (!this.isActive && par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.setBlock(x, y, z, ModBlocks.rsTestBlockOn.blockID, 0, 2);
            }
    	}
    }
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && this.isActive && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            par1World.setBlock(par2, par3, par4, ModBlocks.rsTestBlockOff.blockID, 0, 2);
        }
    }
}

