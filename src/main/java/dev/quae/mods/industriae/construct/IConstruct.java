package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.construct.task.Amount;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public interface IConstruct extends IBlueprint {

  Map<Type, Amount> getRequiredParts();
  char getControllerLegend();
  Amount getRequiredNumberOfParts();

  boolean validateConstruct(BlockPos controllerWorldPosition, IWorldReader world);

  interface Type extends Predicate<Type> {

    @Override
    default boolean test(Type type){
      return this == type;
    }
  }

  interface Part {

    Type getType();
  }

  interface Controller extends Part {

  }

  interface Component extends Part {

  }

}
