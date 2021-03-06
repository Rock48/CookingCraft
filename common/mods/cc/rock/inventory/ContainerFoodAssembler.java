package mods.cc.rock.inventory;



import mods.cc.rock.recipe.CraftingManagerCC;
import mods.cc.rock.tileentity.TileEntityFoodAssembler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerFoodAssembler extends Container
{
    protected TileEntityFoodAssembler tileEntity;
    private World worldObj;
    
    public IInventory craftResult = new InventoryCraftingResultCC();
    
    public ContainerFoodAssembler (InventoryPlayer inventoryPlayer, TileEntityFoodAssembler te, World world)
    {
        tileEntity = te;
        this.worldObj = world;
        
        this.addSlotToContainer(new SlotCraftingCC(inventoryPlayer.player, this.tileEntity, this.craftResult, 0, 80, 81));
        
        //the Slot constructor takes the IInventory and the slot number in that it binds to
        //and the x-y coordinates it resides on-screen
        
        //circle
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 80, 24));

        this.addSlotToContainer(new Slot(tileEntity, 1, 120, 39));
        
        this.addSlotToContainer(new Slot(tileEntity, 2, 134, 81));
        
        this.addSlotToContainer(new Slot(tileEntity, 3, 120, 123));
        
        this.addSlotToContainer(new Slot(tileEntity, 4, 80, 138));
        
        this.addSlotToContainer(new Slot(tileEntity, 5, 40, 123));
        
        this.addSlotToContainer(new Slot(tileEntity, 6, 26, 81));
        
        this.addSlotToContainer(new Slot(tileEntity, 7, 40, 39));
        
        
        //Rolling Pin
        this.addSlotToContainer(new SlotCookingTool(tileEntity, 8, 143, 146));
        
        
        //Commonly used vanilla code that adds the player's inventory
        this.bindPlayerInventory(inventoryPlayer);
        
        tileEntity.eventHandler = this;
        
        this.onCraftMatrixChanged(this.tileEntity);
    }
    
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
    	//player main inv
    	for (int i = 0; i < 3; i++)
    	{
    		for (int j = 0; j < 9; j++)
    			addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 174 + i * 18));
        }
    	
    	//player hotbar
        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, j, 8 + j * 18, 232));
        }
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return true;
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {

        ItemStack itemstack = null;
        Slot slot1 = (Slot) this.inventorySlots.get(slot);

        if (slot1 != null && slot1.getHasStack())
        {
            ItemStack itemstack1 = slot1.getStack();
            itemstack = itemstack1.copy();
            
            if (slot < TileEntityFoodAssembler.INVENTORY_SIZE + 1)
            {
                if (!this.mergeItemStack(itemstack1, TileEntityFoodAssembler.INVENTORY_SIZE + 1, this.inventorySlots.size(), true))
                    return null;
            }
            else if (!this.mergeItemStack(itemstack1, 1, TileEntityFoodAssembler.INVENTORY_SIZE + 1, false))
                return null;

            if (itemstack1.stackSize == 0)
                slot1.putStack((ItemStack) null);
            else
                slot1.onSlotChanged();

            if (itemstack1.stackSize == itemstack.stackSize)
                return null;

            slot1.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
    
    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManagerCC.getInstance().findMatchingRecipe(this.tileEntity, this.worldObj));
    }
}
