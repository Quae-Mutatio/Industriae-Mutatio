package dev.quae.mods.industriae.machine;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMTieredMachineBlock;
import dev.quae.mods.industriae.item.IMBlockItem;
import dev.quae.mods.industriae.recipe.IMCustomMachineRecipe;
import dev.quae.mods.industriae.setup.IMBlocks;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.IMRecipeTypes;
import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import java.util.EnumMap;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.RegistryObject;

public enum MachineType implements  IMMachineType, IStringSerializable {
  ALLOY_SMELTER("alloy_smelter", 4, 2, 0, 0, IMRecipeTypes.ALLOY_SMELTER),
  FORGE_HAMMER("forge_hammer", 1, 1, 0, 0, IMRecipeTypes.FORGE_HAMMER),
  AUTOCLAVE("autoclave", 1, 1, 1, 0, IMRecipeTypes.AUTOCLAVE),
  LATHE("lathe", 2, 2, 0, 0, IMRecipeTypes.LATHE),
  MACERATOR("macerator", 1, 3, 0, 0, IMRecipeTypes.MACERATOR),
  MIXER("mixer", 4, 4, 4, 4, IMRecipeTypes.MIXER),
  ORE_WASHING_PLANT("ore_washing_plant", 1, 3, 1, 0, IMRecipeTypes.ORE_WASHING_PLANT),
  PACKAGER("packager", 3, 1, 0, 0, IMRecipeTypes.PACKAGER),
  POLARISER("polarizer", 1, 1, 0, 0, IMRecipeTypes.POLARIZER),
  PRECISION_ENGRAVING_MACHINE("precision_engraving_machine", 2, 1, 0, 0, IMRecipeTypes.PRECISION_ENGRAVING),
  SIFTER("sifter", 1, 6, 0, 0, IMRecipeTypes.SIFTER),
  THERMAL_CENTRIFUGE("thermal_centrifuge", 1, 3, 0, 0, IMRecipeTypes.THERMAL_CENTRIFUGE),
  UNPACKAGER("unpackager", 1, 3, 0, 0, IMRecipeTypes.UNPACKAGER),
  WIREMILL("wiremill", 1,1, 0,0, IMRecipeTypes.WIREMILL),
  ;

  private final EnumMap<SpeedTier, RegistryObject<TileEntityType<?>>> tileTypeMap;
  private final EnumMap<SpeedTier, RegistryObject<Block>> blockMap;
  private final EnumMap<SpeedTier, RegistryObject<BlockItem>> itemMap;
  private final String name;
  private final int inputInventorySize;
  private final int outputInventorySize;
  private final int inputTankCount;
  private final int outputTankCount;
  private final IRecipeType<IMCustomMachineRecipe> recipeType;

  MachineType(String name, int inputInventorySize, int outputInventorySize, int inputTankCount, int outputTankCount, IRecipeType<IMCustomMachineRecipe> recipe) {
    this.name = name;
    this.recipeType = recipe;
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

  private String getRegistryName(SpeedTier speedTier) {
    return speedTier.getName() + "_" + this.name;
  }
}
