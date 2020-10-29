package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.data.IMBlockStateProvider;
import dev.quae.mods.industriae.data.IMItemModelProvider;
import dev.quae.mods.industriae.data.IMLanguageProvider;
import dev.quae.mods.industriae.data.IMRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = IndustriaeMutatio.ID)
public class DataGeneration {
  @SubscribeEvent
  public static void onGatherData(final GatherDataEvent event) {
    final DataGenerator gen = event.getGenerator();
    final ExistingFileHelper efh = event.getExistingFileHelper();
    if (event.includeServer()) {
      gen.addProvider(new IMRecipeProvider(gen));
    }
    if (event.includeClient()){
      gen.addProvider(new IMItemModelProvider(gen, efh));
      gen.addProvider(new IMBlockStateProvider(gen, efh));
      gen.addProvider(new IMLanguageProvider(gen, "en_us"));
    }
  }
}
