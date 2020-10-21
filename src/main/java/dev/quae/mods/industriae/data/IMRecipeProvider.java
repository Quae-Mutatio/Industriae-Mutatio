package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.data.recipe.IMMaceratorRecipeBuilder;
import dev.quae.mods.industriae.setup.IMItems;
import java.util.function.Consumer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;

public class IMRecipeProvider extends RecipeProvider {

  public IMRecipeProvider(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
    IMMaceratorRecipeBuilder.create(Items.OAK_LOG.getDefaultInstance())
        .addPrimaryResult(IMItems.WOOD_PULP.get(), 4)
        .addSecondaryResult(IMItems.WOOD_PULP.get(), 0.75)
        .addTickLength(2)
        .build(consumer);
  }
}
