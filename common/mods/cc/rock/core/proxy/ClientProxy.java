package mods.cc.rock.core.proxy;

import mods.cc.rock.client.inventory.GuiOven;
import mods.cc.rock.client.inventory.GuiRefridgerator;
import mods.cc.rock.lib.GuiIDs;
import mods.cc.rock.tileentity.TileEntityOven;
import mods.cc.rock.tileentity.TileEntityRefridgerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        
    	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(ID==GuiIDs.ID_REFRIDGERATOR){
        	
                return new GuiRefridgerator(player.inventory, (TileEntityRefridgerator) tileEntity);
                
        }
        if(ID==GuiIDs.ID_OVEN1){
        	
            return new GuiOven(player.inventory, (TileEntityOven) tileEntity, "Oven Mk1");
            
        }
        if(ID==GuiIDs.ID_OVEN2){
        	
            return new GuiOven(player.inventory, (TileEntityOven) tileEntity, "Oven Mk2");
            
        }
        if(ID==GuiIDs.ID_OVEN3){
	
        	return new GuiOven(player.inventory, (TileEntityOven) tileEntity, "Oven Mk3");
    
        }
        return null;
    }
}
