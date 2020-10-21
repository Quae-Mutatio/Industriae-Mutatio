package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.IMMaceratorRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMRecipeSerializers {
  public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IndustriaeMutatio.ID);

  public static final RegistryObject<IMMaceratorRecipe.Serializer> MACERATOR = RECIPE_SERIALIZERS.register("macerator", IMMaceratorRecipe.Serializer::new);

}
