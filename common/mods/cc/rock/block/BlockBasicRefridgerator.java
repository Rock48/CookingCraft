package mods.cc.rock.block;

import mods.cc.rock.client.gui.inventory.GuiBasicRefridgerator;
import mods.cc.rock.inventory.ContainerBasicRefridgerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class BlockBasicRefridgerator extends Block
{
	public String blockTexture;
	public BlockBasicRefridgerator(int par1)
	{
		super(par1, Material.rock);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		 this.blockIcon = iconRegister.registerIcon("cc:basicFridge");
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c)
	{
		if(player instanceof EntityPlayerMP)
		{
			ModLoader.serverOpenWindow((EntityPlayerMP) player, new ContainerBasicRefridgerator(), 85, x, y, z);
		}
		else
		{
			ModLoader.openGUI((EntityPlayerSP) player, new GuiBasicRefridgerator(player.inventory, x, y, z));
		}
		return true;
	}
	/*public TileEntity createNewTileEntity(World par1World)
	{
		return new TileEntityBasicRefridgerator();
	}*/
}