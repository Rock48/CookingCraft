package mods.cc.rock.lib;

import net.minecraft.util.ResourceLocation;

public class Textures {
	
	public static final String GUI_SHEET_LOCATION = "textures/gui/";
	
	//Blocks
	public static final String TEX_KITCHEN_TILE = "BlockKitchenTile";
	public static final String TEX_ALUMINUM_ORE = "BlockAluminumOre";
	public static final String TEX_MACHINE_CORE_ON = "rsBlockOn";
	public static final String TEX_MACHINE_CORE_OFF = "rsBlockOff";
	
	//Items
	public static final String TEX_ALUMINUM_INGOT = "ItemAluminumIngot";
	public static final String TEX_HAMMER = "ItemHammer";
	public static final String TEX_ROD = "ItemRod";
	public static final String TEX_FLOUR = "ItemFlour";
	public static final String TEX_OIL_LIGHT = "oilLight";
	public static final String TEX_OIL_DARK = "oilDark";
	public static final String TEX_FRYING_PAN = "ItemFryingPan";
	public static final String TEX_DOUGH = "ItemDough";
	public static final String TEX_ROLLING_PIN_1 = "RollingPin1";
	public static final String TEX_ROLLING_PIN_2 = "RollingPin2";
	
	//GUIs
	public static final ResourceLocation REFRIDGERATOR_GUI = new ResourceLocation(Reference.MOD_ID.toLowerCase(), GUI_SHEET_LOCATION + "fridge.png");
	public static final ResourceLocation OVEN_GUI = new ResourceLocation(Reference.MOD_ID.toLowerCase(), GUI_SHEET_LOCATION + "oven.png");
	public static final ResourceLocation FOOD_ASS_GUI = new ResourceLocation(Reference.MOD_ID.toLowerCase(), GUI_SHEET_LOCATION + "foodass.png");
}
