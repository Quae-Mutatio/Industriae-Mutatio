package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class ThermalCentrifugeTileEntity extends IMTieredProcessingMachineTileEntity implements ITickableTileEntity {


  public ThermalCentrifugeTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveThermalCentrifuge(speedTier), speedTier);
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

  private void processInput() {
    List<ItemStack> results = this.calculateOutput(IMRecipeTypes.THERMAL_CENTRIFUGE);
    if (results == null) {
      return;
    }
    consumeEnergy();
    if (hasFinishedProcess()) {
      for (int i = 0; i < results.size(); i++) {
        this.setResultStack(results.get(i), 0, i + 1);
      }
    }
  }

  @Override
  public void tick() {
    processInput();
  }
}
