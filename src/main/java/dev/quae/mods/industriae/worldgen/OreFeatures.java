package dev.quae.mods.industriae.worldgen;

import com.google.common.collect.ImmutableMap;
import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.material.Material;
import dev.quae.mods.industriae.setup.IMFeatures;
import dev.quae.mods.industriae.worldgen.feature.config.IMOreFeatureConfig;
import java.util.function.Consumer;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class OreFeatures {

  public static final ConfiguredFeature<?, ?> COPPER_ORE = register(Material.COPPER.getOreName(), IMFeatures.IM_ORE.get().withConfiguration(
      new IMOreFeatureConfig(FillerBlockType.field_241882_a, ImmutableMap.of(
          0.3f, get(Material.COPPER)
      ), 256, 0.005f))
      .func_242733_d(64)
      .func_242728_a()
      .func_242731_b(1)
  );

  public static final ConfiguredFeature<?, ?> APATITE_VEIN = register(Material.APATITE.getOreName(), IMFeatures.IM_ORE.get().withConfiguration(
      new IMOreFeatureConfig(FillerBlockType.field_241882_a, ImmutableMap.of(
          .6f, get(Material.APATITE),
          .4f, get(Material.PHOSPHOR)
      ), 128, 0.018f))
      .withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(60, 0, 256)))
      .withPlacement(Placement.field_242903_g.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))
      .withPlacement(Placement.field_242899_c.configure(new FeatureSpreadConfig(FeatureSpread.func_242253_a(1, 40))))
  );

  public static BlockState get(Material material) {
    return material.getOreBlock().get().getDefaultState();
  }

  private static ConfiguredFeature<?, ?> register(final String name, final ConfiguredFeature<?, ?> feature) {
    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, IndustriaeMutatio.ID + ":" + name, feature);
  }

  public static void addOres(Consumer<ConfiguredFeature<?, ?>> addOreCallback) {
    addOreCallback.accept(COPPER_ORE);
    addOreCallback.accept(APATITE_VEIN);
  }
}
