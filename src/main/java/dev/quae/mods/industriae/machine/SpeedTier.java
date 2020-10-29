package dev.quae.mods.industriae.machine;

import com.google.common.collect.ImmutableList;
import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.IMMachineBlock;
import dev.quae.mods.industriae.data.IMItemModelProvider;
import dev.quae.mods.industriae.setup.IMBlocks;
import dev.quae.mods.industriae.setup.IMItems;
import javax.annotation.Resource;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public enum SpeedTier implements IMSpeedTier {
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
  public double getSpeed() {
    return speed;
  }

  @Override
  public String getName() {
    return name;
  }

  public void createChassisItems() {
    chassisItem = IMItems.ITEMS.register(getChassisRegistryName(), () -> new BlockItem(chassisBlock.get(), new Properties().group(IndustriaeMutatio.MACHINES_TAB)));
    hullItem = IMItems.ITEMS.register(getHullRegistryName(), () -> new BlockItem(hullBlock.get(), new Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  }

  public void createChassisBlocks() {
    chassisBlock = IMBlocks.BLOCKS.register(getChassisRegistryName(), IMMachineBlock::new);
    hullBlock = IMBlocks.BLOCKS.register(getHullRegistryName(), IMMachineBlock::new);
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
