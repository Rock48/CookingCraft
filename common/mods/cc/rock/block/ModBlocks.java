package mods.cc.rock.block;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.lib.BlockIDs;
import mods.cc.rock.lib.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
    public static Block machineCoreOn;
    public static Block machineCoreOff;
	public static Block kitchenTile;
	public static Block aluminumOre;
	public static void initBlocks()
	{
		
 		kitchenTile = new BlockCC(BlockIDs.ID_KITCHEN_TILE, Material.rock, Textures.TEX_KITCHEN_TILE).setHardness(1F).setResistance(2F).setCreativeTab(CookingCraft.tabCC).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("kitchenTile");
		MinecraftForge.setBlockHarvestLevel(kitchenTile, "pickaxe", 0);
		
		aluminumOre = new BlockCC(BlockIDs.ID_ALUMINUM_ORE, Material.rock, Textures.TEX_ALUMINUM_ORE).setHardness(3F).setResistance(5F).setCreativeTab(CookingCraft.tabCC).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreAluminum");
		MinecraftForge.setBlockHarvestLevel(aluminumOre, "pickaxe", 2);
		
		machineCoreOff = new BlockMachineCore(BlockIDs.ID_MACHINE_CORE, false).setHardness(1F).setResistance(2F).setCreativeTab(CookingCraft.tabCC).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("machineCoreOff");
		MinecraftForge.setBlockHarvestLevel(machineCoreOff, "pickaxe", 0);
		
		machineCoreOn = new BlockMachineCore(BlockIDs.ID_MACHINE_CORE_ON, true).setHardness(1F).setResistance(2F).setCreativeTab(CookingCraft.tabCC).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("machineCoreOn");	
		MinecraftForge.setBlockHarvestLevel(machineCoreOff, "pickaxe", 0);
		
		registry();
	}
	
	private static void registry()
	{
	    
		//Register Blocks
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getUnlocalizedName());
		GameRegistry.registerBlock(aluminumOre, aluminumOre.getUnlocalizedName());
		GameRegistry.registerBlock(machineCoreOff, machineCoreOff.getUnlocalizedName());
		GameRegistry.registerBlock(machineCoreOn, machineCoreOn.getUnlocalizedName());
		
	}
	
}
