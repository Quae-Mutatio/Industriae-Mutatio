package dev.quae.mods.industriae.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.data.recipe.IMMachineOutput;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ForgeHammerRecipe extends IMSingleInputMachineRecipe {
  public ForgeHammerRecipe(ResourceLocation id, ItemStack ingredient, List<IMMachineOutput> result, int ticks) {
    super(result, id, ingredient, ticks, IMRecipeSerializers.FORGE_HAMMER.get(), IMRecipeTypes.FORGE_HAMMER);
  }

  public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ForgeHammerRecipe> {

    @Override
    public ForgeHammerRecipe read(ResourceLocation recipeId, JsonObject json) {
      NonNullList<IMMachineOutput> results = NonNullList.create();
      final JsonArray resultsJson = JSONUtils.getJsonArray(json, "results");
      for (JsonElement jsonElement : resultsJson) {
        results.add(IMMachineOutput.from(jsonElement.getAsJsonObject()));
      }
      Item inputRL = ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString()));
      int ticks = json.get("ticks").getAsInt();
      return new ForgeHammerRecipe(recipeId, new ItemStack(inputRL), results, ticks);
    }

    @Override
    public ForgeHammerRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
      ItemStack input = buffer.readItemStack();
      int ticks = buffer.readInt();
      NonNullList<IMMachineOutput> results = NonNullList.create();
      results.add(IMMachineOutput.read(buffer));

      return new ForgeHammerRecipe(recipeId, input, results, ticks);
    }

    @Override
    public void write(PacketBuffer buffer, ForgeHammerRecipe recipe) {
      buffer.writeItemStack(recipe.ingredient);
      buffer.writeInt(recipe.ticks);
      for (final IMMachineOutput ingredient : recipe.result) {
        ingredient.write(buffer);
      }
    }
  }
}
