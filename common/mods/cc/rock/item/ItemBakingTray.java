package mods.cc.rock.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBakingTray extends Item
{
	public ItemBakingTray(int par1) 
	{
		super(par1);
	}
	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.func_94245_a("cc:ItemAluminumIngot");
	}
}
