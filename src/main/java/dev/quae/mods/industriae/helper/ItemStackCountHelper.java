package dev.quae.mods.industriae.helper;

import net.minecraft.item.ItemStack;

public class ItemStackCountHelper {
    public static ItemStack addToStack(ItemStack stack, int increment){
      stack.setCount(stack.getCount() + increment);
      return stack;
    }

    public static ItemStack takeFromStack(ItemStack stack, int decrement) {
      stack.setCount(stack.getCount() - decrement);
      return stack;
    }
}
