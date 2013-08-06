package mods.cc.rock.recipie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mods.cc.rock.item.ModItems;
import mods.cc.rock.lib.ItemIDs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SuppressWarnings("rawtypes")
public class OvenRecipes
{
    private static final OvenRecipes smeltingBase = new OvenRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final OvenRecipes smelting()
    {
        return smeltingBase;
    }

    private OvenRecipes()
    {
        this.addSmelting(Item.wheat.itemID, new ItemStack(ModItems.itemFlour, 2), 1F);
        this.addSmelting(Item.porkRaw.itemID, new ItemStack(Item.porkCooked), 0.5F);
        this.addSmelting(Item.beefRaw.itemID, new ItemStack(Item.beefCooked), 0.5F);
        this.addSmelting(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked), 0.5F);
        this.addSmelting(Item.fishRaw.itemID, new ItemStack(Item.fishCooked), 0.5F);
        this.addSmelting(Item.potato.itemID, new ItemStack(Item.bakedPotato), 0.5F);
        this.addSmelting(ItemIDs.ID_OIL_DARK, new ItemStack(ModItems.oilCookedDark), 0.5F);
        this.addSmelting(ItemIDs.ID_OIL_LIGHT, new ItemStack(ModItems.oilCookedLight), 0.5F);
    }

    /**
     * Adds a smelting recipe.
     */
    @SuppressWarnings("unchecked")
    public void addSmelting(int id, ItemStack itemStack, float xp)
    {
        this.smeltingList.put(Integer.valueOf(id), itemStack);
        this.experienceList.put(Integer.valueOf(itemStack.itemID), Float.valueOf(xp));
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    @Deprecated //In favor of ItemStack sensitive version
    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemID, metadata), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
            return 0;

        float ret = item.getItem().getSmeltingExperience(item);
        
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));

        if (ret < 0 && experienceList.containsKey(item.itemID))
            ret = ((Float)experienceList.get(item.itemID)).floatValue();

        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaSmeltingList;
    }
}
