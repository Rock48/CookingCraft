package rock.minecraft.cc.world;

import java.util.Random;

import rock.minecraft.cc.CookingCraft;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		generateAluminum(world,chunkX*16,chunkZ*16);
	}

	private void generateAluminum(World world, int i, int j)
	{
		Random random = new Random();
		for(int k=0;k<30;k++)
		{
			int xCoord = i + random.nextInt(16);
			int yCoord = random.nextInt(55);
			int zCoord = j + random.nextInt(16);
			new WorldGenMinable(CookingCraft.aluminumOre.blockID, 6).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
}
