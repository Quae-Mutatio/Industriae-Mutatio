package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class UnPackagerTileEntity extends IMTieredProcessingMachineTileEntity implements ITickableTileEntity {


  public UnPackagerTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveUnPackager(speedTier), speedTier);
  }

  @Override
  protected int getInventorySize() {
    return 4;
  }

  @Override
  protected int getOutputStartIndex() {
    return 1;
  }

  private void processInput() {
    List<ItemStack> results = this.calculateOutput(IMRecipeTypes.UNPACKAGER);
    if (results == null) {
      return;
    }
    consumeEnergy();
    if (hasFinishedProcess()) {
      for (int i = 1; i < results.size(); i++) {
        this.setResultStack(results.get(i), 0, i + this.getOutputStartIndex());
      }
    }
  }

  @Override
  public void tick() {
    processInput();
  }
}
