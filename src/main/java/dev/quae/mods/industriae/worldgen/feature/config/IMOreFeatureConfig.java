package dev.quae.mods.industriae.worldgen.feature.config;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.quae.mods.industriae.material.Material;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.BlockState;
import net.minecraft.util.Unit;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;

public class IMOreFeatureConfig implements IFeatureConfig {

  public static final Codec<IMOreFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
      RuleTest.field_237127_c_.fieldOf("target").forGetter(config -> config.target),
      Codec.simpleMap(BlockState.CODEC, Codec.FLOAT, MapCodec.of(Encoder.empty(), Decoder.unit(Unit.INSTANCE))).fieldOf("oreDistribution").forGetter(config -> config.oreDistribution),
      Codec.intRange(0, 64).fieldOf("size").forGetter(config -> config.size),
      Codec.intRange(1, Integer.MAX_VALUE).fieldOf("spawnWeight").forGetter(config -> config.spawnWeight),
      Codec.floatRange(0f, 1f).fieldOf("density").forGetter(config -> config.density))
      .apply(instance, IMOreFeatureConfig::new));

  private static int TOTALWEIGHT = 0;

  public final RuleTest target;
  public final int size;
  public final Map<BlockState, Float> oreDistribution = new HashMap<>();
  public final int spawnWeight;
  public final float density;

  public IMOreFeatureConfig(RuleTest ruleTest, ImmutableMap<Material, Integer> oreDist, int size, int spawnWeight, float density) {
    this.size = size;
    this.target = ruleTest;
    this.spawnWeight = spawnWeight;
    TOTALWEIGHT += this.spawnWeight;
    this.density = density;
    float total = oreDist.values().stream().mapToInt(Integer::intValue).sum();
    for (Entry<Material, Integer> entry : oreDist.entrySet()) {
      this.oreDistribution.put(entry.getKey().getOreBlock().get().getDefaultState(), entry.getValue() / total);
    }
  }

  private IMOreFeatureConfig(RuleTest ruleTest, Map<BlockState, Float> oreDist, int size, int spawnWeight, float density) {
    this.size = size;
    this.target = ruleTest;
    this.spawnWeight = spawnWeight;
    this.density = density;
    this.oreDistribution.putAll(oreDist);
  }

  public float getWeight() {
    return this.spawnWeight / (float) TOTALWEIGHT;
  }
}
