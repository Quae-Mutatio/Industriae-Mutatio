package dev.quae.mods.industriae.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.quae.mods.industriae.data.recipe.IMMachineOutput;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class IMSingleInputMachineRecipe implements IMMachineRecipe {

  protected final List<IMMachineOutput> result;
  protected final ResourceLocation id;
  protected final ItemStack ingredient;
  protected final int ticks;
  private IRecipeSerializer<?> serializer;
  private IRecipeType<?> recipeType;

  public IMSingleInputMachineRecipe(List<IMMachineOutput> result,
      ResourceLocation id,
      ItemStack ingredient,
      int ticks,
      IRecipeSerializer<?> serializer,
      IRecipeType<?> recipeType) {
    this.result = result;
    this.id = id;
    this.ingredient = ingredient;
    this.ticks = ticks;
    this.serializer = serializer;
    this.recipeType = recipeType;
  }

  @Override
  public int getTicks() {
    return this.ticks;
  }

  @Override
  public boolean matches(Inventory inv, World worldIn) {
    return inv.getStackInSlot(0).isItemEqual(this.ingredient);
  }

  @Override
  public ItemStack getCraftingResult(Inventory inv) {
    return getRecipeOutput().copy();
  }

  @Override
  public NonNullList<ItemStack> getRemainingItems(Inventory inv) {
    NonNullList<ItemStack> secondaries = NonNullList.create();
    for (IMMachineOutput output : this.result) {
      if (output.isPrimary()){
        continue;
      }
      secondaries.add(output.resolveStack());
    }
    return secondaries;
  }

  @Override
  public boolean canFit(int width, int height) {
    return width * height == 1;
  }

  @Override
  public ItemStack getRecipeOutput() {
    for (IMMachineOutput output : this.result) {
      if (output.isPrimary()) {
        return output.resolveStack();
      }
    }
    return ItemStack.EMPTY;
  }

  @Override
  public ResourceLocation getId() {
    return id;
  }

  @Override
  public IRecipeSerializer<?> getSerializer() {
    return serializer;
  }

  @Override
  public IRecipeType<?> getType() {
    return recipeType;
  }
}
