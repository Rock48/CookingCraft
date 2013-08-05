package mods.cc.rock.recipie;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.core.util.RecipeHelper;
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
        RecipeHelper.addOreRecipe(new ItemStack(ModBlocks.kitchenTile, 5), new Object[]{
            "ASA",
            "SSS",
            "ASA",
            'A', "ingotAluminum", 'S', Block.stoneBrick});
        
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.kitchenTile), Block.stoneBrick, ModItems.ingotAluminum);
        
        //Machine Core
        RecipeHelper.addOreRecipe(new ItemStack(ModBlocks.machineCoreOff), new Object[]{
            "ARA",
            "ISI",
            "ARA",
            'A', "ingotAluminum", 'R', Item.redstone, 'I', Item.ingotIron, 'S', Item.ingotGold});
        
        //Hammer 
        RecipeHelper.addOreRecipe(new ItemStack(ModItems.itemHammer), new Object[]{
        	"AAA",
        	"AS ",
        	" S ",
        	'A', "ingotAluminum", 'S', ModItems.itemRod
        });
        
        //Bread
        GameRegistry.addShapedRecipe(new ItemStack(Item.bread), new Object[]{
        	"OFO",
        	"FWF",
        	"OFO",
        	'O', ModItems.oilLight, 'F', ModItems.itemFlour, 'W', Item.bucketWater
        });
        
        //Rod
        RecipeHelper.addOreRecipe(new ItemStack(ModItems.itemRod, 2), new Object[]{
        	"DAD",
        	"DAD",
        	'D', new ItemStack(Item.dyePowder, 1, 1), 'A', "ingotAluminum"
        });
        
        //Light Oil
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.oilLight, 4), Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Block.plantYellow);
        
        //Dark Oil
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.oilDark, 4), Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Block.plantRed);
        
        //Frying Pan
        RecipeHelper.addOreRecipe(new ItemStack(ModItems.fryingPan), new Object[]{
            "AA ",
            "AI ",
            "  R",
            'A', "ingotAluminum", 'R', ModItems.itemRod, 'I', Item.ingotIron
        });
        RecipeHelper.addOreRecipe(new ItemStack(ModBlocks.fridge), new Object[]{
        	"AAA",
        	"RCR",
        	"AAA",
        	'A', "ingotAluminum", 'C', ModBlocks.machineCoreOff, 'R', Block.blockRedstone
        });

    }
    
}
