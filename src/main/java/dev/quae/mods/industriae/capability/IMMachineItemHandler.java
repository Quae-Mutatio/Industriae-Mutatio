package dev.quae.mods.industriae.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class IMMachineItemHandler extends ItemStackHandler {

  private final int outputStart;

  public IMMachineItemHandler(int size, int outputStart) {
    super(size);
    this.outputStart = outputStart;
  }

  @NotNull
  @Override
  public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
    if (slot >= outputStart) {
      return stack;
    }
    return super.insertItem(slot, stack, simulate);
  }

  @NotNull
  @Override
  public ItemStack extractItem(int slot, int amount, boolean simulate) {
    int extractSlot = slot;
    if (slot <= outputStart) {
      extractSlot += outputStart;
    }
    extractSlot = MathHelper.clamp(extractSlot, outputStart, getSlots() - 1);
    return super.extractItem(extractSlot, amount, simulate);
  }

  public NonNullList<ItemStack> getStacks(){
    return this.stacks;
  }
}
