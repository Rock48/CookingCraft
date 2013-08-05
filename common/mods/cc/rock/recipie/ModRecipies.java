package mods.cc.rock.recipie;

import mods.cc.rock.core.util.LogUtil;
import mods.cc.rock.lib.Messages;

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
