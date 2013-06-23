package mods.cc.rock.recipie;

import java.util.logging.Level;

import mods.cc.rock.lib.Messages;
import mods.cc.rock.util.LogUtil;

public class ModRecipies
{

    public static void init()
    {
        RecipeOverride.init();
        
        CraftingRecipies.init();
        
        SmeltingRecipies.init();
        
        LogUtil.log(Level.INFO, Messages.MSG_CRAFTING_RECIPE_SUCCESS);
    }
    
}
