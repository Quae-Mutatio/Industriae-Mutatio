package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.IMTieredRegistryResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import dev.quae.mods.industriae.setup.IMTiles;

public class MixerTileEntity extends IMTieredProcessingMachineTileEntity {


  public MixerTileEntity(SpeedTier speedTier) {
    super(IMTieredRegistryResolver.resolveTile(speedTier, IMTiles.MIXER), speedTier, IMRecipeTypes.MIXER);
  }

  @Override
  protected int getInventorySize() {
    return 4;
  }

  @Override
  protected int getOutputStartIndex() {
    return 2;
  }

  @Override
  protected int getFluidInventorySize() {
    return 6;
  }

  @Override
  protected int getFluidOutputStartIndex() {
    return 3;
  }

}
