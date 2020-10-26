package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class PackagerTileEntity extends IMTieredProcessingMachineTileEntity implements ITickableTileEntity {


  public PackagerTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolvePackager(speedTier), speedTier);
  }

  @Override
  protected int getInventorySize() {
    return 4;
  }

  @Override
  protected int getOutputStartIndex() {
    return 3;
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
    List<ItemStack> results = this.calculateOutput(IMRecipeTypes.PACKAGER);
    if (results == null) {
      return;
    }
    consumeEnergy();
    if (hasFinishedProcess()) {
        this.setResultStack(results.get(0), 0, 3);
    }
  }

  @Override
  public void tick() {
    processInput();
  }
}
