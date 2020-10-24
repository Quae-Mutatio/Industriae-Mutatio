package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.ForgeHammerRecipe;
import dev.quae.mods.industriae.recipe.MaceratorRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public class IMRecipeTypes {
  public static final IRecipeType<MaceratorRecipe> MACERATOR = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "macerator").toString());
  public static final IRecipeType<ForgeHammerRecipe> FORGE_HAMMER = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "forge_hammer").toString());
}
