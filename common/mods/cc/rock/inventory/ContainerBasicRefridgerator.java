package mods.cc.rock.inventory;

import mods.cc.rock.tileentity.TileEntityBasicRefridgerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
public class ContainerBasicRefridgerator extends Container
{
	private IInventory bottomPartOfChest;
	private int numberOfRows;
	private IInventory fridgeInventory;
	public ContainerBasicRefridgerator(EntityPlayer player, World world, int x, int y, int z)
	{
		
		TileEntityBasicRefridgerator fridge = (TileEntityBasicRefridgerator) world.getBlockTileEntity(x, y, z);
		IInventory inv = player.inventory;
		for(int j = 0; j < inv.getSizeInventory(); j++)
		{
			inv.setInventorySlotContents(j, null);
		}
		for(int j = 0; j<fridge.getSizeInventory() ; j++)
		{
			inv.setInventorySlotContents(j, fridge.getStackInSlot(j));
		}
		
		
		
		
		
		this.bottomPartOfChest = inv;
		this.numberOfRows = inv.getSizeInventory() / 8;
		inv.openChest();
		int i = (this.numberOfRows - 4) * 18;
		int j;
		int k;
		
		//Chest Inventory
		for(j = 0; j < this.numberOfRows; j++) 
		{
			for(k = 0; k < 9; k++)
			{
				this.addSlotToContainer(new Slot(inv, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}
		//Player Inventory
		for(j = 0; j < 3; j++) 
		{
			for(k = 0; k < 9; k++)
			{
				this.addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 108 + j * 18 + i));
			}
		}
		//Player ItemBar
		for(j = 0; j < 9; j++)
		{
			this.addSlotToContainer(new Slot(player.inventory, j, 8+j*18, 161+1));
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.bottomPartOfChest.isUseableByPlayer(entityplayer);
	}
	

}
