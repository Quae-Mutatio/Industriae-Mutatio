package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.IMTieredRegistryResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import dev.quae.mods.industriae.setup.IMTiles;

public class SifterTileEntity extends IMTieredProcessingMachineTileEntity {

  public SifterTileEntity(SpeedTier speedTier) {
    super(IMTieredRegistryResolver.resolveTile(speedTier, IMTiles.SIFTER), speedTier, IMRecipeTypes.SIFTER);
  }


  @Override
  protected int getInventorySize() {
    return 7;
  }

  @Override
  protected int getOutputStartIndex() {
    return 1;
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
