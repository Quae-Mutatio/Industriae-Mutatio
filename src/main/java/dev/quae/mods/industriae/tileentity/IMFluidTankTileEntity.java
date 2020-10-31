package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.capability.IMStorageFluidHandler;
import dev.quae.mods.industriae.storage.FluidTankType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IMFluidTankTileEntity extends TileEntity {

  private IMStorageFluidHandler fluidInventory;
  private LazyOptional<IFluidHandler> fluidInventoryLO = LazyOptional.of(() -> fluidInventory);
  private FluidTankType type;
  public IMFluidTankTileEntity(TileEntityType<?> tileEntityTypeIn, FluidTankType type) {
    super(tileEntityTypeIn);
    this.type = type;
    fluidInventory = new IMStorageFluidHandler(type.getCapacity());
  }

  @NotNull
  @Override
  public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
      return fluidInventoryLO.cast();
    }
    return super.getCapability(cap, side);
  }
}
