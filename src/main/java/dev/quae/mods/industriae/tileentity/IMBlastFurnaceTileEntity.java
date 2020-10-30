package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.construct.Construct;
import dev.quae.mods.industriae.setup.registers.ConstructController;

public class IMBlastFurnaceTileEntity extends ConstructControllerTileEntity {

  public IMBlastFurnaceTileEntity() {
    super(ConstructController.BLAST_FURNACE.getTileType(), Construct.BLAST_FURNACE.getConstruct());
  }
}
