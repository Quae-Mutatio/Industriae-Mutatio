package dev.quae.mods.industriae.setup.registers;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMConstructPartBlock;
import dev.quae.mods.industriae.construct.IConstruct;
import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.construct.type.ComponentType;
import dev.quae.mods.industriae.construct.type.IOType;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public enum ConstructComponent implements IRegistryEnum<IRecipe<?>>, IConstruct.Component {
  COIL_CUPRONICKEL(ComponentType.COIL),
  COIL_FUSION(ComponentType.COIL),
  COIL_HSS_G(ComponentType.COIL),
  COIL_KANTHAL(ComponentType.COIL),
  COIL_NAQUADAH(ComponentType.COIL),
  COIL_NAQUADAH_ALLOY(ComponentType.COIL),
  COIL_NICHROME(ComponentType.COIL),
  COIL_TUNGSTENSTEEL(ComponentType.COIL),
  BLAST_FURNACE_FRAME(ComponentType.BLAST_FURNACE_FRAME),
  ITEM_INPUT(IOType.ITEM_IN),
  ITEM_OUTPUT(IOType.ITEM_OUT),
  FLUID_INPUT(IOType.FLUID_IN),
  FLUID_OUTPUT(IOType.FLUID_OUT),
  ENERGY_INPUT(IOType.ENERGY_IN),
  ENERGY_OUTPUT(IOType.ENERGY_OUT),
  ;

  private final Type type;
  private RegistryObject<IMConstructPartBlock> block;
  private RegistryObject<BlockItem> item;

  ConstructComponent(Type type) {

    this.type = type;
  }

  @Override
  public void registerBlocks(DeferredRegister<Block> register) {
    block = register.register(this.name().toLowerCase(), () -> new IMConstructPartBlock(this));
  }

  @Override
  public void registerItems(DeferredRegister<Item> register) {
    item = register.register(this.name().toLowerCase(), this.block.lazyMap(it -> new BlockItem(it, new Properties().group(IndustriaeMutatio.MACHINES_TAB))));
  }

  @Override
  public void registerTiles(DeferredRegister<TileEntityType<?>> register) {

  }

  @Override
  public void registerContainers(DeferredRegister<ContainerType<?>> register) {

  }

  @Override
  public void registerRecipeSerializers(DeferredRegister<IRecipeSerializer<?>> register) {

  }

  @Override
  public void registerScreens(Function<Runnable, CompletableFuture<Void>> register) {

  }

  @Override
  public void registerRecipeTypes(Function<String, IRecipeType<IRecipe<?>>> register) {

  }

  @Override
  public Type getType() {
    return this.type;
  }
}
