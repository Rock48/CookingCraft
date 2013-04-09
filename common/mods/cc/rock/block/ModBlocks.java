package mods.cc.rock.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks 
{
	public static Block kitchenTile;
	public static Block cakeSpawner;
	public static Block aluminumOre;
	public static Block primitiveOven;
	public static Block basicRefridgerator;
	
	public static void init()
	{
		kitchenTile = new BlockUnscripted(250,Material.rock,"BlockKitchenTile").setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("kitchenTile");
		aluminumOre = new BlockUnscripted(251,Material.rock,"BlockAluminumOre").setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("aluminumOre");
		cakeSpawner = new BlockCakeSpawner(252).setCreativeTab(CreativeTabs.tabRedstone).setUnlocalizedName("cakeSpawner");
		primitiveOven = new BlockPrimitiveOven(253, false).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("PrimitiveOven");
		basicRefridgerator = new BlockBasicRefridgerator(254).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("basicRefridgerator");
		
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getUnlocalizedName());
		GameRegistry.registerBlock(cakeSpawner, cakeSpawner.getUnlocalizedName());
		GameRegistry.registerBlock(aluminumOre, aluminumOre.getUnlocalizedName());
		GameRegistry.registerBlock(primitiveOven, primitiveOven.getUnlocalizedName());
		GameRegistry.registerBlock(basicRefridgerator, basicRefridgerator.getUnlocalizedName());
		
		LanguageRegistry.addName(kitchenTile, "Kitchen Tile");
		LanguageRegistry.addName(cakeSpawner, "Cake Spawner");
		LanguageRegistry.addName(aluminumOre, "Aluminum Ore");
		LanguageRegistry.addName(primitiveOven, "Primitive Oven [WIP] do not use yet");
		
		OreDictionary.registerOre("oreAlimunum", new ItemStack(aluminumOre));
	}
	
}
