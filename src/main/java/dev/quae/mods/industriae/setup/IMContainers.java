package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.setup.registers.IRegistryEnum;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMContainers {

  public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, IndustriaeMutatio.ID);

  static {
    for (IRegistryEnum<?>[] arr : Registrar.REGISTRY_ENUMS) {
      for (IRegistryEnum<?> val : arr) {
        val.registerContainers(CONTAINERS);
      }
    }
  }
}
