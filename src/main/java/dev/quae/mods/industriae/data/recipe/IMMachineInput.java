package dev.quae.mods.industriae.data.recipe;

import com.google.gson.JsonObject;
import dev.quae.mods.industriae.helper.IMFluidStackHelper;
import dev.quae.mods.industriae.recipe.RandomChanceHelper;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class IMMachineInput {

  private IMStackType stackType;
  private ItemStack item;
  private FluidStack fluid;
  private boolean dontConsume;

  public IMMachineInput(ItemStack item, boolean dontConsume) {
    this.dontConsume = dontConsume;
    this.stackType = IMStackType.ITEM_STACK;
    this.item = item;
    this.fluid = FluidStack.EMPTY;
  }

  public IMMachineInput(FluidStack fluid, boolean dontConsume) {
    this.dontConsume = dontConsume;
    this.stackType = IMStackType.FLUID_STACK;
    this.item = ItemStack.EMPTY;
    this.fluid = fluid;
  }

  public JsonObject serialize() {
    final JsonObject result = new JsonObject();
    if (stackType == IMStackType.FLUID_STACK) {
      result.addProperty("fluid", fluid.getRawFluid().getRegistryName().toString());
      result.addProperty("amount", fluid.getAmount());
    } else if (stackType == IMStackType.ITEM_STACK) {
      result.addProperty("item", item.getItem().getRegistryName().toString());
      result.addProperty("count", item.getCount());
    }
    if (this.dontConsume) {
      result.addProperty("dontConsume", true);
    }
    return result;
  }

  public static IMMachineInput from(JsonObject json) {
    if (json.has("item")) {
      return new IMMachineInput(
          new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString())), json.get("count").getAsInt()),
          json.has("dontConsume") && json.get("dontConsume").getAsBoolean()
      );
    } else if (json.has("fluid")) {
      return new IMMachineInput(
          new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(json.get("fluid").getAsString())), json.get("amount").getAsInt()),
          json.has("dontConsume") && json.get("dontConsume").getAsBoolean()
      );
    }
    return null;
  }

  public static IMMachineInput read(PacketBuffer buffer) {
    int stackType = buffer.readInt();
    if (stackType == IMStackType.FLUID_STACK.getId()) {
      return new IMMachineInput(
          new FluidStack(ForgeRegistries.FLUIDS.getValue(buffer.readResourceLocation()), buffer.readInt()),
          buffer.readBoolean()
      );
    } else if (stackType == IMStackType.ITEM_STACK.getId()) {
      return new IMMachineInput(
          new ItemStack(ForgeRegistries.ITEMS.getValue(buffer.readResourceLocation()), buffer.readInt()),
          buffer.readBoolean()
      );
    }
    return null;
  }

  public void write(PacketBuffer buffer) {
    buffer.writeInt(stackType.getId());
    if (stackType == IMStackType.ITEM_STACK) {
      buffer.writeResourceLocation(this.item.getItem().getRegistryName());
      buffer.writeInt(this.item.getCount());
    } else if (stackType == IMStackType.FLUID_STACK) {
      buffer.writeResourceLocation(this.fluid.getRawFluid().getRegistryName());
      buffer.writeInt(this.fluid.getAmount());
    }
    buffer.writeBoolean(dontConsume);
    buffer.writeBoolean(this.dontConsume);
  }


  public ItemStack resolveItemStack() {
    if (this.getStackType() == IMStackType.FLUID_STACK) {
      return IMFluidStackHelper.getAsItemStack(this.fluid);
    }
    return item;
  }

  public FluidStack getFluidStack() {
    return fluid;
  }


  public IMStackType getStackType() {
    return this.stackType;
  }

  public ItemStack getItem() {
    return item;
  }

  public boolean getDontConsume() {
    return dontConsume;
  }
}
