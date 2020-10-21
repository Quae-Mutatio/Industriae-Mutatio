package dev.quae.mods.industriae;

import dev.quae.mods.industriae.event.WorldGenEvents;
import dev.quae.mods.industriae.setup.Registrar;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(IndustriaeMutatio.ID)
public class IndustriaeMutatio {

  public static final String ID = "industriaemutatio";

  public IndustriaeMutatio() {
    Registrar.onConstruct();
    final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.addListener(this::onSetup);
  }

  private void onSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> MinecraftForge.EVENT_BUS.register(WorldGenEvents.class));
  }
}
