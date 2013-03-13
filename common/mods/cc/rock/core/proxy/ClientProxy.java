package mods.cc.rock.core.proxy;

import mods.cc.rock.lib.Sprites;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture(Sprites.CC_BLOCKS);
	}

}
