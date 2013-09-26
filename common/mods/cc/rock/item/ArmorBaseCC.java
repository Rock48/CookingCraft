package mods.cc.rock.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import mods.cc.rock.lib.Reference;

public class ArmorBaseCC extends ItemArmor
{
    String texture;
    
    public ArmorBaseCC(int id, EnumArmorMaterial armorType, int i, int clothesType)
    {
        this(id, null, armorType, i, clothesType);
    }
    
    
    public ArmorBaseCC(int id, String texture, EnumArmorMaterial armorType, int i, int clothesType)
    {
        super(id, armorType, i, clothesType);
        
        if (texture != null)
            this.texture = texture;
    }
    
    public void registerIcons(IconRegister iconRegister)
    {
        if (this.texture != null)
            itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.texture);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        return null;
        
    }

}
