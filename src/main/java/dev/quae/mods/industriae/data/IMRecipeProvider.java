package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.data.recipe.IMCustomMachineRecipeBuilder;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.function.Consumer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraftforge.fluids.FluidStack;

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

  // UnPackager Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.UNPACKAGER.get(), IMRecipeTypes.UNPACKAGER)
        .addIngredient(Items.GOLD_BLOCK, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 4)
        .addSecondaryResult(Items.GOLD_NUGGET, 1, 1.0)
        .addTickLength(100)
        .build(consumer);

    // Packager Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.PACKAGER.get(), IMRecipeTypes.PACKAGER)
        .addIngredient(Items.GOLD_BLOCK, 1)
        .addIngredient(Items.WHITE_WOOL, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 4)
        .addTickLength(100)
        .build(consumer);

    // Thermal Centrifuge Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.THERMAL_CENTRIFUGE.get(), IMRecipeTypes.THERMAL_CENTRIFUGE)
        .addIngredient(Items.WHITE_WOOL, 1)
        .addPrimaryResult(Items.STRING, 4)
        .addTickLength(100)
        .build(consumer);

    // Ore Washing Plant Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.ORE_WASHING_PLANT.get(), IMRecipeTypes.ORE_WASHING_PLANT)
        .addIngredient(Items.WHITE_WOOL, 1)
        .addIngredient(new FluidStack(Fluids.WATER, 100))
        .addPrimaryResult(Items.STRING, 4)
        .addSecondaryResult(Items.COAL, 1, 1)
        .addTickLength(100)
        .build(consumer);

    // Precision Engraver Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.PRECISION_ENGRAVING.get(), IMRecipeTypes.PRECISION_ENGRAVING)
        .addIngredient(Items.WHITE_WOOL, 1)
        .addReusableIngredient(Items.GLASS, 1)
        .addPrimaryResult(Items.COAL, 1, 1)
        .addTickLength(100)
        .build(consumer);

    // Sifter Recipes
    IMCustomMachineRecipeBuilder.create(IMRecipeSerializers.SIFTER.get(), IMRecipeTypes.SIFTER)
        .addIngredient(Items.WHITE_WOOL, 1)
        .addPrimaryResult(Items.COAL, 1, 0.2)
        .addSecondaryResult(Items.CHARCOAL, 1, 0.4)
        .addSecondaryResult(Items.STRING, 1, 0.6)
        .addSecondaryResult(Items.BLACK_WOOL, 1, 0.1)
        .addTickLength(100)
        .build(consumer);
  }
}
