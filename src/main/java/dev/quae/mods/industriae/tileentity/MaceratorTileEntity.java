package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class MaceratorTileEntity extends IMTieredProcessingMachineTileEntity implements ITickableTileEntity {


  public MaceratorTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveMacerator(speedTier), speedTier);
  }

  @Override
  protected int getInventorySize() {
    return 4;
  }

  private void processInput() {
    List<ItemStack> results = this.calculateOutput(IMRecipeTypes.MACERATOR);
    if (results == null) {
      return;
    }
    consumeEnergy();
    if (hasFinishedProcess()) {
      for (int i = 1; i < results.size(); i++) {
        this.setResultStack(results.get(i - 1), 0, i);
      }
    }
  }

  @Override
  public void tick() {
    processInput();
  }
}
