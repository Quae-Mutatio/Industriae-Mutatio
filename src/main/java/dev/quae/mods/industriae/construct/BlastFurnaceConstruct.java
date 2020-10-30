package dev.quae.mods.industriae.construct;

import com.google.common.collect.ImmutableMap;
import dev.quae.mods.industriae.construct.task.Amount;
import dev.quae.mods.industriae.construct.task.Amount.Const;
import dev.quae.mods.industriae.construct.task.Amount.Range;
import dev.quae.mods.industriae.construct.task.ITask;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.math.vector.Vector3i;

public class BlastFurnaceConstruct extends ConstructBase {


  @Override
  public Map<Type, Amount> getRequiredParts() {
    final HashMap<Type, Amount> requiredParts = new HashMap<>();
    requiredParts.put(ConstructionBlockType.BLAST_FURNACE, new Range(9, 18));
    requiredParts.put(ConstructionBlockType.BLAST_FURNACE_COIL, new Const(16));
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
  public Vector3i getShape() {
    return new Vector3i(3, 4, 3);
  }

  @Override
  public String getLayout() {
    return
        "AAA" +
        "AAA" +
        "AAA" +

        "NNN" +
        "N N" +
        "NNN" +

        "NNN" +
        "N N" +
        "NNN" +

        "XXX" +
        "XXX" +
        "XCX";
  }

  @Override
  public Char2ObjectMap<Predicate<Type>> getLegend() {
    return new Char2ObjectOpenHashMap<>(ImmutableMap.of(
        'A', ConstructionBlockType.BLAST_FURNACE,
        'N', ConstructionBlockType.BLAST_FURNACE_COIL,
        'X', ConstructionBlockType.BLAST_FURNACE.or(IOType.ANY),
        'C', ControllerType.BLAST_FURNACE
    ));
  }
}
