package dev.quae.mods.industriae.recipe;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.data.recipe.IMMachineOutput;
import dev.quae.mods.industriae.helper.RecipeTypeHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class IMCustomMachineRecipe implements IMMachineRecipe {

  protected final List<IMMachineOutput> result;
  protected final ResourceLocation id;
  protected final List<ItemStack> ingredients;
  protected final int ticks;
  private IRecipeSerializer<?> serializer;
  private IRecipeType<IMCustomMachineRecipe> recipeType;

  public IMCustomMachineRecipe(List<IMMachineOutput> result,
      ResourceLocation id,
      List<ItemStack> ingredients,
      int ticks,
      IRecipeSerializer<?> serializer,
      IRecipeType<IMCustomMachineRecipe> recipeType) {
    this.result = result;
    this.id = id;
    this.ingredients = ingredients;
    this.ticks = ticks;
    this.serializer = serializer;
    this.recipeType = recipeType;
  }

  @Override
  public int getTicks() {
    return this.ticks;
  }

  @Override
  public boolean matches(final Inventory inv, World worldIn) {
    List<Predicate<ItemStack>> ingredientTests = new ArrayList<>();
    List<ItemStack> invContents = new ArrayList<>();
    for (final ItemStack stack : this.ingredients) {
      ingredientTests.add((x) -> stack.getItem() == x.getItem() && stack.getCount() >= x.getCount());
    }
    for (int i = 0; i < inv.getSizeInventory(); i++) {
      invContents.add(inv.getStackInSlot(i));
    }
    return RecipeMatcher.findMatches(invContents, ingredientTests) != null;
  }

  @Override
  public ItemStack getCraftingResult(Inventory inv) {
    return getRecipeOutput().copy();
  }

  @Override
  public NonNullList<ItemStack> getRemainingItems(Inventory inv) {
    NonNullList<ItemStack> secondaries = NonNullList.create();
    for (IMMachineOutput output : this.result) {
      if (output.isPrimary()) {
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
    for (IMMachineOutput output : this.result) {
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
    return serializer;
  }

  @Override
  public IRecipeType<IMCustomMachineRecipe> getType() {
    return recipeType;
  }

  public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<IMCustomMachineRecipe> {

    @Override
    public IMCustomMachineRecipe read(ResourceLocation recipeId, JsonObject json) {
      NonNullList<IMMachineOutput> results = NonNullList.create();
      final JsonArray resultsJson = JSONUtils.getJsonArray(json, "results");
      for (JsonElement jsonElement : resultsJson) {
        results.add(IMMachineOutput.from(jsonElement.getAsJsonObject()));
      }
      NonNullList<ItemStack> inputs = NonNullList.create();
      final JsonArray ingredientsJson = JSONUtils.getJsonArray(json, "inputs");
      for (JsonElement jsonElement : ingredientsJson) {
        JsonObject elemObject = jsonElement.getAsJsonObject();
        inputs.add(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(elemObject.get("item").getAsString())), elemObject.get("count").getAsInt()));
      }
      int ticks = json.get("ticks").getAsInt();
      String typeRl = json.get("machine").getAsString();
      return new IMCustomMachineRecipe(results, recipeId, inputs, ticks, this, RecipeTypeHelper.getType(typeRl));
    }

    @Override
    public IMCustomMachineRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
      int inputCount = buffer.readInt();
      int outputCount = buffer.readInt();
      String typeRl = buffer.readString();
      int ticks = buffer.readInt();
      NonNullList<ItemStack> inputs = NonNullList.create();
      NonNullList<IMMachineOutput> outputs = NonNullList.create();
      for (int i = 0; i < inputCount; i++) {
        inputs.add(buffer.readItemStack());
      }
      for (int i = 0; i < outputCount; i++) {
        outputs.add(IMMachineOutput.read(buffer));
      }

      return new IMCustomMachineRecipe(outputs, recipeId, inputs, ticks, this, RecipeTypeHelper.getType(typeRl));
    }

    @Override
    public void write(PacketBuffer buffer, IMCustomMachineRecipe recipe) {
      buffer.writeInt(recipe.ingredients.size());
      buffer.writeInt(recipe.result.size());
      buffer.writeString(RecipeTypeHelper.getRl(recipe.getType()).toString());
      for (ItemStack ingredient : recipe.ingredients) {
        buffer.writeItemStack(ingredient);
      }
      for (IMMachineOutput output : recipe.result) {
        output.write(buffer);
      }
    }
  }
}
