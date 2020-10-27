package dev.quae.mods.industriae.material;

public interface IMaterialType {

  default String getName() {
    return getMaterialName() + "_" + getTypeName();
  }

  String getMaterialName();

  String getTypeName();
}
