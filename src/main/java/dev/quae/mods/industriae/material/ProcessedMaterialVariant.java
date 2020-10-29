package dev.quae.mods.industriae.material;

import dev.quae.mods.industriae.IndustriaeMutatio;
import java.util.function.Function;
import net.minecraft.item.ItemGroup;

public enum ProcessedMaterialVariant implements IMProcessedMaterialVariant {
  IMPURE_DUST(t -> "impure_" + t + "_dust", IndustriaeMutatio.IMPURE_DUST_ORES_TAB),
  PURIFIED_DUST(t -> "purified_" + t + "_dust", IndustriaeMutatio.PURE_DUST_ORES_TAB),
  SMALL_DUST(t -> "small_" + t + "_dust", IndustriaeMutatio.SMALL_DUST_ORES_TAB),
  TINY_DUST(t -> "tiny_" + t + "_dust", IndustriaeMutatio.TINY_DUST_ORES_TAB),
  DUST(t -> t + "_dust", IndustriaeMutatio.DUST_ORES_TAB),
  SMALL_CENTRIFUGED_DUST(t -> "small_centrifuged_" + t + "_ore", IndustriaeMutatio.SMALL_CENTRIFUGED_ORES_TAB),
  TINY_CENTRIFUGED_DUST(t -> "tiny_centrifuged_" + t + "_ore", IndustriaeMutatio.TINY_CENTRIFUGED_ORES_TAB),
  CENTRIFUGED_DUST(t -> "centrifuged_" + t + "_ore", IndustriaeMutatio.CENTRIFUGED_ORES_TAB),
  CRUSHED_ORE(t -> "crushed_" + t + "_ore", IndustriaeMutatio.CRUSHED_ORES_TAB),
  SMALL_CRUSHED_ORE(t -> "small_crushed_" + t + "_ore", IndustriaeMutatio.SMALL_CRUSHED_ORES_TAB),
  TINY_CRUSHED_ORE(t -> "tiny_crushed_" + t + "_ore", IndustriaeMutatio.TINY_CRUSHED_ORES_TAB),
  ;

  private Function<String, String> nameFunction;
  private final ItemGroup group;

  ProcessedMaterialVariant(Function<String, String> nameFunction, ItemGroup group) {

    this.nameFunction = nameFunction;
    this.group = group;
  }

  @Override
  public String getName(String material) {
    return nameFunction.apply(material);
  }

  public ItemGroup getGroup() {
    return group;
  }
}
