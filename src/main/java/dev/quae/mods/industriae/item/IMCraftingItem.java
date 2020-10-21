package dev.quae.mods.industriae.item;

import dev.quae.mods.industriae.IndustriaeMutatio;
import net.minecraft.item.Item;

public class IMCraftingItem extends Item {
  public IMCraftingItem() {
    super(new Item.Properties().group(IndustriaeMutatio.CRAFTING_ITEMS_TAB));
  }
}
