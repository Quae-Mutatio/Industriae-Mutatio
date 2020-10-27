package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class IMTieredMachineBlock extends IMMachineBlock {
  protected final SpeedTier speedTier;
  private final MachineType machineType;

  public IMTieredMachineBlock(SpeedTier speedTier, MachineType machineType) {
    this.speedTier = speedTier;
    this.machineType = machineType;
  }


  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return machineType.getTypeEntityType(speedTier).create();
  }
}
