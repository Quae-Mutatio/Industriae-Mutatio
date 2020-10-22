package dev.quae.mods.industriae.data.recipe;

import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import net.minecraft.item.ItemStack;

public class ForgeHammerRecipeBuilder extends IMSingleInputRecipeBuilder<ForgeHammerRecipeBuilder> {
  private ForgeHammerRecipeBuilder(ItemStack ingredient) {
    super(ingredient, IMRecipeSerializers.FORGE_HAMMER.get());
  }

  public static ForgeHammerRecipeBuilder create(ItemStack input){
    return new ForgeHammerRecipeBuilder(input);
  }
}
