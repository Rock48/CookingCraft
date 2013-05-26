package mods.cc.rock.recipie;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingRecipies
{

    public static void init()
    {
        
        GameRegistry.addSmelting(ModBlocks.aluminumOre.blockID, new ItemStack(ModItems.ingotAluminum), 1F);
        
        GameRegistry.addSmelting(Item.wheat.itemID, new ItemStack(ModItems.itemFlour, 2), 1F);
        
    }
    
}
