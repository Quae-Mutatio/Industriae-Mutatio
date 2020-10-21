package dev.quae.mods.industriae.material;

import dev.quae.mods.industriae.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.RegistryObject;

public enum Material implements IMaterialType {
  APATITE("apatite"),
  COPPER("copper"),
  PHOSPHOR("phosphor");

  private final String name;
  private RegistryObject<OreBlock> oreBlock;
  private RegistryObject<BlockItem> oreItem;

  Material(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
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
}
