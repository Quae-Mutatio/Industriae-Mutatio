package dev.quae.mods.industriae.construct.type;

import dev.quae.mods.industriae.construct.IConstruct.Type;

public enum ControllerType implements Type {
  BLAST_FURNACE("electric_blast_furnace"),
  ;
  private final String name;

  ControllerType(String name) {

    this.name = name;
  }

  public String getName() {
    return name;
  }
}
