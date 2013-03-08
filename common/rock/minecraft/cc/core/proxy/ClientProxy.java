package rock.minecraft.cc.core.proxy;

import rock.minecraft.cc.lib.Sprites;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture(Sprites.CC_BLOCKS);
	}

}
