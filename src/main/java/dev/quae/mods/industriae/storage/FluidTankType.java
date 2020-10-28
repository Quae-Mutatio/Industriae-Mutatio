package dev.quae.mods.industriae.storage;

import dev.quae.mods.industriae.block.IMFluidTank;
import dev.quae.mods.industriae.item.FluidTankItem;
import dev.quae.mods.industriae.setup.IMBlocks;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.IMFluidTankTileEntity;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public enum FluidTankType implements IMFluidTankType {
  COPPER("copper", 8),
  IRON("iron", 32),
  BRONZE("bronze", 64),
  STEEL("steel", 128),
  TUNGSTEN("tungsten", 256),
  TITANIUM("titanium", 512),
  ;

  private String material;
  private final int capacity;
  private RegistryObject<Item> item;
  private RegistryObject<Block> block;
  private RegistryObject<TileEntityType<?>> tile;
  FluidTankType(String material, int bucketsCapacity) {

    this.material = material;
    this.capacity = bucketsCapacity * 1000;
  }

  @Override
  public String getName() {
    return material;
  }

  @Override
  public int getCapacity() {
    return capacity;
  }

  public void createItem() {
      item = IMItems.ITEMS.register(getRegistryName(), FluidTankItem::new);
  }

  public String getRegistryName() {
    return this.getName() + "_drum";
  }

  public void createBlock() {
    block = IMBlocks.BLOCKS.register(getRegistryName(), IMFluidTank::new);
  }

  public void createTileEntity() {
    tile = IMTiles.TILES.register(getRegistryName(), () -> TileEntityType.Builder.create(() -> new IMFluidTankTileEntity(tile.get(), this)).build(null));
  }
}
