package rock.minecraft.cc.block;
import rock.minecraft.cc.lib.Sprites;
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
		return Sprites.CC_BLOCKS;
	}
}
