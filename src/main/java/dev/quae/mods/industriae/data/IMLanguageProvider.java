package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.data.enumeration.MachineTranslation;
import dev.quae.mods.industriae.setup.IMItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class IMLanguageProvider extends LanguageProvider {

  public IMLanguageProvider(DataGenerator gen, String locale) {
    super(gen, IndustriaeMutatio.ID, locale);
  }

  @Override
  protected void addTranslations() {
    this.add(IMItems.INFINITE_WATER_SOURCE.get(), "Infinite Water Source Block");
    this.add(IMItems.ENERGY_BUFFER.get(), "Energy Buffer");
    for (MachineTranslation value : MachineTranslation.values()) {
      value.registerTranslations(this);
    }
    this.add("item.tooltip.fluidstoragetank", "Stored Fluid: ");
    this.add("item.tooltip.holdshiftformore", "Hold shift for more info");
  }
}
