package dev.quae.mods.industriae.data.enumeration;

import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;

public enum SpeedTierTranslation {
  ULV("ULV", SpeedTier.ULV),
  LV("LV", SpeedTier.LV),
  MV( "MV", SpeedTier.MV),
  HV("HV", SpeedTier.HV),
  EV( "EV", SpeedTier.EV),
  IV("IV", SpeedTier.IV),
  LUV( "LuV", SpeedTier.LUV),
  ZPM( "ZPM", SpeedTier.ZPM),
  UV("UV", SpeedTier.UV),
  MAX( "MAX", SpeedTier.MAX);

  private final String englishTranslation;
  private final SpeedTier type;

  SpeedTierTranslation(String englishTranslation, SpeedTier type) {
    this.englishTranslation = englishTranslation;
    this.type = type;
  }

  public String getEnglishTranslation() {
    return englishTranslation;
  }

  public SpeedTier getType() {
    return type;
  }
}
