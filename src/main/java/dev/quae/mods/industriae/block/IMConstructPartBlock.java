package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.machine.ConstructMachine;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class IMConstructPartBlock extends IMMachineBlock {

  private final ConstructMachine machine;
  private final Type constructPartType;

  public IMConstructPartBlock(ConstructMachine machine, Type constructPartType) {
    this.machine = machine;

    this.constructPartType = constructPartType;
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return machine.getTileEntity(constructPartType).get().create();
  }
}
