package dev.quae.mods.industriae.data.recipe;

import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import net.minecraft.item.ItemStack;

public class MaceratorRecipeBuilder extends IMSingleInputRecipeBuilder<MaceratorRecipeBuilder>{

  public MaceratorRecipeBuilder(ItemStack ingredient) {
    super(ingredient, IMRecipeSerializers.MACERATOR.get());
  }

  public static MaceratorRecipeBuilder create(ItemStack input){
    return new MaceratorRecipeBuilder(input);
  }
}
