package dev.quae.mods.industriae.setup.registers;

import dev.quae.mods.industriae.IndustriaeMutatio;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;

public interface IRegistryEnum<T extends IRecipe<?>> {

  void registerBlocks(DeferredRegister<Block> register);

  void registerItems(DeferredRegister<Item> register);

  void registerTiles(DeferredRegister<TileEntityType<?>> register);

  void registerContainers(DeferredRegister<ContainerType<?>> register);

  void registerRecipeSerializers(DeferredRegister<IRecipeSerializer<?>> register);

  void registerScreens(Function<Runnable, CompletableFuture<Void>> register);

  void registerRecipeTypes(Function<String, IRecipeType<T>> register);

  default ResourceLocation rl(String name) {
    return new ResourceLocation(IndustriaeMutatio.ID, name);
  }
}
