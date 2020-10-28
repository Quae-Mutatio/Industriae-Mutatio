package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.data.recipe.IMCustomMachineRecipeBuilder;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.setup.IMItems;
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
    IMCustomMachineRecipeBuilder.create(MachineType.MACERATOR.getSerializer(), MachineType.MACERATOR.getRecipeType())
        .addIngredient(Items.OAK_LOG, 1)
        .addPrimaryResult(IMItems.WOOD_PULP.get(), 4)
        .addSecondaryResult(IMItems.WOOD_PULP.get(), 0.15)
        .addTickLength(100)
        .build(consumer);

    // Forge Hammer Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.FORGE_HAMMER.getSerializer(), MachineType.FORGE_HAMMER.getRecipeType())
        .addIngredient(Items.COBBLESTONE, 1)
        .addPrimaryResult(Items.GRAVEL, 1)
        .addTickLength(100)
        .build(consumer);

    // Alloy Furnace Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.ALLOY_SMELTER.getSerializer(), MachineType.ALLOY_SMELTER.getRecipeType())
        .addIngredient(Items.COAL, 2)
        .addIngredient(Items.IRON_INGOT, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 1)
        .addTickLength(100)
        .build(consumer);

    // Wire Mill Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.WIREMILL.getSerializer(), MachineType.WIREMILL.getRecipeType())
        .addIngredient(Items.IRON_INGOT, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 1)
        .addTickLength(100)
        .build(consumer);

  // UnPackager Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.UNPACKAGER.getSerializer(), MachineType.UNPACKAGER.getRecipeType())
        .addIngredient(Items.GOLD_BLOCK, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 4)
        .addSecondaryResult(Items.GOLD_NUGGET, 1, 1.0)
        .addTickLength(100)
        .build(consumer);

    // Packager Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.PACKAGER.getSerializer(), MachineType.PACKAGER.getRecipeType())
        .addIngredient(Items.GOLD_BLOCK, 1)
        .addIngredient(Items.WHITE_WOOL, 1)
        .addPrimaryResult(Items.GOLD_INGOT, 4)
        .addTickLength(100)
        .build(consumer);

    // Thermal Centrifuge Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.THERMAL_CENTRIFUGE.getSerializer(), MachineType.THERMAL_CENTRIFUGE.getRecipeType())
        .addIngredient(Items.WHITE_WOOL, 1)
        .addPrimaryResult(Items.STRING, 4)
        .addTickLength(100)
        .build(consumer);

    // Ore Washing Plant Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.ORE_WASHING_PLANT.getSerializer(), MachineType.ORE_WASHING_PLANT.getRecipeType())
        .addIngredient(Items.WHITE_WOOL, 1)
        .addIngredient(new FluidStack(Fluids.WATER, 100))
        .addPrimaryResult(Items.STRING, 4)
        .addSecondaryResult(Items.COAL, 1, 1)
        .addTickLength(100)
        .build(consumer);

    // Precision Engraver Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.PRECISION_ENGRAVING_MACHINE.getSerializer(), MachineType.PRECISION_ENGRAVING_MACHINE.getRecipeType())
        .addIngredient(Items.WHITE_WOOL, 1)
        .addReusableIngredient(Items.GLASS, 1)
        .addPrimaryResult(Items.COAL, 1, 1)
        .addTickLength(100)
        .build(consumer);

    // Sifter Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.SIFTER.getSerializer(), MachineType.SIFTER.getRecipeType())
        .addIngredient(Items.WHITE_WOOL, 1)
        .addPrimaryResult(Items.COAL, 1, 0.2)
        .addSecondaryResult(Items.CHARCOAL, 1, 0.4)
        .addSecondaryResult(Items.STRING, 1, 0.6)
        .addSecondaryResult(Items.BLACK_WOOL, 1, 0.1)
        .addTickLength(100)
        .build(consumer);

    // Autoclave Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.AUTOCLAVE.getSerializer(), MachineType.AUTOCLAVE.getRecipeType())
        .addIngredient(Items.GUNPOWDER, 1)
        .addIngredient(new FluidStack(Fluids.WATER, 100))
        .addPrimaryResult(Items.COAL, 1, 1)
        .addTickLength(100)
        .build(consumer);


    // Mixer Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.MIXER.getSerializer(), MachineType.MIXER.getRecipeType())
        .addIngredient(Items.GUNPOWDER, 1)
        .addIngredient(new FluidStack(Fluids.WATER, 100))
        .addPrimaryResult(Items.COAL, 1, 1)
        .addSecondaryResult(Items.BLACK_WOOL, 1, 1.0)
        .addTickLength(100)
        .build(consumer);

    // Polarizer Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.POLARISER.getSerializer(), MachineType.POLARISER.getRecipeType())
        .addIngredient(Items.GUNPOWDER, 1)
        .addPrimaryResult(Items.FIRE_CHARGE, 1, 1)
        .addTickLength(100)
        .build(consumer);

    // Lathe Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.LATHE.getSerializer(), MachineType.LATHE.getRecipeType())
        .addIngredient(Items.IRON_BLOCK, 1)
        .addPrimaryResult(Items.IRON_INGOT, 9, 1)
        .addTickLength(100)
        .build(consumer);

    // Replicator Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.REPLICATOR.getSerializer(), MachineType.REPLICATOR.getRecipeType())
        .addIngredient(Items.IRON_BLOCK, 1)
        .addPrimaryResult(Items.IRON_BLOCK, 9, 1)
        .addTickLength(100)
        .build(consumer);

    // Recycler Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.RECYCLER.getSerializer(), MachineType.RECYCLER.getRecipeType())
        .addIngredient(Items.IRON_BLOCK, 1)
        .addPrimaryResult(() -> Fluids.LAVA, 10)
        .addSecondaryResult(() -> Fluids.WATER, 10)
        .addTickLength(100)
        .build(consumer);

    // Plasma Arc Furnace Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.PLASMA_ARC_FURNACE.getSerializer(), MachineType.PLASMA_ARC_FURNACE.getRecipeType())
        .addIngredient(new FluidStack(Fluids.WATER, 10))
        .addIngredient(Items.IRON_BLOCK, 1)
        .addPrimaryResult(Items.IRON_INGOT, 9)
        .addTickLength(100)
        .build(consumer);

    // Microwave Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.MICROWAVE.getSerializer(), MachineType.MICROWAVE.getRecipeType())
        .addIngredient(Items.PUFFERFISH, 1)
        .addPrimaryResult(Items.COOKED_SALMON, 1, 1)
        .addTickLength(100)
        .build(consumer);

    // Mass Fabricator Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.MASS_FABRICATOR.getSerializer(), MachineType.MASS_FABRICATOR.getRecipeType())
        .addIngredient(Items.IRON_BLOCK, 1)
        .addPrimaryResult(Items.IRON_INGOT, 9, 1)
        .addTickLength(100)
        .build(consumer);

    // Furnace Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.FURNACE.getSerializer(), MachineType.FURNACE.getRecipeType())
        .addIngredient(Items.IRON_BLOCK, 1)
        .addPrimaryResult(Items.IRON_INGOT, 9, 1)
        .addTickLength(100)
        .build(consumer);

    // Forming Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.FORMING_PRESS.getSerializer(), MachineType.FORMING_PRESS.getRecipeType())
        .addIngredient(Items.IRON_BLOCK, 1)
        .addIngredient(Items.IRON_INGOT, 1)
        .addPrimaryResult(Items.IRON_INGOT, 9, 1)
        .addTickLength(100)
        .build(consumer);

    // Fluid Solidifier Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.FLUID_SOLIDIFIER.getSerializer(), MachineType.FLUID_SOLIDIFIER.getRecipeType())
        .addIngredient(new FluidStack(Fluids.WATER, 10))
        .addPrimaryResult(Items.IRON_INGOT, 9, 1)
        .addTickLength(100)
        .build(consumer);

    // Chemical Reactor Recipes
    IMCustomMachineRecipeBuilder.create(MachineType.CHEMICAL_REACTOR.getSerializer(), MachineType.CHEMICAL_REACTOR.getRecipeType())
        .addIngredient(new FluidStack(Fluids.WATER, 10))
        .addIngredient(Items.IRON_INGOT, 1)
        .addPrimaryResult(Items.GOLD_NUGGET, 1, 1)
        .addSecondaryResult(() -> Fluids.LAVA, 100)
        .addTickLength(100)
        .build(consumer);
  }
}
