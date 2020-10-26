package dev.quae.mods.industriae.tileentity;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public enum SpeedTier implements IMSpeedTier {
  ULV(0.5, "ulv"),
  LV(1, "lv"),
  MV(10, "mv"),
  HV(8, "hv"),
  EV(12, "ev"),
  IV(18, "iv"),
  LUV(28, "luv"),
  ZPM(40, "zpm"),
  UV(54, "uv"),
  MAX(80, "max");


  private final double speed;
  private final String name;
  ;

  SpeedTier(double speed, String name) {
    this.speed = speed;
    this.name = name;
  }

  @Override
  public double getSpeed() {
    return speed;
  }

  @Override
  public String getName() {
    return name;
  }

  public static ImmutableList<SpeedTier> getAll() {
    return ImmutableList.of(ULV, LV, MV, HV, EV, IV, LUV, ZPM, UV, MAX);
  }
}
