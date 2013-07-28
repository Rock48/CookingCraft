package mods.cc.rock;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.core.handlers.LocalizationHandler;
import mods.cc.rock.core.proxy.CommonProxy;
import mods.cc.rock.creativetabs.CreativeTabCC;
import mods.cc.rock.event.CookingCraftLivingDropsEvent;
import mods.cc.rock.item.ModItems;
import mods.cc.rock.lib.Messages;
import mods.cc.rock.lib.Reference;
import mods.cc.rock.recipie.ModRecipies;
import mods.cc.rock.tileentity.TileEntityOven;
import mods.cc.rock.tileentity.TileEntityRefridgerator;
import mods.cc.rock.util.LogUtil;
import mods.cc.rock.world.OreGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
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
        
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event)
        {
        	GameRegistry.registerTileEntity(TileEntityRefridgerator.class, "tileRefridgerator");
        	GameRegistry.registerTileEntity(TileEntityOven.class, "tileOven");
            //Init Log
            LogUtil.init();
            
            //Load Language Files
            LocalizationHandler.loadLanguages();
            LogUtil.info(Messages.MSG_LOCALIZATION_INITIALIZATION_SUCCESS);
            
            //Load Blocks
            ModBlocks.initBlocks();
            
            //Load Items
            ModItems.initItems();
            
            //Load Recipes
            ModRecipies.init();
            
        }
        
        
        @Init
        public void load(FMLInitializationEvent event)
        {
        	
            //gui
        	NetworkRegistry.instance().registerGuiHandler(instance, proxy);
        	//Load Ore Gen
            GameRegistry.registerWorldGenerator(new OreGen());
            LogUtil.info(Messages.MSG_ORE_GENERATION_SUCCESS);
            
            //Register Mob Drops
            MinecraftForge.EVENT_BUS.register(new CookingCraftLivingDropsEvent());
            LogUtil.info(Messages.MSG_MOB_DROP_INITIALIZATION_SUCCESS);
           
            
        }
        
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event)
        {
             LogUtil.info(Messages.MSG_MOD_INIT_SUCCESS);
            
        }

}
