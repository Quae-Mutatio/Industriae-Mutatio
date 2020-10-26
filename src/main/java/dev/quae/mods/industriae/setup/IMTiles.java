package dev.quae.mods.industriae.setup;

import com.google.common.collect.ImmutableMap;
import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.helper.IMTieredRegistryResolver;
import dev.quae.mods.industriae.tileentity.AlloySmelterTileEntity;
import dev.quae.mods.industriae.tileentity.ForgeHammerTileEntity;
import dev.quae.mods.industriae.tileentity.IMSpeedTier;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import dev.quae.mods.industriae.tileentity.InfiniteWaterSourceTileEntity;
import dev.quae.mods.industriae.tileentity.MaceratorTileEntity;
import dev.quae.mods.industriae.tileentity.OreWashingPlantTileEntity;
import dev.quae.mods.industriae.tileentity.PackagerTileEntity;
import dev.quae.mods.industriae.tileentity.PrecisionEngravingMachineTileEntity;
import dev.quae.mods.industriae.tileentity.SifterTileEntity;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import dev.quae.mods.industriae.tileentity.ThermalCentrifugeTileEntity;
import dev.quae.mods.industriae.tileentity.UnPackagerTileEntity;
import dev.quae.mods.industriae.tileentity.WireMillTileEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMTiles {

  public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, IndustriaeMutatio.ID);

  // Machine Tiles
  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> MACERATOR = registerTiers("macerator", tier -> () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.MACERATOR)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> FORGE_HAMMER = registerTiers("forge_hammer", tier -> () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.FORGE_HAMMER)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> ALLOY_SMELTER = registerTiers("alloy_smelter", tier -> () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.ALLOY_SMELTER)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> WIREMILL = registerTiers("wiremill", tier -> () -> TileEntityType.Builder.create(() -> new WireMillTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.WIREMILL)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> UNPACKAGER = registerTiers("unpackager", tier -> () -> TileEntityType.Builder.create(() -> new UnPackagerTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.UNPACKAGER)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> PACKAGER = registerTiers("packager", tier -> () -> TileEntityType.Builder.create(() -> new PackagerTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.PACKAGER)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> THERMAL_CENTRIFUGE = registerTiers("thermal_centrifuge", tier -> () -> TileEntityType.Builder.create(() -> new ThermalCentrifugeTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.THERMAL_CENTRIFUGE)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> ORE_WASHING_PLANT = registerTiers("ore_washing_plant", (tier) -> () -> TileEntityType.Builder.create(() -> new OreWashingPlantTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.ORE_WASHING_PLANT)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> PRECISION_ENGRAVING_MACHINE = registerTiers("precision_engraving_machine", (tier) -> () -> TileEntityType.Builder.create(() -> new PrecisionEngravingMachineTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.PRECISION_ENGRAVING_MACHINE)).build(null));

  public static final Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> SIFTER = registerTiers("sifter", tier -> () -> TileEntityType.Builder.create(() -> new SifterTileEntity(tier), IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.SIFTER)).build(null));

  private static Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> registerTiers(String registrySuffix, Function<SpeedTier, Supplier<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> tileEntityTypeFunction) {
    LinkedHashMap<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> map = new LinkedHashMap<>();
    for (SpeedTier speedTier : SpeedTier.getAll()) {
      map.put(speedTier.getName(), TILES.register(speedTier.getName() + "_" + registrySuffix, tileEntityTypeFunction.apply(speedTier)));
    }
    return map;
  }

  public static final RegistryObject<TileEntityType<InfiniteWaterSourceTileEntity>> INFINITE_WATER_SOURCE = TILES.register("infinite_water_source", () -> Builder.create(InfiniteWaterSourceTileEntity::new, IMBlocks.INFINITE_WATER_SOURCE.get()).build(null));


}
