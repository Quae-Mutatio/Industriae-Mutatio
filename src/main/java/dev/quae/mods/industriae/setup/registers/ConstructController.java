package dev.quae.mods.industriae.setup.registers;

import com.google.common.collect.ImmutableSet;
import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMConstructPartTileBlock;
import dev.quae.mods.industriae.construct.IConstruct;
import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.construct.type.ControllerType;
import dev.quae.mods.industriae.tileentity.IMBlastFurnaceTileEntity;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

public enum ConstructController implements IRegistryEnum<IRecipe<?>>, IConstruct.Controller {
  BLAST_FURNACE(ControllerType.BLAST_FURNACE, IMBlastFurnaceTileEntity::new),
  ;

  private final Type type;
  private final Supplier<TileEntity> tileSupplier;
  private RegistryObject<Block> block;
  private RegistryObject<BlockItem> item;
  private RegistryObject<TileEntityType<TileEntity>> tileType;

  ConstructController(Type type, Supplier<TileEntity> tileSupplier) {

    this.type = type;
    this.tileSupplier = tileSupplier;
  }

  @Override
  public void registerBlocks(DeferredRegister<Block> register) {
    block = register.register(this.name().toLowerCase(), () -> new IMConstructPartTileBlock(this) {
          @Nullable
          @Override
          public TileEntity createTileEntity(BlockState state, IBlockReader world) {
            return tileSupplier.get();
          }
        }
    );
  }

  @Override
  public void registerItems(DeferredRegister<Item> register) {
    item = register.register(this.name().toLowerCase(), block.lazyMap(it -> new BlockItem(it, new Properties().group(IndustriaeMutatio.MACHINES_TAB))));
  }

  @Override
  public void registerTiles(DeferredRegister<TileEntityType<?>> register) {
    tileType = register.register(this.name().toLowerCase(), block.lazyMap(it -> new TileEntityType<>(tileSupplier, ImmutableSet.of(it), null)));
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

  public TileEntityType<?> getTileType() {
    return tileType.get();
  }
}
