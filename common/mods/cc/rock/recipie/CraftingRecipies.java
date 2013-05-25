package mods.cc.rock.recipie;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipies
{

    public static void init()
    {
        
        //Kitchen Tile
        GameRegistry.addRecipe(new ItemStack(ModBlocks.kitchenTile, 5),
            "asa",
            "sss",
            "asa",
            'a', new ItemStack(ModItems.ingotAluminum), 's', new ItemStack(Block.stoneBrick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.kitchenTile), Block.stoneBrick, ModItems.ingotAluminum);
        
        //Machine Core
        CookingCraft.addOreRecipe(new ItemStack(ModBlocks.machineCoreOff), new Object[]{
            "AGA",
            "ISI",
            "AGA",
            'A', "ingotAluminum", 'G', Block.glass, 'I', Item.ingotIron, 'S', Item.ingotGold});
        
        
    }
    
}
