package dev.quae.mods.industriae.item;

import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class IMBlockItem extends BlockItem {

  private final Supplier<? extends Block> blockSup;

  public IMBlockItem(Supplier<? extends Block> blockSup, Properties builder) {
    super(null, builder);
    this.blockSup = blockSup;
  }

  @Override
  public Block getBlock() {
    return blockSup.get();
  }
}
