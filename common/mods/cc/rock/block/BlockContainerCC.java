package mods.cc.rock.block;

import mods.cc.rock.tileentity.TileCC;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockContainerCC extends BlockContainer{

	public BlockContainerCC(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack)
    {
    	
	        int direction = 0;
	        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
	
	
	        switch (facing)
	        {
	        case 0:
	            direction = ForgeDirection.NORTH.ordinal();
	            break;
	                
	        case 1:
	            direction = ForgeDirection.EAST.ordinal();
	             break;
	                
	        case 2:
	            direction = ForgeDirection.SOUTH.ordinal();
	            break;
	            
	        case 3:
	            direction = ForgeDirection.WEST.ordinal();
	            break;
	                
	    };
	
	
	    world.setBlockMetadataWithNotify(x, y, z, direction, 3);
	
	
	    if (itemStack.hasDisplayName())
	    {
	        ((TileCC) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
	    }
	        
        ((TileCC) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }
	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return null;
	}
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
        par1World.markBlockForUpdate(par2, par3, par4);
    }
    
}
