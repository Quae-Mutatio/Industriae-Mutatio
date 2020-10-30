package dev.quae.mods.industriae.machine;

import dev.quae.mods.industriae.construct.ConstructionBlockType;
import dev.quae.mods.industriae.construct.IConstruct;
import java.util.List;

public interface IConstructMachine {

  IConstruct getConstruct();

  String getName();

  List<ConstructionBlockType> getConstructTypes();
}
