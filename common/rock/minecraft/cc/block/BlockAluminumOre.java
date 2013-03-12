package rock.minecraft.cc.block;

import rock.minecraft.cc.lib.Sprites;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockAluminumOre extends Block
{

	public BlockAluminumOre(int par1, int par2)
	{
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	public String getTextureFile()
	{
		return Sprites.CC_BLOCKS;
	}

}
