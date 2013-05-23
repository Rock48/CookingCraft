package mods.cc.rock.block;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.cc.rock.CookingCraft;
import mods.cc.rock.lib.BlockIDs;
import mods.cc.rock.lib.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class ModBlocks
{
    
	public static Block kitchenTile;
	public static Block aluminumOre;
	
	public static void initBlocks()
	{
		
 		kitchenTile = new BlockCC(BlockIDs.ID_KITCHEN_TILE, Material.rock, Textures.TEX_KITCHEN_TILE).setHardness(1F).setResistance(2F).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("kitchenTile");
		MinecraftForge.setBlockHarvestLevel(kitchenTile, "pickaxe", 0);
		
		aluminumOre = new BlockAluminumOre(BlockIDs.ID_ALUMINUM_ORE, Material.rock, Textures.TEX_ALUMINUM_ORE);
		MinecraftForge.setBlockHarvestLevel(aluminumOre, "pickaxe", 2);
		
		
		registry();
		blockCrafting();
	}
	
	private static void registry()
	{
	    
		//Register Blocks
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getUnlocalizedName());
		GameRegistry.registerBlock(aluminumOre, aluminumOre.getUnlocalizedName());
		
	}
	
	private static void blockCrafting()
	{
	    
		GameRegistry.addShapelessRecipe(new ItemStack(kitchenTile), new Object[]{Block.stoneBrick});
		
	}
}
