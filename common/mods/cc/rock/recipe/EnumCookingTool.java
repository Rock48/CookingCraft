package mods.cc.rock.recipe;

public enum EnumCookingTool {
	none("NONE",0),
	woodenPin("PIN", 0),
	advancedPin("PIN", 1),
	basicWhisk("WHISK",0);
	
	private final String type;
	private final int level;
	
	EnumCookingTool(String type, int level) {
		this.type = type;
		this.level = level;
	}
	public String getType(){
		return this.type;
	}
	public int getLevel(){
		return this.level;
	}
}
