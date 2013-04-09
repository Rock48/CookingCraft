package mods.cc.rock.client.gui.inventory;

import mods.cc.rock.inventory.ContainerBasicRefridgerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBasicRefridgerator extends GuiContainer
{
	public GuiBasicRefridgerator(InventoryPlayer inventory, int x, int y, int z) 
	{
		super(new ContainerBasicRefridgerator());
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRenderer.drawString("Basic Refridgerator", 5, -39, 4210752);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/cc/textures/gui/fridge.png");
		this.xSize = 176;
		this.ySize = 256;
		int xStart = (this.width - this.xSize)/2;
		int yStart = (this.height - this.ySize)/2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}
}
