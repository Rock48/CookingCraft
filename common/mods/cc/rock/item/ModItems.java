package mods.cc.rock.item;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.lib.ItemIDs;
import mods.cc.rock.lib.Textures;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
    
	public static Item ingotAluminum;
	public static Item itemHammer;
	public static Item itemRod;
	public static Item itemFlour;
	public static Item oilLight;
	public static Item oilDark;
	
	public static void initItems()
    {
		
		ingotAluminum = new ItemCC(ItemIDs.ID_ALUMINUM_INGOT, Textures.TEX_ALUMINUM_INGOT).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("ingotAluminum");
    	itemHammer = new ItemHammer(ItemIDs.ID_HAMMER, Textures.TEX_HAMMER);
		itemRod = new ItemCC(ItemIDs.ID_ROD, Textures.TEX_ROD).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("itemRod");
		itemFlour = new ItemCC(ItemIDs.ID_FLOUR, Textures.TEX_FLOUR).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("itemFlour");
		oilLight = new ItemCC(ItemIDs.ID_OIL_LIGHT, Textures.TEX_OIL_LIGHT).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("itemOilLight");
		oilDark = new ItemCC(ItemIDs.ID_OIL_DARK, Textures.TEX_OIL_DARK).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("itemOilDark");
    	
    	registry();
    }
	
	public static void registry()
	{
		OreDictionary.registerOre("ingotAluminum", ingotAluminum);
	}

}
