package mods.cc.rock.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator
{
	Random random;
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		this.random = random;
		generateAluminum(world,chunkX*16,chunkZ*16);
		
	}

	private void generateAluminum(World world, int i, int j)
	{
		for(int k=0;k<30;k++)
		{
			int xCoord = i + this.random.nextInt(16);
			int yCoord = this.random.nextInt(55);
			int zCoord = j + this.random.nextInt(16);
			//new WorldGenMinable(ModBlocks.aluminumOre.blockID, 6).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
}
