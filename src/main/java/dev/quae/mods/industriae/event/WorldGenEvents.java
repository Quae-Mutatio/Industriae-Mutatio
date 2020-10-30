package dev.quae.mods.industriae.event;

import com.google.common.collect.ImmutableSet;
import dev.quae.mods.industriae.worldgen.OreFeatures;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
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
    final Set<Feature<?>> oreFeatures = BLACKLIST.stream().map(WorldGenEvents::getRealFeature).collect(Collectors.toSet());
    event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).removeIf(f -> oreFeatures.contains(getRealFeature(f.get())));
  }

  static Feature<?> getRealFeature(ConfiguredFeature<?, ?> feature) {
    ConfiguredFeature<?, ?> CF = feature;
    IFeatureConfig C = CF.config;
    while (C instanceof DecoratedFeatureConfig) {
      CF = ((DecoratedFeatureConfig) C).feature.get();
      C = CF.config;
    }
    return CF.feature;
  }
}
