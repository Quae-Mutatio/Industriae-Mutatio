package dev.quae.mods.industriae.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class IMMaceratorItemHandler extends ItemStackHandler {

  public IMMaceratorItemHandler(int size) {
    super(size);
  }

  public IMMaceratorItemHandler(NonNullList<ItemStack> items){
    super(items);
  }

  @NotNull
  @Override
  public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
    if (slot != 0) {
      return stack;
    }
    return super.insertItem(slot, stack, simulate);
  }

  @NotNull
  @Override
  public ItemStack extractItem(int slot, int amount, boolean simulate) {
    if (slot == 0) {
      slot++;
    }
    return super.extractItem(slot, amount, simulate);
  }
}
