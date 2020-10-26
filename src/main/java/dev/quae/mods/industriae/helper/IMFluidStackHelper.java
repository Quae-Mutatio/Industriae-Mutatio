package dev.quae.mods.industriae.helper;

import com.google.gson.JsonObject;
import dev.quae.mods.industriae.constant.IMRecipeConstants;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fluids.FluidStack;

public class IMFluidStackHelper {
  public static ItemStack getAsItemStack(FluidStack fluidStack) {
    ItemStack result = new ItemStack(Items.BARRIER, 1);
    CompoundNBT fluidTag = new CompoundNBT();
    fluidStack.writeToNBT(fluidTag);
    CompoundNBT nbt = result.getTag();
    if (nbt != null){
      nbt.put(IMRecipeConstants.ITEM_STACK_FLUID_KEY, fluidTag);
    } else  {
      CompoundNBT parentNbt = new CompoundNBT();
      parentNbt.put(IMRecipeConstants.ITEM_STACK_FLUID_KEY, fluidTag);
      result.setTag(parentNbt);
    }
    return result;
  }

  public static FluidStack getAsFluidStack(ItemStack itemStack) {
    CompoundNBT tagCompound = itemStack.getTag();
    if (tagCompound == null || !tagCompound.contains(IMRecipeConstants.ITEM_STACK_FLUID_KEY))
    {
      return FluidStack.EMPTY;
    }
    return FluidStack.loadFluidStackFromNBT(tagCompound.getCompound(IMRecipeConstants.ITEM_STACK_FLUID_KEY));
  }

  public static boolean isFluidContainer(ItemStack stack) {
    CompoundNBT tagCompound = stack.getTag();
    if (tagCompound == null || !tagCompound.contains(IMRecipeConstants.ITEM_STACK_FLUID_KEY))
    {
      return false;
    }
    return true;
  }

  public static JsonObject serializeStack(FluidStack stack) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("fluid", stack.getFluid().getRegistryName().toString());
    jsonObject.addProperty("amount", stack.getAmount());
    return jsonObject;
  }
}
