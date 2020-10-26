package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class AlloySmelterTileEntity extends IMTieredProcessingMachineTileEntity {

  public AlloySmelterTileEntity(SpeedTier speedTier) {
    super(TileEntityTypeResolver.resolveAlloySmelter(speedTier), speedTier, IMRecipeTypes.ALLOY_FURNACE);
  }

  @Override
  protected int getInventorySize() {
    return 4;
  }

  @Override
  protected int getOutputStartIndex() {
    return 2;
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
