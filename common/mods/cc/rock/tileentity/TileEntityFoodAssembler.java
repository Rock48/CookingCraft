package mods.cc.rock.tileentity;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;

import mods.cc.rock.lib.ItemIDs;

public class TileEntityFoodAssembler extends TileCC implements IInventory
{

    public ItemStack[] inventory;
    
    public static final int INVENTORY_SIZE = 9;
    
    public Container eventHandler;
    
    public TileEntityFoodAssembler()
    {
        inventory = new ItemStack[INVENTORY_SIZE];
    }
    
    /**
     * Checks if there is an amount of a given item id in an inventory
     * @param itemID
     * @param amount
     * @return if there is the given amount of the item id provided
     */
    public boolean contains(int itemID, int amount)
    {
    	int checknum = 0;
    	
    	for(int i = 0; i < INVENTORY_SIZE; i++)
    	{
    		if(inventory[i] != null)
    		{
    			if(inventory[i].itemID == itemID)
	    			checknum++;

	    		if(checknum == amount)
	    			return true;
    		}
    	}
    	
    	return false;
    }
    
    @Override
    public void onInventoryChanged()
    {
    	if(this.eventHandler != null)
        	this.eventHandler.onCraftMatrixChanged(this);
    }
    
    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt)
    {
        ItemStack stack = getStackInSlot(slot);
        
        if (stack != null)
        {
            if (stack.stackSize <= amt)
            {
                setInventorySlotContents(slot, null);
                
                if(this.eventHandler != null)
                	this.eventHandler.onCraftMatrixChanged(this);
            }
            else
            {
                stack = stack.splitStack(amt);
                
                if (stack.stackSize == 0)
                        setInventorySlotContents(slot, null);
                
                if(this.eventHandler != null)
                	this.eventHandler.onCraftMatrixChanged(this);
            }
        }
        
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack itemStack = getStackInSlot(slot);
        
        if (itemStack != null)
            setInventorySlotContents(slot, null);
        
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        inventory[slot] = itemStack;
        
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
            itemStack.stackSize = getInventoryStackLimit();
    }

    @Override
    public String getInvName()
    {
        return this.hasCustomName() ? this.getCustomName() : "container.foodAssembler";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void openChest()
    {
    }

    @Override
    public void closeChest()
    {      
    }
    
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Food Assembler Data - ");
        
        return s.toString();
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
        
        NBTTagList tagList = tagCompound.getTagList("Inventory");
        
        for (int i = 0; i < tagList.tagCount(); i++)
        {
            NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tag.getByte("Slot");
            
            if (slot >= 0 && slot < inventory.length)
                    inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
        }
        
        orientation = ForgeDirection.getOrientation(tagCompound.getInteger("Orientation"));
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);
                        
        NBTTagList itemList = new NBTTagList();
        
        for (int i = 0; i < inventory.length; i++)
        {
            ItemStack stack = inventory[i];
            
            if (stack != null)
            {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }
        
        tagCompound.setTag("Inventory", itemList);
        
        tagCompound.setInteger("Orientation", orientation.ordinal()); 
    }

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
	    if (i == 8 && itemstack != null)
	        return (itemstack.itemID == ItemIDs.ID_ROLLING_PIN_1 || itemstack.itemID == ItemIDs.ID_ROLLING_PIN_2);
	    else
	        return !(itemstack.itemID == ItemIDs.ID_ROLLING_PIN_1 || itemstack.itemID == ItemIDs.ID_ROLLING_PIN_2);
	}


}

