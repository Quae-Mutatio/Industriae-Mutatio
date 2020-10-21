package dev.quae.mods.industriae.data.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.recipe.IMMaceratorRecipe;
import dev.quae.mods.industriae.recipe.RandomChanceHelper;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class IMMaceratorRecipeOutput {

  private final ItemStack item;
  private final double chance;
  private final boolean primary;

  public IMMaceratorRecipeOutput(ItemStack item, double chance, boolean primary) {
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

  public static IMMaceratorRecipeOutput from(JsonObject json) {
    return new IMMaceratorRecipeOutput(
        new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString())), json.get("count").getAsInt()),
        json.get("chance").getAsDouble(),
        json.get("primary").getAsBoolean()
    );
  }

  public static IMMaceratorRecipeOutput read(PacketBuffer buffer) {
    return new IMMaceratorRecipeOutput(
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
