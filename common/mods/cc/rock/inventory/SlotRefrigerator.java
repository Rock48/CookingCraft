package mods.cc.rock.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import mods.cc.rock.lib.ItemIDs;

public class SlotRefrigerator extends Slot
{
	public boolean playerinv;
	
	public SlotRefrigerator(IInventory par1iInventory, int par2, int par3, int par4, boolean playerinv)
	{
		super(par1iInventory, par2, par3, par4);
		this.playerinv = playerinv;
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		if (playerinv) return true;
		
		return 	itemstack.getItem().itemID == Item.appleRed.itemID ||
				itemstack.getItem().itemID == Item.appleGold.itemID ||
				itemstack.getItem().itemID == Item.potato.itemID ||
				itemstack.getItem().itemID == Item.bakedPotato.itemID ||
				itemstack.getItem().itemID == Item.poisonousPotato.itemID ||
				itemstack.getItem().itemID == Item.bread.itemID ||
				itemstack.getItem().itemID == Item.cake.itemID ||
				itemstack.getItem().itemID == Item.carrot.itemID ||
				itemstack.getItem().itemID == Item.chickenCooked.itemID ||
				itemstack.getItem().itemID == Item.chickenRaw.itemID ||
				itemstack.getItem().itemID == Item.fishRaw.itemID ||
				itemstack.getItem().itemID == Item.fishCooked.itemID ||
				itemstack.getItem().itemID == Item.cookie.itemID ||
				itemstack.getItem().itemID == Item.goldenCarrot.itemID ||
				itemstack.getItem().itemID == Item.melon.itemID ||
				itemstack.getItem().itemID == Item.bowlSoup.itemID ||
				itemstack.getItem().itemID == Item.pumpkinPie.itemID ||
				itemstack.getItem().itemID == Item.beefRaw.itemID ||
				itemstack.getItem().itemID == Item.beefCooked.itemID ||
				itemstack.getItem().itemID == Item.porkRaw.itemID ||
				itemstack.getItem().itemID == Item.porkCooked.itemID ||
				itemstack.getItem().itemID == Item.rottenFlesh.itemID ||
				itemstack.getItem().itemID == Item.spiderEye.itemID ||
				itemstack.getItem().itemID == Item.bucketMilk.itemID ||
		        itemstack.getItem().itemID == ItemIDs.ID_DOUGH ||
                itemstack.getItem().itemID == ItemIDs.ID_OIL_LIGHT ||
                itemstack.getItem().itemID == ItemIDs.ID_OIL_DARK ||
                itemstack.getItem().itemID == ItemIDs.ID_OIL_COOKED_LIGHT ||
                itemstack.getItem().itemID == ItemIDs.ID_OIL_COOKED_DARK;
	}

}
