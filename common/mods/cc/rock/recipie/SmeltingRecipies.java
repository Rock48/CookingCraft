package mods.cc.rock.recipie;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.item.ModItems;
import mods.cc.rock.lib.Messages;
import mods.cc.rock.util.LogUtil;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingRecipies
{

    public static void init()
    {
        
        GameRegistry.addSmelting(ModBlocks.aluminumOre.blockID, new ItemStack(ModItems.ingotAluminum), 1F);
        
        LogUtil.info(Messages.MSG_SMELTING_RECIPE_SUCCESS);
        
    }
    
}
