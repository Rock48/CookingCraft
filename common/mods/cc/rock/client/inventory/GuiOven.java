package mods.cc.rock.client.inventory;

import mods.cc.rock.inventory.ContainerOven;
import mods.cc.rock.lib.Textures;
import mods.cc.rock.tileentity.TileEntityOven;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiOven extends GuiContainer{
	private TileEntityOven ovenInventory;
	private String title;
	public GuiOven(InventoryPlayer playerinv, TileEntityOven oven, String title) {
		super(new ContainerOven(playerinv, oven));
		this.ovenInventory = oven;
		this.title = title;
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        
        this.fontRenderer.drawString(title, this.xSize / 2 - this.fontRenderer.getStringWidth(title) / 2, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(Textures.OVEN_GUI);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.ovenInventory.isBurning())
        {
            i1 = this.ovenInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.ovenInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}
