package mods.cc.rock.recipe;

import mods.cc.rock.core.util.LogUtil;
import mods.cc.rock.core.util.RecipeHelper;
import mods.cc.rock.lib.Messages;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeOverride
{
	public static void init()
	{
		RecipeHelper.RemoveRecipe(new ItemStack(Item.bread));
		RecipeHelper.RemoveRecipe(new ItemStack(Item.cake));
		RecipeHelper.RemoveRecipe(new ItemStack(Item.cookie));
		RecipeHelper.RemoveRecipe(new ItemStack(Item.pumpkinPie));
		RecipeHelper.RemoveRecipe(new ItemStack(Item.bowlSoup));
		
		LogUtil.info(Messages.MSG_RECIPE_OVERRIDE_SUCCESS);
	}
}
