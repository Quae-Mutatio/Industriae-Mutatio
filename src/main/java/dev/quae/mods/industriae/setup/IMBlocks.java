package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.InfiniteWaterSourceBlock;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
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
    for (MachineType value : MachineType.values()) {
      value.createBlocks();
    }
  }


  public static final RegistryObject<Block> INFINITE_WATER_SOURCE = BLOCKS.register("infinite_water_source", InfiniteWaterSourceBlock::new);

}
