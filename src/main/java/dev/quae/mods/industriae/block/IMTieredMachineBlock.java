package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
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

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (worldIn.isRemote) {
      return ActionResultType.SUCCESS;
    }
    TileEntity tile = worldIn.getTileEntity(pos);
    if (tile instanceof IMTieredProcessingMachineTileEntity) {
      NetworkHooks.openGui((ServerPlayerEntity) player, (IMTieredProcessingMachineTileEntity) tile, pos);
      return ActionResultType.SUCCESS;
    }
    return ActionResultType.FAIL;
  }
}
