package dev.quae.mods.industriae.data.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.helper.IMItemStackHelper;
import dev.quae.mods.industriae.helper.RecipeTypeHelper;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class IMCustomMachineRecipeBuilder {

  protected final List<IMMachineOutput> result = Lists.newArrayList();
  protected final List<ItemStack> ingredients;
  private IRecipeSerializer<?> serializer;
  protected int ticks = 0;
  private IRecipeType<IMCustomMachineRecipe> type;

  public IMCustomMachineRecipeBuilder(IRecipeSerializer<?> serializer, IRecipeType<IMCustomMachineRecipe> type) {
    this.type = type;
    ingredients = new ArrayList<>();
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

  public IMCustomMachineRecipeBuilder addPrimaryResult(final IItemProvider result) {
    this.addPrimaryResult(result, 1, 1.d);
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

  public IMCustomMachineRecipeBuilder addTickLength(final int ticks) {
    this.ticks = ticks;
    return this;
  }

  public IMCustomMachineRecipeBuilder addIngredient(IItemProvider itemProvider, final int count) {
    this.ingredients.add(new ItemStack(itemProvider.asItem(), count));
    return this;
  }


  public void build(Consumer<IFinishedRecipe> consumer) {
    ResourceLocation id = this.ingredients.stream().map(x -> x.getItem().getRegistryName()).reduce((x, y) -> new ResourceLocation(x.toString() + y.toString())).orElse(null);
    consumer.accept(new Result(id, this.ingredients, this.result, this.ticks, this.serializer, this.type));
  }

  public static final class Result implements IFinishedRecipe {

    private final ResourceLocation id;
    private final List<IMMachineOutput> result;
    private int ticks;
    private IRecipeSerializer<?> serializer;
    private IRecipeType<IMCustomMachineRecipe> type;
    private final List<ItemStack> ingredients;

    public Result(ResourceLocation id, List<ItemStack> ingredients, List<IMMachineOutput> result, int ticks, IRecipeSerializer<?> serializer, IRecipeType<IMCustomMachineRecipe> type) {
      this.id = id;
      this.ingredients = ingredients;
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
      for (ItemStack ingredient : this.ingredients) {
        inputs.add(IMItemStackHelper.serializeStack(ingredient));
      }
      json.addProperty("ticks", ticks);
      json.addProperty("machine", RecipeTypeHelper.getRl(type).toString());
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
