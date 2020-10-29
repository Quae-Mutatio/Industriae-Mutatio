package dev.quae.mods.industriae.data.enumeration;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.material.ProcessedMaterialVariant;
import java.util.function.Function;

public enum ProcessedMaterialVariationTranslation {
  IMPURE_DUST(t -> "Impure " + t + " Dust", ProcessedMaterialVariant.IMPURE_DUST),
  PURIFIED_DUST(t -> "Purified " + t + " Dust", ProcessedMaterialVariant.PURIFIED_DUST),
  SMALL_DUST(t -> "Small " + t + " Dust", ProcessedMaterialVariant.SMALL_DUST),
  TINY_DUST(t -> "Tiny " + t + " Dust", ProcessedMaterialVariant.TINY_DUST),
  DUST(t -> t + " Dist", ProcessedMaterialVariant.DUST),
  SMALL_CENTRIFUGED_DUST(t -> "Small Centrifuged " + t + " Ore", ProcessedMaterialVariant.SMALL_CENTRIFUGED_DUST),
  TINY_CENTRIFUGED_DUST(t -> "Tiny Centrifuged " + t + " Ore", ProcessedMaterialVariant.TINY_CENTRIFUGED_DUST),
  CENTRIFUGED_DUST(t -> "Centrifuged " + t + " Ore", ProcessedMaterialVariant.CENTRIFUGED_DUST),
  CRUSHED_ORE(t -> "C rushed " + t + " Ore", ProcessedMaterialVariant.CRUSHED_ORE),
  SMALL_CRUSHED_ORE(t -> "Small Crushed " + t + " Ore", ProcessedMaterialVariant.SMALL_CRUSHED_ORE),
  TINY_CRUSHED_ORE(t -> "Tiny Crushed " + t + " Ore", ProcessedMaterialVariant.TINY_CRUSHED_ORE),
  ;
  private final ProcessedMaterialVariant variant;
  private final Function<String, String> english;

  ProcessedMaterialVariationTranslation(Function<String, String> English, ProcessedMaterialVariant variant) {

    this.variant = variant;
    english = English;
  }

  public String getEnglishTranslation(MaterialTranslation material) {
    return this.english.apply(material.getEnglish());
  }

  public ProcessedMaterialVariant getVariant() {
    return variant;
  }
}
