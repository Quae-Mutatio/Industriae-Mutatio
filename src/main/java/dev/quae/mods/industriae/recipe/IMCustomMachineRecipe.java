package dev.quae.mods.industriae.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.data.recipe.IMMachineInput;
import dev.quae.mods.industriae.data.recipe.IMMachineOutput;
import dev.quae.mods.industriae.data.recipe.IMStackType;
import dev.quae.mods.industriae.helper.IMFluidStackHelper;
import dev.quae.mods.industriae.helper.RecipeTypeHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class IMCustomMachineRecipe implements IMMachineRecipe {

  protected final List<IMMachineOutput> result;
  protected final ResourceLocation id;
  protected final List<IMMachineInput> ingredients;
  protected final List<IMMachineInput> fluidIngredients;
  protected final int ticks;
  private IRecipeSerializer<?> serializer;
  private IRecipeType<IMCustomMachineRecipe> recipeType;

  public IMCustomMachineRecipe(List<IMMachineOutput> result,
      ResourceLocation id,
      List<IMMachineInput> ingredients,
      List<IMMachineInput> fluidIngredients,
      int ticks,
      IRecipeSerializer<?> serializer,
      IRecipeType<IMCustomMachineRecipe> recipeType) {
    this.result = result;
    this.id = id;
    this.ingredients = ingredients;
    this.fluidIngredients = fluidIngredients;
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
    return this.matchItems(inv) && this.matchFluids(inv);
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
      secondaries.add(output.resolveItemStack().copy());
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
        return output.resolveItemStack();
      }
    }
    return ItemStack.EMPTY;
  }

  public List<IMMachineInput> getInputs(){
    return this.ingredients;
  }
  public List<IMMachineInput> getFluidInputs(){
    return this.fluidIngredients;
  }

  public List<IMMachineOutput> getAllOutputs() {
    return this.result;
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

  private boolean matchItems(Inventory inv) {
    if (this.ingredients.size() <= 0) {
      return true;
    }
    List<Predicate<ItemStack>> ingredientTests = new ArrayList<>();
    List<ItemStack> invContents = new ArrayList<>();
    for (final IMMachineInput input : this.ingredients) {
      final ItemStack stack = input.resolveItemStack();
      ingredientTests.add((x) -> stack.getItem() == x.getItem() && stack.getCount() <= x.getCount());
    }
    for (int i = 0; i < inv.getSizeInventory(); i++) {
      if (IMFluidStackHelper.isFluidContainer(inv.getStackInSlot(i))) {
        continue;
      }
      invContents.add(inv.getStackInSlot(i));
    }
    int matchCount = 0;
    for (final Predicate<ItemStack> ingredientTest : ingredientTests) {
      boolean foundIngredient = false;
      for (ItemStack invContent : invContents) {
        if (ingredientTest.test(invContent)) {
          foundIngredient = true;
        }
      }
      matchCount += (foundIngredient ? 1 : 0);
    }
    return matchCount >= this.ingredients.size();
  }

  private boolean matchFluids(Inventory inv) {
    if (this.fluidIngredients.size() <= 0) {
      return true;
    }
    List<Predicate<FluidStack>> ingredientTests = new ArrayList<>();
    List<FluidStack> invContents = new ArrayList<>();
    for (final IMMachineInput input : this.fluidIngredients) {
      FluidStack stack = input.getFluidStack();
      ingredientTests.add((x) -> stack.getFluid().isEquivalentTo(x.getFluid()) && stack.getAmount() <= x.getAmount());
    }
    for (int i = 0; i < inv.getSizeInventory(); i++) {
      if (!IMFluidStackHelper.isFluidContainer(inv.getStackInSlot(i))) {
        continue;
      }
      invContents.add(IMFluidStackHelper.getAsFluidStack(inv.getStackInSlot(i)));
    }
    int matchCount = 0;
    for (final Predicate<FluidStack> ingredientTest : ingredientTests) {
      boolean foundIngredient = false;
      for (FluidStack invContent : invContents) {
        if (ingredientTest.test(invContent)) {
          foundIngredient = true;
        }
      }
      matchCount += (foundIngredient ? 1 : 0);
    }
    return matchCount >= this.fluidIngredients.size();
  }

  public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<IMCustomMachineRecipe> {

    @Override
    public IMCustomMachineRecipe read(ResourceLocation recipeId, JsonObject json) {
      NonNullList<IMMachineOutput> results = NonNullList.create();
      final JsonArray resultsJson = JSONUtils.getJsonArray(json, "results");
      for (JsonElement jsonElement : resultsJson) {
        results.add(IMMachineOutput.from(jsonElement.getAsJsonObject()));
      }
      NonNullList<IMMachineInput> inputs = NonNullList.create();
      NonNullList<IMMachineInput> fluids = NonNullList.create();
      final JsonArray ingredientsJson = JSONUtils.getJsonArray(json, "inputs");
      for (JsonElement jsonElement : ingredientsJson) {
        JsonObject elemObject = jsonElement.getAsJsonObject();
        if (elemObject.has("item")) {
          inputs.add(new IMMachineInput(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(elemObject.get("item").getAsString())), elemObject.get("count").getAsInt()), elemObject.has("dontConsume") && elemObject.get("dontConsume").getAsBoolean()));
        } else if (elemObject.has("fluid")) {
          fluids.add(new IMMachineInput(new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(elemObject.get("fluid").getAsString())), elemObject.get("amount").getAsInt()), elemObject.has("dontConsume") && elemObject.get("dontConsume").getAsBoolean()));
        }
      }
      int ticks = json.get("ticks").getAsInt();
      String typeRl = json.get("machine").getAsString();
      return new IMCustomMachineRecipe(results, recipeId, inputs, fluids, ticks, this, RecipeTypeHelper.getType(typeRl));
    }

    @Override
    public IMCustomMachineRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
      int inputCount = buffer.readInt();
      int fluidCount = buffer.readInt();
      int outputCount = buffer.readInt();
      String typeRl = buffer.readString();
      int ticks = buffer.readInt();
      NonNullList<IMMachineInput> inputs = NonNullList.create();
      NonNullList<IMMachineInput> fluids = NonNullList.create();
      NonNullList<IMMachineOutput> outputs = NonNullList.create();
      for (int i = 0; i < inputCount; i++) {
        inputs.add(IMMachineInput.read(buffer));
      }
      for (int i = 0; i < fluidCount; i++) {
        fluids.add(IMMachineInput.read(buffer));
      }
      for (int i = 0; i < outputCount; i++) {
        outputs.add(IMMachineOutput.read(buffer));
      }

      return new IMCustomMachineRecipe(outputs, recipeId, inputs, fluids, ticks, this, RecipeTypeHelper.getType(typeRl));
    }

    @Override
    public void write(PacketBuffer buffer, IMCustomMachineRecipe recipe) {
      buffer.writeInt(recipe.ingredients.size());
      buffer.writeInt(recipe.fluidIngredients.size());
      buffer.writeInt(recipe.result.size());
      buffer.writeString(RecipeTypeHelper.getRl(recipe.getType()).toString());
      for (IMMachineInput ingredient : recipe.ingredients) {
        ingredient.write(buffer);
      }
      for (IMMachineInput fluid : recipe.fluidIngredients) {
        fluid.write(buffer);
      }
      for (IMMachineOutput output : recipe.result) {
        output.write(buffer);
      }
    }
  }
}
