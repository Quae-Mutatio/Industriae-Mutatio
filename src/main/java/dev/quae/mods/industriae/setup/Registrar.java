package dev.quae.mods.industriae.setup;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registrar {

  public static void onConstruct() {
    final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    IMItems.ITEMS.register(bus);
    IMBlocks.BLOCKS.register(bus);
    IMTiles.TILES.register(bus);
    IMContainers.CONTAINERS.register(bus);
    IMRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
  }
}
