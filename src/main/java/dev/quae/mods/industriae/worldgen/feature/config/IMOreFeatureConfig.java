package dev.quae.mods.industriae.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.util.Unit;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;

public class IMOreFeatureConfig implements IFeatureConfig {

  public static final Codec<IMOreFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
      RuleTest.field_237127_c_.fieldOf("target").forGetter(config -> config.target),
      Codec.simpleMap(Codec.FLOAT, BlockState.CODEC, MapCodec.of(Encoder.empty(), Decoder.unit(Unit.INSTANCE))).fieldOf("oreDistribution").forGetter(config -> config.oreDistribution),
      Codec.intRange(0, 64).fieldOf("size").forGetter(config -> config.size),
      Codec.floatRange(0f, 1f).fieldOf("chunkChance").forGetter(config -> config.chunkchance))
      .apply(instance, IMOreFeatureConfig::new));

  public final RuleTest target;
  public final int size;
  public final Map<Float, BlockState> oreDistribution;
  public final float chunkchance;

  public IMOreFeatureConfig(RuleTest ruleTest, Map<Float, BlockState> oreDist, int size, float chanceInChunk) {
    this.size = size;
    this.oreDistribution = oreDist;
    this.target = ruleTest;
    this.chunkchance = chanceInChunk;
  }
}
