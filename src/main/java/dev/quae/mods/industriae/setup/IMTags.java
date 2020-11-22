package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class IMTags {

  public static class Blocks {

    public static final IOptionalNamedTag<Block> ITEM_IO_IN = tag("item_inputs");
    public static final IOptionalNamedTag<Block> ITEM_IO_OUT = tag("item_outputs");
    public static final IOptionalNamedTag<Block> FLUID_IO_IN = tag("fluid_inputs");
    public static final IOptionalNamedTag<Block> FLUID_IO_OUT = tag("fluid_outputs");
    public static final IOptionalNamedTag<Block> ENERGY_IO_IN = tag("energy_inputs");
    public static final IOptionalNamedTag<Block> ENERGY_IO_OUT = tag("energy_outputs");
    public static final IOptionalNamedTag<Block> ANY_IO = tag("all_ios");
    public static final IOptionalNamedTag<Block> COIL = tag("coils");
    public static final IOptionalNamedTag<Block> BLAST_FURNACE_FRAME = tag("blast_furnace_frames");
    public static final IOptionalNamedTag<Block> BLAST_FURNACE_CONTROLLER = tag("blast_furnace_controllers");

    private static IOptionalNamedTag<Block> tag(String name) {
      return BlockTags.createOptional(new ResourceLocation(IndustriaeMutatio.ID, name));
    }
  }
}
