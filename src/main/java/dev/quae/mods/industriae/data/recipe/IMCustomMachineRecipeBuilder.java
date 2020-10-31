package dev.quae.mods.industriae.data.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

public class IMCustomMachineRecipeBuilder {
  private static int counter = 0;
  protected final List<IMMachineOutput> result = Lists.newArrayList();
  protected final List<IMMachineInput> ingredients;
  protected final List<IMMachineInput> fluidIngredients;
  private IRecipeSerializer<?> serializer;
  protected int ticks = 0;
  private IRecipeType<IMCustomMachineRecipe> type;

  public IMCustomMachineRecipeBuilder(IRecipeSerializer<?> serializer, IRecipeType<IMCustomMachineRecipe> type) {
    this.type = type;
    ingredients = new ArrayList<>();
    fluidIngredients = new ArrayList<>();
    this.serializer = serializer;
  }

  public static IMCustomMachineRecipeBuilder create(IRecipeSerializer<IMCustomMachineRecipe> serializer, IRecipeType<IMCustomMachineRecipe> type) {
    return new IMCustomMachineRecipeBuilder(serializer, type);
  }

  public IMCustomMachineRecipeBuilder addPrimaryResult(final IItemProvider result, final int count, final double chance) {
    this.result.add(new IMMachineOutput(new ItemStack(result.asItem(), count), chance, true));
    return this;
  }

  public IMCustomMachineRecipeBuilder addPrimaryResult(final IItemProvider result, final int count) {
    this.addPrimaryResult(result, count, 1.d);
    return this;
  }

  public IMCustomMachineRecipeBuilder addPrimaryResult(final Supplier<Fluid> result, final int count) {
    this.result.add(new IMMachineOutput(new FluidStack(result.get(), count), true));
    return this;
  }


  public IMCustomMachineRecipeBuilder addSecondaryResult(final IItemProvider result, final int count, final double chance) {
    this.result.add(new IMMachineOutput(new ItemStack(result, count), chance, false));
    return this;
  }

  public IMCustomMachineRecipeBuilder addSecondaryResult(final IItemProvider result, final double chance) {
    this.addSecondaryResult(result, 1, chance);
    return this;
  }
  public IMCustomMachineRecipeBuilder addSecondaryResult(final Supplier<Fluid> result, final int amount) {
    this.result.add(new IMMachineOutput(new FluidStack(result.get(), amount),false));
    return this;
  }

  public IMCustomMachineRecipeBuilder addTickLength(final int ticks) {
    this.ticks = ticks;
    return this;
  }

  public IMCustomMachineRecipeBuilder addIngredient(IItemProvider itemProvider, final int count) {
    this.ingredients.add(new IMMachineInput(new ItemStack(itemProvider.asItem(), count), false));
    return this;
  }

  public IMCustomMachineRecipeBuilder addIngredient(FluidStack fluidStack) {
    this.fluidIngredients.add(new IMMachineInput(fluidStack.copy(), false));
    return this;
  }

  public IMCustomMachineRecipeBuilder addReusableIngredient(FluidStack stack) {
    this.fluidIngredients.add(new IMMachineInput(stack.copy(), true));
    return this;
  }

  public IMCustomMachineRecipeBuilder addReusableIngredient(IItemProvider itemProvider, int count) {
    this.fluidIngredients.add(new IMMachineInput(new ItemStack(itemProvider.asItem(), count), true));
    return this;
  }

  public void build(Consumer<IFinishedRecipe> consumer) {
    ResourceLocation id = new ResourceLocation(IndustriaeMutatio.ID, createRecipeId());
    consumer.accept(new Result(id, this.ingredients, this.fluidIngredients, this.result, this.ticks, this.serializer, this.type));
  }

  private String createRecipeId() {
    String result = this.serializer.getRegistryName().getPath() + "_";
    for (IMMachineInput ingredient : this.ingredients) {
      result += ingredient.getItem().getCount() + "_";
      result += ingredient.getItem().getItem().getRegistryName().getPath().replace('/', '_') + "_";
    }
    for (IMMachineInput ingredient : this.fluidIngredients) {
      result += ingredient.getFluidStack().getAmount() + "mb_";
      result += ingredient.getItem().getItem().getRegistryName().getPath().replace('/', '_') + "_";
    }
    result += "_gives_";
    for (IMMachineOutput resultingItem : this.result) {
      if (resultingItem.getStackType() == IMStackType.ITEM_STACK){
        result += resultingItem.getItem().getCount() + "_";
        result += resultingItem.getItem().getItem().getRegistryName().getPath().replace('/', '_') + "_";
      } else if (resultingItem.getStackType() == IMStackType.FLUID_STACK) {
        result += resultingItem.getFluid().getAmount() + "mb_";
        result += resultingItem.getFluid().getFluid().getRegistryName().getPath().replace('/', '_') + "_";
      }
    }
    return result;
  }

  public static final class Result implements IFinishedRecipe {
    private final ResourceLocation id;
    private List<IMMachineInput> fluidIngredients;
    private final List<IMMachineOutput> result;
    private int ticks;
    private IRecipeSerializer<?> serializer;
    private IRecipeType<IMCustomMachineRecipe> type;
    private final List<IMMachineInput> ingredients;

    public Result(ResourceLocation id, List<IMMachineInput> ingredients, List<IMMachineInput> fluidIngredients, List<IMMachineOutput> result, int ticks, IRecipeSerializer<?> serializer, IRecipeType<IMCustomMachineRecipe> type) {
      this.id = id;
      this.ingredients = ingredients;
      this.fluidIngredients = fluidIngredients;
      this.result = result;
      this.ticks = ticks;
      this.serializer = serializer;
      this.type = type;
    }

    @Override
    public void serialize(JsonObject json) {
      final JsonArray results = new JsonArray();
      for (IMMachineOutput output : this.result) {
        results.add(output.serialize());
      }
      final JsonArray inputs = new JsonArray();
      for (IMMachineInput ingredient : this.ingredients) {
        inputs.add(ingredient.serialize());
      }
      for (IMMachineInput ingredient : this.fluidIngredients) {
        inputs.add(ingredient.serialize());
      }
      json.addProperty("ticks", ticks);
      json.add("results", results);
      json.add("inputs", inputs);
    }

    @Override
    public ResourceLocation getID() {
      return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
      return serializer;
    }

    @Nullable
    @Override
    public JsonObject getAdvancementJson() {
      return null;
    }

    @Nullable
    @Override
    public ResourceLocation getAdvancementID() {
      return null;
    }
  }

}
