package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.capability.IMSingleInputItemHandler;
import dev.quae.mods.industriae.helper.ItemStackCountHelper;
import dev.quae.mods.industriae.recipe.IMMachineRecipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class IMTieredProcessingMachineTileEntity<RECIPE extends IMMachineRecipe> extends TileEntity {

  protected final IMSingleInputItemHandler inventory = new IMSingleInputItemHandler(getInventorySize());
  protected final LazyOptional<IItemHandler> inventoryLO = LazyOptional.of(this::getInventory);
  protected int processingTime;
  protected int requiredProcessingTime;
  protected SpeedTier speedTier;

  public IMTieredProcessingMachineTileEntity(TileEntityType<?> tileEntityTypeIn, SpeedTier speedTier) {
    super(tileEntityTypeIn);
    this.speedTier = speedTier;
  }

  protected abstract int getInventorySize();

  @NotNull
  protected IItemHandler getInventory() {
    return this.inventory;
  }

  @NotNull
  @Override
  public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
    if (Objects.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, cap)) {
      return this.inventoryLO.cast();
    }
    return super.getCapability(cap);
  }

  @Override
  protected void invalidateCaps() {
    this.inventoryLO.invalidate();
  }

  protected List<ItemStack> calculateOutput(IRecipeType<RECIPE> recipeType) {
    ItemStack input = this.inventory.getStackInSlot(0);
    if (input.isEmpty()) {
      return null;
    }
    final Inventory craftingInv = new Inventory(input);
    RECIPE recipe = this.getWorld().getRecipeManager().getRecipe(recipeType, craftingInv, this.getWorld()).orElse(null);
    if (recipe == null) {
      return null;
    }
    this.requiredProcessingTime = recipe.getTicks();
    final ItemStack primaryResult = recipe.getCraftingResult(craftingInv);
    final NonNullList<ItemStack> secondaryResults = recipe.getRemainingItems(craftingInv);
    List<ItemStack> results = new ArrayList<>();
    results.add(primaryResult);
    results.addAll(secondaryResults);
    for (ItemStack result : results) {
      if (this.inventory.getStackInSlot(1).getCount() + result.getCount() > 64) {
        return null;
      }
    }
    return results;
  }

  protected boolean hasFinishedProcess() {
    this.processingTime += speedTier.getSpeed();
    boolean finished = this.processingTime >= this.requiredProcessingTime;
    if (finished) {
      this.processingTime = 0;
    }
    return finished;
  }

  protected void consumeEnergy() {
    // TODO add voltaic RF usage
  }

  protected void setResultStack(ItemStack stack, int inputSlot, int outputSlot) {
    if (stack.isEmpty()) {
      return;
    }
    ItemStack inputStack = this.inventory.getStackInSlot(inputSlot);
    ItemStack stackInSlot = this.inventory.getStackInSlot(outputSlot);
    if (stackInSlot.isEmpty()) {
      this.inventory.setStackInSlot(outputSlot, stack);
      this.inventory.setStackInSlot(inputSlot, ItemStackCountHelper.takeFromStack(inputStack, 1));
    } else if (stackInSlot.isItemEqual(stack)) {
      this.inventory.setStackInSlot(outputSlot, ItemStackCountHelper.addToStack(stackInSlot, stack.getCount()));
      this.inventory.setStackInSlot(inputSlot, ItemStackCountHelper.takeFromStack(inputStack, 1));
    }
  }
}
