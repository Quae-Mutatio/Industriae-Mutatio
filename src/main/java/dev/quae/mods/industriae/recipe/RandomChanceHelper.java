package dev.quae.mods.industriae.recipe;

import java.util.Random;
import net.minecraft.util.math.MathHelper;

public class RandomChanceHelper {

  private static Random rnd = new Random();

  public static boolean getShouldReturnFor(double chance) {
    double next = rnd.nextDouble();
    return next <= chance;
  }

}
