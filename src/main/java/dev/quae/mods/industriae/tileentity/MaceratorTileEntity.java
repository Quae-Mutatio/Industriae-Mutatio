package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.recipe.MaceratorRecipe;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import java.util.Objects;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MaceratorTileEntity extends IMTieredProcessingMachineTileEntity<MaceratorRecipe> implements ITickableTileEntity {


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
