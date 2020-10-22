package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.tileentity.SpeedTier;

public class IMTieredMachineBlock extends IMMachineBlock {
  protected SpeedTier speedTier;

  public IMTieredMachineBlock(SpeedTier speedTier) {
    this.speedTier = speedTier;
  }

}
