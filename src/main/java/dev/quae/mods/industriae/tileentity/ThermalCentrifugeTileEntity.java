package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class ThermalCentrifugeTileEntity extends IMTieredProcessingMachineTileEntity {


  public ThermalCentrifugeTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveThermalCentrifuge(speedTier), speedTier, IMRecipeTypes.THERMAL_CENTRIFUGE);
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
    return 0;
  }

  @Override
  protected int getFluidOutputStartIndex() {
    return 0;
  }
}
