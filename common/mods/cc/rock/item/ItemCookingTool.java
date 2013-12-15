package mods.cc.rock.item;

import mods.cc.rock.CookingCraft;

public class ItemCookingTool extends ItemCC
{
	private int toolLevel;
	private String toolType;
    public ItemCookingTool(int id, String texture, String type ,int toolLevel)
    {
        super(id, texture);
        this.toolLevel = toolLevel;
        this.toolType = type;
        this.setCreativeTab(CookingCraft.tabCC);
    }
    public int getToolLevel(){
    	return this.toolLevel;
    }
    public String getToolType(){
    	return this.toolType;
    }
    
    
}
