package dev.quae.mods.industriae.data.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.recipe.IMMaceratorRecipe;
import dev.quae.mods.industriae.recipe.RandomChanceHelper;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class IMMaceratorRecipeOutput {

  private final Item item;
  private final double chance;
  private final boolean primary;

  public IMMaceratorRecipeOutput(Item item, double chance, boolean primary) {
    this.item = item;
    this.chance = chance;
    this.primary = primary;
  }

  public JsonObject serialize() {
    final JsonObject result = new JsonObject();
    result.addProperty("item", item.getRegistryName().toString());
    result.addProperty("chance", chance);
    result.addProperty("primary", primary);
    return result;
  }

  public static IMMaceratorRecipeOutput from(JsonObject json) {
    return new IMMaceratorRecipeOutput(
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString())),
        json.get("chance").getAsDouble(),
        json.get("primary").getAsBoolean()
    );
  }

  public static IMMaceratorRecipeOutput read(PacketBuffer buffer) {
    return new IMMaceratorRecipeOutput(
        ForgeRegistries.ITEMS.getValue(buffer.readResourceLocation()),
        buffer.readDouble(),
        buffer.readBoolean()
    );
  }

  public void write(PacketBuffer buffer) {
    buffer.writeResourceLocation(this.item.getRegistryName());
    buffer.writeDouble(this.chance);
    buffer.writeBoolean(this.primary);
  }


  public ItemStack resolveStack() {
    return new ItemStack(item, RandomChanceHelper.getCountFor(chance));
  }


  public Item getItem() {
    return item;
  }

  public double getChance() {
    return chance;
  }

  public boolean isPrimary() {
    return primary;
  }
}
