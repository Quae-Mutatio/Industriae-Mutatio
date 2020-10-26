package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class ForgeHammerTileEntity extends IMTieredProcessingMachineTileEntity implements ITickableTileEntity {

  public ForgeHammerTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveForgeHammer(speedTier), speedTier);
  }

  private void processInput() {
    List<ItemStack> results = this.calculateOutput(IMRecipeTypes.FORGE_HAMMER);
    if (results == null) {
      return;
    }
    consumeEnergy();
    if (hasFinishedProcess()) {
      this.setResultStack(results.get(0), 0, 1);
    }
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
    return 0;
  }

  @Override
  protected int getFluidOutputStartIndex() {
    return 0;
  }

  @Override
  public void tick() {
    processInput();
  }
}
