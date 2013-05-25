package mods.cc.rock.item;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.lib.ItemIDs;
import mods.cc.rock.lib.Textures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
	public static Item ingotAluminum;
	public static void initItems()
    {
		ingotAluminum = new ItemCC(ItemIDs.ID_ALUMINUM_INGOT, Textures.TEX_ALUMINUM_INGOT).setCreativeTab(CookingCraft.tabCC).setUnlocalizedName("ingotAluminum");
    	itemCrafting();
    	registry();
    }
	public static void registry()
	{
		OreDictionary.registerOre("ingotAluminum", ingotAluminum);
	}
	public static void itemCrafting()
    {
    	GameRegistry.addSmelting(ModBlocks.aluminumOre.blockID, new ItemStack(ingotAluminum), 99999F);
    }
}
