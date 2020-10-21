package dev.quae.mods.industriae.tileentity;

public enum SpeedTier implements IMSpeedTier {
  ULV(0.5),
  LV(1),
  MV(2),
  HV(4),
  EV(8),
  IV(16),
  LUV(32),
  ZPM(64),
  UV(128),
  MAX(256);


  private final double speed;

  SpeedTier(double speed) {
    this.speed = speed;
  }

  @Override
  public double getSpeed() {
    return speed;
  }
}
