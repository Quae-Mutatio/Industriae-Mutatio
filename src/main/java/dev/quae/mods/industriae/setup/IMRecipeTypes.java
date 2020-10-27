package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public class IMRecipeTypes {
  public static final IRecipeType<IMCustomMachineRecipe> MACERATOR = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "macerator").toString());
  public static final IRecipeType<IMCustomMachineRecipe> FORGE_HAMMER = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "forge_hammer").toString());
  public static final IRecipeType<IMCustomMachineRecipe> ALLOY_SMELTER = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "alloy_furnace").toString());
  public static final IRecipeType<IMCustomMachineRecipe> WIREMILL = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "wiremill").toString());
  public static final IRecipeType<IMCustomMachineRecipe> UNPACKAGER = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "unpackager").toString());
  public static final IRecipeType<IMCustomMachineRecipe> PACKAGER =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "packager").toString());
  public static final IRecipeType<IMCustomMachineRecipe> THERMAL_CENTRIFUGE =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "thermal_centrifuge").toString());
  public static final IRecipeType<IMCustomMachineRecipe> ORE_WASHING_PLANT =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "ore_washing_plant").toString());
  public static final IRecipeType<IMCustomMachineRecipe> PRECISION_ENGRAVING =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "precision_engraving").toString());
  public static final IRecipeType<IMCustomMachineRecipe> SIFTER =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "sifter").toString());
  public static final IRecipeType<IMCustomMachineRecipe> AUTOCLAVE =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "autoclave").toString());
  public static final IRecipeType<IMCustomMachineRecipe> MIXER =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "mixer").toString());
  public static final IRecipeType<IMCustomMachineRecipe> POLARIZER =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "polarizer").toString());
  public static final IRecipeType<IMCustomMachineRecipe> LATHE =  IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, "lathe").toString());
}
