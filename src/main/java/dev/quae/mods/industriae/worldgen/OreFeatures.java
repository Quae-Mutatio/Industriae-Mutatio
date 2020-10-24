package dev.quae.mods.industriae.worldgen;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.material.Material;
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
    LIGNITE(Material.LIGNITE, Material.LIGNITE, Material.LIGNITE, Material.COAL, 50, 130, 160, 8, 32),
    COAL(Material.COAL, Material.COAL, Material.COAL, Material.LIGNITE, 50, 80, 80, 6, 32),
    MAGNETITE(Material.MAGNETITE, Material.MAGNETITE, Material.IRON, Material.VANADIUM_MAGNETITE, 50, 120, 160, 3, 32),
    GOLD(Material.MAGNETITE, Material.MAGNETITE, Material.VANADIUM_MAGNETITE, Material.GOLD, 60, 80, 160, 3, 32),
    IRON(Material.BROWN_LIMONITE, Material.YELLOW_LIMONITE, Material.BANDED_IRON, Material.MALACHITE, 10, 40, 120, 4, 24),
    CASSITERITE(Material.TIN, Material.TIN, Material.CASSITERITE, Material.TIN, 40, 120, 50, 5, 24),
    TETRAHEDRITE(Material.TETRAHEDRITE, Material.TETRAHEDRITE, Material.COPPER, Material.STIBNITE, 80, 120, 70, 4, 24),
    NETHER_QUARTZ(Material.NETHER_QUARTZ, Material.NETHER_QUARTZ, Material.NETHER_QUARTZ, Material.NETHER_QUARTZ, 40, 80, 80, 5, 24),
    SULFUR(Material.SULFUR, Material.SULFUR, Material.PYRITE, Material.SPHALERITE, 5, 20, 100, 5, 24),
    COPPER(Material.CHALCOPYRITE, Material.IRON, Material.PYRITE, Material.COPPER, 10, 30, 80, 4, 24),
    BAUXITE(Material.BAUXITE, Material.BAUXITE, Material.ALUMINIUM, Material.ILMENITE, 50, 90, 80, 4, 24),
    SALTS(Material.ROCK_SALT, Material.SALT, Material.LEPIDOLITE, Material.SPODUMENE, 50, 60, 50, 3, 24),
    REDSTONE(Material.REDSTONE, Material.REDSTONE, Material.RUBY, Material.CINNABAR, 10, 40, 60, 3, 24),
    SOAPSTONE(Material.SOAPSTONE, Material.TALC, Material.GLAUCONITE, Material.PENTLANDITE, 10, 40, 40, 3, 16),
    NICKEL(Material.GARNIERITE, Material.NICKEL, Material.COBALTITE, Material.PENTLANDITE, 10, 40, 40, 3, 16),
    PLATINUM(Material.SHELDONITE, Material.PALLADIUM, Material.PLATINUM, Material.IRIDIUM, 40, 50, 5, 3, 16),
    PITCHBLENDE(Material.PITCHBLENDE, Material.PITCHBLENDE, Material.URANIUM, Material.URANINITE, 10, 40, 40, 3, 16),
    PLUTONIUM(Material.URANINITE, Material.URANINITE, Material.PLUTONIUM, Material.URANIUM, 20, 30, 10, 3, 16),
    MONAZITE(Material.BASTNASITE, Material.BASTNASITE, Material.MONAZITE, Material.NEODYMIUM, 20, 40, 30, 3, 16),
    MOLYBDENUM(Material.WULFENITE, Material.MOLYBDENITE, Material.MOLYBDENUM, Material.POWELLITE, 20, 50, 5, 3, 16),
    TUNGSTATE(Material.SCHEELITE, Material.SCHEELITE, Material.TUNGSTATE, Material.LITHIUM, 20, 50, 10, 3, 16),
    SAPPHIRE(Material.ALMANDINE, Material.PYROPE, Material.SAPPHIRE, Material.GREEN_SAPPHIRE, 10, 40, 60, 3, 16),
    MANGANESE(Material.GROSSULAR, Material.SPESSARTINE, Material.PYROLUSITE, Material.TANTALITE, 20, 30, 20, 3, 16),
    QUARTZ(Material.QUARTZITE, Material.BARITE, Material.CERTUS_QUARTZ, Material.CERTUS_QUARTZ, 40, 80, 60, 3, 16),
    DIAMOND(Material.GRAPHITE, Material.GRAPHITE, Material.DIAMOND, Material.COAL, 5, 20, 40, 2, 16),
    OLIVINE(Material.BENTONITE, Material.MAGNESITE, Material.OLIVINE, Material.GLAUCONITE, 10, 40, 60, 3, 16),
    APATITE(Material.APATITE, Material.APATITE, Material.PHOSPHORUS, Material.PHOSPHATE, 40, 60, 60, 3, 16),
    GALENA(Material.GALENA, Material.GALENA, Material.SILVER, Material.LEAD, 30, 60, 40, 5, 16),
    LAPIS(Material.LAZURITE, Material.SODALITE, Material.LAPIS, Material.CALCITE, 20, 50, 40, 5, 16),
    BERYLLIUM(Material.BERYLLIUM, Material.BERYLLIUM, Material.EMERALD, Material.THORIUM, 5, 30, 30, 3, 16),
    ;

    private final Material primary;
    private final Material secondary;
    private final Material inbetween;
    private final Material sporadic;
    private final int minHeight;
    private final int maxHeight;
    private final int weight;
    private final int density;
    private final int size;

    private RegistryObject<MultiChunkOreFeature> featureBase;
    private ConfiguredFeature<?, ?> feature;

    Vein(Material primary, Material secondary, Material inbetween, Material sporadic, int minHeight, int maxHeight, int weight, int density, int size) {
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
      final Object2IntOpenHashMap<Material> ores = new Object2IntOpenHashMap<>();
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
