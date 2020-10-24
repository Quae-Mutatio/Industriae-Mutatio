package dev.quae.mods.industriae.helper;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public class RecipeTypeHelper {

  public static IRecipeType<IMCustomMachineRecipe> getType(String rl) {
    if (rl.equals(IndustriaeMutatio.ID + ":forge_hammer")) {
      return IMRecipeTypes.FORGE_HAMMER;
    } else if (rl.equals(IndustriaeMutatio.ID + ":macerator")) {
      return IMRecipeTypes.MACERATOR;
    }
    return null;
  }

  public static ResourceLocation getRl(IRecipeType<IMCustomMachineRecipe> recipeType) {
    if (recipeType.equals(IMRecipeTypes.MACERATOR)) {
      return new ResourceLocation(IndustriaeMutatio.ID, "macerator");
    } else if (recipeType.equals(IMRecipeTypes.FORGE_HAMMER)) {
      return new ResourceLocation(IndustriaeMutatio.ID, "forge_hammer");
    }
    return new ResourceLocation("");
  }
}
