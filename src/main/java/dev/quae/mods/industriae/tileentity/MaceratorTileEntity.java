package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.capability.IMMaceratorItemHandler;
import dev.quae.mods.industriae.helper.TileEntityTypeResolver;
import dev.quae.mods.industriae.recipe.IMMaceratorRecipe;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import dev.quae.mods.industriae.setup.IMTiles;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
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

public class MaceratorTileEntity extends TileEntity implements ITickableTileEntity {

  private final IMMaceratorItemHandler inventory = new IMMaceratorItemHandler(4);
  private final LazyOptional<IItemHandler> inventoryLO = LazyOptional.of(this::getInventory);
  private int processingTime;
  private int requiredProcessingTime;
  private SpeedTier speedTier;


  public MaceratorTileEntity(SpeedTier speedTier) {
    this(speedTier, TileEntityTypeResolver.resolveMacerator(speedTier));
  }

  public MaceratorTileEntity(SpeedTier speedTier, TileEntityType<?> type) {
    super(type);
    this.speedTier = speedTier;
  }

  private IItemHandler getInventory() {
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

  private void processInput() {
    ItemStack input = this.inventory.getStackInSlot(0);
    if (input.isEmpty()) {
      return;
    }
    final Inventory craftingInv = new Inventory(input);
    IMMaceratorRecipe recipe = this.getWorld().getRecipeManager().getRecipe(IMRecipeTypes.MACERATOR, craftingInv, this.getWorld()).orElse(null);
    if (recipe == null){
      return;
    }
    this.requiredProcessingTime = recipe.getTicks();
    final ItemStack primaryResult = recipe.getCraftingResult(craftingInv);
    final NonNullList<ItemStack> secondaryResults = recipe.getRemainingItems(craftingInv);
    List<ItemStack> results = new ArrayList<>();
    results.add(primaryResult);
    for (ItemStack secondaryResult : secondaryResults) {
      results.add(secondaryResult);
    }
    for (ItemStack result : results) {
      if (this.inventory.getStackInSlot(1).getCount() + result.getCount() > 64) {
        return;
      }
    }
    consumeEnergy();
    this.processingTime += speedTier.getSpeed();
    if (this.processingTime >= this.requiredProcessingTime) {
      this.processingTime = 0;
      int resultIndexCounter = 0;
      for (ItemStack result : results) {
        resultIndexCounter++;
        if (result.isEmpty()) {
          continue;
        }
        ItemStack stackInSlot = this.inventory.getStackInSlot(resultIndexCounter);
        if (stackInSlot.isEmpty()) {
          this.inventory.setStackInSlot(resultIndexCounter, result);
          this.inventory.setStackInSlot(0, new ItemStack(stackInSlot.getItem(), stackInSlot.getCount() - 1));
        } else {
          if (stackInSlot.isItemEqual(result)) {
            this.inventory.setStackInSlot(resultIndexCounter, new ItemStack(result.getItem(), result.getCount() + stackInSlot.getCount()));
            this.inventory.setStackInSlot(0, new ItemStack(stackInSlot.getItem(), stackInSlot.getCount() - 1));
          }
        }
      }
    }
  }


  private void consumeEnergy() {
    // TODO add voltaic RF usage
  }

  @Override
  public void tick() {
    processInput();
  }
}
