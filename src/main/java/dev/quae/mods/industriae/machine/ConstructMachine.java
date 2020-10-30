package dev.quae.mods.industriae.machine;

import com.google.common.collect.ImmutableList;
import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMConstructPartBlock;
import dev.quae.mods.industriae.construct.BlastFurnaceConstruct;
import dev.quae.mods.industriae.construct.ConstructionBlockType;
import dev.quae.mods.industriae.construct.ControllerType;
import dev.quae.mods.industriae.construct.IConstruct;
import dev.quae.mods.industriae.construct.IConstruct.Type;
import dev.quae.mods.industriae.setup.IMBlocks;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.ConstructComponentTileEntity;
import dev.quae.mods.industriae.tileentity.ConstructControllerTileEntity;
import java.util.EnumMap;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public enum ConstructMachine implements IConstructMachine {
  BLAST_FURNACE(new BlastFurnaceConstruct(), ControllerType.BLAST_FURNACE, ImmutableList.of(ConstructionBlockType.BLAST_FURNACE, ConstructionBlockType.BLAST_FURNACE_COIL)),
  ;

  private final IConstruct construct;
  private final ControllerType controller;
  private final List<ConstructionBlockType> constructTypes;
  private final EnumMap<ConstructionBlockType, RegistryObject<TileEntityType<?>>> componentTiles;
  private final EnumMap<ConstructionBlockType, RegistryObject<Item>> componentItems;
  private final EnumMap<ConstructionBlockType, RegistryObject<Block>> componentBlocks;
  private RegistryObject<TileEntityType<?>> controllerTile;
  private RegistryObject<IMConstructPartBlock> controllerBlock;
  private RegistryObject<Item> controllerItem;

  ConstructMachine(IConstruct construct, ControllerType controller, List<ConstructionBlockType> constructTypes) {
    this.construct = construct;
    this.controller = controller;
    this.constructTypes = constructTypes;
    componentTiles = new EnumMap<>(ConstructionBlockType.class);
    componentItems = new EnumMap<>(ConstructionBlockType.class);
    componentBlocks = new EnumMap<>(ConstructionBlockType.class);
  }

  public void createTileEntities() {
    controllerTile = IMTiles.TILES.register(controller.getName(), () -> TileEntityType.Builder.create(() -> new ConstructControllerTileEntity(controllerTile.get(), construct)).build(null));
    for (ConstructionBlockType type : constructTypes) {
      registerSubTypes(controller.getName(), type, (name, constructType) -> componentTiles.put(constructType, IMTiles.TILES.register(name, () -> TileEntityType.Builder.create(() -> new ConstructComponentTileEntity(componentTiles.get(constructType).get(), constructType)).build(null))));
    }
  }

  public void createBlocks() {
    controllerBlock = IMBlocks.BLOCKS.register(controller.getName(), () -> new IMConstructPartBlock(this, controller));
    for (ConstructionBlockType type : constructTypes) {
      registerSubTypes(controller.getName(), type, (name, constructType) -> componentBlocks.put(constructType, IMBlocks.BLOCKS.register(name, () -> new IMConstructPartBlock(this, constructType))));
    }
  }

  public void createItems() {
    controllerItem = IMItems.ITEMS.register(controller.getName(),() -> new BlockItem(this.controllerBlock.get(), new Properties().group(IndustriaeMutatio.MACHINES_TAB)));
    for (ConstructionBlockType type : constructTypes) {
      registerSubTypes(controller.getName(), type, (name, constructType) -> componentItems.put(constructType, IMItems.ITEMS.register(name, () -> new BlockItem(this.componentBlocks.get(constructType).get(), new Properties().group(IndustriaeMutatio.MACHINES_TAB)))));
    }
  }

  private void registerSubTypes(String name, ConstructionBlockType type, BiConsumer<String, ConstructionBlockType> consumer) {
    if (type.getAcceptedTypes().isEmpty()) {
      consumer.accept(name, type);
      return;
    }
    for (ConstructionBlockType acceptedType : type.getAcceptedTypes()) {
      String currentName = name + "_" + acceptedType.getName();
      registerSubTypes(currentName, acceptedType, consumer);
    }
  }



  public IConstruct getConstruct() {
    return construct;
  }

  public String getName() {
    return controller.getName();
  }

  public List<ConstructionBlockType> getConstructTypes() {
    return constructTypes;
  }

  public ControllerType getController() {
    return controller;
  }

  public RegistryObject<TileEntityType<?>> getTileEntity(Type type) {
    if (type == this.controller){
      return controllerTile;
    }
    return componentTiles.get(type);
  }
}
