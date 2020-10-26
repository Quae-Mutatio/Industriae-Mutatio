package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.capability.IMMachineFluidHandler;
import dev.quae.mods.industriae.capability.IMMachineItemHandler;
import dev.quae.mods.industriae.helper.IMFluidStackHelper;
import dev.quae.mods.industriae.helper.IMItemStackHelper;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class IMTieredProcessingMachineTileEntity extends TileEntity {

  private static final int MACHINE_FLUID_TANK_CAPACITY = 64000;

  protected final IMMachineItemHandler inventory = new IMMachineItemHandler(getInventorySize(), getOutputStartIndex());
  protected final LazyOptional<IItemHandler> inventoryLO = LazyOptional.of(this::getInventory);
  protected final IMMachineFluidHandler fluidInventory = new IMMachineFluidHandler(getFluidInventorySize(), getFluidOutputStartIndex(), MACHINE_FLUID_TANK_CAPACITY);
  protected final LazyOptional<IFluidHandler> fluidInventoryLO = LazyOptional.of(() -> fluidInventory);
  protected int processingTime;
  protected int requiredProcessingTime;
  protected SpeedTier speedTier;

  public IMTieredProcessingMachineTileEntity(TileEntityType<?> tileEntityTypeIn, SpeedTier speedTier) {
    super(tileEntityTypeIn);
    this.speedTier = speedTier;
  }

  protected abstract int getInventorySize();

  protected abstract int getOutputStartIndex();

  protected abstract int getFluidInventorySize();

  protected abstract int getFluidOutputStartIndex();

  @NotNull
  protected IItemHandler getInventory() {
    return this.inventory;
  }

  @NotNull
  @Override
  public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
    if (Objects.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, cap)) {
      return this.inventoryLO.cast();
    } else if (Objects.equals(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, cap)) {
      return this.fluidInventoryLO.cast();
    }
    return super.getCapability(cap);
  }

  @Override
  protected void invalidateCaps() {
    this.inventoryLO.invalidate();
  }

  protected List<ItemStack> calculateOutput(IRecipeType<IMCustomMachineRecipe> recipeType) {
    final Inventory craftingInv = new Inventory(getOutputStartIndex() + getFluidOutputStartIndex());
    int offset = 0;
    for (int i = 0; i < this.getOutputStartIndex(); i++) {
      craftingInv.setInventorySlotContents(i, this.inventory.getStackInSlot(i));
      offset++;
    }
    for (int i = 0; i < this.getFluidOutputStartIndex(); i++) {
      craftingInv.setInventorySlotContents(i + offset, IMFluidStackHelper.getAsItemStack(this.fluidInventory.getFluidInTank(i)));
      offset++;
    }
    IMCustomMachineRecipe recipe = this.getWorld().getRecipeManager().getRecipe(recipeType, craftingInv, this.getWorld()).orElse(null);
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
    if (stack.isEmpty() && !IMFluidStackHelper.isFluidContainer(stack)) {
      return;
    }
    if (IMFluidStackHelper.isFluidContainer(stack)) {
      this.fluidInventory.internalFill(outputSlot, IMFluidStackHelper.getAsFluidStack(stack));
      this.fluidInventory.internalDrain(inputSlot, IMFluidStackHelper.getAsFluidStack(stack));
    }
    ItemStack inputStack = this.inventory.getStackInSlot(inputSlot);
    ItemStack stackInSlot = this.inventory.getStackInSlot(outputSlot);
    if (stackInSlot.isEmpty()) {
      this.inventory.setStackInSlot(outputSlot, stack);
      this.inventory.setStackInSlot(inputSlot, IMItemStackHelper.takeFromStack(inputStack, 1));
    } else if (stackInSlot.isItemEqual(stack)) {
      this.inventory.setStackInSlot(outputSlot, IMItemStackHelper.addToStack(stackInSlot, stack.getCount()));
      this.inventory.setStackInSlot(inputSlot, IMItemStackHelper.takeFromStack(inputStack, 1));
    }
  }

  @Override
  public void read(BlockState state, CompoundNBT nbt) {
    super.read(state, nbt);
    this.processingTime = nbt.getInt("processingTime");
    ItemStackHelper.loadAllItems(nbt, this.inventory.getStacks());
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    ItemStackHelper.saveAllItems(compound, this.inventory.getStacks());
    compound.putInt("processingTime", this.processingTime);
    return super.write(compound);
  }
}
