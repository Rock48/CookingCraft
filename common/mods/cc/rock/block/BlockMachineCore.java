
package mods.cc.rock.block;

import java.util.Random;

import mods.cc.rock.lib.Reference;
import mods.cc.rock.lib.Textures;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockMachineCore extends BlockCC
{
	private boolean isActive;
	public BlockMachineCore(int id, boolean par2Active)
	{
		super(id, Material.rock);
		this.isActive = par2Active;
	}
	public void registerIcons(IconRegister iconRegister)
	{
		if(this.isActive)
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()+":"+Textures.TEX_MACHINE_CORE_ON);
		else if(!this.isActive)
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()+":"+Textures.TEX_MACHINE_CORE_OFF);
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
            	par1World.setBlock(x, y, z, ModBlocks.machineCoreOn.blockID, 0, 2);
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
            	par1World.setBlock(x, y, z, ModBlocks.machineCoreOn.blockID, 0, 2);
            }
    	}
    }
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && this.isActive && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            par1World.setBlock(par2, par3, par4, ModBlocks.machineCoreOff.blockID, 0, 2);
        }
    }
}

