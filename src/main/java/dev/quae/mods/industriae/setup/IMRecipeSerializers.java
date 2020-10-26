package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMRecipeSerializers {
  public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IndustriaeMutatio.ID);

  public static final RegistryObject<IMCustomMachineRecipe.Serializer> MACERATOR = RECIPE_SERIALIZERS.register("macerator", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> FORGE_HAMMER = RECIPE_SERIALIZERS.register("forge_hammer", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> ALLOY_FURNACE = RECIPE_SERIALIZERS.register("alloy_furnace", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> WIREMILL = RECIPE_SERIALIZERS.register("wiremill", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> UNPACKAGER = RECIPE_SERIALIZERS.register("unpackager", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> PACKAGER = RECIPE_SERIALIZERS.register("packager", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> THERMAL_CENTRIFUGE = RECIPE_SERIALIZERS.register("thermal_centrifuge", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> ORE_WASHING_PLANT = RECIPE_SERIALIZERS.register("ore_washing_plant", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> PRECISION_ENGRAVING = RECIPE_SERIALIZERS.register("precision_engraving", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> SIFTER = RECIPE_SERIALIZERS.register("sifter", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> AUTOCLAVE = RECIPE_SERIALIZERS.register("autoclave", IMCustomMachineRecipe.Serializer::new);
  public static final RegistryObject<IMCustomMachineRecipe.Serializer> MIXER = RECIPE_SERIALIZERS.register("mixer", IMCustomMachineRecipe.Serializer::new);

}
