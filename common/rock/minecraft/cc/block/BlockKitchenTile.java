package rock.minecraft.cc.block;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockKitchenTile extends Block
{
	public BlockKitchenTile(int id, int texture)
	{
		super(id, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);

	}
	public String getTextureFile()
	{
		return "/rock/minecraft/cc/art/sprites/cc_blocks.png";
	}
}
