package dev.quae.mods.industriae.material;

import dev.quae.mods.industriae.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.RegistryObject;

public enum Ore implements IMaterialType {
  ALMANDINE(Material.ALMANDINE),
  ALUMINIUM(Material.ALUMINIUM),
  APATITE(Material.APATITE),
  BANDED_IRON(Material.BANDED_IRON),
  BARITE(Material.BARITE),
  BASTNASITE(Material.BASTNASITE),
  BAUXITE(Material.BAUXITE),
  BENTONITE(Material.BENTONITE),
  BERYLLIUM(Material.BERYLLIUM),
  BROWN_LIMONITE(Material.BROWN_LIMONITE),
  CALCITE(Material.CALCITE),
  CASSITERITE(Material.CASSITERITE),
  CERTUS_QUARTZ(Material.CERTUS_QUARTZ),
  CHALCOPYRITE(Material.CHALCOPYRITE),
  CINNABAR(Material.CINNABAR),
  COAL(Material.COAL),
  COBALTITE(Material.COBALTITE),
  COPPER(Material.COPPER),
  DIAMOND(Material.DIAMOND),
  EMERALD(Material.EMERALD),
  GALENA(Material.GALENA),
  GARNIERITE(Material.GARNIERITE),
  GLAUCONITE(Material.GLAUCONITE),
  GOLD(Material.GOLD),
  GRAPHITE(Material.GRAPHITE),
  GREEN_SAPPHIRE(Material.GREEN_SAPPHIRE),
  GROSSULAR(Material.GROSSULAR),
  ILMENITE(Material.ILMENITE),
  IRIDIUM(Material.IRIDIUM),
  IRON(Material.IRON),
  LAPIS(Material.LAPIS),
  LAZURITE(Material.LAZURITE),
  LEAD(Material.LEAD),
  LEPIDOLITE(Material.LEPIDOLITE),
  LIGNITE(Material.LIGNITE),
  LITHIUM(Material.LITHIUM),
  MAGNESITE(Material.MAGNESITE),
  MAGNETITE(Material.MAGNETITE),
  MALACHITE(Material.MALACHITE),
  MOLYBDENITE(Material.MOLYBDENITE),
  MOLYBDENUM(Material.MOLYBDENUM),
  MONAZITE(Material.MONAZITE),
  NEODYMIUM(Material.NEODYMIUM),
  NETHER_QUARTZ(Material.NETHER_QUARTZ),
  NICKEL(Material.NICKEL),
  OLIVINE(Material.OLIVINE),
  PALLADIUM(Material.PALLADIUM),
  PENTLANDITE(Material.PENTLANDITE),
  PHOSPHATE(Material.PHOSPHATE),
  PHOSPHORUS(Material.PHOSPHORUS),
  PITCHBLENDE(Material.PITCHBLENDE),
  PLATINUM(Material.PLATINUM),
  PLUTONIUM(Material.PLUTONIUM),
  POWELLITE(Material.POWELLITE),
  PYRITE(Material.PYRITE),
  PYROLUSITE(Material.PYROLUSITE),
  PYROPE(Material.PYROPE),
  QUARTZITE(Material.QUARTZITE),
  REDSTONE(Material.REDSTONE),
  ROCK_SALT(Material.ROCK_SALT),
  RUBY(Material.RUBY),
  SALT(Material.SALT),
  SAPPHIRE(Material.SAPPHIRE),
  SCHEELITE(Material.SCHEELITE),
  SHELDONITE(Material.SHELDONITE),
  SILVER(Material.SILVER),
  SOAPSTONE(Material.SOAPSTONE),
  SODALITE(Material.SODALITE),
  SPESSARTINE(Material.SPESSARTINE),
  SPHALERITE(Material.SPHALERITE),
  SPODUMENE(Material.SPODUMENE),
  STIBNITE(Material.STIBNITE),
  SULFUR(Material.SULFUR),
  TALC(Material.TALC),
  TANTALITE(Material.TANTALITE),
  TETRAHEDRITE(Material.TETRAHEDRITE),
  THORIUM(Material.THORIUM),
  TIN(Material.TIN),
  TUNGSTATE(Material.TUNGSTATE),
  URANINITE(Material.URANINITE),
  URANIUM(Material.URANIUM),
  VANADIUM_MAGNETITE(Material.VANADIUM_MAGNETITE),
  WULFENITE(Material.WULFENITE),
  YELLOW_LIMONITE(Material.YELLOW_LIMONITE),
  ;

  private final Material material;
  private RegistryObject<OreBlock> oreBlock;
  private RegistryObject<BlockItem> oreItem;

  Ore(Material material) {
    this.material = material;
  }

  public void setOreBlock(RegistryObject<OreBlock> oreBlock) {
    this.oreBlock = oreBlock;
  }

  public RegistryObject<OreBlock> getOreBlock() {
    return oreBlock;
  }

  public void setOreItem(RegistryObject<BlockItem> oreItem) {
    this.oreItem = oreItem;
  }

  public RegistryObject<BlockItem> getOreItem() {
    return oreItem;
  }

  @Override
  public String getMaterialName() {
    return this.material.getName();
  }

  @Override
  public String getTypeName() {
    return "ore";
  }
}
