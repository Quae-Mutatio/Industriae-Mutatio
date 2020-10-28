package dev.quae.mods.industriae.container;

import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import org.jetbrains.annotations.Nullable;

public class IMTieredMachineContainer extends Container {

  private final IWorldPosCallable canInteractWithCallable;
  private MachineType machine;
  private SpeedTier tier;
  public int playerInvY;
  public int titleY;
  public IMTieredMachineContainer(int id, PlayerInventory playerInventory, IMTieredProcessingMachineTileEntity tile, MachineType machine, SpeedTier tier) {
    super(machine.getContainerType(tier), id);
    canInteractWithCallable = IWorldPosCallable.of(tile.getWorld(), tile.getPos());
    this.machine = machine;
    this.tier = tier;
    int startX = 8;
    int startY = 17;
    titleY = startY;
    int lastIndex = 0;
    int tileRow = 0;
    for (int i = 0; i < tile.getMachineType().getInputInventorySize(); i++) {
      if (i % 3 == 0){
        tileRow ++;
        lastIndex = i;
      }
      this.addSlot(new Slot(tile, i, startX + ((i % 3) * 18), startY + (tileRow * 18)));
    }
    for (int i = 0; i < tile.getMachineType().getInputTankCount(); i++) {
      if (i % 3 == 0){
        tileRow ++;
      }
      this.addSlot(new Slot(tile, i + lastIndex, startX + ((i % 3) * 18), startY + (tileRow * 18)));
    }
    // Main Player Inventory
    int slotSizePlus2 = 18;

    int playerStartY = 141;
    playerInvY = playerStartY;
    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 9; column++) {
        this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSizePlus2), playerStartY + (row * slotSizePlus2)));
      }
    }

    // Hotbar
    int hatBarY = 200;
    for (int column = 0; column < 9; column++) {
      this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), hatBarY));
    }
  }

  @Override
  public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
    ItemStack itemStack = ItemStack.EMPTY;
    Slot slot = this.inventorySlots.get(index);
    if (slot != null && slot.getHasStack()) {
      ItemStack itemStack1 = slot.getStack();
      itemStack = itemStack1.copy();
      if (index < this.machine.getInputInventorySize()) {
        if (!this.mergeItemStack(itemStack1, this.machine.getInputInventorySize(), this.inventorySlots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.mergeItemStack(itemStack1, 0, this.machine.getInputInventorySize(), false)) {
        return ItemStack.EMPTY;
      }

      if (itemStack1.isEmpty()) {
        slot.putStack(ItemStack.EMPTY);
      } else {
        slot.onSlotChanged();
      }
    }
    return itemStack;
  }

  @Override
  public boolean canInteractWith(PlayerEntity playerIn) {
    return isWithinUsableDistance(canInteractWithCallable, playerIn, machine.getBlock(tier));
  }

  public IMTieredMachineContainer(int windowId, PlayerInventory playerInv, PacketBuffer buf, MachineType machine, SpeedTier tier){
    this(windowId, playerInv, (IMTieredProcessingMachineTileEntity) playerInv.player.world.getTileEntity(buf.readBlockPos()), machine, tier);
  }
}
