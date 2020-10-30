package dev.quae.mods.industriae.api.capabilities.energy;

import dev.quae.mods.industriae.IndustriaeMutatio;
import net.minecraft.util.text.TranslationTextComponent;

public enum Voltage implements IVoltage {
  ULTRA_LOW(8, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.ultra_low")),
  LOW(32, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.low")),
  MEDIUM(128, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.medium")),
  HIGH(512, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.high")),
  EXTREME(2048, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.extreme")),
  INSANE(8192, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.insane")),
  LUDICROUS(32768, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.ludicrous")),
  ZPM(131072, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.zpm")),
  ULTIMATE(524288, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.ultimate")),
  MAXIMUM(Integer.MAX_VALUE, new TranslationTextComponent(IndustriaeMutatio.ID + ".energy.voltages.maximum")),
  ;

  int voltage;
  int capacity;
  TranslationTextComponent name;

  Voltage(int voltage, TranslationTextComponent name){
    this.voltage = voltage;
    this.capacity = Math.min(voltage << 8, Integer.MAX_VALUE);
    this.name = name;
  }

  @Override
  public int getVoltage() {
    return voltage;
  }

  @Override
  public int getCapacity() {
    return capacity;
  }

  @Override
  public TranslationTextComponent getName() {
    return name;
  }
}