package dev.quae.mods.industriae.tileentity;

public enum SpeedTier implements IMSpeedTier {
  ULV(0.5),
  LV(1),
  MV(10),
  HV(8),
  EV(12),
  IV(18),
  LUV(28),
  ZPM(40),
  UV(54),
  MAX(80);


  private final double speed;

  SpeedTier(double speed) {
    this.speed = speed;
  }

  @Override
  public double getSpeed() {
    return speed;
  }
}
