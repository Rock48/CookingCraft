package mods.cc.rock.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks 
{
	public static Block kitchenTile;
	public static Block cakeSpawner;
	public static Block aluminumOre;
	public static Block primitiveOven;
	public static Block basicRefridgerator;
	public static Block rsTestBlockOff;
	public static Block rsTestBlockOn;
	
	public static void init()
	{
		kitchenTile = new BlockUnscripted(1100,Material.rock,"BlockKitchenTile").setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("kitchenTile").setHardness(2.0F).setResistance(15.0F);
		aluminumOre = new BlockUnscripted(1101,Material.rock,"BlockAluminumOre").setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("aluminumOre").setHardness(3.0F).setResistance(5.0F);
		cakeSpawner = new BlockCakeSpawner(1102).setCreativeTab(CreativeTabs.tabRedstone).setUnlocalizedName("cakeSpawner").setHardness(3.0F).setResistance(2.5F);
		primitiveOven = new BlockPrimitiveOven(1103, false).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("PrimitiveOven").setHardness(2.5F).setResistance(5.0F);
		basicRefridgerator = new BlockBasicRefridgerator(1104).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("basicRefridgerator").setHardness(2.0F).setResistance(5.0F);
		rsTestBlockOff = new BlockRsTestBlock(1105, false).setCreativeTab(CreativeTabs.tabRedstone).setUnlocalizedName("rsTestBlockOff").setHardness(3.0F).setResistance(20.0F);
		rsTestBlockOn = new BlockRsTestBlock(1106, true).setUnlocalizedName("rsTestBlockOn").setHardness(3.0F).setResistance(20.0F);
		
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getUnlocalizedName());
		GameRegistry.registerBlock(cakeSpawner, cakeSpawner.getUnlocalizedName());
		GameRegistry.registerBlock(aluminumOre, aluminumOre.getUnlocalizedName());
		GameRegistry.registerBlock(primitiveOven, primitiveOven.getUnlocalizedName());
		GameRegistry.registerBlock(basicRefridgerator, basicRefridgerator.getUnlocalizedName());
		GameRegistry.registerBlock(rsTestBlockOff, rsTestBlockOff.getUnlocalizedName());
		GameRegistry.registerBlock(rsTestBlockOn, rsTestBlockOn.getUnlocalizedName());
		
		LanguageRegistry.addName(kitchenTile, "Kitchen Tile");
		LanguageRegistry.addName(cakeSpawner, "Cake Spawner");
		LanguageRegistry.addName(aluminumOre, "Aluminum Ore");
		LanguageRegistry.addName(primitiveOven, "Primitive Oven [WIP] do not use yet");
		LanguageRegistry.addName(basicRefridgerator, "Basic Refridgerator");
		LanguageRegistry.addName(rsTestBlockOff, "Redstone Test Block");
		
		MinecraftForge.setBlockHarvestLevel(aluminumOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(cakeSpawner, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rsTestBlockOn, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rsTestBlockOff, "pickaxe", 1);
		
		OreDictionary.registerOre("oreAlimunum", new ItemStack(aluminumOre));
	}
	
}
