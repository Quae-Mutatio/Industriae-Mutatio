package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.setup.IMTiles;
import net.minecraft.tileentity.TileEntityType;

public class LVMaceratorTileEntity extends IMMaceratorTileEntity {

  public LVMaceratorTileEntity() {
    super(IMTiles.LV_MACERATOR.get());
  }

  protected double getSpeedMultiplier() {
    return MachineSpeedMultiplierTier.LOW_VOLTAGE.getSpeed();
  }
}
