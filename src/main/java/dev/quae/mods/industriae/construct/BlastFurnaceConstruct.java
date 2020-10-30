package dev.quae.mods.industriae.construct;

import com.google.common.collect.ImmutableMap;
import dev.quae.mods.industriae.construct.task.Amount;
import dev.quae.mods.industriae.construct.task.Amount.Const;
import dev.quae.mods.industriae.construct.task.Amount.Range;
import dev.quae.mods.industriae.construct.type.ComponentType;
import dev.quae.mods.industriae.construct.type.ControllerType;
import dev.quae.mods.industriae.construct.type.IOType;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.util.math.BlockPos;

public class BlastFurnaceConstruct extends ConstructBase {


  @Override
  public Map<Type, Amount> getRequiredParts() {
    final HashMap<Type, Amount> requiredParts = new HashMap<>();
    requiredParts.put(ComponentType.BLAST_FURNACE_FRAME, new Range(9, 18));
    requiredParts.put(ComponentType.COIL, new Const(16));
    requiredParts.put(ControllerType.BLAST_FURNACE, new Const(1));
    requiredParts.put(IOType.ITEM_IN, new Const(1));
    requiredParts.put(IOType.ITEM_OUT, new Const(1));
    requiredParts.put(IOType.ENERGY_IN, new Const(1));
    requiredParts.put(IOType.FLUID_IN, new Range(0, 1));
    requiredParts.put(IOType.FLUID_OUT, new Range(0, 1));
    return requiredParts;
  }

  @Override
  public char getControllerLegend() {
    return 'C';
  }

  @Override
  public Amount getRequiredNumberOfParts() {
    // TODO use layout and remove spaces

    return new Const(34);
  }


  @Override
  public BlockPos getShape() {
    return new BlockPos(3, 4, 3);
  }

  @Override
  public BlockPos getControllerLocalOffset() {
    return new BlockPos(1, 0, 2);
  }

  @Override
  public String getLayout() {
    return
        "XXX" +
            "XXX" +
            "XCX" +

            "NNN" +
            "N N" +
            "NNN" +

            "NNN" +
            "N N" +
            "NNN" +

            "AAA" +
            "AAA" +
            "AAA";
  }

  @Override
  public Char2ObjectMap<Predicate<Type>> getLegend() {
    return new Char2ObjectOpenHashMap<>(ImmutableMap.of(
        'A', ComponentType.BLAST_FURNACE_FRAME,
        'N', ComponentType.COIL,
        'X', ComponentType.BLAST_FURNACE_FRAME.or(IOType.ANY),
        'C', ControllerType.BLAST_FURNACE
    ));
  }
}
