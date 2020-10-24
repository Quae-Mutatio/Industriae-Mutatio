package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.recipe.ForgeHammerRecipe;
import dev.quae.mods.industriae.recipe.MaceratorRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMRecipeSerializers {
  public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IndustriaeMutatio.ID);

  public static final RegistryObject<MaceratorRecipe.Serializer> MACERATOR = RECIPE_SERIALIZERS.register("macerator", MaceratorRecipe.Serializer::new);
  public static final RegistryObject<ForgeHammerRecipe.Serializer> FORGE_HAMMER = RECIPE_SERIALIZERS.register("forge_hammer", ForgeHammerRecipe.Serializer::new);

}
