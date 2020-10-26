package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.IMTieredRegistryResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import dev.quae.mods.industriae.setup.IMTiles;

public class AutoclaveTileEntity extends IMTieredProcessingMachineTileEntity {


  public AutoclaveTileEntity(SpeedTier speedTier) {
    super(IMTieredRegistryResolver.resolveTile(speedTier, IMTiles.AUTOCLAVE), speedTier, IMRecipeTypes.AUTOCLAVE);
  }

  @Override
  protected int getInventorySize() {
    return 2;
  }

  @Override
  protected int getOutputStartIndex() {
    return 1;
  }

  @Override
  protected int getFluidInventorySize() {
    return 1;
  }

  @Override
  protected int getFluidOutputStartIndex() {
    return 1;
  }

}
