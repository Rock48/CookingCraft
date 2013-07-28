package mods.cc.rock.core.proxy;

import cpw.mods.fml.common.network.IGuiHandler;
import mods.cc.rock.inventory.ContainerOven;
import mods.cc.rock.inventory.ContainerRefridgerator;
import mods.cc.rock.tileentity.TileEntityOven;
import mods.cc.rock.tileentity.TileEntityRefridgerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(ID==0){
                return new ContainerRefridgerator(player.inventory, (TileEntityRefridgerator) tileEntity);
        }
        if(ID==1){
            return new ContainerOven(player.inventory, (TileEntityOven) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
