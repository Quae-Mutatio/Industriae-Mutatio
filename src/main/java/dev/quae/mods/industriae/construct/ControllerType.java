package dev.quae.mods.industriae.construct;

public enum ControllerType implements IConstruct.Type {
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
