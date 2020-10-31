package dev.quae.mods.industriae.block;

import dev.quae.mods.industriae.material.IMaterialType;
import net.minecraft.block.Block;

public class OreBlock extends Block {

  private final IMaterialType materialType;

  public OreBlock(Properties properties, IMaterialType materialType) {
    super(properties);
    this.materialType = materialType;
  }

  public IMaterialType getMaterialType() {
    return materialType;
  }
}
