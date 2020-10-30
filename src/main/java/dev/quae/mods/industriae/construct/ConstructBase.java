package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.block.IMConstructPartBlock;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2CharMap;
import it.unimi.dsi.fastutil.objects.Object2CharMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap;
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
    boolean matchesFlag = false;
    for (Rotation value : Rotation.values()) {
      matchesFlag = true;
      for (Entry<BlockPos> entry : offsetMap().object2CharEntrySet()) {
        final BlockPos offsetPos = controllerPos.add(entry.getKey().rotate(value));
        if (!matches(new CachedBlockInfo(world, offsetPos, false), legend.get(entry.getCharValue()))) {
          matchesFlag = false;
          break;
        }
      }
      if (matchesFlag) {
        break;
      }
    }

    return matchesFlag;
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
    for (int x = 0; x < shape.getX(); x++) {
      for (int z = 0; z < shape.getZ(); z++) {
        for (int y = 0; y < shape.getY(); y++) {
          final char ch = layout.charAt(charOff);
          final BlockPos offset = new BlockPos(x, y, z).subtract(controllerLocalOffset);
          OFFSET_MAP.put(offset, ch);
          charOff++;
        }
      }
    }

    return OFFSET_MAP;
  }

  private boolean matches(CachedBlockInfo cachedBlock, Predicate<Type> typeTest) {
    final BlockState state = cachedBlock.getBlockState();
    //noinspection ConstantConditions
    if (state == null) {
      return false;
    }
    final Block block = state.getBlock();
    if (block instanceof IMConstructPartBlock) {
      return typeTest.test(((IMConstructPartBlock) block).getType());
    }
    return false;
  }
}
