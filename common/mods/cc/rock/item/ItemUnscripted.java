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
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("cc:"+this.itemTexture);
	}

}
