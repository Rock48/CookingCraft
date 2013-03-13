package mods.cc.rock.block;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockKitchenTile extends Block
{
	public BlockKitchenTile(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);

	}
	@Override
	public void func_94332_a(IconRegister iconRegister)
	{
		 this.field_94336_cN = iconRegister.func_94245_a("cc:BlockKitchenTile");
	}
}
