package mods.cc.rock.recipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mods.cc.rock.item.ItemCookingTool;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ShapelessRecipeCC extends ShapelessRecipes implements IRecipeCC
{
	private ItemStack recipeOutput;
	private EnumCookingTool toolNeeded;
	
	public ShapelessRecipeCC(ItemStack par1ItemStack, List par2List, EnumCookingTool tool)
	{
		super(par1ItemStack, par2List);
		this.recipeOutput = par1ItemStack;
		this.toolNeeded = tool;
	}

	@Override
	public boolean matches(IInventory inventorycrafting, World world)
	{
		ArrayList arraylist = new ArrayList(this.recipeItems);
		if(this.toolNeeded.getType() != "NONE"){
			if(inventorycrafting.getStackInSlot(8)!=null){
				if(inventorycrafting.getStackInSlot(8).getItem() instanceof ItemCookingTool){
					if (this.toolNeeded.getType() != ((ItemCookingTool) inventorycrafting.getStackInSlot(8).getItem()).getToolType()){
						return false;
					}
					if (!(this.toolNeeded.getLevel()  <= ((ItemCookingTool) inventorycrafting.getStackInSlot(8).getItem()).getToolLevel())){
						return false;
					}
				}
				
			}else{
				return false;
			}
		}
		
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
