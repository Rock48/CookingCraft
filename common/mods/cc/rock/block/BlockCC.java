package mods.cc.rock.block;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.cc.rock.lib.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;


public class BlockCC extends Block
{
	String texture;
	/**
	 * 
	 * @param id of block
	 * @param material of block
	 * @param texture of block: use null if Overriding registerIcons
	 */
    public BlockCC(int id, Material material, String texture)
    {
        super(id, material);
        if(texture != null)
        this.texture = texture;
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
    	if(this.texture != null)
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.texture);
    }

    
    /*Sets the direction of the block when placed
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
    }*/


}