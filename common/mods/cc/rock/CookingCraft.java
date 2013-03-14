package mods.cc.rock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import mods.cc.rock.block.BlockAluminumOre;
import mods.cc.rock.block.BlockCakeSpawner;
import mods.cc.rock.block.BlockKitchenTile;
import mods.cc.rock.core.proxy.CommonProxy;
import mods.cc.rock.item.ItemAluminumIngot;
import mods.cc.rock.item.ItemFoodWormHole;
import mods.cc.rock.world.OreGen;
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
	
	public static Item foodWormHole;
	public static Item aluminumIngot;
	
	@SidedProxy(clientSide = "mods.cc.rock.core.proxy.ClientProxy", serverSide = "mods.cc.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		kitchenTile = new BlockKitchenTile(250);
		cakeSpawner = new BlockCakeSpawner(251);
		aluminumOre = new BlockAluminumOre(252);
		
		aluminumIngot = new ItemAluminumIngot(1236);
		foodWormHole = new ItemFoodWormHole(1235);
		
		GameRegistry.registerBlock(kitchenTile, "kitchenTile");
		GameRegistry.registerBlock(cakeSpawner, "cakeSpawner");
		GameRegistry.registerBlock(aluminumOre, "aluminumOre");
		
		LanguageRegistry.addName(kitchenTile, "Kitchen Tile");
		LanguageRegistry.addName(cakeSpawner, "Cake Spawner");	
		LanguageRegistry.addName(foodWormHole, "Food Worm Hole");
		LanguageRegistry.addName(aluminumOre, "Aluminum Ore");
		LanguageRegistry.addName(aluminumIngot, "Aluminum Ingot");
		
		OreDictionary.registerOre("ingotAluminum", new ItemStack(aluminumIngot));
		OreDictionary.registerOre("oreAlimunum", new ItemStack(aluminumOre));
		
		GameRegistry.registerWorldGenerator(new OreGen());
		
		GameRegistry.addSmelting(aluminumOre.blockID, new ItemStack(aluminumIngot), 0.4F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(kitchenTile, 1), new Object[]{Block.stoneBrick});
		addOreRecipe(new ItemStack(cakeSpawner, 1), new Object[]{
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
	}
	@SuppressWarnings("unchecked")
	public static void addOreRecipe(ItemStack output, Object[] input) 
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, new Object[] { Boolean.valueOf(true), input }));
	}

}
