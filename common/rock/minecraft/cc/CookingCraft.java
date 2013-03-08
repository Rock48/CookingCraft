package rock.minecraft.cc;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import rock.minecraft.cc.block.BlockCakeSpawner;
import rock.minecraft.cc.block.BlockKitchenTile;
import rock.minecraft.cc.core.proxy.CommonProxy;
import rock.minecraft.cc.item.ItemFoodWormHole;
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
	
	public static Item foodWormHole;
	
	@SidedProxy(clientSide = "rock.minecraft.cc.core.proxy.ClientProxy", serverSide = "rock.minecraft.cc.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		kitchenTile = new BlockKitchenTile(250,0).setBlockName("kitchenTile");
		cakeSpawner = new BlockCakeSpawner(251,1).setBlockName("cakeSpawner").setRequiresSelfNotify();
		foodWormHole = new ItemFoodWormHole(1235).setIconIndex(0).setItemName("foodWormHole");
		
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getBlockName());
		GameRegistry.registerBlock(cakeSpawner, cakeSpawner.getBlockName());
		
		LanguageRegistry.addName(kitchenTile, "Kitchen Tile");
		LanguageRegistry.addName(cakeSpawner, "Cake Spawner");
		
		LanguageRegistry.addName(foodWormHole, "Food Worm Hole");
		
		GameRegistry.addShapelessRecipe(new ItemStack(kitchenTile, 1), new Object[]{Block.stoneBrick});
		GameRegistry.addRecipe(new ItemStack(cakeSpawner, 1), new Object[]{
			"CCC",
			"SFS",
			"RSR",
			'C', Item.cake, 'S', Block.stone, 'R', Block.torchRedstoneActive, 'F', foodWormHole
			});
		GameRegistry.addRecipe(new ItemStack(foodWormHole, 8), new Object[]{
			"AEA",
			"ENE",
			"AEA",
			'A', Item.appleRed, 'E', Item.enderPearl, 'N', Item.netherStar
		});
	}

}
