package dev.quae.mods.industriae.construct.type;

import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.setup.IMTags;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public enum ControllerType implements Type {
  BLAST_FURNACE("electric_blast_furnace", IMTags.Blocks.BLAST_FURNACE_CONTROLLER),
  ;
  private final String name;
  private final IOptionalNamedTag<Block> tag;

  ControllerType(String name, IOptionalNamedTag<Block> tag) {

    this.name = name;
    this.tag = tag;
  }

  public String getName() {
    return name;
  }

  @Override
  public ITag<Block> getTag() {
    return this.tag;
  }
}
