package rock.minecraft.cc;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import rock.minecraft.cc.block.BlockAluminumOre;
import rock.minecraft.cc.block.BlockCakeSpawner;
import rock.minecraft.cc.block.BlockKitchenTile;
import rock.minecraft.cc.core.proxy.CommonProxy;
import rock.minecraft.cc.item.ItemAluminumIngot;
import rock.minecraft.cc.item.ItemFoodWormHole;
import rock.minecraft.cc.world.OreGen;
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
	
	@SidedProxy(clientSide = "rock.minecraft.cc.core.proxy.ClientProxy", serverSide = "rock.minecraft.cc.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		kitchenTile = new BlockKitchenTile(250,0).setBlockName("kitchenTile");
		cakeSpawner = new BlockCakeSpawner(251,1).setBlockName("cakeSpawner").setRequiresSelfNotify();
		aluminumOre = new BlockAluminumOre(252,2).setBlockName("aluminumOre");
		
		aluminumIngot = new ItemAluminumIngot(1236).setIconIndex(1).setItemName("aluminumIngot");
		foodWormHole = new ItemFoodWormHole(1235).setIconIndex(0).setItemName("foodWormHole");
		
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getBlockName());
		GameRegistry.registerBlock(cakeSpawner, cakeSpawner.getBlockName());
		GameRegistry.registerBlock(aluminumOre, aluminumOre.getBlockName());
		
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
