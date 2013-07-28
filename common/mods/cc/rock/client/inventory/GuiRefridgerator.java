package mods.cc.rock.client.inventory;

import mods.cc.rock.inventory.ContainerRefridgerator;
import mods.cc.rock.tileentity.TileEntityRefridgerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class GuiRefridgerator extends GuiContainer{

	public GuiRefridgerator(InventoryPlayer inventoryPlayer, TileEntityRefridgerator tileEntity) {
    
        	//the container is instanciated and passed to the superclass for handling 
        	super(new ContainerRefridgerator(inventoryPlayer, tileEntity));
        	ySize = 256;

	}
	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        //draw text and stuff here
        //the parameters for drawString are: string, x, y, color
        fontRenderer.drawString(StatCollector.translateToLocal("Refrigerator"), 6, 6, 4210752);
        //draws "Inventory" or your regional equivalent
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96, 4210752);
}
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        //draw your Gui here, only thing you need to change is the path
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/mods/cc/textures/gui/fridge.png");
        
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
	}
	

}
