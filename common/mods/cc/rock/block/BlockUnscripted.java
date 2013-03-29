package mods.cc.rock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockUnscripted extends Block
{
	public String blockTexture;
	public BlockUnscripted(int par1, Material par2Material, String par3)
	{
		super(par1, par2Material);
		this.blockTexture = par3;
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		 this.blockIcon = iconRegister.registerIcon("cc:"+this.blockTexture);
	}
}