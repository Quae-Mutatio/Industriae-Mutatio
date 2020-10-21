package dev.quae.mods.industriae.event;

import dev.quae.mods.industriae.worldgen.OreFeatures;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//@EventBusSubscriber(modid = IndustriaeMutatio.ID, bus = Bus.FORGE) TODO add when fixed
public class WorldGenEvents {

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void onBiomeLoad(final BiomeLoadingEvent event) {
    if (event.getCategory().equals(Category.NETHER)
        || event.getCategory().equals(Category.THEEND)
        || event.getCategory().equals(Category.NONE)) {
      return;
    }
    OreFeatures.addOres(feature -> event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, feature));
  }
}
