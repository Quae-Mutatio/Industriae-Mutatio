package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.construct.IConstruct;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ConstructComponentTileEntity extends TileEntity {

  private final IConstruct construct;

  public ConstructComponentTileEntity(TileEntityType<?> tileEntityTypeIn, IConstruct construct) {
    super(tileEntityTypeIn);
    this.construct = construct;
  }
}
