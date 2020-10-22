package dev.quae.mods.industriae.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.crafting.IRecipe;

public interface IMMachineRecipe extends IRecipe<Inventory> {
  int getTicks();
}
