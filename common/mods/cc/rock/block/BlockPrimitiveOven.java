package mods.cc.rock.block;

import java.util.Random;

import mods.cc.rock.tileentity.TileEntityPrimitiveOven;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPrimitiveOven extends BlockContainer
{
	private static boolean keepInventory = false;
	public int front = 0;
	private Random bakingRand;
	
	Icon[] iconBuffer;
	public BlockPrimitiveOven(int par1, boolean par2Boolean) 
	{
		super(par1, Material.rock);
		bakingRand = new Random();
		
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		iconBuffer = new Icon[3];
		iconBuffer[0] = par1IconRegister.registerIcon("cc:PrimitiveSides");
		iconBuffer[1] = par1IconRegister.registerIcon("cc:PrimitiveFront");
		iconBuffer[2] = par1IconRegister.registerIcon("cc:PrimitiveFrontOn");
	}
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityPrimitiveOven();
	}
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
		par1World.markBlockForUpdate(par2, par3, par4);
	}
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
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
	@Override
	public Icon getBlockTexture(IBlockAccess par1IBA, int par2, int par3, int par4, int par5)
	{
		
		TileEntity tile = ModLoader.getMinecraftInstance().getIntegratedServer().worldServers[0].getBlockTileEntity(par2, par3, par4);        
		System.out.println(tile);
		if(tile != null)
		{
			front = ((TileEntityPrimitiveOven) tile).getFrontDirection();
		}
		else
		{
			ModLoader.getMinecraftInstance().getIntegratedServer().worldServers[0].markBlockForUpdate(par2, par3, par4);
		}
		if(par5 == front)
		{
			//if(((TileEntityPrimitiveOven) tile).isActive())
			//{
			//	return iconBuffer[2];
			//}
			//else
			//{
				return iconBuffer[1];
			//}
		}
		else
		{
			return  iconBuffer[0];
		}
	}
		
	@Override
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
	@Override
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
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if(!keepInventory)
		{
			TileEntityPrimitiveOven primitiveOven = (TileEntityPrimitiveOven) par1World.getBlockTileEntity(par2, par3, par4);
			if(primitiveOven != null)
			{
				for(int i = 0; i < primitiveOven.getSizeInventory(); i++)
				{
					ItemStack IS = primitiveOven.getStackInSlot(i);
					if(IS != null)
					{
						float j = this.bakingRand.nextFloat() * 0.8F + 0.1F;
						float k = this.bakingRand.nextFloat() * 0.8F + 0.1F;
						float l = this.bakingRand.nextFloat() * 0.8F + 0.1F;
						while(IS.stackSize > 0)
						{
							int m = this.bakingRand.nextInt(21);
							if(m > IS.stackSize)
							{
								m = IS.stackSize;
							}
							IS.stackSize -= m;
							EntityItem n = new EntityItem(par1World, (double) ((float) par2 + j), (double) ((float) par3 + k), (double) ((float) par4 + l), new ItemStack(IS.itemID, m, IS.getItemDamage()));
							if(IS.hasTagCompound())
							{
								n.getEntityItem().setTagCompound((NBTTagCompound) IS.getTagCompound().copy());
							}
							float o = 0.05F;
							n.motionX = (double) ((float) this.bakingRand.nextGaussian() * o);
							n.motionY = (double) ((float) this.bakingRand.nextGaussian() * o);
							n.motionZ = (double) ((float) this.bakingRand.nextGaussian() * o);
							par1World.spawnEntityInWorld(n);
						}
					}
				}
			}
		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		TileEntityPrimitiveOven primitiveOven = (TileEntityPrimitiveOven) par1World.getBlockTileEntity(par2, par3, par4);
		if(par5EntityPlayer instanceof EntityPlayerMP)
		{
			
		}
		return true;
	}
}
