package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class WireMillTileEntity extends IMTieredProcessingMachineTileEntity {

  public WireMillTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveWireMill(speedTier), speedTier, IMRecipeTypes.WIREMILL);
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
}
