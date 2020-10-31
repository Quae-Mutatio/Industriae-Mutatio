package dev.quae.mods.industriae.material;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;

public enum Material implements IMaterialType {
  ALMANDINE("almandine"),
  ALUMINIUM("aluminium"),
  APATITE("apatite"),
  BANDED_IRON("banded_iron"),
  BARITE("barite"),
  BASTNASITE("bastnasite"),
  BAUXITE("bauxite"),
  BENTONITE("bentonite"),
  BERYLLIUM("beryllium"),
  BROWN_LIMONITE("brown_limonite"),
  CALCITE("calcite"),
  CASSITERITE("cassiterite"),
  CERTUS_QUARTZ("certus_quartz"),
  CHALCOPYRITE("chalcopyrite"),
  CINNABAR("cinnabar"),
  COAL("coal"),
  COBALTITE("cobaltite"),
  COPPER("copper"),
  DIAMOND("diamond"),
  EMERALD("emerald"),
  GALENA("galena"),
  GARNIERITE("garnierite"),
  GLAUCONITE("glauconite"),
  GOLD("gold"),
  GRAPHITE("graphite"),
  GREEN_SAPPHIRE("green_sapphire"),
  GROSSULAR("grossular"),
  ILMENITE("ilmenite"),
  IRIDIUM("iridium"),
  IRON("iron"),
  LAPIS("lapis"),
  LAZURITE("lazurite"),
  LEAD("lead"),
  LEPIDOLITE("lepidolite"),
  LIGNITE("lignite"),
  LITHIUM("lithium"),
  MAGNESITE("magnesite"),
  MAGNETITE("magnetite"),
  MALACHITE("malachite"),
  MOLYBDENITE("molybdenite"),
  MOLYBDENUM("molybdenum"),
  MONAZITE("monazite"),
  NEODYMIUM("neodymium"),
  NETHER_QUARTZ("nether_quartz"),
  NICKEL("nickel"),
  OLIVINE("olivine"),
  PALLADIUM("palladium"),
  PENTLANDITE("pentlandite"),
  PHOSPHATE("phosphate"),
  PHOSPHORUS("phosphorus"),
  PITCHBLENDE("pitchblende"),
  PLATINUM("platinum"),
  PLUTONIUM("plutonium"),
  POWELLITE("powellite"),
  PYRITE("pyrite"),
  PYROLUSITE("pyrolusite"),
  PYROPE("pyrope"),
  QUARTZITE("quartzite"),
  REDSTONE("redstone"),
  ROCK_SALT("rock_salt"),
  RUBY("ruby"),
  SALT("salt"),
  SAPPHIRE("sapphire"),
  SCHEELITE("scheelite"),
  SHELDONITE("sheldonite"),
  SILVER("silver"),
  SOAPSTONE("soapstone"),
  SODALITE("sodalite"),
  SPESSARTINE("spessartine"),
  SPHALERITE("sphalerite"),
  SPODUMENE("spodumene"),
  STIBNITE("stibnite"),
  SULFUR("sulfur"),
  TALC("talc"),
  TANTALITE("tantalite"),
  TETRAHEDRITE("tetrahedrite"),
  THORIUM("thorium"),
  TIN("tin"),
  TUNGSTATE("tungstate"),
  URANINITE("uraninite"),
  URANIUM("uranium"),
  VANADIUM_MAGNETITE("vanadium_magnetite"),
  WULFENITE("wulfenite"),
  YELLOW_LIMONITE("yellow_limonite"),
  ;

  private final String name;

  Material(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getMaterialName() {
    return name;
  }

  @Override
  public String getTypeName() {
    return "";
  }

  public static Codec<Material> CODEC = new Codec<Material>() {
    @Override
    public <T> DataResult<T> encode(Material input, DynamicOps<T> ops, T prefix) {
      return ops.mergeToPrimitive(prefix, ops.createString(input.name()));
    }

    @Override
    public <T> DataResult<Pair<Material, T>> decode(DynamicOps<T> ops, T input) {
      return ops.getStringValue(input).map(Material::valueOf).map(r -> Pair.of(r, ops.empty()));
    }
  };
}
