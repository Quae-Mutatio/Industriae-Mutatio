package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.construct.IConstruct.Part;
import dev.quae.mods.industriae.construct.IConstruct.Type;

public class IMConstructPartBlock extends IMMachineBlock {

  private final Type type;
  private final Part part;

  public IMConstructPartBlock(Part part) {

    this.type = part.getType();
    this.part = part;
  }

  public Type getType() {
    return type;
  }

  public Part getPart() {
    return part;
  }
}
