package dev.quae.mods.industriae.item;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class IMFirstLayerColouredItem extends Item {

  private static final List<IMFirstLayerColouredItem> ORE_CHUNK = new ArrayList<>();
  private int colour;

  public IMFirstLayerColouredItem(Properties properties, int colours) {
    super(properties);
    this.colour = colours;
    ORE_CHUNK.add(this);
  }

  public static List<IMFirstLayerColouredItem> getDusts() {
    return ORE_CHUNK;
  }

  @OnlyIn(Dist.CLIENT)
  public int getColour(int index) {
      return index == 0 ? colour : 0xFFFFFFFF;
  }

}
