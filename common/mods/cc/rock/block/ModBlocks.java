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
	public static Block fridge;
	public static Block oven1;
	public static Block oven1On;
	public static Block oven2;
	public static Block oven2On;
	public static Block oven3;
	public static Block oven3On;
	
	public static void initBlocks()
	{
		
 		kitchenTile = new BlockCC(BlockIDs.ID_KITCHEN_TILE, Material.rock, Textures.TEX_KITCHEN_TILE).setHardness(1F).setResistance(2F).setCreativeTab(CookingCraft.tabCC).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("kitchenTile");
		aluminumOre = new BlockCC(BlockIDs.ID_ALUMINUM_ORE, Material.rock, Textures.TEX_ALUMINUM_ORE).setHardness(3F).setResistance(5F).setCreativeTab(CookingCraft.tabCC).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreAluminum");
		machineCoreOff = new BlockMachineCore(BlockIDs.ID_MACHINE_CORE, false).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("machineCoreOff");
		machineCoreOn = new BlockMachineCore(BlockIDs.ID_MACHINE_CORE_ON, true).setUnlocalizedName("machineCoreOn").setLightValue(0.9F);
		fridge = new BlockRefridgerator(BlockIDs.ID_FRIDGE).setUnlocalizedName("fridge").setCreativeTab(CookingCraft.tabCC);
		
		//OVENS
		
		//OVEN MK1
		oven1 = new BlockOven(BlockIDs.ID_OVEN1_OFF, false, 1).setUnlocalizedName("Oven1").setCreativeTab(CookingCraft.tabCC);
		oven1On = new BlockOven(BlockIDs.ID_OVEN1_ON, true, 1).setUnlocalizedName("Oven1On").setLightValue(1F);
		
		//OVEN MK2
		oven2 = new BlockOven(BlockIDs.ID_OVEN2_OFF, false, 2).setUnlocalizedName("Oven2").setCreativeTab(CookingCraft.tabCC);
		oven2On = new BlockOven(BlockIDs.ID_OVEN2_ON, true, 2).setUnlocalizedName("Oven2On").setLightValue(1F);
		
		//OVEN MK3
		oven3 = new BlockOven(BlockIDs.ID_OVEN3_OFF, false, 3).setUnlocalizedName("Oven3").setCreativeTab(CookingCraft.tabCC);
		oven3On = new BlockOven(BlockIDs.ID_OVEN3_ON, true, 3).setUnlocalizedName("Oven3On").setLightValue(1F);
		harvests();
		registry();
	}
	
	private static void harvests()
	{
	    //Set Block Harvest Levels
	    MinecraftForge.setBlockHarvestLevel(kitchenTile, "pickaxe", 0);
	    MinecraftForge.setBlockHarvestLevel(aluminumOre, "pickaxe", 2);
	    MinecraftForge.setBlockHarvestLevel(machineCoreOff, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(machineCoreOff, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(fridge, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(oven1, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(oven1On, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(oven2, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(oven2On, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(oven3, "pickaxe", 1);
	    MinecraftForge.setBlockHarvestLevel(oven3On, "pickaxe", 1);
	    
	}
	
	private static void registry()
	{
		//Register Blocks
		GameRegistry.registerBlock(kitchenTile, kitchenTile.getUnlocalizedName());
		GameRegistry.registerBlock(aluminumOre, aluminumOre.getUnlocalizedName());
		GameRegistry.registerBlock(machineCoreOff, machineCoreOff.getUnlocalizedName());
		GameRegistry.registerBlock(machineCoreOn, machineCoreOn.getUnlocalizedName());
		GameRegistry.registerBlock(fridge, fridge.getUnlocalizedName());
		GameRegistry.registerBlock(oven1, oven1.getUnlocalizedName());
		GameRegistry.registerBlock(oven1On, oven1On.getUnlocalizedName());
		GameRegistry.registerBlock(oven2, oven2.getUnlocalizedName());
		GameRegistry.registerBlock(oven2On, oven2On.getUnlocalizedName());
		GameRegistry.registerBlock(oven3, oven3.getUnlocalizedName());
		GameRegistry.registerBlock(oven3On, oven3On.getUnlocalizedName());
	}
	
}
