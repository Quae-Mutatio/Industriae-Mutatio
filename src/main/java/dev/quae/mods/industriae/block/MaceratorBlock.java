package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class MaceratorBlock extends IMMachineBlock {

  private SpeedTier speedTier;

  public MaceratorBlock(SpeedTier speedTier) {
    super();
    this.speedTier = speedTier;
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return IMTiles.LV_MACERATOR.get().create();
  }
}
