package dev.quae.mods.industriae.client.colours;

import dev.quae.mods.industriae.item.IMFirstLayerColouredItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class IMFirstLayerColouredItemColor implements IItemColor {

  @Override
  public int getColor(ItemStack itemStack, int index) {
    if (itemStack.getItem() instanceof IMFirstLayerColouredItem) {
      for (IMFirstLayerColouredItem dust : IMFirstLayerColouredItem.getDusts()) {
        if (itemStack.getItem() == dust) {
          return dust.getColour(index);
        }
      }
    }
    return 0xFFFFFFFF;
  }
}
