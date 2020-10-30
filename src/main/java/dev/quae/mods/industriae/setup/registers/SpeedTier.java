package dev.quae.mods.industriae.setup.registers;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMMachineBlock;
import dev.quae.mods.industriae.machine.IMSpeedTier;
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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public enum SpeedTier implements IMSpeedTier, IRegistryEnum<IRecipe<?>> {
  ULV(0.5, "ulv"),
  LV(1, "lv"),
  MV(10, "mv"),
  HV(8, "hv"),
  EV(12, "ev"),
  IV(18, "iv"),
  LUV(28, "luv"),
  ZPM(40, "zpm"),
  UV(54, "uv"),
  MAX(80, "max");


  private final double speed;
  private final String name;
  private RegistryObject<Block> chassisBlock;
  private RegistryObject<Block> hullBlock;
  private RegistryObject<Item> chassisItem;
  private RegistryObject<Item> hullItem;

  SpeedTier(double speed, String name) {
    this.speed = speed;
    this.name = name;
  }

  @Override
  public void registerBlocks(DeferredRegister<Block> register) {
    chassisBlock = register.register(getChassisRegistryName(), IMMachineBlock::new);
    hullBlock = register.register(getHullRegistryName(), IMMachineBlock::new);
  }

  @Override
  public void registerItems(DeferredRegister<Item> register) {
    chassisItem = register.register(getChassisRegistryName(), chassisBlock.lazyMap(it -> new BlockItem(it, new Properties().group(IndustriaeMutatio.MACHINES_TAB))));
    hullItem = register.register(getHullRegistryName(), hullBlock.lazyMap(it -> new BlockItem(it, new Properties().group(IndustriaeMutatio.MACHINES_TAB))));
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
  public double getSpeed() {
    return speed;
  }

  @Override
  public String getName() {
    return name;
  }

  public void registerBlockState(BlockStateProvider provider) {
    provider.simpleBlock(this.chassisBlock.get(), provider.models().cubeAll(getChassisRegistryName(), new ResourceLocation(IndustriaeMutatio.ID, "block/machine/" + this.name)));
    provider.simpleBlock(this.hullBlock.get(), provider.models().cubeAll(getHullRegistryName(), new ResourceLocation(IndustriaeMutatio.ID, "block/machine/" + this.name)));
  }

  public String getChassisRegistryName() {
    return this.name + "_machine_chassis";
  }
  public String getHullRegistryName() {
    return this.name + "_machine_hull";
  }

  public void registerItemModels(ItemModelProvider provider) {
    provider.getBuilder(getChassisRegistryName()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(IndustriaeMutatio.ID, "block/" + getChassisRegistryName())));
    provider.getBuilder(getHullRegistryName()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(IndustriaeMutatio.ID, "block/" + getHullRegistryName())));
  }

  public RegistryObject<Block> getChassisBlock() {
    return chassisBlock;
  }

  public RegistryObject<Block> getHullBlock() {
    return hullBlock;
  }
}
