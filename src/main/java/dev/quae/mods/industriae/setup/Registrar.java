package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.setup.registers.ConstructComponent;
import dev.quae.mods.industriae.setup.registers.ConstructController;
import dev.quae.mods.industriae.setup.registers.IRegistryEnum;
import dev.quae.mods.industriae.setup.registers.MachineType;
import dev.quae.mods.industriae.setup.registers.SpeedTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registrar {

  public static final IRegistryEnum<?>[][] REGISTRY_ENUMS = new IRegistryEnum[][]{
      MachineType.values(),
      ConstructController.values(),
      ConstructComponent.values(),
      SpeedTier.values()
  };

  public static void onConstruct() {
    final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    IMBlocks.BLOCKS.register(bus);
    IMItems.ITEMS.register(bus);
    IMTiles.TILES.register(bus);
    IMContainers.CONTAINERS.register(bus);
    IMFeatures.FEATURES.register(bus);
    IMRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
  }
}
