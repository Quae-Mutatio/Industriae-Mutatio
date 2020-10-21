package dev.quae.mods.industriae.data.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.recipe.IMMaceratorRecipe.Serializer;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class IMMaceratorRecipeBuilder {

  private final List<IMMaceratorRecipeOutput> result = Lists.newArrayList();
  private final ItemStack ingredient;
  private int ticks = 0;

  public IMMaceratorRecipeBuilder(ItemStack ingredient) {
    this.ingredient = ingredient;
  }

  public static IMMaceratorRecipeBuilder create(ItemStack ingredient) {
    return new IMMaceratorRecipeBuilder(ingredient);
  }

  public IMMaceratorRecipeBuilder addPrimaryResult(final IItemProvider result, final double chance) {
    this.result.add(new IMMaceratorRecipeOutput(result.asItem(), chance, true));
    return this;
  }

  public IMMaceratorRecipeBuilder addPrimaryResult(final IItemProvider result) {
    this.addPrimaryResult(result, 1.d);
    return this;
  }

  public IMMaceratorRecipeBuilder addSecondaryResult(final IItemProvider result, final double chance) {
    this.result.add(new IMMaceratorRecipeOutput(result.asItem(), chance, false));
    return this;
  }

  public IMMaceratorRecipeBuilder addTickLength(final int ticks){
    this.ticks = ticks;
    return this;
  }

  public void build(Consumer<IFinishedRecipe> consumer) {
    ResourceLocation id = this.ingredient.getItem().getRegistryName();
    consumer.accept(new Result(id, this.ingredient, this.result, this.ticks));
  }

  public static final class Result implements IFinishedRecipe {
    private final ResourceLocation id;
    private final List<IMMaceratorRecipeOutput> result;
    private int ticks;
    private final ItemStack ingredient;

    public Result(ResourceLocation id, ItemStack ingredient, List<IMMaceratorRecipeOutput> result, int ticks) {
      this.id = id;
      this.ingredient = ingredient;
      this.result = result;
      this.ticks = ticks;
    }

    @Override
    public void serialize(JsonObject json) {
      final JsonArray results = new JsonArray();
      for (IMMaceratorRecipeOutput output : this.result) {
        results.add(output.serialize());
      }
      json.addProperty("item", id.toString());
      json.add("results", results);
      json.addProperty("ticks", ticks);
    }

    @Override
    public ResourceLocation getID() {
      return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
      return IMRecipeSerializers.MACERATOR.get();
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
