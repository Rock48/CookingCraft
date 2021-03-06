package mods.cc.rock.item;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.lib.ItemIDs;
import mods.cc.rock.lib.Textures;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;

import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
    
    //Items
	public static Item ingotAluminum;
	public static Item itemHammer;
	public static Item itemRod;
	public static Item itemFlour;
	public static Item oilLight;
	public static Item oilDark;
	public static Item oilCookedLight;
    public static Item oilCookedDark;
	public static Item fryingPan;
	public static Item dough;
	public static Item rollingPin1;
	public static Item rollingPin2;
	public static Item chefHat;
	
	//Custom Enum Armor Materials -- NTS: The int array is # of armor points {helmet, chestpiece, leggings, boots}
    public static EnumArmorMaterial BLANK_LOOKS = EnumHelper.addArmorMaterial("LOOKS", -1, new int[] {0, 0, 0, 0}, 0);
    
    
	public static void initItems()
    {
		
		ingotAluminum = new ItemCC(ItemIDs.ID_ALUMINUM_INGOT, Textures.TEX_ALUMINUM_INGOT).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("ingotAluminum").setMaxStackSize(64);
    	itemHammer = new ItemHammer(ItemIDs.ID_HAMMER, Textures.TEX_HAMMER);
		itemRod = new ItemCC(ItemIDs.ID_ROD, Textures.TEX_ROD).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("itemRod").setMaxStackSize(64);
		itemFlour = new ItemCC(ItemIDs.ID_FLOUR, Textures.TEX_FLOUR).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("itemFlour").setMaxStackSize(64);
		oilLight = new ItemCC(ItemIDs.ID_OIL_LIGHT, Textures.TEX_OIL_LIGHT).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("oilLight").setMaxStackSize(8);
		oilDark = new ItemCC(ItemIDs.ID_OIL_DARK, Textures.TEX_OIL_DARK).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("oilDark").setMaxStackSize(8);
		oilCookedLight = new ItemCC(ItemIDs.ID_OIL_COOKED_LIGHT, Textures.TEX_OIL_LIGHT).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("oilCookedLight").setMaxStackSize(8);
        oilCookedDark = new ItemCC(ItemIDs.ID_OIL_COOKED_DARK, Textures.TEX_OIL_DARK).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("oilCookedDark").setMaxStackSize(8);
    	fryingPan = new ItemCC(ItemIDs.ID_FRYING_PAN, Textures.TEX_FRYING_PAN).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("fryingPan");
		dough = new ItemCC(ItemIDs.ID_DOUGH, Textures.TEX_DOUGH).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("dough").setMaxStackSize(64);
    	rollingPin1 = new ItemCookingTool(ItemIDs.ID_ROLLING_PIN_1, Textures.TEX_ROLLING_PIN_1,"PIN",0).setUnlocalizedName("rollingPin1").setMaxDamage(5);
    	rollingPin2 = new ItemCookingTool(ItemIDs.ID_ROLLING_PIN_2, Textures.TEX_ROLLING_PIN_2,"PIN",1).setUnlocalizedName("rollingPin2").setMaxDamage(15);
    	
    	chefHat = new ArmorBaseCC(ItemIDs.ID_CHEF_HAT, BLANK_LOOKS, 0, 0).setUnlocalizedName("chefHat").setCreativeTab(CookingCraft.tabCC);
    	
    	registry();
    }
	
	public static void registry()
	{
		OreDictionary.registerOre("ingotAluminum", ingotAluminum);
	}

}
