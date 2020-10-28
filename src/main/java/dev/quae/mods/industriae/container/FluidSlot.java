package dev.quae.mods.industriae.container;

import dev.quae.mods.industriae.helper.IMFluidStackHelper;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class FluidSlot extends Slot {

  private IMTieredProcessingMachineTileEntity machineTile;

  public FluidSlot(IMTieredProcessingMachineTileEntity machineTile, int index, int xPosition, int yPosition) {
    super(machineTile, index, xPosition, yPosition);
    this.machineTile = machineTile;
  }

  @Override
  public void putStack(ItemStack stack) {

    if (machineTile.getFluidHandler().getTanks() <= getSlotIndex()) {
      return;
    }
    FluidStack fluidStack = IMFluidStackHelper.getAsFluidStack(stack);
    int startAmount = fluidStack.getAmount();
    int remainder = machineTile.getFluidHandler().internalFill(getSlotIndex(), fluidStack);
    IMFluidStackHelper.drainFluidAmount(stack, startAmount - remainder);
  }

  public FluidStack getFluidStack() {
    return machineTile.getFluidHandler().getFluidInTank(getSlotIndex());
  }

  @Override
  public boolean isItemValid(ItemStack stack) {
    return IMFluidStackHelper.isFluidContainer(stack);
  }

  @Override
  public ItemStack getStack() {
    return ItemStack.EMPTY;
  }
}
