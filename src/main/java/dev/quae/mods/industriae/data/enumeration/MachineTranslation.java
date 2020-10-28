package dev.quae.mods.industriae.data.enumeration;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.data.IMLanguageProvider;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;

public enum MachineTranslation {
  ALLOY_SMELTER("Alloy Smelter", MachineType.ALLOY_SMELTER),
  FORGE_HAMMER("Forge Hammer", MachineType.FORGE_HAMMER),
  AUTOCLAVE("Autoclave", MachineType.AUTOCLAVE),
  LATHE("Lathe", MachineType.LATHE),
  MACERATOR("Macerator", MachineType.MACERATOR),
  MIXER("Mixer", MachineType.MIXER),
  ORE_WASHING_PLANT("Ore Washing Plant", MachineType.ORE_WASHING_PLANT),
  PACKAGER("Packager", MachineType.PACKAGER),
  POLARISER("Poloriser", MachineType.POLARISER),
  PRECISION_ENGRAVING_MACHINE("Precision Engraving Machine", MachineType.PRECISION_ENGRAVING_MACHINE),
  SIFTER("Sifter", MachineType.SIFTER),
  THERMAL_CENTRIFUGE("Thermal Centrifuge", MachineType.THERMAL_CENTRIFUGE),
  UNPACKAGER("Un Packager", MachineType.UNPACKAGER),
  WIREMILL("Wire Mill", MachineType.WIREMILL),
  REPLICATOR("Replicator", MachineType.REPLICATOR),
  RECYCLER("Recycler", MachineType.RECYCLER),
  PLASMA_ARC_FURNACE("Plasma Arc Furnace", MachineType.PLASMA_ARC_FURNACE),
  MICROWAVE("Microwave", MachineType.MICROWAVE),
  MASS_FABRICATOR("Mass Fabricator", MachineType.MASS_FABRICATOR),
  FURNACE("Furnace", MachineType.FURNACE),
  FORMING_PRESS("Forming Press", MachineType.FORMING_PRESS),
  FLUID_SOLIDIFIER("Fluid Solidifier", MachineType.FLUID_SOLIDIFIER),
  PRINTER("Printer", MachineType.PRINTER),
  SCANNER("Scanner", MachineType.SCANNER),
  FLUID_HEATER("Fluid Heater", MachineType.FLUID_HEATER),
  FLUID_EXTRACTOR("Fluid Extractor", MachineType.FLUID_EXTRACTOR),
  FLUID_CANNER("Fluid Canner", MachineType.FLUID_CANNER),
  FERMENTER("Fermenter", MachineType.FERMENTER),
  EXTRUDER("Extruder", MachineType.EXTRUDER),
  EXTRACTOR("Extractor", MachineType.EXTRACTOR),
  ELECTROMAGNETIC_SEPARATOR("Electromagnetic Separator", MachineType.ELECTROMAGNETIC_SEPARATOR),
  ELECTROLYZER("Electrolyzer", MachineType.ELECTROLYZER),
  ELECTRIC_OVEN("Electric Oven", MachineType.ELECTRIC_OVEN),
  DISSASEMBLER("Disassembler", MachineType.DISSASEMBLER),
  CUTTING_MACHINE("Cutting Machine", MachineType.CUTTING_MACHINE),
  CHEMICAL_REACTOR("Chemical Reactor", MachineType.CHEMICAL_REACTOR),
  COMPRESSOR("Compressor", MachineType.COMPRESSOR),
  DISTILLERY("Distillery", MachineType.DISTILLERY),
  CENTRIFUGE("Centrifuge", MachineType.CENTRIFUGE),
  BREWERY("Brewery", MachineType.BREWERY),
  CHEMICAL_BATH("Chemical Bath", MachineType.CHEMICAL_BATH),
  CANNING_MACHINE("Canning Machine", MachineType.CANNING_MACHINE),
  ASSEMBLING_MACHINE("Assembling Machine", MachineType.ASSEMBLING_MACHINE),
  BENDING_MACHINE("Bending Machine", MachineType.BENDING_MACHINE),
  SLICING_MACHINE("Slicing Machine", MachineType.SLICING_MACHINE),
  ;

  private final String englishTranslation;
  private final MachineType type;

  MachineTranslation(String englishTranslation, MachineType type) {

    this.englishTranslation = englishTranslation;
    this.type = type;
  }


  public void registerTranslations(IMLanguageProvider lang) {
    for (SpeedTierTranslation value : SpeedTierTranslation.values()) {
      String nameEnglish = value.getEnglishTranslation() + " " + this.englishTranslation;
      lang.addBlock(() -> this.type.getBlock(value.getType()), nameEnglish);
      lang.add("container." + IndustriaeMutatio.ID + "." + this.type.getRegistryName(value.getType()), nameEnglish);
    }
  }
}
