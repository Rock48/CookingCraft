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
        CookingCraft.addOreRecipe(new ItemStack(ModItems.itemRod), new Object[]{
        	"DAD",
        	"DAD",
        	'D', new ItemStack(Item.dyePowder, 1, 1), 'A', "ingotAluminum"
        });
        
        //Light Oil
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.oilLight), Item.potion, Block.plantYellow);
        
        //Dark Oil
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.oilDark), Item.potion, Block.plantRed);
        
        //Frying Pan
        CookingCraft.addOreRecipe(new ItemStack(ModItems.fryingPan), new Object[]{
            "AA ",
            "AI ",
            "  R",
            'A', new ItemStack(ModItems.ingotAluminum), 'R', new ItemStack(ModItems.itemRod), 'I', new ItemStack(Item.ingotIron)
        });
    }
    
}
