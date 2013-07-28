package mods.cc.rock.core.proxy;

import mods.cc.rock.client.inventory.GuiOven;
import mods.cc.rock.client.inventory.GuiRefridgerator;
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
        if(ID==0){
        	
                return new GuiRefridgerator(player.inventory, (TileEntityRefridgerator) tileEntity);
                
        }
        if(ID==1){
        	
            return new GuiOven(player.inventory, (TileEntityOven) tileEntity);
            
        }
        return null;
    }
}
