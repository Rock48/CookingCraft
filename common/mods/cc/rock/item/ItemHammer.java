package mods.cc.rock.item;

import mods.cc.rock.CookingCraft;
import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.core.util.GeneralHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHammer extends ItemCC
{
	
	public ItemHammer(int id, String texture)
	{
		super(id, texture);
		this.setUnlocalizedName("itemHammer")
			.setCreativeTab(CookingCraft.tabCC)
			.setMaxDamage(25);
	}

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if(!par3World.isRemote && (par3World.getBlockId(par4, par5, par6) == ModBlocks.machineCoreOn.blockID || par3World.getBlockId(par4, par5, par6) == ModBlocks.machineCoreOff.blockID))
    	{

    		par1ItemStack.damageItem(1, par2EntityPlayer);
            GeneralHelper.spawnItemOnGround(par3World, par4, par5, par6, 1, par2EntityPlayer, new ItemStack(ModBlocks.machineCoreOff));
            par3World.setBlockToAir(par4, par5, par6);
    		
    	}
    	if(!par3World.isRemote && (par3World.getBlockId(par4, par5, par6) == ModBlocks.fridge.blockID))
    	{

    		par1ItemStack.damageItem(1, par2EntityPlayer);
            GeneralHelper.spawnItemOnGround(par3World, par4, par5, par6, 1, par2EntityPlayer, new ItemStack(ModBlocks.fridge));
            par3World.setBlockToAir(par4, par5, par6);
    		
    	}
    	if(!par3World.isRemote && (par3World.getBlockId(par4, par5, par6) == ModBlocks.oven1On.blockID) || (par3World.getBlockId(par4, par5, par6) == ModBlocks.oven1.blockID))
    	{

    		par1ItemStack.damageItem(1, par2EntityPlayer);
            GeneralHelper.spawnItemOnGround(par3World, par4, par5, par6, 1, par2EntityPlayer, new ItemStack(ModBlocks.oven1));
            par3World.setBlockToAir(par4, par5, par6);
    		
    	}
    	if(!par3World.isRemote && (par3World.getBlockId(par4, par5, par6) == ModBlocks.oven2On.blockID) || (par3World.getBlockId(par4, par5, par6) == ModBlocks.oven2.blockID))
    	{

    		par1ItemStack.damageItem(1, par2EntityPlayer);
            GeneralHelper.spawnItemOnGround(par3World, par4, par5, par6, 1, par2EntityPlayer, new ItemStack(ModBlocks.oven2));
            par3World.setBlockToAir(par4, par5, par6);
    		
    	}
    	if(!par3World.isRemote && (par3World.getBlockId(par4, par5, par6) == ModBlocks.oven3On.blockID) || (par3World.getBlockId(par4, par5, par6) == ModBlocks.oven3.blockID))
    	{

    		par1ItemStack.damageItem(1, par2EntityPlayer);
            GeneralHelper.spawnItemOnGround(par3World, par4, par5, par6, 1, par2EntityPlayer, new ItemStack(ModBlocks.oven3));
            par3World.setBlockToAir(par4, par5, par6);
    		
    	}
    	if(!par3World.isRemote && (par3World.getBlockId(par4, par5, par6) == ModBlocks.foodAssembler.blockID))
    	{

    		par1ItemStack.damageItem(1, par2EntityPlayer);
            GeneralHelper.spawnItemOnGround(par3World, par4, par5, par6, 1, par2EntityPlayer, new ItemStack(ModBlocks.foodAssembler));
            par3World.setBlockToAir(par4, par5, par6);
    		
    	}
    	return true;
    }
	

    //on entity right clicked
    @Override
    public boolean onLeftClickEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, Entity par3EntityLivingBase){
    	
    	if(par3EntityLivingBase instanceof EntityCreeper){
    		//get hp
    		float tempHp = ((EntityCreeper) par3EntityLivingBase).getHealth();
    		((EntityCreeper) par3EntityLivingBase).onStruckByLightning(new EntityLightningBolt(par2EntityPlayer.worldObj, 0, 0, 0));
    		((EntityCreeper) par3EntityLivingBase).extinguish();
    		((EntityCreeper) par3EntityLivingBase).setHealth(tempHp);
    	
    		return true;
    	}
    	
    	return false;
    }
    
	
	

}
