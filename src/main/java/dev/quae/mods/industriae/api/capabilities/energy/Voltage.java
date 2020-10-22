package dev.quae.mods.industriae.api.capabilities.energy;

import dev.quae.mods.industriae.IndustriaeMutatio;
import net.minecraft.util.text.TranslationTextComponent;

public enum Voltage implements IVoltage {
  ULTRA_LOW(5, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.ultra_low")),
  LOW(12, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.low")),
  MEDIUM(24, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.medium")),
  HIGH(110, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.high")),
  EXTREME(230, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.extreme")),
  INSANE(400, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.insane")),
  LUDICROUS(690, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.ludicrous")),
  ZPM(25000, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.zpm")),
  ULTIMATE(220000, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.ultimate")),
  MAXIMUM(400000, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.maximum")),
  ;

  int intRepresentation;
  TranslationTextComponent name;

  Voltage(int intRepresentation, TranslationTextComponent name){
    this.intRepresentation = intRepresentation;
    this.name = name;
  }

  @Override
  public int getIntRepresentation() {
    return intRepresentation;
  }

  @Override
  public TranslationTextComponent getName() {
    return name;
  }
}