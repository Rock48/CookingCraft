package mods.cc.rock.recipie;

import java.util.logging.Level;

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
		
		LogUtil.log(Level.INFO, Messages.MSG_RECIPE_OVERRIDE_SUCCESS);
	}
}
