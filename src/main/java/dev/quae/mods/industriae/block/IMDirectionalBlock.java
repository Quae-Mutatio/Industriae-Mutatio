package dev.quae.mods.industriae.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;

public class IMDirectionalBlock extends DirectionalBlock {

  protected IMDirectionalBlock(Properties builder) {
    super(builder);
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    super.fillStateContainer(builder.add(FACING));
  }

  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }
}
