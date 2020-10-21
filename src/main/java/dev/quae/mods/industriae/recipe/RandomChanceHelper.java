package dev.quae.mods.industriae.recipe;

import java.util.Random;
import net.minecraft.util.math.MathHelper;

public class RandomChanceHelper {

  private static Random rnd = new Random();

  public static int getCountFor(double chance) {
    int base = MathHelper.floor(chance);
    return base + (rnd.nextDouble() <= chance % 1 ? 1 : 0);
  }

}
