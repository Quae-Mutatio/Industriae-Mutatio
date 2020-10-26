package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public class IMRecipeTypes {
  public static final IRecipeType<IMCustomMachineRecipe> MACERATOR = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "macerator").toString());
  public static final IRecipeType<IMCustomMachineRecipe> FORGE_HAMMER = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "forge_hammer").toString());
  public static final IRecipeType<IMCustomMachineRecipe> ALLOY_FURNACE = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "alloy_furnace").toString());
  public static final IRecipeType<IMCustomMachineRecipe> WIREMILL = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "wiremill").toString());
  public static final IRecipeType<IMCustomMachineRecipe> UNPACKAGER = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "unpackager").toString());
  public static final IRecipeType<IMCustomMachineRecipe> PACKAGER =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "packager").toString());
  public static final IRecipeType<IMCustomMachineRecipe> THERMAL_CENTRIFUGE =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "thermal_centrifuge").toString());
}
