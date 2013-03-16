package mods.cc.rock.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemUnscripted extends Item
{
	public String itemTexture;

	public ItemUnscripted(int par1, String par2)
	{
		super(par1);
		this.itemTexture = par2;
	}
	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.func_94245_a("cc:"+this.itemTexture);
	}

}
