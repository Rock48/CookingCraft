package mods.cc.rock.block;

import java.util.Random;

import mods.cc.rock.tileentity.TileEntityPrimitiveOven;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPrimitiveOven extends BlockContainer
{
	public int front = 0;
	private Random bakingRand;
	
	Icon[] iconBuffer;
	public BlockPrimitiveOven(int par1, boolean par2Boolean) 
	{
		super(par1, Material.rock);
		bakingRand = new Random();
		
	}
	public void func_94332_a(IconRegister par1IconRegister)
	{
		iconBuffer = new Icon[3];
		iconBuffer[0] = par1IconRegister.func_94245_a("cc:PrimitiveSides");
		iconBuffer[1] = par1IconRegister.func_94245_a("cc:PrimitiveFront");
		iconBuffer[2] = par1IconRegister.func_94245_a("cc:PrimitiveFrontOn");
	}
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityPrimitiveOven();
	}
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
		par1World.markBlockForUpdate(par2, par3, par4);
	}
	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		TileEntity blockEntity = par1World.getBlockTileEntity(par2, par3, par4);
		if(par1World.isRemote)
		{
			return;
		}
		int i = par1World.getBlockId(par2, par3, par4-1);
		int j = par1World.getBlockId(par2, par3, par4+1);
		int k = par1World.getBlockId(par2-1, par3, par4);
		int l = par1World.getBlockId(par2+1, par3, par4);
		byte byte0 = 3;
		if(Block.opaqueCubeLookup[i] && !Block.opaqueCubeLookup[j])
		{
			byte0 = 3;
		}
		if(Block.opaqueCubeLookup[j] && !Block.opaqueCubeLookup[i])
		{
			byte0 = 2;
		}
		if(Block.opaqueCubeLookup[k] && !Block.opaqueCubeLookup[l])
		{
			byte0 = 5;
		}
		if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[k])
		{
			byte0 = 4;
		}
		((TileEntityPrimitiveOven) blockEntity).setFrontDirection(byte0);
	}
	public Icon getBlockTexture(IBlockAccess par1IBA, int par2, int par3, int par4, int par5)
	{
		
		TileEntity tile = ModLoader.getMinecraftInstance().getIntegratedServer().worldServers[0].getBlockTileEntity(par2, par3, par4);        
		System.out.print(tile);
		if(tile != null)
		{
			front = ((TileEntityPrimitiveOven) tile).getFrontDirection();
		}
		else
		{
			ModLoader.getMinecraftInstance().getIntegratedServer().worldServers[0].markBlockForUpdate(par2, par3, par4);
		}
		
		switch(par5) {
		case 0:
			return 	iconBuffer[0];
		case 1:
			return 	iconBuffer[0];
		default:
			if(par5 == front)
			{
				return /*((TileEntityPrimitiveOven) tile).isActive() ? iconBuffer[2] : */iconBuffer[1];
			
			}
			else
			{
				return  iconBuffer[0];
			}
		}
		
	}
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par1){
		case 0:
			return iconBuffer[0];
		case 1:
			return iconBuffer[0];
		case 2:
			return iconBuffer[0];
		case 3:
			return iconBuffer[1];
		case 4:
			return iconBuffer[0];
		case 5:
			return iconBuffer[0];
		default:
return iconBuffer[0];
		}
	}
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving EL, ItemStack par6ItemStack)
	{
		int i = MathHelper.floor_double((double) (EL.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		TileEntity blockEntity = (TileEntity) par1World.getBlockTileEntity(par2, par3, par4);
		
		switch(i){
		case 0:
			((TileEntityPrimitiveOven) blockEntity).setFrontDirection(2);
			break;
		case 1:
			((TileEntityPrimitiveOven) blockEntity).setFrontDirection(5);
			break;
		case 2:
			((TileEntityPrimitiveOven) blockEntity).setFrontDirection(3);
			break;
		case 3:
			((TileEntityPrimitiveOven) blockEntity).setFrontDirection(4);
			break;
		}
	}
}
