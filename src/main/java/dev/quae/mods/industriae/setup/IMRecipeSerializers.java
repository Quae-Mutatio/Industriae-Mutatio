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

}
