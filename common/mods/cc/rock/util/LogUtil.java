package mods.cc.rock.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import mods.cc.rock.lib.Reference;
import cpw.mods.fml.common.FMLLog;

public class LogUtil {
	private static Logger ccLog = Logger.getLogger(Reference.MOD_NAME);
	
	public static void init(){
		ccLog.setParent(FMLLog.getLogger());
		
		log(Level.INFO, "Initializing Log");
	}
	
	public static void log(Level level, String msg){
		
		ccLog.log(level, msg);
	}
}
