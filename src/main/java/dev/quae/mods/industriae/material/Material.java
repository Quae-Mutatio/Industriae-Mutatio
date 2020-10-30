package dev.quae.mods.industriae.material;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import dev.quae.mods.industriae.block.OreBlock;
import dev.quae.mods.industriae.item.IMFirstLayerColouredItem;
import dev.quae.mods.industriae.setup.IMItems;
import java.util.EnumMap;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;

public enum Material implements IMaterialType {
  ALMANDINE("almandine", 0xd10f0f),
  ALUMINIUM("aluminium", 0x0fafdb),
  APATITE("apatite", 0x1e88a6),
  BANDED_IRON("banded_iron", 0xa66550),
  BARITE("barite", 0xe6eded),
  BASTNASITE("bastnasite", 0xeb3f10),
  BAUXITE("bauxite", 0xe38539),
  BENTONITE("bentonite", 0xe8e0c1),
  BERYLLIUM("beryllium", 0x828282),
  BROWN_LIMONITE("brown_limonite", 0x8a6033),
  CALCITE("calcite", 0xede1d3),
  CASSITERITE("cassiterite", 0xf5f3f0),
  CERTUS_QUARTZ("certus_quartz", 0xd5d7e8),
  CHALCOPYRITE("chalcopyrite", 0xd9cc6f),
  CINNABAR("cinnabar", 0x820808),
  COAL("coal", 0x323232),
  COBALTITE("cobaltite", 0x2f2f91),
  COPPER("copper", 0xff6a00),
  DIAMOND("diamond", 0x0062ff),
  EMERALD("emerald", 0X9bcce0),
  GALENA("galena", 0x908c96),
  GARNIERITE("garnierite", 0x1fa141),
  GLAUCONITE("glauconite", 0x129936),
  GOLD("gold", 0xffc800),
  GRAPHITE("graphite", 0x323232),
  GREEN_SAPPHIRE("green_sapphire", 0x129936),
  GROSSULAR("grossular", 0Xbd3a3a),
  ILMENITE("ilmenite", 0x424242),
  IRIDIUM("iridium", 0Xdedede),
  IRON("iron", 0x858585),
  LAPIS("lapis", 0x3330db),
  LAZURITE("lazurite", 0x3330db),
  LEAD("lead", 0x513561),
  LEPIDOLITE("lepidolite", 0xcca8e3),
  LIGNITE("lignite", 0x875f4a),
  LITHIUM("lithium", 0xcfcfcf),
  MAGNESITE("magnesite", 0xe3aad8),
  MAGNETITE("magnetite", 0x3b3b3b),
  MALACHITE("malachite", 0x4a7a47),
  MOLYBDENITE("molybdenite", 0x5e5e5e),
  MOLYBDENUM("molybdenum", 0xb3baba),
  MONAZITE("monazite", 0xb5925b),
  NEODYMIUM("neodymium", 0x212121),
  NETHER_QUARTZ("nether_quartz", 0xebe8e4),
  NICKEL("nickel", 0xd6c0a3),
  OLIVINE("olivine", 0x8bd691),
  PALLADIUM("palladium", 0xdbdbdb),
  PENTLANDITE("pentlandite", 0xcccccc),
  PHOSPHATE("phosphate", 0xc5c9bf),
  PHOSPHORUS("phosphorus", 0xdedede),
  PITCHBLENDE("pitchblende", 0x7a6f5e),
  PLATINUM("platinum", 0xdcecf2),
  PLUTONIUM("plutonium", 0xf2f2f2),
  POWELLITE("powellite", 0xf5f2e6),
  PYRITE("pyrite", 0xe8d48b),
  PYROLUSITE("pyrolusite", 0x4d4c49),
  PYROPE("pyrope", 0xde2f2f),
  QUARTZITE("quartzite", 0x99c1d1),
  REDSTONE("redstone", 0xFF0000),
  ROCK_SALT("rock_salt", 0xdbbfd2),
  RUBY("ruby", 0xFF0000),
  SALT("salt", 0xFFFFFF),
  SAPPHIRE("sapphire", 0x4c48db),
  SCHEELITE("scheelite", 0x827a6f),
  SHELDONITE("sheldonite", 0xede2d3),
  SILVER("silver", 0xe4ebea),
  SOAPSTONE("soapstone", 0xc0ebed),
  SODALITE("sodalite", 0x3360e8),
  SPESSARTINE("spessartine", 0Xd94545),
  SPHALERITE("sphalerite", 0x87857b),
  SPODUMENE("spodumene", 0x7c469c),
  STIBNITE("stibnite", 0x48454a),
  SULFUR("sulfur", 0xb3ab40),
  TALC("talc", 0x87b340),
  TANTALITE("tantalite", 0xb38740),
  TETRAHEDRITE("tetrahedrite", 0xe01919),
  THORIUM("thorium", 0x121212),
  TIN("tin", 0xEFEFEF),
  TUNGSTATE("tungstate", 0xdedede),
  URANINITE("uraninite", 0x969db0),
  URANIUM("uranium", 0xc9c9c3),
  VANADIUM_MAGNETITE("vanadium_magnetite", 0x434343),
  WULFENITE("wulfenite", 0xe34949),
  YELLOW_LIMONITE("yellow_limonite", 0xdecf2f),;

  private final String name;
  private RegistryObject<OreBlock> oreBlock;
  private RegistryObject<BlockItem> oreItem;
  private EnumMap<ProcessedMaterialVariant, RegistryObject<Item>> processedVariants;
  private final int colour;

  Material(String name, int colour) {
    this.name = name;
    processedVariants = new EnumMap<>(ProcessedMaterialVariant.class);
    this.colour = colour;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setOreBlock(RegistryObject<OreBlock> oreBlock) {
    this.oreBlock = oreBlock;
  }

  public void createProcessedOreVariants() {
    for (ProcessedMaterialVariant value : ProcessedMaterialVariant.values()) {
      processedVariants.put(value, IMItems.ITEMS.register(value.getName(this.name), () -> new IMFirstLayerColouredItem(new Properties().group(value.getGroup()), this.colour)));
    }
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

  public RegistryObject<Item> getVariant(ProcessedMaterialVariant value) {
    return this.processedVariants.get(value);
  }
}
