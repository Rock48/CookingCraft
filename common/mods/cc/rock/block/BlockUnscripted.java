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
	public void func_94332_a(IconRegister iconRegister)
	{
		 this.field_94336_cN = iconRegister.func_94245_a("cc:"+this.blockTexture);
	}
}