package mods.cc.rock.item;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.block.ModBlocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHammer extends ItemCC{
	boolean used;
	public ItemHammer(int id, String texture) {
		super(id, texture);
		this.setUnlocalizedName("itemHammer")
			.setCreativeTab(CookingCraft.tabCC);
			used = false;
		
	}

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if((par3World.getBlockId(par4, par5, par6) == ModBlocks.machineCoreOn.blockID || par3World.getBlockId(par4, par5, par6) == ModBlocks.machineCoreOff.blockID))
    	{
    		par3World.spawnEntityInWorld(new EntityItem(par3World, (double) par4 + Math.random(), (double) par5 + Math.random(), (double) par6 + Math.random(), new ItemStack(ModBlocks.machineCoreOff)));
    		par3World.setBlockToAir(par4, par5, par6);

    		return true;
    	}
    	return false;
    }
    
    
	
	
	

}
