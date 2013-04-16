package mods.cc.rock;

import mods.cc.rock.block.ModBlocks;
import mods.cc.rock.client.gui.inventory.GuiBasicRefridgerator;
import mods.cc.rock.core.proxy.CommonProxy;
import mods.cc.rock.item.ItemUnscripted;
import mods.cc.rock.tileentity.TileEntityBasicRefridgerator;
import mods.cc.rock.tileentity.TileEntityPrimitiveOven;
import mods.cc.rock.world.OreGen;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_CookingCraft extends BaseMod
{
	
	public static Item foodWormHole;
	public static Item aluminumIngot;
	public static Item bakingTray;
	public static Item fryingPan;
	public static Item saucePan;
	public static Item panHandle;
	
	@SidedProxy(clientSide = "mods.cc.rock.core.proxy.ClientProxy", serverSide = "mods.cc.rock.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Override
	public String getName()
	{
		return "CookingCraft";
	}
	@Override
	public String getVersion() 
	{
		return "0.0.1";
	}
	@Override
	public void load()
		{
			MinecraftForge.EVENT_BUS.register(new mods.cc.rock.event.CookingCraftLivingDropsEvent());
		
			ModBlocks.init();
			
			ModLoader.registerContainerID(this, 85);
			proxy.registerRenderThings();
			
			foodWormHole = new ItemUnscripted(1235,"ItemFoodWormHole").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("foodWormHole");
			aluminumIngot = new ItemUnscripted(1236,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("aluminumIngot");
			bakingTray = new ItemUnscripted(1237,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("bakingTray");
			fryingPan = new ItemUnscripted(1238,"ItemFryingPan").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("fryingPan");
			saucePan = new ItemUnscripted(1239,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("saucePan");
			panHandle = new ItemUnscripted(1240,"ItemAluminumIngot").setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("panHandle");
			
			LanguageRegistry.addName(foodWormHole, "Food Worm Hole");
			LanguageRegistry.addName(aluminumIngot, "Aluminum Ingot");
			LanguageRegistry.addName(bakingTray, "Baking Tray");
			LanguageRegistry.addName(fryingPan, "Frying Pan");
			LanguageRegistry.addName(saucePan, "Sauce Pan");
			LanguageRegistry.addName(panHandle, "Pan Handle");

			
			OreDictionary.registerOre("ingotAluminum", new ItemStack(aluminumIngot));
			
			GameRegistry.registerWorldGenerator(new OreGen());
			
			GameRegistry.registerTileEntity(TileEntityPrimitiveOven.class, "tileEntityPrimitiveOven");
			GameRegistry.registerTileEntity(TileEntityBasicRefridgerator.class, "tileEntityBasicRefridgerator");
			
			GameRegistry.addSmelting(ModBlocks.aluminumOre.blockID, new ItemStack(aluminumIngot), 0.4F);
			
			GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.kitchenTile, 1), new Object[]{Block.stoneBrick});
			addOreRecipe(new ItemStack(ModBlocks.cakeSpawner), new Object[]{
				"CCC",
				"AFA",
				"RSR",
				'C', Item.cake, 'S', Block.stone, 'R', Block.torchRedstoneActive, 'F', foodWormHole, 'A',"ingotAluminum"
			});
			GameRegistry.addRecipe(new ItemStack(foodWormHole, 8), new Object[]{
				"AEA",
				"ENE",
				"AEA",
				'A', Item.appleRed, 'E', Item.enderPearl, 'N', Item.netherStar
			});
			addOreRecipe(new ItemStack(bakingTray), new Object[]{
				"A A",
				"AAA",
				'A', "ingotAluminum"
			});
			addOreRecipe(new ItemStack(panHandle), new Object[]{
				"LL ",
				"AAA",
				"LL ",
				'L', Item.leather, 'A', "ingotAluminum"
			});
			addOreRecipe(new ItemStack(fryingPan), new Object[]{
				"P  ",
				"AAA",
				'A', "ingotAluminum", 'P', panHandle
			});
			addOreRecipe(new ItemStack(saucePan), new Object[]{
				"P  ",
				"A A",
				"AAA",
				'A', "ingotAluminum", 'P', panHandle
			});
			addOreRecipe(new ItemStack(ModBlocks.rsTestBlockOff), new Object[]{
				"ARA",
				"RAR",
				"ARA",
				'A', "ingotAluminum", 'R', Item.redstone
			});
		}
		@SuppressWarnings("unchecked")
		public static void addOreRecipe(ItemStack output, Object[] input) 
		{
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, new Object[] { Boolean.valueOf(true), input }));
		}
		@SideOnly(Side.CLIENT)
		public GuiContainer getContainerGUI(EntityClientPlayerMP player, int id, int x, int y, int z)
		{
			switch(id)
			{
			
			case 85:
				return new GuiBasicRefridgerator(player.inventory, x, y, z);
			default:
				return null;
			}
		}
}
