package dev.quae.mods.industriae.worldgen.feature;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.worldgen.OreFeatures.Vein;
import dev.quae.mods.industriae.worldgen.feature.config.MultiChunkOreFeatureConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.LongNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.util.Constants.NBT;
import org.jetbrains.annotations.NotNull;

public class OreGenerationManager extends WorldSavedData {

  private final Map<ChunkPos, Vein> ORE_CENTER_MAP = new HashMap<>();
  private static int TOTAL_WEIGHT = 0;

  public OreGenerationManager() {
    super(IndustriaeMutatio.ID + ":ore_gen_manager");
  }

  public OreGenerationManager(String name) {
    super(name);
  }

  public static OreGenerationManager getInstance(ServerWorld world) {
    return world.getSavedData().getOrCreate(OreGenerationManager::new, IndustriaeMutatio.ID + ":ore_gen_manager");
  }

  public boolean canSpawnFeatureInChunk(MultiChunkOreFeature feature, ChunkPos pos, Random rand) {
    if (ORE_CENTER_MAP.containsKey(pos)) {
      return getFeature(ORE_CENTER_MAP.get(pos).getFeature()).equals(feature);
    }
    if (getSurrounding(pos, 2).anyMatch(ORE_CENTER_MAP::containsKey)) {
      return false;
    }
    int seed = rand.nextInt(TOTAL_WEIGHT);
    for (Vein vein : Vein.values()) {
      if (seed < vein.getWeight()) {
        ORE_CENTER_MAP.put(pos, vein);
        break;
      }
      seed -= vein.getWeight();
    }
    return getFeature(ORE_CENTER_MAP.get(pos).getFeature()).equals(feature);
  }

  @NotNull
  private Stream<ChunkPos> getSurrounding(final ChunkPos pos) {
    return getSurrounding(pos, 1);
  }

  private Stream<ChunkPos> getSurrounding(ChunkPos pos, int r) {
    final int radius = 2 * r + 1;
    return IntStream.range(0, (int) Math.pow(radius, 2)).mapToObj(it -> new ChunkPos(pos.x + (it % radius) - radius / 2, pos.z + (it / radius) - radius / 2));
  }

  public static void addWeight(int weight) {
    TOTAL_WEIGHT += weight;
  }

  private MultiChunkOreFeature getFeature(ConfiguredFeature<?, ?> feature) {
    return (MultiChunkOreFeature) ((DecoratedFeatureConfig) feature.config).feature.get().feature;
  }

  private MultiChunkOreFeatureConfig getConfig(ConfiguredFeature<?, ?> feature) {
    return (MultiChunkOreFeatureConfig) ((DecoratedFeatureConfig) feature.config).feature.get().config;
  }

  @Override
  public void read(CompoundNBT nbt) {
    ORE_CENTER_MAP.clear();
    final int size = nbt.getInt("size");
    final ListNBT chunkPosList = nbt.getList("chunkPosList", NBT.TAG_LONG);
    final ListNBT veinList = nbt.getList("veinList", NBT.TAG_STRING);
    for (int i = 0; i < size; i++) {
      final ChunkPos pos = new ChunkPos(((LongNBT) chunkPosList.get(i)).getLong());
      final Vein vein = Vein.valueOf(veinList.getString(i));
      ORE_CENTER_MAP.put(pos, vein);
    }
  }

  @Override
  public CompoundNBT write(CompoundNBT nbt) {
    final int size = ORE_CENTER_MAP.size();
    nbt.putInt("size", size);
    final ListNBT chunkPosList = new ListNBT();
    final ListNBT veinList = new ListNBT();
    int index = 0;
    for (Entry<ChunkPos, Vein> entry : ORE_CENTER_MAP.entrySet()) {
      chunkPosList.add(index, LongNBT.valueOf(entry.getKey().asLong()));
      veinList.add(index, StringNBT.valueOf(entry.getValue().name()));
      index++;
    }
    nbt.put("chunkPosList", chunkPosList);
    nbt.put("veinList", veinList);
    return nbt;
  }
}
