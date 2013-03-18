package mods.cc.rock.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPrimitiveOven extends TileEntity implements IInventory
{
	private ItemStack bakingItemStacks[];
	
	public int bakingBurnTime;
	public int bakingItemBurnTime;
	public int bakingCookTime;
	
	public int front;
	
	private boolean isActive=false;
	
	public TileEntityPrimitiveOven()
	{
		bakingItemStacks = new ItemStack[3]; //TODO
		bakingBurnTime = 0;
		bakingCookTime = 0;
		bakingItemBurnTime = 0;
	}
	
	public void setFrontDirection(int par1)
	{
		this.front = par1;
	}
	public int getFrontDirection()
	{
		return this.front;
	}
	@Override
	public int getSizeInventory() 
	{
		return bakingItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) 
	{
		return bakingItemStacks[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) 
	{
		if(bakingItemStacks[par1] != null)
		{
			if(bakingItemStacks[par1].stackSize <= par2)
			{
				ItemStack itemstack = bakingItemStacks[par1];
				bakingItemStacks[par1] = null;
				return itemstack;
			}
			ItemStack itemstack1 = bakingItemStacks[par1].splitStack(par2);
			if(bakingItemStacks[par1].stackSize==0)
			{
				bakingItemStacks[par1] = null;
			}
			return itemstack1;
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) 
	{
		if(bakingItemStacks[par1] != null)
		{
			ItemStack itemstack = bakingItemStacks[par1];
			bakingItemStacks[par1] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) 
	{
		bakingItemStacks[par1] = par2ItemStack;
		if(par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
		{
			par2ItemStack.stackSize = getInventoryStackLimit();
		}
	}
	@Override
	public String getInvName() 
	{
		return "container.PrimitiveOven";
	}
	public int getCookProgressScaled(int par1)
	{
		return (bakingCookTime * par1) / 200;
	}
	public int getBurnTimeRemainingScaled(int par1)
	{
		if(bakingItemBurnTime == 0)
		{
			bakingItemBurnTime = 200;
		}
		return (bakingItemBurnTime * par1) / bakingItemBurnTime;
	}
	public boolean isBurning()
	{
		return bakingBurnTime > 0;
	}
	@Override
	public boolean func_94042_c() 
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) 
	{
		if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
		{
			return false;
		}
		return par1EntityPlayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord +0.5D) <= 64D;
	}
	/*
	private boolean canSmelt() //TODO
	{
		if(bakingItemStacks[0] == null)
		{
			return false;
		}
		//ItemStack itemstack = 
	}*/
	public static boolean isItemFuel(ItemStack par1ItemStack)
	{
		return getItemBurnTime(par1ItemStack) > 0;
	}
	public static int getItemBurnTime(ItemStack par1ItemStack) //TODO
	{
		return 200;
	}
	@Override
	public void openChest() 
	{
		
	}

	@Override
	public void closeChest() 
	{
		
	}
	public boolean isActive()
	{
		return this.isActive;
	}

	@Override
	public boolean func_94041_b(int par1, ItemStack itemstack) 
	{
		return false;
	}

}
