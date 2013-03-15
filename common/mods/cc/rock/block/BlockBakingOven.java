package mods.cc.rock.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBakingOven extends Block
{
	boolean RC;
	Icon[] iconBuffer;
	public BlockBakingOven(int par1) 
	{
		super(par1, Material.rock);
	}
	public void func_94332_a(IconRegister par1IconRegister)
	{
		iconBuffer = new Icon[3];
		iconBuffer[0] = par1IconRegister.func_94245_a("cc:PrimativeSides");
		iconBuffer[1] = par1IconRegister.func_94245_a("cc:PrimativeFront");
		iconBuffer[2] = par1IconRegister.func_94245_a("cc:PrimativeFrontOn");
	}
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par1 == 3 ? iconBuffer[1+par2] : iconBuffer[0];
	}
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if(par1World.isRemote == true)
		{
			return true;
		}
		else if(par1World.getBlockMetadata(par2, par3, par4)==0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, par6);
			this.setLightValue(1.0F);
			return true;
		}
		else if(par1World.getBlockMetadata(par2, par3, par4)==1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, par6);
			this.setLightValue(0F);
			return true;
		}
		else
		{
			return true;
		}
	}
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if(par1World.getBlockMetadata(par2, par3, par4)==0)
		this.setLightValue(0F);
		else if(par1World.getBlockMetadata(par2, par3, par4)==1)
		this.setLightValue(1F);
	}
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {	
		if(par1World.getBlockMetadata(par2, par3, par4)==0)
		this.setLightValue(0F);
		else if(par1World.getBlockMetadata(par2, par3, par4)==1)
		this.setLightValue(1F);
    }
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 2; ix++) 
		{
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
}
