package dev.quae.mods.industriae.data.recipe;

import com.google.gson.JsonObject;
import dev.quae.mods.industriae.recipe.RandomChanceHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class IMMachineOutput {

  private final ItemStack item;
  private final double chance;
  private final boolean primary;

  public IMMachineOutput(ItemStack item, double chance, boolean primary) {
    this.item = item;
    this.chance = chance;
    this.primary = primary;
  }

  public JsonObject serialize() {
    final JsonObject result = new JsonObject();
    result.addProperty("item", item.getItem().getRegistryName().toString());
    result.addProperty("count", item.getCount());
    result.addProperty("chance", chance);
    result.addProperty("primary", primary);
    return result;
  }

  public static IMMachineOutput from(JsonObject json) {
    return new IMMachineOutput(
        new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString())), json.get("count").getAsInt()),
        json.get("chance").getAsDouble(),
        json.get("primary").getAsBoolean()
    );
  }

  public static IMMachineOutput read(PacketBuffer buffer) {
    return new IMMachineOutput(
        new ItemStack(ForgeRegistries.ITEMS.getValue(buffer.readResourceLocation()), buffer.readInt()),
        buffer.readDouble(),
        buffer.readBoolean()
    );
  }

  public void write(PacketBuffer buffer) {
    buffer.writeResourceLocation(this.item.getItem().getRegistryName());
    buffer.writeInt(this.item.getCount());
    buffer.writeDouble(this.chance);
    buffer.writeBoolean(this.primary);
  }


  public ItemStack resolveStack() {
    return RandomChanceHelper.getShouldReturnFor(chance) ? item : ItemStack.EMPTY;
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
