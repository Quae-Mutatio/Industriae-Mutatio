package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.tileentity.AlloySmelterTileEntity;
import dev.quae.mods.industriae.tileentity.ForgeHammerTileEntity;
import dev.quae.mods.industriae.tileentity.MaceratorTileEntity;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import dev.quae.mods.industriae.tileentity.UnPackagerTileEntity;
import dev.quae.mods.industriae.tileentity.WireMillTileEntity;
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

  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> LV_ALLOY_SMELTER = TILES.register("lv_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.LV), IMBlocks.LV_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> MV_ALLOY_SMELTER = TILES.register("mv_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.MV), IMBlocks.MV_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> HV_ALLOY_SMELTER = TILES.register("hv_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.HV), IMBlocks.HV_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> EV_ALLOY_SMELTER = TILES.register("ev_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.EV), IMBlocks.EV_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> IV_ALLOY_SMELTER = TILES.register("iv_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.IV), IMBlocks.IV_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> LUV_ALLOY_SMELTER = TILES.register("luv_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.LUV), IMBlocks.LUV_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> ZPM_ALLOY_SMELTER = TILES.register("zpm_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.ZPM), IMBlocks.ZPM_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> UV_ALLOY_SMELTER = TILES.register("uv_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.UV), IMBlocks.UV_ALLOY_SMELTER.get()).build(null));
  public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> MAX_ALLOY_SMELTER = TILES.register("max_alloy_smelter", () -> TileEntityType.Builder.create(() -> new AlloySmelterTileEntity(SpeedTier.MAX), IMBlocks.MAX_ALLOY_SMELTER.get()).build(null));

  public static final RegistryObject<TileEntityType<WireMillTileEntity>> LV_WIREMILL = TILES.register("lv_wiremill", () -> TileEntityType.Builder.create(() ->   new WireMillTileEntity(SpeedTier.LV), IMBlocks.LV_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> MV_WIREMILL = TILES.register("mv_wiremill", () -> TileEntityType.Builder.create(() ->   new WireMillTileEntity(SpeedTier.MV), IMBlocks.MV_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> HV_WIREMILL = TILES.register("hv_wiremill", () -> TileEntityType.Builder.create(() ->   new WireMillTileEntity(SpeedTier.HV), IMBlocks.HV_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> EV_WIREMILL = TILES.register("ev_wiremill", () -> TileEntityType.Builder.create(() ->   new WireMillTileEntity(SpeedTier.EV), IMBlocks.EV_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> IV_WIREMILL = TILES.register("iv_wiremill", () -> TileEntityType.Builder.create(() ->   new WireMillTileEntity(SpeedTier.IV), IMBlocks.IV_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> LUV_WIREMILL = TILES.register("luv_wiremill", () -> TileEntityType.Builder.create(() -> new WireMillTileEntity(SpeedTier.LUV), IMBlocks.LUV_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> ZPM_WIREMILL = TILES.register("zpm_wiremill", () -> TileEntityType.Builder.create(() -> new WireMillTileEntity(SpeedTier.ZPM), IMBlocks.ZPM_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> UV_WIREMILL = TILES.register("uv_wiremill", () -> TileEntityType.Builder.create(() ->   new WireMillTileEntity(SpeedTier.UV), IMBlocks.UV_WIREMILL.get()).build(null));
  public static final RegistryObject<TileEntityType<WireMillTileEntity>> MAX_WIREMILL = TILES.register("max_wiremill", () -> TileEntityType.Builder.create(() -> new WireMillTileEntity(SpeedTier.MAX), IMBlocks.MAX_WIREMILL.get()).build(null));

  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> LV_UNPACKAGER = TILES.register("lv_unpackager", () -> TileEntityType.Builder.create(() ->   new UnPackagerTileEntity(SpeedTier.LV), IMBlocks.LV_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> MV_UNPACKAGER = TILES.register("mv_unpackager", () -> TileEntityType.Builder.create(() ->   new  UnPackagerTileEntity(SpeedTier.MV), IMBlocks.MV_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> HV_UNPACKAGER = TILES.register("hv_unpackager", () -> TileEntityType.Builder.create(() ->   new  UnPackagerTileEntity(SpeedTier.HV), IMBlocks.HV_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> EV_UNPACKAGER = TILES.register("ev_unpackager", () -> TileEntityType.Builder.create(() ->   new  UnPackagerTileEntity(SpeedTier.EV), IMBlocks.EV_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> IV_UNPACKAGER = TILES.register("iv_unpackager", () -> TileEntityType.Builder.create(() ->   new  UnPackagerTileEntity(SpeedTier.IV), IMBlocks.IV_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> LUV_UNPACKAGER = TILES.register("luv_unpackager", () -> TileEntityType.Builder.create(() -> new  UnPackagerTileEntity(SpeedTier.LUV), IMBlocks.LUV_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> ZPM_UNPACKAGER = TILES.register("zpm_unpackager", () -> TileEntityType.Builder.create(() -> new  UnPackagerTileEntity(SpeedTier.ZPM), IMBlocks.ZPM_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> UV_UNPACKAGER = TILES.register("uv_unpackager", () -> TileEntityType.Builder.create(() ->   new  UnPackagerTileEntity(SpeedTier.UV), IMBlocks.UV_UNPACKAGER.get()).build(null));
  public static final RegistryObject<TileEntityType<UnPackagerTileEntity>> MAX_UNPACKAGER = TILES.register("max_unpackager", () -> TileEntityType.Builder.create(() -> new  UnPackagerTileEntity(SpeedTier.MAX), IMBlocks.MAX_UNPACKAGER.get()).build(null));


}
