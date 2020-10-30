package dev.quae.mods.industriae.setup.registers;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMTieredMachineBlock;
import dev.quae.mods.industriae.client.gui.IMTieredMachineContainerScreen;
import dev.quae.mods.industriae.container.IMTieredMachineContainer;
import dev.quae.mods.industriae.machine.IMMachineType;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public enum MachineType implements IMMachineType, IStringSerializable, IRegistryEnum<IMCustomMachineRecipe> {
  ALLOY_SMELTER("alloy_smelter", 4, 2, 0, 0),
  FORGE_HAMMER("forge_hammer", 1, 1, 0, 0),
  AUTOCLAVE("autoclave", 1, 1, 1, 0),
  LATHE("lathe", 2, 2, 0, 0),
  MACERATOR("macerator", 1, 3, 0, 0),
  MIXER("mixer", 4, 4, 4, 4),
  ORE_WASHING_PLANT("ore_washing_plant", 1, 3, 1, 0),
  PACKAGER("packager", 3, 1, 0, 0),
  POLARISER("polarizer", 1, 1, 0, 0),
  PRECISION_ENGRAVING_MACHINE("precision_engraving_machine", 2, 1, 0, 0),
  SIFTER("sifter", 1, 6, 0, 0),
  THERMAL_CENTRIFUGE("thermal_centrifuge", 1, 3, 0, 0),
  UNPACKAGER("unpackager", 1, 3, 0, 0),
  WIREMILL("wiremill", 1,1, 0,0),
  REPLICATOR("replicator", 1,1, 2,0),
  RECYCLER("recycler", 1,0, 0,2),
  PLASMA_ARC_FURNACE("plasma_arc_furnace", 4,4, 2,2),
  MICROWAVE("microwave", 1,1, 0,0),
  MASS_FABRICATOR("mass_fabricator", 2,2, 2,2),
  FURNACE("furnace", 1,1, 0,0),
  FORMING_PRESS("forming_press", 6,1, 0,0),
  FLUID_SOLIDIFIER("fluid_solidifier", 0,1, 1,0),
  PRINTER("printer", 1,1, 1,0),
  SCANNER("scanner", 1,1, 0,0),
  FLUID_HEATER("fluid_heater", 0,0, 1,1),
  FLUID_EXTRACTOR("fluid_extractor", 1,0, 0,1),
  FLUID_CANNER("fluid_canner", 1,1, 1,0),
  FERMENTER("fermenter", 1,0, 1,1),
  EXTRUDER("extruder", 2,1, 0,0),
  EXTRACTOR("extractor", 1,1, 0,1),
  ELECTROMAGNETIC_SEPARATOR("electromagnetic_separator", 1,6, 0,0),
  ELECTROLYZER("electrolyzer", 1,6, 1,6),
  ELECTRIC_OVEN("electric_oven", 1,1, 0,0),
  DISSASEMBLER("dissasembler", 1,6, 0,0),
  CUTTING_MACHINE("cutting_machine", 1,2, 0,0),
  CHEMICAL_REACTOR("chemical_reactor", 3,3, 3,3),
  COMPRESSOR("compressor", 1,1, 0,0),
  DISTILLERY("distillery", 0,0, 1,1),
  CENTRIFUGE("centrifuge", 1,6, 1,6),
  BREWERY("brewery", 1,0, 1,1),
  CHEMICAL_BATH("chemical_bath", 1,3, 1,0),
  CANNING_MACHINE("canning_machine", 2,1, 0,0),
  ASSEMBLING_MACHINE("assembling_machine", 9,1, 1,0),
  BENDING_MACHINE("bending_machine", 2,1, 0,0),
  SLICING_MACHINE("slicing_machine", 1,1, 0,0),
  ;

  private final EnumMap<SpeedTier, RegistryObject<TileEntityType<?>>> tileTypeMap;
  private final EnumMap<SpeedTier, RegistryObject<Block>> blockMap;
  private final EnumMap<SpeedTier, RegistryObject<BlockItem>> itemMap;
  private final EnumMap<SpeedTier, RegistryObject<ContainerType<IMTieredMachineContainer>>> containerMap;
  private IRecipeType<IMCustomMachineRecipe> recipeType;
  private RegistryObject<IRecipeSerializer<IMCustomMachineRecipe>> serializer;
  private final String name;
  private final int inputInventorySize;
  private final int outputInventorySize;
  private final int inputTankCount;
  private final int outputTankCount;

  MachineType(String name, int inputInventorySize, int outputInventorySize, int inputTankCount, int outputTankCount) {
    this.name = name;
    this.tileTypeMap = new EnumMap<>(SpeedTier.class);
    this.blockMap = new EnumMap<>(SpeedTier.class);
    this.itemMap = new EnumMap<>(SpeedTier.class);
    this.containerMap = new EnumMap<>(SpeedTier.class);
    this.inputInventorySize = inputInventorySize;
    this.outputInventorySize = outputInventorySize;
    this.inputTankCount = inputTankCount;
    this.outputTankCount = outputTankCount;
  }

  @Override
  public void registerBlocks(DeferredRegister<Block> register) {
    for (SpeedTier value : SpeedTier.values()) {
      blockMap.put(value, register.register(getRegistryName(value), () -> new IMTieredMachineBlock(value, this)));
    }
  }

  @Override
  public void registerItems(DeferredRegister<Item> register) {
    for (SpeedTier value : SpeedTier.values()) {
      itemMap.put(value, register.register(getRegistryName(value), this.blockMap.get(value).lazyMap(it -> new BlockItem(it, new Properties().group(IndustriaeMutatio.MACHINES_TAB)))));
    }
  }

  @Override
  public void registerTiles(DeferredRegister<TileEntityType<?>> register) {
    for (SpeedTier value : SpeedTier.values()) {
      tileTypeMap.put(value, register.register(getRegistryName(value), this.blockMap.get(value).lazyMap(it -> TileEntityType.Builder.create(() -> new IMTieredProcessingMachineTileEntity(tileTypeMap.get(value).get(), value, this), it).build(null))));
    }
  }

  @Override
  public void registerContainers(DeferredRegister<ContainerType<?>> register) {
    for (SpeedTier value : SpeedTier.values()) {
      containerMap.put(value, register.register(getRegistryName(value), () -> IForgeContainerType.create((id, inv, buf) -> new IMTieredMachineContainer(id, inv, buf, this, value))));
    }
  }

  @Override
  public void registerRecipeSerializers(DeferredRegister<IRecipeSerializer<?>> register) {
    serializer = register.register(this.name, IMCustomMachineRecipe.Serializer::new);
  }

  @Override
  public void registerScreens(Function<Runnable, CompletableFuture<Void>> register) {
    for (Entry<SpeedTier, RegistryObject<ContainerType<IMTieredMachineContainer>>> entry : containerMap.entrySet()) {
      register.apply(() -> ScreenManager.registerFactory(entry.getValue().get(), IMTieredMachineContainerScreen::new));
    }
  }

  @Override
  public void registerRecipeTypes(Function<String, IRecipeType<IMCustomMachineRecipe>> register) {
    recipeType = register.apply(this.name);
  }

  @Override
  public int getInputInventorySize() {
    return this.inputInventorySize;
  }

  @Override
  public int getOutputInventorySize() {
    return this.outputInventorySize;
  }

  @Override
  public int getInputTankCount() {
    return this.inputTankCount;
  }

  @Override
  public int getOutputTankCount() {
    return this.outputTankCount;
  }

  @Override
  public IRecipeType<IMCustomMachineRecipe> getRecipeType() {
    return this.recipeType;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public Block getBlock(SpeedTier speedTier) {
    return blockMap.get(speedTier).get();
  }

  public Item getItem(SpeedTier tier) {
    return itemMap.get(tier).get();
  }

  public TileEntityType<?> getTypeEntityType(SpeedTier speedTier) {
    return tileTypeMap.get(speedTier).get();
  }

  public ContainerType<?> getContainerType(SpeedTier tier) {
    return this.containerMap.get(tier).get();
  }

  public IRecipeSerializer<IMCustomMachineRecipe> getSerializer() {
    return serializer.get();
  }

  public String getRegistryName(SpeedTier speedTier) {
    return speedTier.getName() + "_" + this.name;
  }
}
