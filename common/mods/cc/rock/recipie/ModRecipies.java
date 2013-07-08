package mods.cc.rock.recipie;

import mods.cc.rock.lib.Messages;
import mods.cc.rock.util.LogUtil;

public class ModRecipies
{

    public static void init()
    {
        RecipeOverride.init();
        
        CraftingRecipies.init();
        
        SmeltingRecipies.init();
        
        LogUtil.info(Messages.MSG_CRAFTING_RECIPE_SUCCESS);
    }
    
}
