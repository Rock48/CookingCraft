package mods.cc.rock.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import mods.cc.rock.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogUtil
{
	private static Logger ccLog = Logger.getLogger(Reference.MOD_NAME);
	
	public static void init()
	{
		ccLog.setParent(FMLLog.getLogger());
		info("Initializing Log");
	}
	
	public static void log(Level level, String msg)
	{
		ccLog.log(level, msg);
	}
	
	public static void info(String msg)
	{
	    ccLog.log(Level.INFO, msg);
	}
	
	public static void warning(String msg)
    {
        ccLog.log(Level.WARNING, msg);
    }
	
	public static void severe(String msg)
    {
        ccLog.log(Level.SEVERE, msg);
    }
	
	public static void fine(String msg)
    {
        ccLog.log(Level.FINE, msg);
    }

    public static void finer(String msg)
    {
        ccLog.log(Level.FINER, msg);
    }

    public static void finest(String msg)
    {
        ccLog.log(Level.FINEST, msg);
    }
}
