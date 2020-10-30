package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.api.capabilities.energy.IVoltaicEnergyStorage;
import dev.quae.mods.industriae.api.capabilities.energy.Voltage;
import dev.quae.mods.industriae.api.capabilities.energy.VoltaicEnergyStorage;
import dev.quae.mods.industriae.setup.IMTiles;
import net.minecraft.tileentity.TileEntity;

public class EnergyBufferTileEntity extends TileEntity implements IVoltaicEnergyStorage {
  private VoltaicEnergyStorage energy;

  public EnergyBufferTileEntity(Voltage voltage) {
    super(IMTiles.ENERGY_BUFFER.get());
    this.energy = new VoltaicEnergyStorage(voltage);
  }

  @Override
  public int receiveEnergy(Voltage voltage, int maxReceive, boolean simulate) {
    return energy.receiveEnergy(voltage, maxReceive, simulate);
  }

  @Override
  public int extractEnergy(Voltage voltage, int maxExtract, boolean simulate) {
    return energy.extractEnergy(voltage, maxExtract, simulate);
  }

  @Override
  public Voltage getVoltage() {
    return energy.getVoltage();
  }

  @Override
  public int getEnergyStored() {
    return energy.getEnergyStored();
  }

  @Override
  public int getMaxEnergyStored() {
    return energy.getMaxEnergyStored();
  }

  @Override
  public boolean canExtract(Voltage voltage) {
    return energy.canExtract(voltage);
  }

  @Override
  public boolean canReceive(Voltage voltage) {
    return energy.canReceive(voltage);
  }
}