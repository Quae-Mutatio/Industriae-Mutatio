package dev.quae.mods.industriae.capability;

import net.minecraft.fluid.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

public class InfiniteFluidInventory implements IFluidHandler {

  @Override
  public int getTanks() {
    return 1;
  }

  @NotNull
  @Override
  public FluidStack getFluidInTank(int tank) {
    return new FluidStack(Fluids.WATER, Integer.MAX_VALUE);
  }

  @Override
  public int getTankCapacity(int tank) {
    return Integer.MAX_VALUE;
  }

  @Override
  public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
    return false;
  }

  @Override
  public int fill(FluidStack resource, FluidAction action) {
    return 0;
  }

  @NotNull
  @Override
  public FluidStack drain(FluidStack resource, FluidAction action) {
      return resource.getFluid() == Fluids.WATER ? resource : FluidStack.EMPTY;
  }

  @NotNull
  @Override
  public FluidStack drain(int maxDrain, FluidAction action) {
    return new FluidStack(Fluids.WATER, maxDrain);
  }
}
