package dev.quae.mods.industriae.worldgen.feature;

import com.mojang.serialization.Codec;
import dev.quae.mods.industriae.worldgen.feature.config.MultiChunkOreFeatureConfig;
import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

public class MultiChunkOreFeature extends Feature<MultiChunkOreFeatureConfig> {

  public MultiChunkOreFeature(Codec<MultiChunkOreFeatureConfig> codec) {
    super(codec);
  }

  @Override
  public boolean func_241855_a(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, MultiChunkOreFeatureConfig config) {
    final ChunkPos chunkPos = new ChunkPos(pos);
    if (OreGenerationManager.getInstance(world.getWorld()).canSpawnFeatureInChunk(this, chunkPos, random)) {
      this.generate(world, chunkGenerator, random, pos, config);
      return true;
    }
    return false;
  }

  private void generate(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, MultiChunkOreFeatureConfig config) {
    if (config.stone.test(world.getBlockState(pos), random)) {
      final int r2 = config.radius * config.radius;
      BlockPos.getAllInBox(pos.add(-config.radius, -config.radius, -config.radius), pos.add(config.radius, config.radius, config.radius))
          .filter(it -> it.distanceSq(pos) <= r2)
          .forEach(it -> generateSingle(world, chunkGenerator, random, it, config));
    }
  }

  private void generateSingle(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, MultiChunkOreFeatureConfig config) {
    final BlockState existing = world.getBlockState(pos);
    if (config.stone.test(existing, random) && config.canSpawnOre(random)) {
      setBlockState(world, pos, config.chooseRandomOre(random));
    }
  }
}
