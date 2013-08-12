package mods.cc.rock;

import java.io.File;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.configuration.ConfigHandler;
import mods.cc.rock.core.handlers.LocalizationHandler;
import mods.cc.rock.core.proxy.CommonProxy;
import mods.cc.rock.core.util.LogUtil;
import mods.cc.rock.creativetabs.CreativeTabCC;
import mods.cc.rock.event.CookingCraftLivingDropsEvent;
import mods.cc.rock.item.ModItems;
import mods.cc.rock.lib.Messages;
import mods.cc.rock.lib.Reference;
import mods.cc.rock.recipie.ModRecipies;
import mods.cc.rock.world.OreGen;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CookingCraft
{
        @Instance(Reference.MOD_ID)
        public static CookingCraft instance;
        
    	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    	public static CommonProxy proxy;
    	
    	public static CreativeTabs tabCC = new CreativeTabCC(Reference.MOD_ID);
        
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event)
        {
        	
            //Init Log
            LogUtil.init();
            
            //Load Language Files
            LocalizationHandler.loadLanguages();
            
            //Load the Configuration File
            ConfigHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_NAME + ".cfg"));
            
            //Register Sound Handler
            proxy.registerSoundHandler();
            
            //Load Blocks
            ModBlocks.initBlocks();
            
            //Load Items
            ModItems.initItems();
            
            //Load Recipes
            ModRecipies.init();
            
        }
        
        
        @EventHandler
        public void load(FMLInitializationEvent event)
        {
        	
            //Register GUI Handler
        	NetworkRegistry.instance().registerGuiHandler(instance, proxy);
        	
        	//Load Ore Gen
            GameRegistry.registerWorldGenerator(new OreGen());
            LogUtil.info(Messages.MSG_ORE_GENERATION_SUCCESS);
            
            //Register Mob Drops
            MinecraftForge.EVENT_BUS.register(new CookingCraftLivingDropsEvent());
            LogUtil.info(Messages.MSG_MOB_DROP_INITIALIZATION_SUCCESS);
            
            //Register Tile Entities
            proxy.registerTileEntities();
            
        }
        
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event)
        {
             LogUtil.info(Messages.MSG_MOD_INIT_SUCCESS);
        }

}
