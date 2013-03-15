package mods.cc.rock.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BakingItemBlock extends ItemBlock 
{
	public BakingItemBlock(int par1) {
		super(par1);
		setHasSubtypes(true);
		setUnlocalizedName("bakingItemOven");
	}
	private final static String[] subNames = {
		"on","off"
	};
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
	}


}
