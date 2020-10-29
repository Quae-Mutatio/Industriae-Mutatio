package dev.quae.mods.industriae.client;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = IndustriaeMutatio.ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      for (MachineType value : MachineType.values()) {
        value.registerScreen();
      }
    });
  }
}
