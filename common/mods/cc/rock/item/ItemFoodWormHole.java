package mods.cc.rock.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemFoodWormHole extends Item
{
	public ItemFoodWormHole(int id) 
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.func_94245_a("cc:ItemFoodWormHole");
	}

}
