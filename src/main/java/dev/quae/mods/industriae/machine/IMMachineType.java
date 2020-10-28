package dev.quae.mods.industriae.machine;

import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IStringSerializable;

public interface IMMachineType extends IStringSerializable {

  /**
   * @return size of input inventory
   */
  int getInputInventorySize();

  /**
   * @return size of output inventory
   */
  int getOutputInventorySize();

  /**
   *
   * @return size of input tank
   */
  int getInputTankCount();

  /**
   * @return size of output tank
   */
  int getOutputTankCount();

  /**
   * @return get name
   */
  String getName();

  @Override
  default String getString(){
    return getName();
  }

  IRecipeType<IMCustomMachineRecipe> getRecipeType();
}
