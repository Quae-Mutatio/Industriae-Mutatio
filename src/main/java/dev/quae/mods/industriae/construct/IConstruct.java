package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.construct.task.Amount;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.jetbrains.annotations.NotNull;

public interface IConstruct extends IBlueprint {

  Map<Type, Amount> getRequiredParts();

  char getControllerLegend();

  Amount getRequiredNumberOfParts();

  boolean validateConstruct(BlockPos controllerWorldPosition, IWorldReader world);

  interface Type extends Predicate<Block> {

    ITag<Block> getTag();

    @Override
    default boolean test(Block block) {
      return this.getTag().contains(block);
    }

    @Nonnull
    default Type and(@NotNull Type other) {
      Objects.requireNonNull(other);
      return new MergedType(this, other, false);
    }

    @Nonnull
    default Type or(@NotNull Type other) {
      Objects.requireNonNull(other);
      return new MergedType(this, other, true);
    }

    @Override
    @NotNull
    default Type negate() {
      return new NegatedType(this);
    }

    class MergedType implements Type {

      private final Type a;
      private final Type b;
      private final boolean merge;

      public MergedType(Type a, Type b, boolean merge) {
        this.a = a;
        this.b = b;
        this.merge = merge;
      }

      @Override
      public ITag<Block> getTag() {
        return null;
      }

      @Override
      public boolean test(Block block) {
        return (merge ? a.or(b) : a.and(b)).test(block);
      }
    }

    class NegatedType implements Type {

      private final Type negative;

      public NegatedType(Type negative) {
        this.negative = negative;
      }

      @Override
      public ITag<Block> getTag() {
        return null;
      }

      @Override
      public boolean test(Block block) {
        return negative.negate().test(block);
      }
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
