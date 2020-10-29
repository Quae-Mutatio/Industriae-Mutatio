package dev.quae.mods.industriae.material;

public interface IMaterialType {

  String getName();

  default String getOreName() {
    return getName() + "_ore";
  }

  default boolean hasOre() {
    return true;
  }
}
