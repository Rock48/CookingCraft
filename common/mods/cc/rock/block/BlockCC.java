package mods.cc.rock.block;


import mods.cc.rock.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockCC extends Block
{
	String texture;
	
	/**
	 * BlockCC
	 * @param id of block
	 * @param material of block
	 * @param texture of block
	 */
    public BlockCC(int id, Material material, String texture)
    {
        super(id, material);
        if(texture != null)
            this.texture = texture;
    }
    /**
     * BlockCC
     * @param id of block
     * @param material of block
     */
    public BlockCC(int id, Material material)
    {
        super(id, material);
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
    	if(this.texture != null)
    	    this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.texture);
    }

    
    /**Sets the direction of the block when placed*/



}