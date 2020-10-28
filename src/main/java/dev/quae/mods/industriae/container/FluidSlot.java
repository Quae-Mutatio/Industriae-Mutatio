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
    int inputCount = machineTile.getMachineType().getInputTankCount();
    int outputTanks = (machineTile.getFluidHandler().getTanks() - inputCount);
    for (int i = 0; i < outputTanks; i++) {
      IMFluidStackHelper.drainFluidAmount(stack, machineTile.getFluidHandler().internalFill(IMFluidStackHelper.getAsFluidStack(stack)));

    }
  }

  @Override
  public boolean isItemValid(ItemStack stack) {
    return IMFluidStackHelper.isFluidContainer(stack);
  }
}
