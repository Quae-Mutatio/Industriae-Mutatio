package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.construct.IConstruct.Type;

public enum IOType implements IConstruct.Type {
  ITEM_IN,
  ITEM_OUT,
  FLUID_IN,
  FLUID_OUT,
  ENERGY_IN,
  ENERGY_OUT,
  ANY;

  @Override
  public boolean test(Type type) {
    if (this == ANY){
      return type instanceof IOType;
    }
    return Type.super.test(type);
  }
}
