package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.machine.IConstructMachine;

public enum Construct implements IConstructMachine {
  BLAST_FURNACE("blast_furnace", new BlastFurnaceConstruct()),
  ;

  private final String name;
  private final IConstruct construct;

  Construct(String name, IConstruct construct) {

    this.name = name;
    this.construct = construct;
  }

  @Override
  public IConstruct getConstruct() {
    return construct;
  }

  @Override
  public String getName() {
    return name;
  }
}
