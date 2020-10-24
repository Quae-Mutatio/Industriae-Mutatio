package dev.quae.mods.industriae.event;

import com.google.common.collect.ImmutableSet;
import dev.quae.mods.industriae.worldgen.OreFeatures;
import java.util.Set;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//@EventBusSubscriber(modid = IndustriaeMutatio.ID, bus = Bus.FORGE) TODO add when fixed
public class WorldGenEvents {

  private static final Set<ConfiguredFeature<?, ?>> BLACKLIST = ImmutableSet.of(
      Features.ORE_COAL,
      Features.ORE_IRON,
      Features.ORE_GOLD_EXTRA,
      Features.ORE_GOLD,
      Features.ORE_REDSTONE,
      Features.ORE_DIAMOND,
      Features.ORE_LAPIS,
      Features.ORE_EMERALD
  );

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void onBiomeLoadingAdd(final BiomeLoadingEvent event) {
    if (event.getCategory().equals(Category.NETHER)
        || event.getCategory().equals(Category.THEEND)
        || event.getCategory().equals(Category.NONE)) {
      return;
    }
    OreFeatures.addOres(feature -> event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES.ordinal(), feature));
  }

  @SubscribeEvent(priority = EventPriority.NORMAL)
  public static void onBiomeLoadingRemove(final BiomeLoadingEvent event) {
    if (event.getCategory().equals(Category.NETHER)
        || event.getCategory().equals(Category.THEEND)
        || event.getCategory().equals(Category.NONE)) {
      return;
    }
    event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).removeIf(feature -> BLACKLIST.contains(feature.get()));
  }
}
