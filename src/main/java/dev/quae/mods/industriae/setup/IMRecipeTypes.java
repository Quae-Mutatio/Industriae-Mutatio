package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.IMMaceratorRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public class IMRecipeTypes {
  public static final IRecipeType<IMMaceratorRecipe> MACERATOR = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "machine_macerator").toString());
}
