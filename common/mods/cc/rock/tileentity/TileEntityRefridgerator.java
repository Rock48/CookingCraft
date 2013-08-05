package mods.cc.rock.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityRefridgerator extends TileCC implements IInventory
{

    public ItemStack[] inventory;
    
    public static final int INVENTORY_SIZE = 9 * 8;
    
    public TileEntityRefridgerator()
    {
        inventory = new ItemStack[INVENTORY_SIZE];
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
    public ItemStack decrStackSize(int slot, int amt) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    if (stack.stackSize <= amt) {
                            setInventorySlotContents(slot, null);
                    } else {
                            stack = stack.splitStack(amt);
                            if (stack.stackSize == 0) {
                                    setInventorySlotContents(slot, null);
                            }
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
        return this.hasCustomName() ? this.getCustomName() : "container.refridgerator";
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
        s.append("Refridgerator Data - ");
        
        return s.toString();
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            
            NBTTagList tagList = tagCompound.getTagList("Inventory");
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < inventory.length) {
                            inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
            }
            orientation = ForgeDirection.getOrientation(tagCompound.getInteger("Orientation"));
            
            	
            
    }
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
            super.writeToNBT(tagCompound);
                            
            NBTTagList itemList = new NBTTagList();
            for (int i = 0; i < inventory.length; i++) {
                    ItemStack stack = inventory[i];
                    if (stack != null) {
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
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return 	itemstack.getItem().itemID == Item.appleRed.itemID||
				itemstack.getItem().itemID == Item.appleGold.itemID||
				itemstack.getItem().itemID == Item.potato.itemID||
				itemstack.getItem().itemID == Item.bakedPotato.itemID||
				itemstack.getItem().itemID == Item.poisonousPotato.itemID||
				itemstack.getItem().itemID == Item.bread.itemID||
				itemstack.getItem().itemID == Item.cake.itemID||
				itemstack.getItem().itemID == Item.carrot.itemID||
				itemstack.getItem().itemID == Item.chickenCooked.itemID||
				itemstack.getItem().itemID == Item.chickenRaw.itemID||
				itemstack.getItem().itemID == Item.fishRaw.itemID||
				itemstack.getItem().itemID == Item.fishCooked.itemID||
				itemstack.getItem().itemID == Item.cookie.itemID||
				itemstack.getItem().itemID == Item.goldenCarrot.itemID||
				itemstack.getItem().itemID == Item.melon.itemID||
				itemstack.getItem().itemID == Item.bowlSoup.itemID||
				itemstack.getItem().itemID == Item.pumpkinPie.itemID||
				itemstack.getItem().itemID == Item.beefRaw.itemID||
				itemstack.getItem().itemID == Item.beefCooked.itemID||
				itemstack.getItem().itemID == Item.porkRaw.itemID||
				itemstack.getItem().itemID == Item.porkCooked.itemID||
				itemstack.getItem().itemID == Item.rottenFlesh.itemID||
				itemstack.getItem().itemID == Item.spiderEye.itemID||
				itemstack.getItem().itemID == Item.bucketMilk.itemID;
	}


}
