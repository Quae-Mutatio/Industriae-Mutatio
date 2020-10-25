package dev.quae.mods.industriae.helper;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.constant.IMRecipeConstants;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public class RecipeTypeHelper {

  public static IRecipeType<IMCustomMachineRecipe> getType(String rl) {
    if (rl.equals(IMRecipeConstants.FORGE_HAMMER_RL)) {
      return IMRecipeTypes.FORGE_HAMMER;
    } else if (rl.equals(IMRecipeConstants.MACERATOR_RL)) {
      return IMRecipeTypes.MACERATOR;
    } else if (rl.equals(IMRecipeConstants.ALLOY_FURNACE_RL)) {
      return IMRecipeTypes.ALLOY_FURNACE;
    } else if (rl.equals(IMRecipeConstants.WIREMILL_RL)) {
      return IMRecipeTypes.WIREMILL;
    } else if (rl.equals(IMRecipeConstants.UNPACKAGER_RL)) {
      return IMRecipeTypes.UNPACKAGER;
    } else if (rl.equals(IMRecipeConstants.PACKAGER_RL)) {
      return IMRecipeTypes.PACKAGER;
    } else if (rl.equals(IMRecipeConstants.THERMAL_CENTRIFUGE_RL)) {
      return IMRecipeTypes.THERMAL_CENTRIFUGE;
    }
    return null;
  }

  public static ResourceLocation getRl(IRecipeType<IMCustomMachineRecipe> recipeType) {
    if (recipeType.equals(IMRecipeTypes.MACERATOR)) {
      return new ResourceLocation(IMRecipeConstants.MACERATOR_RL);
    } else if (recipeType.equals(IMRecipeTypes.FORGE_HAMMER)) {
      return new ResourceLocation(IMRecipeConstants.FORGE_HAMMER_RL);
    } else if (recipeType.equals(IMRecipeTypes.ALLOY_FURNACE)) {
      return new ResourceLocation(IMRecipeConstants.ALLOY_FURNACE_RL);
    } else if (recipeType.equals(IMRecipeTypes.WIREMILL)) {
      return new ResourceLocation(IMRecipeConstants.WIREMILL_RL);
    } else if (recipeType.equals(IMRecipeTypes.UNPACKAGER)) {
      return new ResourceLocation(IMRecipeConstants.UNPACKAGER_RL);
    } else if (recipeType.equals(IMRecipeTypes.PACKAGER)) {
      return new ResourceLocation(IMRecipeConstants.PACKAGER_RL);
    } else if (recipeType.equals(IMRecipeTypes.THERMAL_CENTRIFUGE)) {
      return new ResourceLocation(IMRecipeConstants.THERMAL_CENTRIFUGE_RL);
    }
    return new ResourceLocation("");
  }
}
