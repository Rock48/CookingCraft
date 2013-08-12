package mods.cc.rock.core.proxy;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.cc.rock.client.inventory.GuiFoodAssembler;
import mods.cc.rock.client.inventory.GuiOven;
import mods.cc.rock.client.inventory.GuiRefridgerator;
import mods.cc.rock.inventory.ContainerFoodAssembler;
import mods.cc.rock.inventory.ContainerOven;
import mods.cc.rock.inventory.ContainerRefridgerator;
import mods.cc.rock.lib.GuiIDs;
import mods.cc.rock.tileentity.TileEntityFoodAssembler;
import mods.cc.rock.tileentity.TileEntityOven;
import mods.cc.rock.tileentity.TileEntityRefridgerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler
{
    
    public void registerSoundHandler() {}
    
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityRefridgerator.class, "tileRefridgerator");
        GameRegistry.registerTileEntity(TileEntityOven.class, "tileOven");
        GameRegistry.registerTileEntity(TileEntityFoodAssembler.class, "tileFoodAssembler");
    }
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        
        if(ID == GuiIDs.ID_REFRIDGERATOR)
                return new ContainerRefridgerator(player.inventory, (TileEntityRefridgerator) tileEntity);
        else if (ID == GuiIDs.ID_OVEN1 || ID == GuiIDs.ID_OVEN2 || ID == GuiIDs.ID_OVEN3)
            return new ContainerOven(player.inventory, (TileEntityOven) tileEntity);
        else if (ID == GuiIDs.FOOD_ASS)
            return new ContainerFoodAssembler(player.inventory, (TileEntityFoodAssembler) tileEntity, world);
        else
            return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        
        if (ID == GuiIDs.ID_REFRIDGERATOR)
                return new GuiRefridgerator(player.inventory, (TileEntityRefridgerator) tileEntity);
        else if (ID == GuiIDs.ID_OVEN1)
            return new GuiOven(player.inventory, (TileEntityOven) tileEntity, "Oven Mk1");
        else if (ID == GuiIDs.ID_OVEN2)
            return new GuiOven(player.inventory, (TileEntityOven) tileEntity, "Oven Mk2");
        else if (ID == GuiIDs.ID_OVEN3)
            return new GuiOven(player.inventory, (TileEntityOven) tileEntity, "Oven Mk3");
        else if (ID == GuiIDs.FOOD_ASS)
            return new GuiFoodAssembler(player.inventory, (TileEntityFoodAssembler) tileEntity, world);
        else
            return null;
    }
    
}
