
package mods.cc.rock.block;

import java.util.Random;

import mods.cc.rock.item.ModItems;
import mods.cc.rock.lib.Reference;
import mods.cc.rock.lib.Textures;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMachineCore extends BlockCC
{
	private boolean isActive;
	
	public BlockMachineCore(int id, boolean par2Active)
	{
		super(id, Material.rock);
		this.isActive = par2Active;
		this.setHardness(1F).setResistance(2F).setStepSound(Block.soundStoneFootstep);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
		if(this.isActive)
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()+":"+Textures.TEX_MACHINE_CORE_ON);
		else if(!this.isActive)
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()+":"+Textures.TEX_MACHINE_CORE_OFF);
	}
	
    public void onBlockAdded(World par1World, int x, int y, int z)
    {
    	if(!par1World.isRemote)
    	{
            if(this.isActive && !par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.scheduleBlockUpdate(x, y, z, this.blockID, 4);
            }
            else if (!this.isActive && par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.setBlock(x, y, z, ModBlocks.machineCoreOn.blockID, 0, 2);
            }
    	}
    }
    
    public void onNeighborBlockChange(World par1World, int x, int y, int z, int par5)
    {	
    	if(!par1World.isRemote)
    	{
            if(this.isActive && !par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.scheduleBlockUpdate(x, y, z, this.blockID, 4);
            }
            else if (!this.isActive && par1World.isBlockIndirectlyGettingPowered(x, y, z))
            {
            	par1World.setBlock(x, y, z, ModBlocks.machineCoreOn.blockID, 0, 2);
            }
    	}
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && this.isActive && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            par1World.setBlock(par2, par3, par4, ModBlocks.machineCoreOff.blockID, 0, 2);
        }
    }
    
    public boolean canCreatureSpawn(EnumCreatureType type, World world, int x, int y, int z){
    	return false;
    }
    
    public void dropItem(World par1World, int par2, int par3, int par4, int par5, EntityLiving par6EntityLiving)
    {
        if (!par1World.isRemote)
        {
            if ((par5 & 1) == 1)
            {
                EntityItem entityItem = new EntityItem(par1World, (double) par2 + Math.random(), (double) par3 + Math.random(), (double) par4 + Math.random(), new ItemStack(this));
                par1World.spawnEntityInWorld(entityItem);
            }
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem().itemID == ModItems.itemHammer.itemID)
        {
            this.dropItem(par1World, par2, par3, par4, 1, par5EntityPlayer);
            par1World.setBlockToAir(par2, par3, par4);
            return true;
        }
        else
        {
            return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
        }
    }
}

