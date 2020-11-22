package dev.quae.mods.industriae.construct.type;

import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.setup.IMTags;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public enum ComponentType implements Type {
  COIL(IMTags.Blocks.COIL),
  BLAST_FURNACE_FRAME(IMTags.Blocks.BLAST_FURNACE_FRAME),
  ;

  private final IOptionalNamedTag<Block> tag;

  ComponentType(IOptionalNamedTag<Block> tag) {
    this.tag = tag;
  }

  @Override
  public ITag<Block> getTag() {
    return this.tag;
  }
}
