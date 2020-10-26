package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class OreWashingPlantTileEntity extends IMTieredProcessingMachineTileEntity implements ITickableTileEntity {


  public OreWashingPlantTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveOreWasher(speedTier), speedTier);
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

  private void processInput() {
    List<ItemStack> results = this.calculateOutput(IMRecipeTypes.ORE_WASHING_PLANT);
    if (results == null) {
      return;
    }
    consumeEnergy();
    if (hasFinishedProcess()) {
      for (int i = 0; i < results.size(); i++) {
        this.setResultStack(results.get(i), 0, i + this.getOutputStartIndex());
      }
    }
  }

  @Override
  public void tick() {
    processInput();
  }
}
