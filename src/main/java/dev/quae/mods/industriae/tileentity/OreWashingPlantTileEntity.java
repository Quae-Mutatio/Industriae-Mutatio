package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class OreWashingPlantTileEntity extends IMTieredProcessingMachineTileEntity {


  public OreWashingPlantTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveOreWasher(speedTier), speedTier, IMRecipeTypes.ORE_WASHING_PLANT);
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
