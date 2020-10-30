package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.setup.registers.IRegistryEnum;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMRecipeSerializers {
  public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IndustriaeMutatio.ID);

  static {
    for (IRegistryEnum[] arr : Registrar.REGISTRY_ENUMS) {
      for (IRegistryEnum val : arr) {
        val.registerRecipeSerializers(RECIPE_SERIALIZERS);
        val.registerRecipeTypes(name -> IRecipeType.register(IndustriaeMutatio.ID + ":" + name));
      }
    }
  }
}
