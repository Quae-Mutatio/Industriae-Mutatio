package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;

public class PrecisionEngravingMachineTileEntity extends IMTieredProcessingMachineTileEntity {

  public PrecisionEngravingMachineTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolvePrecisionEngraver(speedTier), speedTier, IMRecipeTypes.PRECISION_ENGRAVING);
  }


  @Override
  protected int getInventorySize() {
    return 3;
  }

  @Override
  protected int getOutputStartIndex() {
    return 2;
  }

  @Override
  protected int getFluidInventorySize() {
    return 0;
  }

  @Override
  protected int getFluidOutputStartIndex() {
    return 0;
  }
}
