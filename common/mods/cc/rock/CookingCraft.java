package mods.cc.rock;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.core.proxy.CommonProxy;
import mods.cc.rock.item.ItemUnscripted;
import mods.cc.rock.world.OreGen;
import net.minecraft.block.Block;
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
		ModBlocks.init();
		
		proxy.registerRenderThings();
		
		foodWormHole = new ItemUnscripted(1235,"ItemFoodWormHole").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("foodWormHole");
		aluminumIngot = new ItemUnscripted(1236,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("aluminumIngot");
		bakingTray = new ItemUnscripted(1237,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("bakingTray");
		fryingPan = new ItemUnscripted(1238,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("fryingPan");
		saucePan = new ItemUnscripted(1239,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("saucePan");
		panHandle = new ItemUnscripted(1240,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("panHandle");
		
		LanguageRegistry.addName(foodWormHole, "Food Worm Hole");
		LanguageRegistry.addName(aluminumIngot, "Aluminum Ingot");
		LanguageRegistry.addName(bakingTray, "Baking Tray");
		LanguageRegistry.addName(fryingPan, "Frying Pan");
		LanguageRegistry.addName(saucePan, "Sauce Pan");
		LanguageRegistry.addName(panHandle, "Pan Handle");

		
		OreDictionary.registerOre("ingotAluminum", new ItemStack(aluminumIngot));
		
		GameRegistry.registerWorldGenerator(new OreGen());
		
		GameRegistry.addSmelting(ModBlocks.aluminumOre.blockID, new ItemStack(aluminumIngot), 0.4F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.kitchenTile, 1), new Object[]{Block.stoneBrick});
		addOreRecipe(new ItemStack(ModBlocks.cakeSpawner), new Object[]{
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
