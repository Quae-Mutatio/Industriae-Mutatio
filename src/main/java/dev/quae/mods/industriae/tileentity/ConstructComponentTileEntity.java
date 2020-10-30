package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.construct.IConstruct;
import dev.quae.mods.industriae.construct.IConstruct.Type;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ConstructComponentTileEntity extends TileEntity implements IConstruct.Component {


  private final Type type;

  public ConstructComponentTileEntity(TileEntityType<?> tileEntityTypeIn, Type type) {
    super(tileEntityTypeIn);
    this.type = type;
  }

  @Override
  public Type getType() {
    return type;
  }
}
