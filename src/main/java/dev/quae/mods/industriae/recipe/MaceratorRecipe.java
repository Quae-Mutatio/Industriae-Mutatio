package dev.quae.mods.industriae.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.data.recipe.IMMachineOutput;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class MaceratorRecipe extends IMSingleInputMachineRecipe {

  public MaceratorRecipe(final ResourceLocation id, final ItemStack ingredient, final List<IMMachineOutput> results, final int ticks) {
    super(results, id, ingredient, ticks, IMRecipeSerializers.MACERATOR.get(), IMRecipeTypes.MACERATOR);
  }


  public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<MaceratorRecipe> {

    @Override
    public MaceratorRecipe read(ResourceLocation recipeId, JsonObject json) {
      NonNullList<IMMachineOutput> results = NonNullList.create();
      final JsonArray resultsJson = JSONUtils.getJsonArray(json, "results");
      for (JsonElement jsonElement : resultsJson) {
        results.add(IMMachineOutput.from(jsonElement.getAsJsonObject()));
      }
      Item inputRL = ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString()));
      int ticks = json.get("ticks").getAsInt();
      return new MaceratorRecipe(recipeId, new ItemStack(inputRL), results, ticks);
    }

    @Override
    public MaceratorRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
      ItemStack input = buffer.readItemStack();
      int ticks = buffer.readInt();
      NonNullList<IMMachineOutput> results = NonNullList.create();
      results.add(IMMachineOutput.read(buffer));

      return new MaceratorRecipe(recipeId, input, results, ticks);
    }

    @Override
    public void write(PacketBuffer buffer, MaceratorRecipe recipe) {
      buffer.writeItemStack(recipe.ingredient);
      buffer.writeInt(recipe.ticks);
      for (final IMMachineOutput ingredient : recipe.result) {
        ingredient.write(buffer);
      }
    }
  }
}
