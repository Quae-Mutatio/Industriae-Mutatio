package dev.quae.mods.industriae.api.capabilities.energy;

import net.minecraft.util.text.TranslationTextComponent;

public interface IVoltage {
  int getVoltage();
  int getCapacity();
  TranslationTextComponent getName();
}