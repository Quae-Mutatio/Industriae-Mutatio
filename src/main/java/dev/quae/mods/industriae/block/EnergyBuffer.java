package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.api.capabilities.energy.Voltage;
import dev.quae.mods.industriae.tileentity.EnergyBufferTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class EnergyBuffer extends Block {

  public EnergyBuffer() {
    super(Properties.create(Material.IRON));
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new EnergyBufferTileEntity(Voltage.ULTRA_LOW);//todo change this to actual things
  }
}
