package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.setup.IMTiles;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class InfiniteWaterSourceBlock extends Block {

  public InfiniteWaterSourceBlock() {
    super(AbstractBlock.Properties.create(Material.IRON));
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return IMTiles.INFINITE_WATER_SOURCE.get().create();
  }
}
