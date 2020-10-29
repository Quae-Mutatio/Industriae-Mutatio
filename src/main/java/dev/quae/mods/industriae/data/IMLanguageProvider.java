package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.data.enumeration.MachineTranslation;
import dev.quae.mods.industriae.data.enumeration.MaterialTranslation;
import dev.quae.mods.industriae.data.enumeration.ProcessedMaterialVariationTranslation;
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
    for (MachineTranslation value : MachineTranslation.values()) {
      value.registerTranslations(this);
    }
    for (MaterialTranslation value : MaterialTranslation.values()) {
      for (ProcessedMaterialVariationTranslation variant : ProcessedMaterialVariationTranslation.values()) {
        this.addItem(value.getMaterial().getVariant(variant.getVariant()), variant.getEnglishTranslation(value));
      }
    }
    this.add("item.tooltip.fluidstoragetank", "Stored Fluid: ");
    this.add("item.tooltip.holdshiftformore", "Hold shift for more info");
  }
}
