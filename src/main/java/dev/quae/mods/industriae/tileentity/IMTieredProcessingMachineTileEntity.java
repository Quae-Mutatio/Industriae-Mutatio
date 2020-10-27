package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.capability.IMMachineFluidHandler;
import dev.quae.mods.industriae.capability.IMMachineItemHandler;
import dev.quae.mods.industriae.data.recipe.IMMachineInput;
import dev.quae.mods.industriae.data.recipe.IMMachineOutput;
import dev.quae.mods.industriae.helper.IMFluidStackHelper;
import dev.quae.mods.industriae.helper.IMItemStackHelper;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IMTieredProcessingMachineTileEntity extends TileEntity implements ITickableTileEntity {

  private static final int MACHINE_FLUID_TANK_CAPACITY = 64000;

  protected final IMMachineItemHandler inventory;
  protected final LazyOptional<IItemHandler> inventoryLO = LazyOptional.of(this::getInventory);
  protected final IMMachineFluidHandler fluidInventory;
  protected final LazyOptional<IFluidHandler> fluidInventoryLO = LazyOptional.of(this::getTank);

  protected int processingTime;
  protected int requiredProcessingTime;
  protected SpeedTier speedTier;
  private MachineType machineType;
  private IRecipeType<IMCustomMachineRecipe> recipeType;
  IMCustomMachineRecipe currentRecipe = null;

  public IMTieredProcessingMachineTileEntity(TileEntityType<?> tileEntityTypeIn, SpeedTier speedTier, MachineType machineType) {
    super(tileEntityTypeIn);
    this.inventory  = new IMMachineItemHandler(machineType.getInputInventorySize() + machineType.getOutputInventorySize(), machineType.getInputInventorySize());
    this.fluidInventory  = new IMMachineFluidHandler(machineType.getInputTankCount() + machineType.getOutputTankCount(), machineType.getInputTankCount(), MACHINE_FLUID_TANK_CAPACITY);
    this.speedTier = speedTier;
    this.machineType = machineType;
    this.recipeType = machineType.getRecipeType();
  }

  @NotNull
  protected IItemHandler getInventory() {
    return this.inventory;
  }
  private IFluidHandler getTank() {
    return this.fluidInventory;
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

  protected List<ItemStack> calculateOutput() {
    currentRecipe = null;
    final Inventory craftingInv = new Inventory(this.machineType.getInputInventorySize() + this.machineType.getInputTankCount());
    int offset = 0;
    for (int i = 0; i < this.machineType.getInputInventorySize(); i++) {
      craftingInv.setInventorySlotContents(i, this.inventory.getStackInSlot(i));
      offset++;
    }
    for (int i = 0; i < this.machineType.getInputTankCount(); i++) {
      craftingInv.setInventorySlotContents(i + offset, IMFluidStackHelper.getAsItemStack(this.fluidInventory.getFluidInTank(i)));
    }
    currentRecipe = this.getWorld().getRecipeManager().getRecipe(recipeType, craftingInv, this.getWorld()).orElse(null);
    if (currentRecipe == null) {
      return null;
    }
    this.requiredProcessingTime = currentRecipe.getTicks();
    final ItemStack primaryResult = currentRecipe.getCraftingResult(craftingInv);
    final NonNullList<ItemStack> secondaryResults = currentRecipe.getRemainingItems(craftingInv);
    List<ItemStack> results = new ArrayList<>();
    results.add(primaryResult.copy());
    results.addAll(secondaryResults.stream().map(ItemStack::copy).collect(Collectors.toList()));
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

  protected void setResultStacks() {
    this.removeInputs();
    int index = 0;
    for (IMMachineOutput output : this.currentRecipe.getAllOutputs()) {
      int offsetIndex = index + this.machineType.getInputInventorySize();
      ItemStack stack = output.resolveItemStack().copy();
      if (stack.isEmpty() && !IMFluidStackHelper.isFluidContainer(stack)) {
        return;
      }
      if (IMFluidStackHelper.isFluidContainer(stack)) {
        this.fluidInventory.internalFill(offsetIndex, IMFluidStackHelper.getAsFluidStack(stack));
      }
      ItemStack stackInSlot = this.inventory.getStackInSlot(offsetIndex);
      if (stackInSlot.isEmpty()) {
        this.inventory.setStackInSlot(offsetIndex, stack);
      } else if (stackInSlot.isItemEqual(stack)) {
        this.inventory.setStackInSlot(offsetIndex, IMItemStackHelper.addToStack(stackInSlot, stack.getCount()));
      }
      index++;
    }

  }

  private void removeInputs(){

    int fluidInputIndex = 0;
    for (IMMachineInput fluidInput : this.currentRecipe.getFluidInputs()) {
      if (fluidInput.getDontConsume()) {
        continue;
      }
      for (int i = 0; i < this.machineType.getInputTankCount(); i++) {
        if (!fluidInventory.getFluidInTank(i).isFluidEqual(fluidInput.getFluidStack())) {
          continue;
        }
        this.fluidInventory.internalDrain(fluidInputIndex, fluidInput.getFluidStack().copy());
        fluidInputIndex++;
      }
    }

    int inputIndex = 0;
    for (IMMachineInput itemInput : this.currentRecipe.getInputs()) {
      if ((itemInput.getDontConsume())) {
        continue;
      }
      for (int i = 0; i < this.machineType.getInputInventorySize(); i++) {
        if (!inventory.getStackInSlot(i).isItemEqual(itemInput.getItem())) {
          continue;
        }
        this.inventory.setStackInSlot(inputIndex, IMItemStackHelper.takeFromStack(this.inventory.getStackInSlot(i), itemInput.getItem().getCount()));
        inputIndex++;
      }
    }
  }

  private void processInput() {
    List<ItemStack> results = this.calculateOutput();
    if (results == null) {
      return;
    }
    consumeEnergy();
    if (hasFinishedProcess()) {
      this.setResultStacks();
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

  @Override
  public void tick() {
    processInput();
  }
}
