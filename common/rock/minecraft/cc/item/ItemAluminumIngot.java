package rock.minecraft.cc.item;

import rock.minecraft.cc.lib.Sprites;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAluminumIngot extends Item
{

	public ItemAluminumIngot(int par1) 
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
	{
		return Sprites.CC_ITEMS;
	}

}
