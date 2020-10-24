package dev.quae.mods.industriae.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.quae.mods.industriae.material.Material;
import dev.quae.mods.industriae.worldgen.feature.OreGenerationManager;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.Random;
import java.util.stream.IntStream;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;

public class MultiChunkOreFeatureConfig implements IFeatureConfig {

  public static final Codec<MultiChunkOreFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
      RuleTest.field_237127_c_.fieldOf("stone").forGetter(it -> it.stone),
      Codec.intRange(0, Integer.MAX_VALUE).fieldOf("weight").forGetter(it -> it.weight),
      Codec.intRange(0, 32).fieldOf("radius").forGetter(it -> it.radius),
      Codec.intRange(0, Integer.MAX_VALUE).fieldOf("density").forGetter(it -> it.density),
      OreDefinition.CODEC.fieldOf("ores").forGetter(it -> it.ores))
      .apply(instance, MultiChunkOreFeatureConfig::new));

  public final RuleTest stone;
  public final int weight;
  public final int radius;
  public final int density;
  public final OreDefinition ores;

  public MultiChunkOreFeatureConfig(RuleTest stone, int weight, int radius, int density, OreDefinition ores) {
    this.stone = stone;
    this.weight = weight;
    this.radius = radius + 8;
    this.density = density;
    this.ores = ores;

    OreGenerationManager.addWeight(weight);
  }

  public boolean canSpawnOre(Random random) {
    return random.nextInt(this.density) == 0;
  }

  public BlockState chooseRandomOre(Random random) {
    int seed = random.nextInt(ores.totalWeight);
    for (Entry<BlockState> entry : ores.weights.object2IntEntrySet()) {
      if (seed < entry.getIntValue()) {
        return entry.getKey();
      }
      seed -= entry.getIntValue();
    }
    return Blocks.AIR.getDefaultState();
  }

  public static class OreDefinition {

    public static final Codec<OreDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Codec.unboundedMap(BlockState.CODEC, Codec.INT).fieldOf("weights").forGetter(it -> it.weights)
    ).apply(instance, map -> new OreDefinition(new Object2IntOpenHashMap<>(map))));

    public int totalWeight;
    public Object2IntMap<BlockState> weights;

    public OreDefinition(Object2IntOpenHashMap<BlockState> weights) {
      this.weights = weights;
      this.totalWeight = IntStream.of(weights.values().toIntArray()).sum();
    }

    public OreDefinition(Object2IntMap<Material> weights) {
      this(new Object2IntOpenHashMap<>(weights.keySet().stream().map(mat -> mat.getOreBlock().get().getDefaultState()).toArray(BlockState[]::new), weights.values().toIntArray()));
    }
  }
}
