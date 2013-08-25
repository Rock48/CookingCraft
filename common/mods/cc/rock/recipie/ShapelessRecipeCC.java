package mods.cc.rock.recipie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

import mods.cc.rock.lib.ItemIDs;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ShapelessRecipeCC extends ShapelessRecipes implements IRecipeCC
{
	private ItemStack recipeOutput;
	private boolean pinNeeded;
	
	public ShapelessRecipeCC(ItemStack par1ItemStack, List par2List, boolean pin)
	{
		super(par1ItemStack, par2List);
		this.recipeOutput = par1ItemStack;
		this.pinNeeded = pin;
	}

	@Override
	public boolean matches(IInventory inventorycrafting, World world)
	{
		ArrayList arraylist = new ArrayList(this.recipeItems);
		
		if (this.pinNeeded && inventorycrafting.getStackInSlot(8) == null)
	        return false;
		
        for (int i = 0; i < 8; ++i)
        {
            ItemStack itemstack = inventorycrafting.getStackInSlot(i);
            
            if (itemstack != null)
            {
                boolean flag = false;
                Iterator iterator = arraylist.iterator();

                while (iterator.hasNext())
                {
                    ItemStack itemstack1 = (ItemStack) iterator.next();

                    if (itemstack.itemID == itemstack1.itemID && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage()))
                    {
                        flag = true;
                        arraylist.remove(itemstack1);
                        break;
                    }
                }

                if (!flag)
                    return false;
            }
        }

        return arraylist.isEmpty();
	}

	@Override
	public ItemStack getCraftingResult(IInventory par1InventoryCrafting)
    {
        return this.recipeOutput.copy();
    }

}
