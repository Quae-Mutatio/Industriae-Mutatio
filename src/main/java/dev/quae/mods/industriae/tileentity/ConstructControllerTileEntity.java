package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.construct.IConstruct;
import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.construct.type.ControllerType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ConstructControllerTileEntity extends TileEntity implements ITickableTileEntity, IConstruct.Controller {

  private final IConstruct construct;

  public ConstructControllerTileEntity(TileEntityType<?> tileEntityTypeIn, IConstruct construct) {
    super(tileEntityTypeIn);
    this.construct = construct;
  }

  @Override
  public void tick() {
    construct.validateConstruct(pos, this.world);
  }

  @Override
  public Type getType() {
    return ControllerType.BLAST_FURNACE;
  }
}
