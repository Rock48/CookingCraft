package mods.cc.rock.recipie;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IRecipeCC
{
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(IInventory inventorycrafting, World world);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(IInventory inventorycrafting);

    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();

    ItemStack getRecipeOutput();
}
