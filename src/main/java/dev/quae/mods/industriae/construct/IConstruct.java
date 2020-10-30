package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.construct.task.Amount;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

public interface IConstruct extends IBlueprint {

  Map<Type, Amount> getRequiredParts();
  char getControllerLegend();
  Amount getRequiredNumberOfParts();

  boolean validateConstruct(BlockPos controllerWorldPosition, World world);

  interface Type extends Predicate<Type> {

    @Override
    default boolean test(Type type){
      return this == type;
    }
  }

  interface Part {
    Type getConstructType();
  }

  interface Controller extends Part {

  }

  interface Component extends Part {

  }

}
