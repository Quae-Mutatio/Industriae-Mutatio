package dev.quae.mods.industriae.api.capabilities.energy;

public class VoltaicEnergyStorage implements IVoltaicEnergyStorage {
  private Voltage voltage;
  private int energy;
  private int capacity;
  private int maxReceive;
  private int maxExtract;

  public VoltaicEnergyStorage(Voltage voltage, int capacity) {
    this(voltage, capacity, capacity, capacity, 0);
  }

  public VoltaicEnergyStorage(Voltage voltage, int capacity, int maxTransfer) {
    this(voltage, capacity, maxTransfer, maxTransfer, 0);
  }

  public VoltaicEnergyStorage(Voltage voltage, int capacity, int maxReceive, int maxExtract) {
    this(voltage, capacity, maxReceive, maxExtract, 0);
  }

  public VoltaicEnergyStorage(Voltage voltage, int capacity, int maxReceive, int maxExtract, int energy) {
    this.voltage = voltage;
    this.capacity = capacity;
    this.maxReceive = maxReceive;
    this.maxExtract = maxExtract;
    this.energy = Math.max(0 , Math.min(capacity, energy));
  }

  @Override
  public int receiveEnergy(Voltage voltage, int maxReceive, boolean simulate) {
    if (!canReceive(voltage)) return 0;

    int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
    if (!simulate)energy += energyReceived;
    return energyReceived;
  }

  @Override
  public int extractEnergy(Voltage voltage, int maxExtract, boolean simulate) {
    if (!canExtract(voltage)) return 0;

    int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
    if (!simulate) energy -= energyExtracted;
    return energyExtracted;
  }

  @Override
  public Voltage getVoltage() {
    return voltage;
  }

  @Override
  public int getEnergyStored() {
    return energy;
  }

  @Override
  public int getMaxEnergyStored() {
    return capacity;
  }

  @Override
  public boolean canExtract(Voltage voltage) {
    return this.voltage == voltage && maxExtract > 0;
  }

  @Override
  public boolean canReceive(Voltage voltage) {
    return this.voltage == voltage && maxReceive > 0;
  }

  //WARNING: SETS ENERGY WITHOUT CHECKS, ONLY USE FOR R/W FROM NBT
  public void setVoltage(Voltage voltage) {
    this.voltage = voltage;
  }

  //WARNING: SETS ENERGY WITHOUT CHECKS, ONLY USE FOR R/W FROM NBT
  public void setEnergyStored(int energy) {
    this.energy = Math.max(0, Math.min(capacity, energy));
  }
}
