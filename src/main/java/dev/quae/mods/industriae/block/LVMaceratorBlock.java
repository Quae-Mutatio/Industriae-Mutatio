package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.setup.IMTiles;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class LVMaceratorBlock extends IMMachineBlock {

  public LVMaceratorBlock() {
    super();
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
