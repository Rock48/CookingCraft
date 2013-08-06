package mods.cc.rock.recipie;

import mods.cc.rock.core.util.LogUtil;
import mods.cc.rock.item.ModItems;
import mods.cc.rock.lib.BlockIDs;
import mods.cc.rock.lib.ItemIDs;
import mods.cc.rock.lib.Messages;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingRecipies
{

    public static void init()
    {
        //Aluminum
        GameRegistry.addSmelting(BlockIDs.ID_ALUMINUM_ORE, new ItemStack(ModItems.ingotAluminum), 1F);
        
        //Lightflower Oil
        GameRegistry.addSmelting(ItemIDs.ID_OIL_LIGHT, new ItemStack(ModItems.oilCookedLight), 0.2F);
        
        LogUtil.info(Messages.MSG_SMELTING_RECIPE_SUCCESS);
        
    }
    
}
