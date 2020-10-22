package dev.quae.mods.industriae.api.capabilities.energy;

public interface IVoltaicEnergyStorage {
  /**
   * Adds energy to the storage. Returns quantity of energy that was accepted.
   *
   * @param voltage The energy voltage that is supposed to be inserted.
   * @param maxReceive Maximum amount of energy of a certain voltage to be inserted.
   * @param simulate If TRUE, the insertion will only be simulated.
   * @return Amount of energy of give voltage that was (or would have been, if simulated) accepted by the storage.
   */
  int receiveEnergy(Voltage voltage, int maxReceive, boolean simulate);

  /**
   * Removes energy from the storage. Returns quantity of energy that was removed.
   *
   * @param voltage The energy voltage that is supposed to be extracted.
   * @param maxExtract Maximum amount of energy of a certain voltage to be extracted.
   * @param simulate If TRUE, the extraction will only be simulated.
   * @return Amount of energy that was (or would have been, if simulated) extracted from the storage.
   */
  int extractEnergy(Voltage voltage, int maxExtract, boolean simulate);

  /**
   * Returns the voltage of the energy currently stored.
   */
  Voltage getVoltage();

  /**
   * Returns the amount of energy currently stored.
   */
  int getEnergyStored();

  /**
   * Returns the maximum amount of energy that can be stored.
   */
  int getMaxEnergyStored();

  /**
   * Returns if this storage can have energy extracted.
   * If this is false, then any calls to extractEnergy will return 0.
   */
  boolean canExtract(Voltage voltage);

  /**
   * Used to determine if this storage can receive energy.
   * If this is false, then any calls to receiveEnergy will return 0.
   */
  boolean canReceive(Voltage voltage);
}
