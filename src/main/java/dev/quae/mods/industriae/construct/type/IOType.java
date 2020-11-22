package dev.quae.mods.industriae.construct.type;

import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.setup.IMTags;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public enum IOType implements Type {
  ITEM_IN(IMTags.Blocks.ITEM_IO_IN),
  ITEM_OUT(IMTags.Blocks.ITEM_IO_IN),
  FLUID_IN(IMTags.Blocks.ITEM_IO_IN),
  FLUID_OUT(IMTags.Blocks.ITEM_IO_IN),
  ENERGY_IN(IMTags.Blocks.ITEM_IO_IN),
  ENERGY_OUT(IMTags.Blocks.ITEM_IO_IN),
  ANY(IMTags.Blocks.ITEM_IO_IN);

  private final IOptionalNamedTag<Block> type;

  IOType(IOptionalNamedTag<Block> type) {
    this.type = type;
  }

  @Override
  public ITag<Block> getTag() {
    return this.type;
  }
}
