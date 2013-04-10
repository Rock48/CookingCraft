package mods.cc.rock.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityBasicRefridgerator extends TileEntity implements ISidedInventory, net.minecraftforge.common.ISidedInventory
{
	private ItemStack[] chestStuff = new ItemStack[72];
	private String localizedName;
	public int playersUsingChest;
	
	@Override
	public int getSizeInventory() {
		return 72;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.chestStuff[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInvName() {
		return this.isInvNameLocalized() ? this.localizedName : "container.basicRefridgerator";
	}

	@Override
	public boolean isInvNameLocalized() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	/**
	 * Setting the localizedName variable
	 * @param par1Str -- Name
	 */
	public void func_94043_a(String par1Str)
	{
		this.localizedName = par1Str;
	}
	@Override
	public int getInventoryStackLimit() {
		return 8;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq( (double)this.xCoord+0.5D, (double)this.yCoord+0.5D, (double)this.zCoord+0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return 	itemstack == new ItemStack(Item.appleRed)||
				itemstack == new ItemStack(Item.appleGold)||
				itemstack == new ItemStack(Item.potato)||
				itemstack == new ItemStack(Item.bakedPotato)||
				itemstack == new ItemStack(Item.poisonousPotato)||
				itemstack == new ItemStack(Item.bread)||
				itemstack == new ItemStack(Item.cake)||
				itemstack == new ItemStack(Item.carrot)||
				itemstack == new ItemStack(Item.chickenCooked)||
				itemstack == new ItemStack(Item.chickenRaw)||
				itemstack == new ItemStack(Item.fishRaw)||
				itemstack == new ItemStack(Item.fishCooked)||
				itemstack == new ItemStack(Item.cookie)||
				itemstack == new ItemStack(Item.goldenCarrot)||
				itemstack == new ItemStack(Item.melon)||
				itemstack == new ItemStack(Item.bowlSoup)||
				itemstack == new ItemStack(Item.pumpkinPie)||
				itemstack == new ItemStack(Item.beefRaw)||
				itemstack == new ItemStack(Item.beefCooked)||
				itemstack == new ItemStack(Item.porkRaw)||
				itemstack == new ItemStack(Item.porkCooked)||
				itemstack == new ItemStack(Item.rottenFlesh)||
				itemstack == new ItemStack(Item.spiderEye)||
				itemstack == new ItemStack(Item.bucketMilk);
	}

	@Override
	@Deprecated
	public
	int getStartInventorySide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Deprecated
	public
	int getSizeInventorySide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getSizeInventorySide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean func_102007_a(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean func_102008_b(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

}
