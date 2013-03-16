package mods.cc.rock;

import mods.cc.rock.block.BakingItemBlock;
import mods.cc.rock.block.BlockBakingOven;
import mods.cc.rock.block.BlockCakeSpawner;
import mods.cc.rock.block.BlockUnscripted;
import mods.cc.rock.core.proxy.CommonProxy;
import mods.cc.rock.item.ItemUnscripted;
import mods.cc.rock.world.OreGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "CC", name = "CookingCraft", version = "pralpha0a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CookingCraft 
{
	public static Block kitchenTile;
	public static Block cakeSpawner;
	public static Block aluminumOre;
	public static Block bakingOven;
	
	public static Item foodWormHole;
	public static Item aluminumIngot;
	public static Item bakingTray;
	public static Item fryingPan;
	public static Item saucePan;
	public static Item panHandle;
	
	@SidedProxy(clientSide = "mods.cc.rock.core.proxy.ClientProxy", serverSide = "mods.cc.rock.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		kitchenTile = new BlockUnscripted(250,Material.rock,"BlockKitchenTile").setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("kitchenTile");
		aluminumOre = new BlockUnscripted(251,Material.rock,"BlockAluminumOre").setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("aluminumOre");
		cakeSpawner = new BlockCakeSpawner(252).setCreativeTab(CreativeTabs.tabRedstone).setUnlocalizedName("cakeSpawner");
		bakingOven = new BlockBakingOven(253).setCreativeTab(CreativeTabs.tabBlock);
		
		foodWormHole = new ItemUnscripted(1235,"ItemFoodWormHole").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("foodWormHole");
		aluminumIngot = new ItemUnscripted(1236,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("aluminumIngot");
		bakingTray = new ItemUnscripted(1237,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("bakingTray");
		fryingPan = new ItemUnscripted(1238,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("fryingPan");
		saucePan = new ItemUnscripted(1239,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("saucePan");
		panHandle = new ItemUnscripted(1240,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("panHandle");
		
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getUnlocalizedName());
		GameRegistry.registerBlock(cakeSpawner, cakeSpawner.getUnlocalizedName());
		GameRegistry.registerBlock(aluminumOre, aluminumOre.getUnlocalizedName());
		GameRegistry.registerBlock(bakingOven, BakingItemBlock.class, "bakingOven");
		
		LanguageRegistry.addName(kitchenTile, "Kitchen Tile");
		LanguageRegistry.addName(cakeSpawner, "Cake Spawner");
		LanguageRegistry.addName(foodWormHole, "Food Worm Hole");
		LanguageRegistry.addName(aluminumOre, "Aluminum Ore");
		LanguageRegistry.addName(aluminumIngot, "Aluminum Ingot");
		LanguageRegistry.addName(bakingTray, "Baking Tray");
		LanguageRegistry.addName(fryingPan, "Frying Pan");
		LanguageRegistry.addName(saucePan, "Sauce Pan");
		LanguageRegistry.addName(panHandle, "Pan Handle");
		LanguageRegistry.addName(new ItemStack(bakingOven,1,0), "Primative Oven");
		LanguageRegistry.addName(new ItemStack(bakingOven,1,1), "Primative Oven On");
		
		OreDictionary.registerOre("ingotAluminum", new ItemStack(aluminumIngot));
		OreDictionary.registerOre("oreAlimunum", new ItemStack(aluminumOre));
		
		GameRegistry.registerWorldGenerator(new OreGen());
		
		GameRegistry.addSmelting(aluminumOre.blockID, new ItemStack(aluminumIngot), 0.4F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(kitchenTile, 1), new Object[]{Block.stoneBrick});
		addOreRecipe(new ItemStack(cakeSpawner), new Object[]{
			"CCC",
			"AFA",
			"RSR",
			'C', Item.cake, 'S', Block.stone, 'R', Block.torchRedstoneActive, 'F', foodWormHole, 'A',"ingotAluminum"
		});
		GameRegistry.addRecipe(new ItemStack(foodWormHole, 8), new Object[]{
			"AEA",
			"ENE",
			"AEA",
			'A', Item.appleRed, 'E', Item.enderPearl, 'N', Item.netherStar
		});
		addOreRecipe(new ItemStack(bakingTray), new Object[]{
			"A A",
			"AAA",
			'A', "ingotAluminum"
		});
		addOreRecipe(new ItemStack(panHandle), new Object[]{
			"LL ",
			"AAA",
			"LL ",
			'L', Item.leather, 'A', "ingotAluminum"
		});
		addOreRecipe(new ItemStack(fryingPan), new Object[]{
			"P  ",
			"AAA",
			'A', "ingotAluminum", 'P', panHandle
		});
		addOreRecipe(new ItemStack(saucePan), new Object[]{
			"P  ",
			"A A",
			"AAA",
			'A', "ingotAluminum", 'P', panHandle
		});
	}
	@SuppressWarnings("unchecked")
	public static void addOreRecipe(ItemStack output, Object[] input) 
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, new Object[] { Boolean.valueOf(true), input }));
	}

}
