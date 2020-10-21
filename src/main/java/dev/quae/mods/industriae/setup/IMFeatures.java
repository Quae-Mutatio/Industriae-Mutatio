package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.worldgen.feature.IMOreFeature;
import dev.quae.mods.industriae.worldgen.feature.config.IMOreFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMFeatures {

  static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, IndustriaeMutatio.ID);

  public static final RegistryObject<Feature<IMOreFeatureConfig>> IM_ORE = FEATURES.register("ore", () -> new IMOreFeature(IMOreFeatureConfig.CODEC));

}
