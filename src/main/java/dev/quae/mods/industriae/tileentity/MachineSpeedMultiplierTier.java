package dev.quae.mods.industriae.tileentity;

public enum MachineSpeedMultiplierTier implements IMMachineSpeedMultiplierTier {
  ULTRA_LOW_VOLTAGE(0.5),
  LOW_VOLTAGE(1),
  MEDIUM_VOLTAGE(2),
  HIGH_VOLTAGE(4),
  EXTREME_VOLTAGE(8),
  INSANE_VOLTAGE(16),
  LUDICROUS_VOLTAGE(32),
  ZPM_VOLTAGE(64),
  ULTIMATE_VOLTAGE(128),
  MAXIMUM_VOLTAGE(256);


  private final double speed;

  MachineSpeedMultiplierTier(double speed) {
    this.speed = speed;
  }

  @Override
  public double getSpeed() {
    return speed;
  }
}
