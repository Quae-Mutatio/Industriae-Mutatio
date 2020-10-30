package dev.quae.mods.industriae.construct;

import com.google.common.collect.ImmutableList;
import dev.quae.mods.industriae.construct.IConstruct.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public enum ConstructionBlockType implements IConstruct.Type, IConstructionBlockType {
  BLAST_FURNACE_COIL_CUPRONICKEL("cupronickel"),
  BLAST_FURNACE_COIL_KANTHAL("kanthal"),
  BLAST_FURNACE_COIL_NICHROME("nichrome"),
  BLAST_FURNACE_COIL_TUNGSTENSTEEL("tungstensteel"),
  BLAST_FURNACE_COIL_HSS_G("hss_g"),
  BLAST_FURNACE_COIL_NAQUADAH("naquadah"),
  BLAST_FURNACE_COIL_NAQUADAH_ALLOY("naquadah_alloy"),
  BLAST_FURNACE_COIL_FUSION("fusion"),
  // TODO use Set
  BLAST_FURNACE_COIL("coil", ImmutableList.of(
      BLAST_FURNACE_COIL_CUPRONICKEL,
      BLAST_FURNACE_COIL_KANTHAL,
      BLAST_FURNACE_COIL_NICHROME,
      BLAST_FURNACE_COIL_TUNGSTENSTEEL,
      BLAST_FURNACE_COIL_HSS_G,
      BLAST_FURNACE_COIL_NAQUADAH,
      BLAST_FURNACE_COIL_NAQUADAH_ALLOY,
      BLAST_FURNACE_COIL_FUSION)),
  BLAST_FURNACE("frame"),
  ;

  private final String registryNameSuffix;
  private List<ConstructionBlockType> accept;

  ConstructionBlockType(String registryNameSuffix, List<ConstructionBlockType> accept) {
    this.registryNameSuffix = registryNameSuffix;
    this.accept = accept;
  }

  ConstructionBlockType(String registryNameSuffix) {
    this.accept = new ArrayList<>();
    this.registryNameSuffix = registryNameSuffix;
  }

  @Override
  public String getName() {
    return registryNameSuffix;
  }

  public List<ConstructionBlockType> getAcceptedTypes() {
    return this.accept;
  }


  @Override
  public boolean test(Type type) {
    if (this.accept != null && !this.accept.isEmpty()) {
      Predicate<Type> predicate = null;
      for (Type acceptedType : this.accept) {
        if (predicate == null) {
          predicate = acceptedType;
          continue;
        }
        predicate = predicate.or(acceptedType);
      }
      predicate.test(type);
    }
    return this.test(type);
  }
}
