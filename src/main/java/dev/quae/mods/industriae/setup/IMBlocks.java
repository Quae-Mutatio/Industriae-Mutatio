package dev.quae.mods.industriae.setup;

import static net.minecraft.block.AbstractBlock.Properties.create;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.OreBlock;
import dev.quae.mods.industriae.material.Ore;
import dev.quae.mods.industriae.block.InfiniteWaterSourceBlock;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import dev.quae.mods.industriae.storage.FluidTankType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMBlocks {  
  
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IndustriaeMutatio.ID);

  static {
    for (Ore ore : Ore.values()) {
      ore.setOreBlock(registerOre(ore));
    }
    
    for (MachineType value : MachineType.values()) {
      value.createBlocks();
    }

    for (FluidTankType value : FluidTankType.values()) {
      value.createBlock();
    }
  }

  public static RegistryObject<OreBlock> registerOre(Ore ore) {
    return BLOCKS.register(ore.getName(), () -> new OreBlock(create(net.minecraft.block.material.Material.ROCK), ore));
  }

  public static final RegistryObject<Block> INFINITE_WATER_SOURCE = BLOCKS.register("infinite_water_source", InfiniteWaterSourceBlock::new);

}
