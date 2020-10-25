package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.data.recipe.IMCustomMachineRecipeBuilder;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
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
    // Macerator Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.MACERATOR.get(), IMRecipeTypes.MACERATOR)
        .addIngredient(Items.OAK_LOG, 1)
        .addPrimaryResult(IMItems.WOOD_PULP.get(), 4)
        .addSecondaryResult(IMItems.WOOD_PULP.get(), 0.15)
        .addTickLength(100)
        .build(consumer);

    // Forge Hammer Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.FORGE_HAMMER.get(), IMRecipeTypes.FORGE_HAMMER)
        .addIngredient(Items.COBBLESTONE, 1)
        .addPrimaryResult(Items.GRAVEL, 1)
        .addTickLength(100)
        .build(consumer);

    // Alloy Furnace Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.ALLOY_FURNACE.get(), IMRecipeTypes.ALLOY_FURNACE)
        .addIngredient(Items.COAL, 2)
        .addIngredient(Items.IRON_INGOT, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 1)
        .addTickLength(100)
        .build(consumer);

    // Wire Mill Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.WIREMILL.get(), IMRecipeTypes.WIREMILL)
        .addIngredient(Items.IRON_INGOT, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 1)
        .addTickLength(100)
        .build(consumer);
  }
}
