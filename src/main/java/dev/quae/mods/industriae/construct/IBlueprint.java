package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.construct.IConstruct.Type;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import java.util.function.Predicate;
import net.minecraft.util.math.vector.Vector3i;

public interface IBlueprint {

  Vector3i getShape();

  String getLayout();

  Char2ObjectMap<Predicate<Type>> getLegend();
}
