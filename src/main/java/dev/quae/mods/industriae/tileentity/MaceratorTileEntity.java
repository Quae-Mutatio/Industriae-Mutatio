package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.capability.IMMaceratorItemHandler;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import dev.quae.mods.industriae.setup.IMTiles;
import java.util.Objects;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
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
    super(IMTiles.LV_MACERATOR.get());
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
    final NonNullList<ItemStack> results = this.getWorld().getRecipeManager().getRecipe(IMRecipeTypes.MACERATOR, craftingInv, this.getWorld())
        .map(x -> NonNullList.from(x.getCraftingResult(craftingInv), x.getRemainingItems(craftingInv).toArray(new ItemStack[0])))
        .orElse(NonNullList.create());
    if (this.inventory.getStackInSlot(1).getCount() + results.stream().findFirst().get().getCount() > 64){
      return;
    }
    this.processingTime += speedTier.getSpeed();
    if (this.processingTime >= this.requiredProcessingTime) {

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


  @Override
  public void tick() {
    processInput();
  }
}
