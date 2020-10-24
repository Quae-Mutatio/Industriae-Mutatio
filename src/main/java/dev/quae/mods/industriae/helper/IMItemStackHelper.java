package dev.quae.mods.industriae.helper;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;

public class IMItemStackHelper {
    public static ItemStack addToStack(ItemStack stack, int increment){
      stack.setCount(stack.getCount() + increment);
      return stack;
    }

    public static ItemStack takeFromStack(ItemStack stack, int decrement) {
      stack.setCount(stack.getCount() - decrement);
      return stack;
    }

    public static JsonObject serializeStack(ItemStack stack) {
      JsonObject jsonObject = new JsonObject();
      jsonObject.addProperty("item", stack.getItem().getRegistryName().toString());
      jsonObject.addProperty("count", stack.getCount());
      return jsonObject;
    }
}
