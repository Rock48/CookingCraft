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
        CookingCraft.addOreRecipe(new ItemStack(ModBlocks.kitchenTile, 5), new Object[]{
            "ASA",
            "SSS",
            "ASA",
            'A', "ingotAluminum", 'S', Block.stoneBrick});
        
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.kitchenTile), Block.stoneBrick, ModItems.ingotAluminum);
        
        //Machine Core
        CookingCraft.addOreRecipe(new ItemStack(ModBlocks.machineCoreOff), new Object[]{
            "AGA",
            "ISI",
            "AGA",
            'A', "ingotAluminum", 'G', Block.glass, 'I', Item.ingotIron, 'S', Item.ingotGold});
        
        //Hammer
        CookingCraft.addOreRecipe(new ItemStack(ModItems.itemHammer), new Object[]{
        	"AAA",
        	"AS ",
        	" S ",
        	'A', "ingotAluminum", 'S', Item.stick
        });
        
        
    }
    
}
