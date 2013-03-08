package rock.minecraft.cc.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/rock/minecraft/cc/art/sprites/cc_blocks.png");
	}

}
