package dev.quae.mods.industriae.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.text.NBTTextComponent;

public class IMFluidTank extends Block {
  public IMFluidTank() {
    super(AbstractBlock.Properties.create(Material.IRON));
  }
}
