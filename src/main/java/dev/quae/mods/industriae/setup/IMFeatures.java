package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.worldgen.OreFeatures.Vein;
import dev.quae.mods.industriae.worldgen.feature.MultiChunkOreFeature;
import dev.quae.mods.industriae.worldgen.feature.config.MultiChunkOreFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMFeatures {

  static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, IndustriaeMutatio.ID);

  static {
    for (Vein vein : Vein.values()) {
      vein.setFeatureBase(FEATURES.register(vein.name().toLowerCase() + "_vein", () -> new MultiChunkOreFeature(MultiChunkOreFeatureConfig.CODEC)));
    }
  }

}
