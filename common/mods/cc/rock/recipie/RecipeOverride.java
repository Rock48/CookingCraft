package mods.cc.rock.recipie;

import mods.cc.rock.CookingCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeOverride {
	public static void init(){
		CookingCraft.RemoveRecipe(new ItemStack(Item.bread));
	}
}
