package mods.cc.rock.item;

import mods.cc.rock.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemCC extends Item
{
	public String texture;
	
	public ItemCC(int id, String texture) 
	{
		super(id-256);
		this.texture = texture;
		this.setMaxStackSize(1);
	}
	
	public ItemCC(int id)
	{
		super(id-256);
	}
	
    public void registerIcons(IconRegister iconRegister)
    {
    	if(this.texture != null)
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.texture);
    }
}
