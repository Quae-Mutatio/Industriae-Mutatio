package dev.quae.mods.industriae.data.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public abstract class IMSingleInputRecipeBuilder<BUILDER extends IMSingleInputRecipeBuilder<?>> {

  protected final List<IMMachineOutput> result = Lists.newArrayList();
  protected final ItemStack ingredient;
  private IRecipeSerializer<?> serializer;
  protected int ticks = 0;

  public IMSingleInputRecipeBuilder(ItemStack ingredient,
      IRecipeSerializer<?> serializer) {
    this.ingredient = ingredient;
    this.serializer = serializer;
  }

  public BUILDER addPrimaryResult(final IItemProvider result, final int count,  final double chance) {
    this.result.add(new IMMachineOutput(new ItemStack(result.asItem(), count), chance, true));
    return (BUILDER) this;
  }

  public BUILDER addPrimaryResult(final IItemProvider result, final int count) {
    this.addPrimaryResult(result, count, 1.d);
    return (BUILDER) this;
  }

  public BUILDER addPrimaryResult(final IItemProvider result) {
    this.addPrimaryResult(result, 1, 1.d);
    return (BUILDER) this;
  }

  public BUILDER addSecondaryResult(final IItemProvider result, final int count, final double chance) {
    this.result.add(new IMMachineOutput(new ItemStack(result, count), chance, false));
    return (BUILDER) this;
  }

  public BUILDER addSecondaryResult(final IItemProvider result, final double chance) {
    this.addSecondaryResult(result, 1, chance);
    return (BUILDER) this;
  }

  public BUILDER addTickLength(final int ticks){
    this.ticks = ticks;
    return (BUILDER) this;
  }

  public void build(Consumer<IFinishedRecipe> consumer) {
    ResourceLocation id = this.ingredient.getItem().getRegistryName();
    consumer.accept(new Result(id, this.ingredient, this.result, this.ticks, this.serializer));
  }

  public static final class Result implements IFinishedRecipe {
    private final ResourceLocation id;
    private final List<IMMachineOutput> result;
    private int ticks;
    private IRecipeSerializer<?> serializer;
    private final ItemStack ingredient;

    public Result(ResourceLocation id, ItemStack ingredient, List<IMMachineOutput> result, int ticks, IRecipeSerializer<?> serializer) {
      this.id = id;
      this.ingredient = ingredient;
      this.result = result;
      this.ticks = ticks;
      this.serializer = serializer;
    }

    @Override
    public void serialize(JsonObject json) {
      final JsonArray results = new JsonArray();
      for (IMMachineOutput output : this.result) {
        results.add(output.serialize());
      }
      json.addProperty("item", id.toString());
      json.addProperty("ticks", ticks);
      json.add("results", results);
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
