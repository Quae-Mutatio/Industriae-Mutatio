package dev.quae.mods.industriae.data.enumeration;

import dev.quae.mods.industriae.material.Material;

public enum MaterialTranslation {
  ALMANDINE(Material.ALMANDINE, "Almandine"),
  ALUMINIUM(Material.ALUMINIUM, "Aluminium"),
  APATITE(Material.APATITE, "apatite"),
  BANDED_IRON(Material.BANDED_IRON, "Banded Iron"),
  BARITE(Material.BARITE, "Barite"),
  BASTNASITE(Material.BASTNASITE, "Bastnasite"),
  BAUXITE(Material.BAUXITE, "Bauxite"),
  BENTONITE(Material.BENTONITE, "Bentonite"),
  BERYLLIUM(Material.BERYLLIUM, "Beryllium"),
  BROWN_LIMONITE(Material.BROWN_LIMONITE, "Brown Limonite"),
  CALCITE(Material.CALCITE, "Calcite"),
  CASSITERITE(Material.CASSITERITE, "Cassiterite"),
  CERTUS_QUARTZ(Material.CERTUS_QUARTZ, "Certus Quartz"),
  CHALCOPYRITE(Material.CHALCOPYRITE, "Chalcopyrite"),
  CINNABAR(Material.CINNABAR, "Cinnabar"),
  COAL(Material.COAL, "Coal"),
  COBALTITE(Material.COBALTITE, "Cobaltite"),
  COPPER(Material.COPPER, "Copper"),
  DIAMOND(Material.DIAMOND, "Diamond"),
  EMERALD(Material.EMERALD, "Emerald"),
  GALENA(Material.GALENA, "Galena"),
  GARNIERITE(Material.GARNIERITE, "Garnierite"),
  GLAUCONITE(Material.GLAUCONITE, "Glauconite"),
  GOLD(Material.GOLD, "Gold"),
  GRAPHITE(Material.GRAPHITE, "Graphite"),
  GREEN_SAPPHIRE(Material.GREEN_SAPPHIRE, "Green Sapphire"),
  GROSSULAR(Material.GROSSULAR, "Grossular"),
  ILMENITE(Material.ILMENITE, "Ilmenite"),
  IRIDIUM(Material.IRIDIUM, "Iridium"),
  IRON(Material.IRON, "Iron"),
  LAPIS(Material.LAPIS, "Lapis"),
  LAZURITE(Material.LAZURITE, "Lazurite"),
  LEAD(Material.LEAD, "Lead"),
  LEPIDOLITE(Material.LEPIDOLITE, "Lepidolite"),
  LIGNITE(Material.LIGNITE, "Lignite"),
  LITHIUM(Material.LITHIUM, "Lithium"),
  MAGNESITE(Material.MAGNESITE, "Magnesite"),
  MAGNETITE(Material.MAGNETITE, "Magnetite"),
  MALACHITE(Material.MALACHITE, "Malachite"),
  MOLYBDENITE(Material.MOLYBDENITE, "Molybdenite"),
  MOLYBDENUM(Material.MOLYBDENUM, "Molybdenum"),
  MONAZITE(Material.MONAZITE, "Monazite"),
  NEODYMIUM(Material.NEODYMIUM, "Neodymium"),
  NETHER_QUARTZ(Material.NETHER_QUARTZ, "Nether Quartz"),
  NICKEL(Material.NICKEL, "Nickel"),
  OLIVINE(Material.OLIVINE, "Olivine"),
  PALLADIUM(Material.PALLADIUM, "Palladium"),
  PENTLANDITE(Material.PENTLANDITE, "Pentlandite"),
  PHOSPHATE(Material.PHOSPHATE, "Phosphate"),
  PHOSPHORUS(Material.PHOSPHORUS, "Phosphorus"),
  PITCHBLENDE(Material.PITCHBLENDE, "Pitchblende"),
  PLATINUM(Material.PLATINUM, "Platinum"),
  PLUTONIUM(Material.PLUTONIUM, "Plutonium"),
  POWELLITE(Material.POWELLITE, "Powellite"),
  PYRITE(Material.PYRITE, "Pyrite"),
  PYROLUSITE(Material.PYROLUSITE, "Pyrolusite"),
  PYROPE(Material.PYROPE, "Pyrope"),
  QUARTZITE(Material.QUARTZITE, "Quartzite"),
  REDSTONE(Material.REDSTONE, "Redstone"),
  ROCK_SALT(Material.ROCK_SALT, "Rock Salt"),
  RUBY(Material.RUBY, "Ruby"),
  SALT(Material.SALT, "Salt"),
  SAPPHIRE(Material.SAPPHIRE, "Sapphire"),
  SCHEELITE(Material.SCHEELITE, "Scheelite"),
  SHELDONITE(Material.SHELDONITE, "Sheldonite"),
  SILVER(Material.SILVER, "Silver"),
  SOAPSTONE(Material.SOAPSTONE, "Soapstone"),
  SODALITE(Material.SODALITE, "Sodalite"),
  SPESSARTINE(Material.SPESSARTINE, "Spessartine"),
  SPHALERITE(Material.SPHALERITE, "Sphalerite"),
  SPODUMENE(Material.SPODUMENE, "Spodumene"),
  STIBNITE(Material.STIBNITE, "Stibnite"),
  SULFUR(Material.SULFUR, "Sulfur"),
  TALC(Material.TALC, "Talc"),
  TANTALITE(Material.TANTALITE, "Tantalite"),
  TETRAHEDRITE(Material.TETRAHEDRITE, "Tetrahedrite"),
  THORIUM(Material.THORIUM, "Thorium"),
  TIN(Material.TIN, "Tin"),
  TUNGSTATE(Material.TUNGSTATE, "Tungstate"),
  URANINITE(Material.URANINITE, "Uraninite"),
  URANIUM(Material.URANIUM, "Uranium"),
  VANADIUM_MAGNETITE(Material.VANADIUM_MAGNETITE, "Vanadium Magnetite"),
  WULFENITE(Material.WULFENITE, "Wulfenite"),
  YELLOW_LIMONITE(Material.YELLOW_LIMONITE, "Yellow Limonite"),
;
  private Material material;
  private String english;

  MaterialTranslation(Material material, String english){
    this.material = material;

    this.english = english;
  }

  public String getEnglish(){
    return english;
  }

  public Material getMaterial() {
    return material;
  }
}

