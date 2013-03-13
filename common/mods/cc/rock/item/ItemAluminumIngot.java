package mods.cc.rock.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAluminumIngot extends Item
{
	public ItemAluminumIngot(int par1) 
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.func_94245_a("cc:ItemAluminumIngot");
	}

}
