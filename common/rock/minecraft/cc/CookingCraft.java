package rock.minecraft.cc;

import net.minecraft.block.Block;
import rock.minecraft.cc.block.BlockCakeSpawner;
import rock.minecraft.cc.block.BlockKitchenTile;
import rock.minecraft.cc.core.proxy.CommonProxy;
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
	@SidedProxy(clientSide = "rock.minecraft.cc.core.proxy.ClientProxy", serverSide = "rock.minecraft.cc.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		kitchenTile = new BlockKitchenTile(250,0).setBlockName("kitchenTile");
		cakeSpawner = new BlockCakeSpawner(251,1).setBlockName("cakeSpawner").setRequiresSelfNotify();
		
		GameRegistry.registerBlock(kitchenTile, "kitchenTile");
		GameRegistry.registerBlock(cakeSpawner, "cakeSpawner");
		
		LanguageRegistry.addName(kitchenTile, "Kitchen Tile");
		LanguageRegistry.addName(cakeSpawner, "Cake Spawner");
	}

}
