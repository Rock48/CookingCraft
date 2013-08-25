package mods.cc.rock.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import mods.cc.rock.lib.ItemIDs;

public class SlotRollingPin extends Slot
{

    public SlotRollingPin(IInventory par1iInventory, int par2, int par3, int par4)
    {
        super(par1iInventory, par2, par3, par4);
    }

    @Override
    public boolean isItemValid(ItemStack itemstack)
    {
        return itemstack.getItem().itemID == ItemIDs.ID_ROLLING_PIN_1 ||
               itemstack.getItem().itemID == ItemIDs.ID_ROLLING_PIN_2;
    }
}
