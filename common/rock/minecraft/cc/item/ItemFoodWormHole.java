package rock.minecraft.cc.item;

import rock.minecraft.cc.lib.Sprites;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemFoodWormHole extends Item
{

	public ItemFoodWormHole(int id) 
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
	{
		return Sprites.CC_ITEMS;
	}
	

}
