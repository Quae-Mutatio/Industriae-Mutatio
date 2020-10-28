package dev.quae.mods.industriae.capability;

import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

public class IMStorageFluidHandler implements IFluidHandler {

  FluidStack stack;
  private int tankCapacity;

  public IMStorageFluidHandler(int tankCapacity) {
    this.tankCapacity = tankCapacity;
  }

  @Override
  public int getTanks() {
    return 1;
  }

  @NotNull
  @Override
  public FluidStack getFluidInTank(int tank) {
    if (tank > 0) {
      return FluidStack.EMPTY;
    }
    return stack;
  }

  @Override
  public int getTankCapacity(int tank) {
    return tankCapacity;
  }

  @Override
  public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
    if (tank > 0) {
      return false;
    }
    return stack.containsFluid(this.stack) || this.stack.isEmpty();
  }

  @Override
  public int fill(FluidStack resource, FluidAction action) {
      if (!this.isFluidValid(0, resource)) {
        return resource.getAmount();
      }
      if (stack.isEmpty()) {
        int remainder = resource.getAmount() - this.tankCapacity;
        this.stack= new FluidStack(resource.getFluid(), MathHelper.clamp(resource.getAmount(), 0, this.tankCapacity));
        if (remainder > 0) {
          return remainder;
        }
        return 0;
      }
      int leftover = stack.getAmount() + resource.getAmount() - this.tankCapacity;
      if (leftover > 0) {
        if (action.execute()) {
          stack.setAmount(this.tankCapacity);
        }
        return leftover;
      }
      if (action.execute()) {
        stack.setAmount(stack.getAmount() + resource.getAmount());
      }
      return 0;
  }

  @NotNull
  @Override
  public FluidStack drain(FluidStack resource, FluidAction action) {
      if (!this.isFluidValid(0, resource)) {
        return resource;
      }
      if (stack.getAmount() <= resource.getAmount()) {
        FluidStack stackToReturn = stack.copy();
        if (action.execute()) {
          stack.setAmount(0);
        }
        return stackToReturn;
      }
      if (action.execute()) {
        stack.setAmount(stack.getAmount() - resource.getAmount());
      }
      return resource.copy();
  }

  @NotNull
  @Override
  public FluidStack drain(int maxDrain, FluidAction action) {
      if (stack.getAmount() <= maxDrain) {
        FluidStack stackToReturn = stack.copy();
        if (action.execute()) {
          stack.setAmount(0);
        }
        return stackToReturn;
      }
      if (action.execute()) {
        stack.setAmount(stack.getAmount() - maxDrain);
      }
      return new FluidStack(stack.getFluid(), maxDrain);
  }

  public void internalFill(int tank, FluidStack stack) {
    if (tank > 0) {
      return;
    }
    if (this.stack.isEmpty()) {
      this.stack = stack.copy();
      return;
    }
    this.stack.setAmount(stack.getAmount() + this.stack.getAmount());
  }

  public void internalDrain(int tank, FluidStack stack) {
    if (tank > 0) {
      return;
    }
    if (this.stack.getAmount() < stack.getAmount()) {
      this.stack.setAmount(0);
    }
    this.stack.setAmount(stack.getAmount() - this.stack.getAmount());
  }

}
