package mods.cc.rock.core.helpers;

import net.minecraft.entity.EntityLiving;

public class ItemHelper
{
    /**
     * 
     * @param entity
     *         The entity that will drop the item.
     * @param id
     *         The id to drop.
     * @param rarity
     *         The higher the number, the rarer it is to drop. Do 1 for constant drop.
     */
    public static void dropItem(EntityLiving entity, int id, int rarity)
    {
        dropItem(entity, id, rarity, 1);
    }
    
    /**
     * 
     * @param entity
     * @param id
     * @param rarity
     * @param amount
     */
    public static void dropItem(EntityLiving entity, int id, int rarity, int amount)
    {
        double r = Math.random() * rarity;

        if ((int) r == 0)
            entity.dropItem(id, amount);
    }
}
