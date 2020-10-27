package dev.quae.mods.industriae.worldgen;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.material.Ore;
import dev.quae.mods.industriae.worldgen.feature.MultiChunkOreFeature;
import dev.quae.mods.industriae.worldgen.feature.config.MultiChunkOreFeatureConfig;
import dev.quae.mods.industriae.worldgen.feature.config.MultiChunkOreFeatureConfig.OreDefinition;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.fml.RegistryObject;

public class OreFeatures {

  static {
    for (Vein vein : Vein.values()) {
      vein.createFeature();
    }
  }

  public static void addOres(Consumer<Supplier<ConfiguredFeature<?, ?>>> addOreCallback) {
    for (Vein vein : Vein.values()) {
      addOreCallback.accept(vein::getFeature);
    }
  }

  @SuppressWarnings("unchecked")
  private static <FC extends IFeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> register(final String name, final ConfiguredFeature<?, ?> feature) {
    return (ConfiguredFeature<FC, F>) Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, IndustriaeMutatio.ID + ":" + name, feature);
  }

  public enum Vein {
    LIGNITE(Ore.LIGNITE, Ore.LIGNITE, Ore.LIGNITE, Ore.COAL, 50, 130, 160, 8, 32),
    COAL(Ore.COAL, Ore.COAL, Ore.COAL, Ore.LIGNITE, 50, 80, 80, 6, 32),
    MAGNETITE(Ore.MAGNETITE, Ore.MAGNETITE, Ore.IRON, Ore.VANADIUM_MAGNETITE, 50, 120, 160, 3, 32),
    GOLD(Ore.MAGNETITE, Ore.MAGNETITE, Ore.VANADIUM_MAGNETITE, Ore.GOLD, 60, 80, 160, 3, 32),
    IRON(Ore.BROWN_LIMONITE, Ore.YELLOW_LIMONITE, Ore.BANDED_IRON, Ore.MALACHITE, 10, 40, 120, 4, 24),
    CASSITERITE(Ore.TIN, Ore.TIN, Ore.CASSITERITE, Ore.TIN, 40, 120, 50, 5, 24),
    TETRAHEDRITE(Ore.TETRAHEDRITE, Ore.TETRAHEDRITE, Ore.COPPER, Ore.STIBNITE, 80, 120, 70, 4, 24),
    NETHER_QUARTZ(Ore.NETHER_QUARTZ, Ore.NETHER_QUARTZ, Ore.NETHER_QUARTZ, Ore.NETHER_QUARTZ, 40, 80, 80, 5, 24),
    SULFUR(Ore.SULFUR, Ore.SULFUR, Ore.PYRITE, Ore.SPHALERITE, 5, 20, 100, 5, 24),
    COPPER(Ore.CHALCOPYRITE, Ore.IRON, Ore.PYRITE, Ore.COPPER, 10, 30, 80, 4, 24),
    BAUXITE(Ore.BAUXITE, Ore.BAUXITE, Ore.ALUMINIUM, Ore.ILMENITE, 50, 90, 80, 4, 24),
    SALTS(Ore.ROCK_SALT, Ore.SALT, Ore.LEPIDOLITE, Ore.SPODUMENE, 50, 60, 50, 3, 24),
    REDSTONE(Ore.REDSTONE, Ore.REDSTONE, Ore.RUBY, Ore.CINNABAR, 10, 40, 60, 3, 24),
    SOAPSTONE(Ore.SOAPSTONE, Ore.TALC, Ore.GLAUCONITE, Ore.PENTLANDITE, 10, 40, 40, 3, 16),
    NICKEL(Ore.GARNIERITE, Ore.NICKEL, Ore.COBALTITE, Ore.PENTLANDITE, 10, 40, 40, 3, 16),
    PLATINUM(Ore.SHELDONITE, Ore.PALLADIUM, Ore.PLATINUM, Ore.IRIDIUM, 40, 50, 5, 3, 16),
    PITCHBLENDE(Ore.PITCHBLENDE, Ore.PITCHBLENDE, Ore.URANIUM, Ore.URANINITE, 10, 40, 40, 3, 16),
    PLUTONIUM(Ore.URANINITE, Ore.URANINITE, Ore.PLUTONIUM, Ore.URANIUM, 20, 30, 10, 3, 16),
    MONAZITE(Ore.BASTNASITE, Ore.BASTNASITE, Ore.MONAZITE, Ore.NEODYMIUM, 20, 40, 30, 3, 16),
    MOLYBDENUM(Ore.WULFENITE, Ore.MOLYBDENITE, Ore.MOLYBDENUM, Ore.POWELLITE, 20, 50, 5, 3, 16),
    TUNGSTATE(Ore.SCHEELITE, Ore.SCHEELITE, Ore.TUNGSTATE, Ore.LITHIUM, 20, 50, 10, 3, 16),
    SAPPHIRE(Ore.ALMANDINE, Ore.PYROPE, Ore.SAPPHIRE, Ore.GREEN_SAPPHIRE, 10, 40, 60, 3, 16),
    MANGANESE(Ore.GROSSULAR, Ore.SPESSARTINE, Ore.PYROLUSITE, Ore.TANTALITE, 20, 30, 20, 3, 16),
    QUARTZ(Ore.QUARTZITE, Ore.BARITE, Ore.CERTUS_QUARTZ, Ore.CERTUS_QUARTZ, 40, 80, 60, 3, 16),
    DIAMOND(Ore.GRAPHITE, Ore.GRAPHITE, Ore.DIAMOND, Ore.COAL, 5, 20, 40, 2, 16),
    OLIVINE(Ore.BENTONITE, Ore.MAGNESITE, Ore.OLIVINE, Ore.GLAUCONITE, 10, 40, 60, 3, 16),
    APATITE(Ore.APATITE, Ore.APATITE, Ore.PHOSPHORUS, Ore.PHOSPHATE, 40, 60, 60, 3, 16),
    GALENA(Ore.GALENA, Ore.GALENA, Ore.SILVER, Ore.LEAD, 30, 60, 40, 5, 16),
    LAPIS(Ore.LAZURITE, Ore.SODALITE, Ore.LAPIS, Ore.CALCITE, 20, 50, 40, 5, 16),
    BERYLLIUM(Ore.BERYLLIUM, Ore.BERYLLIUM, Ore.EMERALD, Ore.THORIUM, 5, 30, 30, 3, 16),
    ;

    private final Ore primary;
    private final Ore secondary;
    private final Ore inbetween;
    private final Ore sporadic;
    private final int minHeight;
    private final int maxHeight;
    private final int weight;
    private final int density;
    private final int size;

    private RegistryObject<MultiChunkOreFeature> featureBase;
    private ConfiguredFeature<?, ?> feature;

    Vein(Ore primary, Ore secondary, Ore inbetween, Ore sporadic, int minHeight, int maxHeight, int weight, int density, int size) {
      this.primary = primary;
      this.secondary = secondary;
      this.inbetween = inbetween;
      this.sporadic = sporadic;
      this.minHeight = minHeight;
      this.maxHeight = maxHeight;
      this.weight = weight;
      this.density = density;
      this.size = size;
    }

    public void createFeature() {
      final Object2IntOpenHashMap<Ore> ores = new Object2IntOpenHashMap<>();
      // This is done to ensure that if a primary and secondary ore, for example, are the same that it doesn't override the original value.
      ores.computeInt(this.primary, (material, x) -> x == null ? 100 : x + 100);
      ores.computeInt(this.secondary, (material, x) -> x == null ? 50 : x + 50);
      ores.computeInt(this.inbetween, (material, x) -> x == null ? 25 : x + 25);
      ores.computeInt(this.sporadic, (material, x) -> x == null ? 10 : x + 10);
      feature = register(name().toLowerCase(), featureBase.get().withConfiguration(
          new MultiChunkOreFeatureConfig(FillerBlockType.field_241882_a, this.weight, this.size, this.density, new OreDefinition(ores)))
          .withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(this.minHeight, 0, this.maxHeight)))
      );
    }

    public ConfiguredFeature<?, ?> getFeature() {
      return feature;
    }

    public void setFeatureBase(RegistryObject<MultiChunkOreFeature> feature) {
      this.featureBase = feature;
    }

    public int getWeight() {
      return weight;
    }
  }
}
