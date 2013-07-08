package mods.cc.rock.recipie;

import mods.cc.rock.core.helpers.RecipeHelper;
import mods.cc.rock.lib.Messages;
import mods.cc.rock.util.LogUtil;

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
