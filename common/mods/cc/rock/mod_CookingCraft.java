package mods.cc.rock;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_CookingCraft extends BaseMod
{
	@SidedProxy(clientSide = "mods.cc.rock.core.proxy.ClientProxy", serverSide = "mods.cc.rock.core.proxy.CommonProxy")
		public static void addOreRecipe(ItemStack output, Object[] input) 
		{
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, new Object[] { Boolean.valueOf(true), input }));
		}
}
