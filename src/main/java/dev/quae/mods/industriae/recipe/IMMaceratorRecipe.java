package dev.quae.mods.industriae.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.data.recipe.IMMaceratorRecipeOutput;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class IMMaceratorRecipe implements IRecipe<Inventory> {

  private final List<IMMaceratorRecipeOutput> result;
  private final ItemStack ingredient;
  private final int ticks;
  private final ResourceLocation id;

  public IMMaceratorRecipe(final ResourceLocation id, final ItemStack ingredient, final List<IMMaceratorRecipeOutput> results, final int ticks) {
    this.id = id;
    this.ingredient = ingredient;
    this.result = results;
    this.ticks = ticks;
  }

  @Override
  public boolean matches(Inventory inv, World worldIn) {
    return inv.getStackInSlot(0).isItemEqual(this.ingredient);
  }

  @Override
  public ItemStack getCraftingResult(Inventory inv) {
    return getRecipeOutput().copy();
  }

  @Override
  public NonNullList<ItemStack> getRemainingItems(Inventory inv) {
    NonNullList<ItemStack> secondaries = NonNullList.create();
    for (IMMaceratorRecipeOutput output : this.result) {
      if (output.isPrimary()){
        continue;
      }
      secondaries.add(output.resolveStack());
    }
    return secondaries;
  }

  @Override
  public boolean canFit(int width, int height) {
    return width * height == 1;
  }

  @Override
  public ItemStack getRecipeOutput() {
    for (IMMaceratorRecipeOutput output : this.result) {
      if (output.isPrimary()) {
        return output.resolveStack();
      }
    }
    return ItemStack.EMPTY;
  }

  @Override
  public ResourceLocation getId() {
    return id;
  }

  @Override
  public IRecipeSerializer<?> getSerializer() {
    return IMRecipeSerializers.MACERATOR.get();
  }

  @Override
  public IRecipeType<?> getType() {
    return IMRecipeTypes.MACERATOR;
  }

  public int getTicks(){
    return this.ticks;
  }

  public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<IMMaceratorRecipe> {

    @Override
    public IMMaceratorRecipe read(ResourceLocation recipeId, JsonObject json) {
      NonNullList<IMMaceratorRecipeOutput> results = NonNullList.create();
      final JsonArray resultsJson = JSONUtils.getJsonArray(json, "results");
      for (JsonElement jsonElement : resultsJson) {
        results.add(IMMaceratorRecipeOutput.from(jsonElement.getAsJsonObject()));
      }
      Item inputRL = ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.get("item").getAsString()));
      int ticks = json.get("ticks").getAsInt();
      return new IMMaceratorRecipe(recipeId, new ItemStack(inputRL), results, ticks);
    }

    @Override
    public IMMaceratorRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
      ItemStack input = buffer.readItemStack();
      int ticks = buffer.readInt();
      NonNullList<IMMaceratorRecipeOutput> results = NonNullList.create();
      results.add(IMMaceratorRecipeOutput.read(buffer));

      return new IMMaceratorRecipe(recipeId, input, results, ticks);
    }

    @Override
    public void write(PacketBuffer buffer, IMMaceratorRecipe recipe) {
      buffer.writeItemStack(recipe.ingredient);
      buffer.writeInt(recipe.ticks);
      for (final IMMaceratorRecipeOutput ingredient : recipe.result) {
          ingredient.write(buffer);
      }
    }
  }
}
