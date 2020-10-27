package dev.quae.mods.industriae.machine;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMTieredMachineBlock;
import dev.quae.mods.industriae.item.IMBlockItem;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMBlocks;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.IMRecipeSerializers;
import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import java.util.EnumMap;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public enum MachineType implements  IMMachineType, IStringSerializable {
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
  ;

  private final EnumMap<SpeedTier, RegistryObject<TileEntityType<?>>> tileTypeMap;
  private final EnumMap<SpeedTier, RegistryObject<Block>> blockMap;
  private final EnumMap<SpeedTier, RegistryObject<BlockItem>> itemMap;
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
    this.inputInventorySize = inputInventorySize;
    this.outputInventorySize = outputInventorySize;
    this.inputTankCount = inputTankCount;
    this.outputTankCount = outputTankCount;
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
  public String getName() {
    return this.name;
  }

  public IRecipeSerializer<IMCustomMachineRecipe> getSerializer() {
    return serializer.get();
  }

  @Override
  public IRecipeType<IMCustomMachineRecipe> getRecipeType() {
    return this.recipeType;
  }

  public TileEntityType<?> getTypeEntityType(SpeedTier speedTier) {
    return tileTypeMap.get(speedTier).get();
  }

  public void createTileEntityTypes() {
    for (SpeedTier value : SpeedTier.values()) {
      tileTypeMap.put(value, IMTiles.TILES.register(value.getName().concat("_").concat(this.getName()), () -> TileEntityType.Builder.create(() -> new IMTieredProcessingMachineTileEntity(tileTypeMap.get(value).get(), value, this), blockMap.get(value).get()).build(null)));
    }
  }

  public void createBlocks() {
    for (SpeedTier value : SpeedTier.values()) {
      blockMap.put(value, IMBlocks.BLOCKS.register(getRegistryName(value), () -> new IMTieredMachineBlock(value, this)));
    }
  }

  public Block getBlock(SpeedTier speedTier) {
    return blockMap.get(speedTier).get();
  }

  public void createItems() {
    for (SpeedTier value : SpeedTier.values()) {
      itemMap.put(value, IMItems.ITEMS.register(getRegistryName(value), () -> new IMBlockItem(() -> getBlock(value), new Properties().group(IndustriaeMutatio.MACHINES_TAB))));
    }
  }

  public void createRecipeType() {
    recipeType = IRecipeType.register(new ResourceLocation(IndustriaeMutatio.ID, this.name).toString());
  }

  public void createSerializer() {
    serializer = IMRecipeSerializers.RECIPE_SERIALIZERS.register(this.name, IMCustomMachineRecipe.Serializer::new);
  }

  private String getRegistryName(SpeedTier speedTier) {
    return speedTier.getName() + "_" + this.name;
  }
}
