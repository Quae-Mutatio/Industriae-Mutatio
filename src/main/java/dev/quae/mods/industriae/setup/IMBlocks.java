package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.AlloySmelterBlock;
import dev.quae.mods.industriae.block.ForgeHammerBlock;
import dev.quae.mods.industriae.block.InfiniteWaterSourceBlock;
import dev.quae.mods.industriae.block.MaceratorBlock;
import dev.quae.mods.industriae.block.OreWashingPlantBlock;
import dev.quae.mods.industriae.block.PackagerBlock;
import dev.quae.mods.industriae.block.PrecisionEngraverMachineBlock;
import dev.quae.mods.industriae.block.ThermalCentrifugeBlock;
import dev.quae.mods.industriae.block.UnPackagerBlock;
import dev.quae.mods.industriae.block.WireMillBlock;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMBlocks {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IndustriaeMutatio.ID);

  // Machine Blocks
  public static final Map<String, RegistryObject<Block>> MACERATOR = registerTiers("macerator", tier -> () -> new MaceratorBlock(tier));

  public static final Map<String, RegistryObject<Block>> FORGE_HAMMER = registerTiers("forge_hammer", tier -> () -> new ForgeHammerBlock(tier));

  public static final Map<String, RegistryObject<Block>> ALLOY_SMELTER = registerTiers("alloy_smelter", tier -> () -> new AlloySmelterBlock(tier));

  public static final Map<String, RegistryObject<Block>> WIREMILL = registerTiers("wiremill", tier -> () -> new WireMillBlock(tier));

  public static final Map<String, RegistryObject<Block>> UNPACKAGER = registerTiers("unpackager", tier -> () -> new UnPackagerBlock(tier));

  public static final Map<String, RegistryObject<Block>> PACKAGER = registerTiers("packager", tier -> () -> new PackagerBlock(tier));

  public static final Map<String, RegistryObject<Block>> THERMAL_CENTRIFUGE = registerTiers("thermal_centrifuge", (tier) -> () -> new ThermalCentrifugeBlock(tier));

  public static final Map<String, RegistryObject<Block>> ORE_WASHING_PLANT = registerTiers("ore_washing_plant", (tier) -> () -> new OreWashingPlantBlock(tier));

  public static final Map<String, RegistryObject<Block>> PRECISION_ENGRAVING_MACHINE = registerTiers("precision_engraving_machine", (tier) -> () -> new PrecisionEngraverMachineBlock(tier));

  private static Map<String, RegistryObject<Block>> registerTiers(String registrySuffix, Function<SpeedTier, Supplier<Block>> tileEntityTypeFunction) {
    LinkedHashMap<String, RegistryObject<Block>> map = new LinkedHashMap<>();
    for (SpeedTier speedTier : SpeedTier.getAll()) {
      map.put(speedTier.getName(), BLOCKS.register(speedTier.getName() + "_" + registrySuffix, tileEntityTypeFunction.apply(speedTier)));
    }
    return map;
  }


  public static final RegistryObject<Block> INFINITE_WATER_SOURCE = BLOCKS.register("infinite_water_source", InfiniteWaterSourceBlock::new);

}
