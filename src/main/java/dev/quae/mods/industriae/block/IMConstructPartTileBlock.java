package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.construct.IConstruct.Part;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public abstract class IMConstructPartTileBlock extends IMConstructPartBlock {

  public IMConstructPartTileBlock(Part part) {
    super(part);
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public abstract TileEntity createTileEntity(BlockState state, IBlockReader world);
}
