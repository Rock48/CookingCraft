package mods.cc.rock.item;

import net.minecraft.item.ItemStack;

import mods.cc.rock.CookingCraft;

public class ItemRollingPin extends ItemCC
{
    public ItemRollingPin(int id, String texture)
    {
        super(id, texture);
        this.setCreativeTab(CookingCraft.tabCC);
    }
    
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        //par1ItemStack.damageItem(1, par1ItemStack.getItem().);
        return true;
    }

}
