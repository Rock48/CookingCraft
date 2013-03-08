
package rock.minecraft.cc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockDoStuffBlock extends Block
{
	public BlockDoStuffBlock(int id, int texture)
	{
		super(id, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	public String getTextureFile()
	{
		return "/rock/minecraft/cc/art/sprites/cc_blocks.png";
	}
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if(par1World.isRemote)
    	{
    		return true;
    	}
    	else
    	{
    		World.setBlock(par2, par3+1, par4, Block.cake.blockID);
    		return true;
    	}
    }

}
