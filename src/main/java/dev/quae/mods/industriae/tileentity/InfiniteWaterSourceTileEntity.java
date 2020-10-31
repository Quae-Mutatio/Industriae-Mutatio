package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.capability.InfiniteFluidInventory;
import dev.quae.mods.industriae.setup.IMTiles;
import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.fluid.Fluids;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InfiniteWaterSourceTileEntity extends TileEntity implements ITickableTileEntity {


  protected InfiniteFluidInventory fluidInventory = new InfiniteFluidInventory();
  protected final LazyOptional<IFluidHandler> fluidInventoryLO = LazyOptional.of(() -> fluidInventory);
  public InfiniteWaterSourceTileEntity() {
    super(IMTiles.INFINITE_WATER_SOURCE.get());
  }

  @Override
  public void tick() {

    ArrayList<BlockPos> positions = new ArrayList<>();
    positions.add(this.pos.add(1, 0, 0));
    positions.add(this.pos.add(-1, 0, 0));
    positions.add(this.pos.add(0, 1, 0));
    positions.add(this.pos.add(0, -1, 0));
    positions.add(this.pos.add(0, 0, 1));
    positions.add(this.pos.add(0, 0, -1));
    for (BlockPos position : positions) {
      TileEntity te = world.getTileEntity(position);
      if (te == null){
        continue;
      }

      LazyOptional<IFluidHandler> handlerLO = te.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);
      if (!handlerLO.isPresent()) {
        continue;
      }

      handlerLO.resolve().get().fill(new FluidStack(Fluids.WATER, 1000), FluidAction.EXECUTE);
    }
  }

  @NotNull
  @Override
  public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
    if (Objects.equals(cap, CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)){
      return this.fluidInventoryLO.cast();
    }
    return super.getCapability(cap, side);
  }
}
