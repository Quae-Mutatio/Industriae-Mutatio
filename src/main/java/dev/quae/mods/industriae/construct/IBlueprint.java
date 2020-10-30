package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.construct.IConstruct.Type;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import java.util.function.Predicate;
import net.minecraft.util.math.BlockPos;

public interface IBlueprint {

  BlockPos getShape();

  BlockPos getControllerLocalOffset();

  String getLayout();

  Char2ObjectMap<Predicate<Type>> getLegend();
}
