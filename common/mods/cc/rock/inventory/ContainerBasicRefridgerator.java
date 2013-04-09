package mods.cc.rock.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBasicRefridgerator extends Container
{

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	

}
