package mods.cc.rock.inventory;



import mods.cc.rock.item.ModItems;
import mods.cc.rock.recipie.CraftingManagerCC;
import mods.cc.rock.tileentity.TileEntityFoodAssembler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.Item;
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
        
        this.addSlotToContainer(new SlotCrafting(inventoryPlayer.player, this.tileEntity, this.craftResult, 0, 80, 81));
        
        //the Slot constructor takes the IInventory and the slot number in that it binds to
        //and the x-y coordinates it resides on-screen
        
        int x;
        int y;
        
        //circle
        
        this.addSlotToContainer(new Slot(tileEntity, 0, 80, 24));

        this.addSlotToContainer(new Slot(tileEntity, 1, 120, 39));
        
        this.addSlotToContainer(new Slot(tileEntity, 2, 134, 81));
        
        this.addSlotToContainer(new Slot(tileEntity, 3, 120, 123));
        
        this.addSlotToContainer(new Slot(tileEntity, 4, 80, 138));
        
        this.addSlotToContainer(new Slot(tileEntity, 5, 40, 123));
        
        this.addSlotToContainer(new Slot(tileEntity, 6, 26, 81));
        
        this.addSlotToContainer(new Slot(tileEntity, 7, 40, 39));
        
        
        
        
        

        //commonly used vanilla code that adds the player's inventory
            
        this.bindPlayerInventory(inventoryPlayer);
        
        tileEntity.eventHandler = this;
        
        this.onCraftMatrixChanged(this.tileEntity);
    }
    
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
    	//player main inv
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 9; j++) {
    			
    			addSlotToContainer(new SlotRefrigerator(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 174 + i * 18,true));
    			
    		}
        }
    	//player hotbar
        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotRefrigerator(inventoryPlayer, j, 8 + j * 18, 232,true));
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
        /*ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack())
        {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();
            
            if (slot == 0)
            {
                if (!this.mergeItemStack(stackInSlot, 10, 46, true))
                {
                    return null;
                }

                slotObject.onSlotChange(stackInSlot, stack);
            }
            
            //merges the item into player inventory since its in the tileEntity
            if (slot < TileScientificAssembler.INVENTORY_SIZE)
            {
                if (!this.mergeItemStack(stackInSlot, 0, 35, true))
                    return null;
            }
            //places it into the tileEntity is possible since its in the player inventory
            else if (!this.mergeItemStack(stackInSlot, 0, TileScientificAssembler.INVENTORY_SIZE, false))
                return null;

            
            if (stackInSlot.stackSize == 0)
                slotObject.putStack(null);
            else
                slotObject.onSlotChanged();

            if (stackInSlot.stackSize == stack.stackSize)
                return null;
            
            
            if (stackInSlot.stackSize == stack.stackSize)
                return null;

            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        
        return stack;*/
    	return null;
    }
    
    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManagerCC.getInstance().findMatchingRecipe(this.tileEntity, this.worldObj));
        
        
        
    }
    
    


   
}
