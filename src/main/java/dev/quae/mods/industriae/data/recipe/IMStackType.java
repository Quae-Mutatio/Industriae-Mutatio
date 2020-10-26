package dev.quae.mods.industriae.data.recipe;

public enum IMStackType {
  ITEM_STACK(0),
  FLUID_STACK(1);

  private final int stackId;

  IMStackType(int stackId) {
    this.stackId = stackId;
  }

  public int getId() {
    return this.stackId;
  }
}
