package dev.quae.mods.industriae.tileentity;

public enum SpeedTier implements IMSpeedTier {
  ULV(0.5),
  LV(1),
  MV(1.5),
  HV(2),
  EV(3.5),
  IV(4.5),
  LUV(6),
  ZPM(9),
  UV(15),
  MAX(20);


  private final double speed;

  SpeedTier(double speed) {
    this.speed = speed;
  }

  @Override
  public double getSpeed() {
    return speed;
  }
}
