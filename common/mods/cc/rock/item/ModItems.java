package mods.cc.rock.item;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.lib.ItemIDs;
import mods.cc.rock.lib.Textures;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
    
	public static Item ingotAluminum;
	
	
	public static void initItems()
    {
		ingotAluminum = new ItemCC(ItemIDs.ID_ALUMINUM_INGOT, Textures.TEX_ALUMINUM_INGOT).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("ingotAluminum");
    	
		
    	registry();
    }
	
	public static void registry()
	{
		OreDictionary.registerOre("ingotAluminum", ingotAluminum);
	}

}
