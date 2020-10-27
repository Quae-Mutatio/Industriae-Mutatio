package dev.quae.mods.industriae.capability;

import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

public class IMMachineFluidHandler implements IFluidHandler {

  NonNullList<FluidStack> stacks;
  private int size;
  private int outputStartIndex;
  private int tankCapacity;

  public IMMachineFluidHandler(int size, int outputStartIndex, int tankCapacity) {
    stacks = NonNullList.withSize(size, FluidStack.EMPTY);
    this.size = size;
    this.outputStartIndex = outputStartIndex;
    this.tankCapacity = tankCapacity;
  }

  @Override
  public int getTanks() {
    return size;
  }

  @NotNull
  @Override
  public FluidStack getFluidInTank(int tank) {
    if (tank >= size) {
      return FluidStack.EMPTY;
    }
    return stacks.get(tank);
  }

  @Override
  public int getTankCapacity(int tank) {
    return tankCapacity;
  }

  @Override
  public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
    if (tank >= size) {
      return false;
    }
    return stack.containsFluid(this.stacks.get(tank)) || this.stacks.get(tank).isEmpty();
  }

  @Override
  public int fill(FluidStack resource, FluidAction action) {
    for (int i = 0; i < outputStartIndex; i++) {
      if (!this.isFluidValid(i, resource)) {
        continue;
      }
      FluidStack stackInTank = this.stacks.get(i);
      if (stackInTank.isEmpty()) {
        int remainder = resource.getAmount() - this.tankCapacity;
        this.stacks.set(i, new FluidStack(resource.getFluid(), MathHelper.clamp(resource.getAmount(), 0, this.tankCapacity)));
        if (remainder > 0) {
          return remainder;
        }
        return 0;
      }
      int leftover = stackInTank.getAmount() + resource.getAmount() - this.tankCapacity;
      if (leftover > 0) {
        if (action.execute()) {
          stackInTank.setAmount(this.tankCapacity);
        }
        return leftover;
      }
      if (action.execute()) {
        stackInTank.setAmount(stackInTank.getAmount() + resource.getAmount());
      }
      return 0;
    }
    return resource.getAmount();
  }

  @NotNull
  @Override
  public FluidStack drain(FluidStack resource, FluidAction action) {
    for (int i = outputStartIndex; i < this.size; i++) {
      if (!this.isFluidValid(i, resource)) {
        continue;
      }
      FluidStack stackInTank = this.stacks.get(i);
      if (stackInTank.getAmount() <= resource.getAmount()) {
        FluidStack stackToReturn = stackInTank.copy();
        if (action.execute()) {
          stackInTank.setAmount(0);
        }
        return stackToReturn;
      }
      if (action.execute()) {
        stackInTank.setAmount(stackInTank.getAmount() - resource.getAmount());
      }
      return resource.copy();
    }
    return FluidStack.EMPTY;
  }

  @NotNull
  @Override
  public FluidStack drain(int maxDrain, FluidAction action) {
    for (int i = outputStartIndex; i < this.size; i++) {
      FluidStack stackInTank = this.stacks.get(i);
      if (stackInTank.getAmount() <= maxDrain) {
        FluidStack stackToReturn = stackInTank.copy();
        if (action.execute()) {
          stackInTank.setAmount(0);
        }
        return stackToReturn;
      }
      if (action.execute()) {
        stackInTank.setAmount(stackInTank.getAmount() - maxDrain);
      }
      return new FluidStack(stackInTank.getFluid(), maxDrain);
    }
    return FluidStack.EMPTY;
  }

  public void internalFill(int tank, FluidStack stack) {
    if (tank >= this.size) {
      return;
    }
    if (this.stacks.get(tank).isEmpty()) {
      this.stacks.set(tank, stack.copy());
      return;
    }
    this.stacks.get(tank).setAmount(stack.getAmount() + this.stacks.get(tank).getAmount());
  }

  public void internalDrain(int tank, FluidStack stack) {
    if (tank >= this.size) {
      return;
    }
    if (this.stacks.get(tank).getAmount() < stack.getAmount()) {
      this.stacks.get(tank).setAmount(0);
    }
    this.stacks.get(tank).setAmount(stack.getAmount() - this.stacks.get(tank).getAmount());
  }

}
