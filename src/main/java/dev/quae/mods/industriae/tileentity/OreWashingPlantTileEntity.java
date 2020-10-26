package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.IMTieredRegistryResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import dev.quae.mods.industriae.setup.IMTiles;

public class OreWashingPlantTileEntity extends IMTieredProcessingMachineTileEntity {


  public OreWashingPlantTileEntity(SpeedTier speedTier) {
    super(IMTieredRegistryResolver.resolveTile(speedTier, IMTiles.ORE_WASHING_PLANT), speedTier, IMRecipeTypes.ORE_WASHING_PLANT);
  }

  @Override
  protected int getInventorySize() {
    return 4;
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
