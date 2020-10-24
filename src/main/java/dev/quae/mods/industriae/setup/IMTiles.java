package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.tileentity.ForgeHammerTileEntity;
import dev.quae.mods.industriae.tileentity.MaceratorTileEntity;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMTiles {

  public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, IndustriaeMutatio.ID);

  // Machine Tiles
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> LV_MACERATOR = TILES.register("lv_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.LV), IMBlocks.LV_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> MV_MACERATOR = TILES.register("mv_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.MV), IMBlocks.MV_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> HV_MACERATOR = TILES.register("hv_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.HV), IMBlocks.HV_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> EV_MACERATOR = TILES.register("ev_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.EV), IMBlocks.EV_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> IV_MACERATOR = TILES.register("iv_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.IV), IMBlocks.IV_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> LuV_MACERATOR = TILES.register("luv_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.LUV), IMBlocks.LUV_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> ZPM_MACERATOR = TILES.register("zpm_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.ZPM), IMBlocks.ZPM_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> UV_MACERATOR = TILES.register("uv_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.UV), IMBlocks.UV_MACERATOR.get()).build(null));
  public static final RegistryObject<TileEntityType<MaceratorTileEntity>> MAX_MACERATOR = TILES.register("max_macerator", () -> TileEntityType.Builder.create(() -> new MaceratorTileEntity(SpeedTier.MAX), IMBlocks.MAX_MACERATOR.get()).build(null));

  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> LV_FORGE_HAMMER = TILES.register("lv_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.LV), IMBlocks.LV_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> MV_FORGE_HAMMER = TILES.register("mv_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.MV), IMBlocks.MV_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> HV_FORGE_HAMMER = TILES.register("hv_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.HV), IMBlocks.HV_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> EV_FORGE_HAMMER = TILES.register("ev_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.EV), IMBlocks.EV_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> IV_FORGE_HAMMER = TILES.register("iv_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.IV), IMBlocks.IV_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> LuV_FORGE_HAMMER = TILES.register("luv_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.LUV), IMBlocks.LUV_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> ZPM_FORGE_HAMMER = TILES.register("zpm_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.ZPM), IMBlocks.ZPM_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> UV_FORGE_HAMMER = TILES.register("uv_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.UV), IMBlocks.UV_FORGE_HAMMER.get()).build(null));
  public static final RegistryObject<TileEntityType<ForgeHammerTileEntity>> MAX_FORGE_HAMMER = TILES.register("max_forge_hammer", () -> TileEntityType.Builder.create(() -> new ForgeHammerTileEntity(SpeedTier.MAX), IMBlocks.MAX_FORGE_HAMMER.get()).build(null));

}
