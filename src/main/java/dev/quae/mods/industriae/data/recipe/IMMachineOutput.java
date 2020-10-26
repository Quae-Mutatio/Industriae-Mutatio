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

public class IMMachineOutput {

  private final IMStackType stackType;
  private final ItemStack item;
  private final FluidStack fluid;
  private final double chance;
  private final boolean primary;

  public IMMachineOutput(ItemStack stack, double chance, boolean primary) {
    this.item = stack;
    this.fluid = FluidStack.EMPTY;
    this.chance = chance;
    this.primary = primary;
    this.stackType = IMStackType.ITEM_STACK;
  }

  public IMMachineOutput(FluidStack stack, boolean primary) {
    this.item = ItemStack.EMPTY;
    this.fluid = stack;
    this.chance = 1;
    this.primary = primary;
    this.stackType = IMStackType.FLUID_STACK;
  }

  public JsonObject serialize() {
    final JsonObject result = new JsonObject();
    if (stackType == IMStackType.FLUID_STACK) {
      result.addProperty("fluid", fluid.getRawFluid().getRegistryName().toString());
      result.addProperty("amount", item.getCount());
    } else if (stackType == IMStackType.ITEM_STACK) {
      result.addProperty("item", item.getItem().getRegistryName().toString());
      result.addProperty("count", item.getCount());
      result.addProperty("chance", chance);
    }
    result.addProperty("primary", primary);
    return result;
  }

  public static IMMachineOutput from(JsonObject json) {
    if (json.has("item")) {
      return new IMMachineOutput(
          new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString())), json.get("count").getAsInt()),
          json.get("chance").getAsDouble(),
          json.get("primary").getAsBoolean()
      );
    } else if (json.has("fluid")) {
      return new IMMachineOutput(
          new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(json.get("fluid").getAsString())), json.get("amount").getAsInt()),
          json.get("primary").getAsBoolean()
      );
    }
    return null;
  }

  public static IMMachineOutput read(PacketBuffer buffer) {
    int stackType = buffer.readInt();
    if (stackType == IMStackType.FLUID_STACK.getId()) {
      return new IMMachineOutput(
          new FluidStack(ForgeRegistries.FLUIDS.getValue(buffer.readResourceLocation()), buffer.readInt()),
          buffer.readBoolean()
      );
    } else if (stackType == IMStackType.ITEM_STACK.getId()) {
      return new IMMachineOutput(
          new ItemStack(ForgeRegistries.ITEMS.getValue(buffer.readResourceLocation()), buffer.readInt()),
          buffer.readDouble(),
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
      buffer.writeDouble(this.chance);
    } else if (stackType == IMStackType.FLUID_STACK) {
      buffer.writeResourceLocation(this.fluid.getRawFluid().getRegistryName());
      buffer.writeInt(this.fluid.getAmount());
    }
    buffer.writeBoolean(this.primary);
  }


  public ItemStack resolveItemStack() {
    if (this.getStackType() == IMStackType.FLUID_STACK) {
      return IMFluidStackHelper.getAsItemStack(this.fluid);
    }
    return RandomChanceHelper.getShouldReturnFor(chance) ? item : ItemStack.EMPTY;
  }

  public IMStackType getStackType() {
    return this.stackType;
  }

  public ItemStack getItem() {
    return item;
  }

  public double getChance() {
    return chance;
  }

  public boolean isPrimary() {
    return primary;
  }
}
