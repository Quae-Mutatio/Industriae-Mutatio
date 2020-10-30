package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.block.IMConstructPartBlock;
import dev.quae.mods.industriae.construct.task.Amount;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2CharMap;
import it.unimi.dsi.fastutil.objects.Object2CharMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.IWorldReader;

public abstract class ConstructBase implements IConstruct {

  private static Object2CharMap<BlockPos> OFFSET_MAP;

  public boolean validateConstruct(BlockPos controllerPos, IWorldReader world) {
    // Check each rotation of the local offsets if the blockstate contains the correct construct type.
    final Char2ObjectMap<Predicate<Type>> legend = this.getLegend();
    final Object2IntMap<Type> amounts = new Object2IntOpenHashMap<>();
    boolean matchesFlag = false;
    for (Rotation value : Rotation.values()) {
      matchesFlag = true;
      final ObjectSet<Entry<BlockPos>> entries = offsetMap().object2CharEntrySet();
      for (Entry<BlockPos> entry : entries) {
        final BlockPos offsetPos = controllerPos.add(entry.getKey().rotate(value));
        final Type type = matches(new CachedBlockInfo(world, offsetPos, false), legend.get(entry.getCharValue()));
        if (type == null) {
          matchesFlag = false;
          amounts.clear();
          break;
        }
        amounts.computeInt(type, (t, i) -> i == null ? 1 : i++);
      }
      if (matchesFlag) {
        break;
      }
    }
    if (!matchesFlag) {
      return false;
    }

    final Map<Type, Amount> requiredParts = this.getRequiredParts();
    for (Map.Entry<Type, Amount> entry : requiredParts.entrySet()) {
      if (!entry.getValue().test(amounts.getInt(entry.getKey()))) {
        return false;
      }
    }

    return true;
  }

  private Object2CharMap<BlockPos> offsetMap() {
    if (OFFSET_MAP != null) {
      return OFFSET_MAP;
    } else {
      OFFSET_MAP = new Object2CharOpenHashMap<>();
    }

    final Vector3i controllerLocalOffset = getControllerLocalOffset();
    final String layout = getLayout();
    final BlockPos shape = getShape();
    int charOff = 0;
    for (int y = 0; y < shape.getY(); y++) {
      for (int z = 0; z < shape.getZ(); z++) {
        for (int x = 0; x < shape.getX(); x++) {
          final char ch = layout.charAt(charOff++);
          if (ch == ' ') {
            continue;
          }
          final BlockPos offset = new BlockPos(x, y, z).subtract(controllerLocalOffset);
          OFFSET_MAP.put(offset, ch);
        }
      }
    }

    return OFFSET_MAP;
  }

  private Type matches(CachedBlockInfo cachedBlock, Predicate<Type> typeTest) {
    final BlockState state = cachedBlock.getBlockState();
    //noinspection ConstantConditions
    if (state == null) {
      return null;
    }
    final Block block = state.getBlock();
    if (block instanceof IMConstructPartBlock) {
      final Type type = ((IMConstructPartBlock) block).getType();
      return typeTest.test(type) ? type : null;
    }
    return null;
  }
}
