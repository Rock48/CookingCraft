package mods.cc.rock;

import java.util.ArrayList;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.core.handlers.LocalizationHandler;
import mods.cc.rock.core.proxy.CommonProxy;
import mods.cc.rock.creativetabs.CreativeTabCC;
import mods.cc.rock.item.ModItems;
import mods.cc.rock.lib.Reference;
import mods.cc.rock.recipie.ModRecipies;
import mods.cc.rock.recipie.RecipeOverride;
import mods.cc.rock.world.OreGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CookingCraft
{
        @Instance(Reference.MOD_ID)
        public static CookingCraft instance;
        
    	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    	public static CommonProxy proxy;
    	
    	
    	public static CreativeTabs tabCC = new CreativeTabCC(Reference.MOD_ID);
    	
    	/**
    	 * Adds a recipe, supports ore dictionary
    	 * @param output
    	 * @param input
    	 */
        @SuppressWarnings("unchecked")
        public static void addOreRecipe(ItemStack output, Object[] input) 
    	{
    		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, new Object[] { Boolean.valueOf(true), input }));
    	}
        
        public static void RemoveRecipe(ItemStack resultItem) //Code by yope_fried inspired by pigalot
        {
            ItemStack recipeResult = null;
            ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

            for (int scan = 0; scan < recipes.size(); scan++)
            {
                IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
                if (tmpRecipe instanceof ShapedRecipes)
                {
                    ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                    recipeResult = recipe.getRecipeOutput();
                }

                if (tmpRecipe instanceof ShapelessRecipes)
                {
                    ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
                    recipeResult = recipe.getRecipeOutput();
                }

                if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
                {
                    System.out.println("[CookingCraft] Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
                    recipes.remove(scan);
                }
            }
        }
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event)
        {

            LocalizationHandler.loadLanguages();
            
            ModBlocks.initBlocks();
            
            ModItems.initItems();
            
            ModRecipies.init();
            
        }
        
        
        @Init
        public void load(FMLInitializationEvent event)
        {
        	
            GameRegistry.registerWorldGenerator(new OreGen());
            
        }
        
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event)
        {
            
            
        }
}
