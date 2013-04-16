package mods.cc.rock.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
public class ContainerBasicRefridgerator extends Container
{
	private IInventory bottomPartOfChest;
	private int numberOfRows;
	private IInventory fridgeInventory;
	public ContainerBasicRefridgerator(IInventory par1IInventory, IInventory par2IInventory)
	{
		this.bottomPartOfChest = par2IInventory;
		this.numberOfRows = par2IInventory.getSizeInventory() / 8;
		par2IInventory.openChest();
		int i = (this.numberOfRows - 4) * 18;
		int j;
		int k;
		
		//Chest Inventory
		for(j = 0; j < this.numberOfRows; j++) 
		{
			for(k = 0; k < 9; k++)
			{
				this.addSlotToContainer(new Slot(par2IInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}
		//Player Inventory
		for(j = 0; j < 3; j++) 
		{
			for(k = 0; k < 9; k++)
			{
				this.addSlotToContainer(new Slot(par1IInventory, k + j * 9 + 9, 8 + k * 18, 108 + j * 18 + i));
			}
		}
		//Player ItemBar
		for(j = 0; j < 9; j++)
		{
			this.addSlotToContainer(new Slot(par1IInventory, j, 8+j*18, 161+1));
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.bottomPartOfChest.isUseableByPlayer(entityplayer);
	}
	

}
